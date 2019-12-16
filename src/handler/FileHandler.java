package handler;

import command.Command;
import command.OpenExplorerCommand;
import command.QueryCommand;

public class FileHandler extends BaseHandler
{

	@Override
	public boolean process(Command command)
	{
		OpenExplorerCommand cmd = (OpenExplorerCommand) command;
		cmd.execute();
		
		QueryCommandHandler queryCommandHandler = new QueryCommandHandler();
		queryCommandHandler.process(new QueryCommand());
		
		return true;
	}

}
