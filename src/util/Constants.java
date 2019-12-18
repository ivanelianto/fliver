package util;

import java.util.HashMap;

import command.ChangeDirectoryCommand;
import command.ListCommand;
import command.MakeDirectoryCommand;
import command.MakeFileCommand;
import command.MoveCommand;
import command.QueryCommand;
import command.RemoveCommand;
import command.RemoveDirectoryCommand;
import file.HTMLFile;
import file.PlainFile;
import file.TextFile;

public class Constants
{
	public static final HashMap<String, Class<? extends QueryCommand>> commands = new HashMap<>();
	public static final HashMap<String, Class<? extends PlainFile>> fileTypes = new HashMap<>();
	
	static 
	{
		commands.put("ls", ListCommand.class);
		commands.put("cd", ChangeDirectoryCommand.class);
		commands.put("mkdir", MakeDirectoryCommand.class);
		commands.put("firel", MakeFileCommand.class);
		commands.put("rmdir", RemoveDirectoryCommand.class);
		commands.put("rm", RemoveCommand.class);
		commands.put("mv", MoveCommand.class);
		
		fileTypes.put("html", HTMLFile.class);
		fileTypes.put("txt", TextFile.class);
	}
}
