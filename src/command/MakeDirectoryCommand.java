package command;

import facade.FileFacade;
import file.Folder;

public class MakeDirectoryCommand extends QueryCommand
{
	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;

		for (String argument : this.getArguments())
		{
			FileFacade.getInstance()
				.getCurrentFolder()
				.addFile(new Folder(argument));
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
