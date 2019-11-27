package util;

import java.util.ArrayList;

import file.File;
import file.HTMLFile;
import model.User;

public class Database
{
	public static ArrayList<User> users = new ArrayList<User>();
	
	public static ArrayList<File> files = new ArrayList<File>();

	static
	{
		users.add(new User("iv", "something"));
		
		files.add(new HTMLFile());
	}
}
