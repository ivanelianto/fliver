package command;

import facade.FileFacade;

public class ListCommand extends QueryCommand
{
	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;
		
		FileFacade.getInstance()
			.getCurrentFolder()
			.retrieveAll();
	}

	@Override
	public boolean isValidArguments()
	{
		if (!isValidArgumentLength())
		{
			System.err.println("Too many arguments.");
			return false;
		}
		
		return true;
	}

	private boolean isValidArgumentLength()
	{
		return this.getArguments().length == 0;
	}
}
