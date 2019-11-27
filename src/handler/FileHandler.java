package handler;

import command.Command;
import command.OpenExplorerCommand;

public class FileHandler extends BaseHandler
{

	@Override
	public boolean process(Command command)
	{
		OpenExplorerCommand cmd = (OpenExplorerCommand) command;
		cmd.execute();
		return true;
	}

}
