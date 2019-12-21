package command;

import facade.FileFacade;

public class RemoveCommand extends QueryCommand
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
				.deleteFile(argument);
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
