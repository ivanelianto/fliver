package command;

import util.MyScanner;

public class StartupCommand implements Command
{
	private String username;
	private String password;

	@Override
	public void execute()
	{
		System.out.print("Username : ");
		username = MyScanner.getString();
		System.out.print("Password : ");
		password = MyScanner.getString();
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

}
