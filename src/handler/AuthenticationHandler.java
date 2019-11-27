package handler;

import command.Command;
import command.LoginCommand;
import command.OpenExplorerCommand;
import model.User;

public class AuthenticationHandler extends BaseHandler
{

	public AuthenticationHandler()
	{

	}

	@Override
	public boolean process(Command command)
	{
		LoginCommand cmd = (LoginCommand) command;
		cmd.execute();
		
		User user = cmd.getLoggedInUser();
		
		if (user == null)
		{
			System.err.println("Invalid username or password.");
			return false;
		}
		
		this.processNext(new OpenExplorerCommand());
		
		return true;
	}

}
