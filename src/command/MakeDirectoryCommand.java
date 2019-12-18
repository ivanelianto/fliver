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

		return true;
	}

	private boolean isValidArgumentLength()
	{
		return this.getArguments().length > 0;
	}
}
