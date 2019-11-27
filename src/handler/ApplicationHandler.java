package handler;

import command.Command;
import command.LoginCommand;
import command.StartupCommand;

public class ApplicationHandler extends BaseHandler
{
	
	@Override
	public boolean process(Command command)
	{
		StartupCommand cmd = (StartupCommand) command;
		cmd.execute();
		
		this.processNext(new LoginCommand(
					cmd.getUsername(),
					cmd.getPassword()
				));
		
		return true;
	}

}
