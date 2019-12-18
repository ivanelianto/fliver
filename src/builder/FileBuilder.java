package builder;

import java.util.ArrayList;
import java.util.Arrays;

import file.PlainFile;
import util.Constants;

public class FileBuilder extends BaseBuilder
{
	public FileBuilder(String... inputtedFiles)
	{
		this.setArguments(new ArrayList<String>(Arrays.asList(inputtedFiles)));
	}
	
	@Override
	public Object getResult()
	{
		ArrayList<PlainFile> files = new ArrayList<>();

		if (!isValidArguments())
		{
			System.err.println("Missing arguments.");
		}
		else
		{
			for (String argument : this.getArguments())
			{
				int dotIndex = getDotIndex(argument);

				if (dotIndex == -1)
				{
					System.err.println("Missing file extension.");
					break;
				}

				String extension = argument.substring(dotIndex + 1, argument.length());

				try
				{
					PlainFile file = Constants.fileTypes.get(extension).newInstance();
					file.setName(argument);
					files.add(file);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					
					System.err.println(String.format("'%s' has invalid file extension.",
							argument));
					break;
				}
			}
		}
		
		return files;
	}

	private boolean isValidArguments()
	{
		return hasValidArgumentLength();
	}

	private boolean hasValidArgumentLength()
	{
		return this.getArguments().size() > 0;
	}

	private int getDotIndex(String argument)
	{
		return argument.lastIndexOf('.');
	}
}
