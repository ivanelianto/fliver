package command;

import facade.FileFacade;
import file.File;
import file.Folder;

public class MakeDirectoryCommand extends QueryCommand
{
	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;

		int count = 0;
		
		for (String argument : this.getArguments())
		{
			File folder = new Folder(argument);
			
			count = FileFacade.getInstance()
				.getCurrentFolder()
				.addFile(folder) ? ++count : count;
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
		else if (!isOnlyAlphanumeric())
		{
			System.err.println("Directory name must be only contains letter or numbers.");
			return false;
		}

		return true;
	}

	private boolean isValidArgumentLength()
	{
		return this.getArguments().length > 0;
	}
	
	private boolean isOnlyAlphanumeric()
	{
		for (String arg : this.getArguments())
			for (char c : arg.toCharArray())
				if (Character.isWhitespace(c))
					continue;
				else if (!Character.isLetterOrDigit(c))
					return false;
		
		return true;
	}
}
