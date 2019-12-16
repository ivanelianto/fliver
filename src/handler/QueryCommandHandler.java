package handler;

import command.Command;

public class QueryCommandHandler extends BaseHandler
{

	@Override
	public boolean process(Command command)
	{
		command.execute();
		return true;
	}

}
