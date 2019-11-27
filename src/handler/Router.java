package handler;

import command.Command;

public interface Router
{
	boolean process(Command command);
	
	Router setNext(Router router);
}
