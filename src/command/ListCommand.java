package command;

import facade.FileFacade;

public class ListCommand extends QueryCommand
{

	@Override
	public void execute()
	{
		clearScreen();
		
		FileFacade.getInstance()
			.getCurrentFolder()
			.retrieveAll();
	}

}
