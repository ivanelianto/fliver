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
		
		for (String argument : this.getArguments())
		{
			int dotIndex = argument.lastIndexOf('.');
			
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
				break;
			}
		}
		
		System.out.println(String.format("%d file(s) created.", files.size()));
		
		return files;
	}
}
