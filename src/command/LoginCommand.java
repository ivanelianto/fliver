package command;

import model.User;
import util.Database;

public class LoginCommand implements Command
{
	private User user;
	private String username;
	private String password;

	public LoginCommand(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	@Override
	public void execute()
	{
		this.user = Database.users.stream()
			.filter(x -> 
				x.getUsername().equals(this.username)
				&& x.getPassword().equals(this.password)
			)
			.findAny()
			.orElse(null);
	}

	public User getLoggedInUser()
	{
		return this.user;
	}

}
