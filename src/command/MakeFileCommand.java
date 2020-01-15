package command;

import java.util.ArrayList;

import builder.FileBuilder;
import facade.FileFacade;
import file.PlainFile;
import util.Constants;

public class MakeFileCommand extends QueryCommand
{
	@SuppressWarnings("unchecked")
	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;
		
		normalizeArguments();
		
		FileBuilder builder = new FileBuilder(this.getArguments());
		ArrayList<PlainFile> files = (ArrayList<PlainFile>) builder.getResult();
		
		int count = 0;
		
		for (PlainFile file : files)
		{
			count = FileFacade.getInstance()
				.getCurrentFolder()
				.addFile(file) ? ++count : count;
		}
		
		try
		{
			long sleepTime = this.getArguments().length * 150;
			Thread.sleep(sleepTime);
			System.out.println(String.format("%d file(s) created.", count));
		}
		catch (InterruptedException e)
		{
		}
	}
	
	@Override
	public boolean isValidArguments()
	{
		if (!isValidArgumentLength())
		{
			System.err.println("Missing arguments.");
			return false;
		}
		else if (!isValidFilePattern())
		{
			System.err.println("Missing file extension.");
			return false;
		}
		
		return true;
	}

	private boolean isValidArgumentLength()
	{
		return this.getArguments().length > 0;
	}
	
	private boolean isValidFilePattern()
	{
		for (String argument : this.getArguments())
		{
			int dotIndex = argument.lastIndexOf('.');

			if (dotIndex == -1)
				return false;
		}
		
		return true;
	}
	
	private void normalizeArguments()
	{
		ArrayList<String> validArguments = new ArrayList<>();
		
		for (String argument : this.getArguments())
		{
			int dotIndex = argument.lastIndexOf('.');
			
			String extension = argument.substring(dotIndex + 1, argument.length());
			
			if (Constants.fileTypes.get(extension) != null)
				validArguments.add(argument);
			else
				System.err.println(String.format("%s has invalid extension.", argument));
		}
		
		this.setArguments(validArguments.toArray(new String[]{}));
	}
}
