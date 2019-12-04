package handler;

import command.Command;
import command.CommandQueryBuilder;
import command.OpenExplorerCommand;
import command.QueryCommand;
import util.MyScanner;

public class FileHandler extends BaseHandler
{

	@Override
	public boolean process(Command command)
	{
		OpenExplorerCommand cmd = (OpenExplorerCommand) command;
		cmd.execute();
		
		System.out.print("> ");
		String queryCommandInput = MyScanner.getString();
		
		CommandQueryBuilder builder = new CommandQueryBuilder(queryCommandInput);
		QueryCommand queryCommand = builder.getCommand();
		queryCommand.execute();
		
		return true;
	}

}
