package builder;

import java.util.ArrayList;

import file.PlainFile;
import util.Constants;

public class FileBuilder extends BaseBuilder
{
	public FileBuilder(String query)
	{
		super(query);
	}

	@Override
	public Object getResult()
	{
		ArrayList<PlainFile> files = new ArrayList<>();
		
		for (String argument : this.getArguments())
		{
			int dotIndex = getDotIndex(argument);
			
			if (dotIndex == -1)
			{
				System.err.println("Missing file extension.");
				return null;
			}
			
			String extension = argument.substring(
					dotIndex + 1, 
					argument.length());
			
			try
			{
				PlainFile file = Constants.fileTypes.get(extension).newInstance();
				file.setName(getFileName(argument));
				files.add(file);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return files;
	}

	private int getDotIndex(String argument)
	{
		return argument.lastIndexOf('.');
	}

	private String getFileName(String argument)
	{
		return argument.substring(0, getDotIndex(argument));
	}
}
