package command;

import facade.FileFacade;

public class ListCommand extends QueryCommand
{

	@Override
	public void execute()
	{
		FileFacade.getInstance()
			.getCurrentFolder()
			.retrieveAll();
	}

}
