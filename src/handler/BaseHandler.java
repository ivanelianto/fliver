package handler;

import command.Command;

public abstract class BaseHandler implements Router
{

	private Router nextHandler;

	public final Router setNext(Router handler)
	{
		this.nextHandler = handler;
		return handler;
	}

	public final boolean processNext(Command command)
	{
		if (this.nextHandler != null)
			this.nextHandler.process(command);
		return true;
	}

	public abstract boolean process(Command command);
}
