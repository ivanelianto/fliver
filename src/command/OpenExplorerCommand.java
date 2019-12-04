package command;

import facade.FileFacade;

public class OpenExplorerCommand implements Command
{

	@Override
	public void execute()
	{
		displayAllFiles();
	}

	public void displayAllFiles()
	{
		FileFacade.getInstance()
			.getMainFolder()
			.retrieveAll();
	}
	
}
