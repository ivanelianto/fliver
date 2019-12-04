package util;

import java.util.HashMap;

import command.ListCommand;
import command.MakeDirectoryCommand;
import command.MoveCommand;
import command.QueryCommand;
import command.RemoveCommand;
import command.RemoveDirectoryCommand;

public class Constants
{
	public static final HashMap<String, Class<? extends QueryCommand>> commands = new HashMap<>();
	
	static 
	{
		commands.put("ls", ListCommand.class);
		commands.put("mkdir", MakeDirectoryCommand.class);
		commands.put("rm", RemoveCommand.class);
		commands.put("rmdir", RemoveDirectoryCommand.class);
		commands.put("mv", MoveCommand.class);
	}
}
