package util;

import java.util.ArrayList;

import model.User;

public class Database
{
	public static ArrayList<User> users = new ArrayList<User>();

	static
	{
		users.add(new User("iv", "something"));
	}
}
