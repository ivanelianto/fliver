package util;

import java.util.HashMap;

import command.ChangeDirectoryCommand;
import command.InsertContentCommand;
import command.ListCommand;
import command.MakeDirectoryCommand;
import command.MakeFileCommand;
import command.MoveCommand;
import command.QueryCommand;
import command.ReadFileContentCommand;
import command.RemoveCommand;
import file.HTMLFile;
import file.PlainFile;
import file.TextFile;

public class Constants
{
	public static final HashMap<String, Class<? extends QueryCommand>> commands = new HashMap<>();
	public static final HashMap<String, Class<? extends PlainFile>> fileTypes = new HashMap<>();
	
	static 
	{
//		commands.put("ls", ListCommand.class);
//		commands.put("cd", ChangeDirectoryCommand.class);
//		commands.put("mkd", MakeDirectoryCommand.class);
//		commands.put("mkf", MakeFileCommand.class);
//		commands.put("rm", RemoveCommand.class);
//		commands.put("mv", MoveCommand.class);
//		commands.put("ins", InsertContentCommand.class);
//		commands.put("cat", ReadFileContentCommand.class);
		
		commands.put("ostende", ListCommand.class);
		commands.put("lanuae", ChangeDirectoryCommand.class);
		commands.put("faciesd", MakeDirectoryCommand.class);
		commands.put("faciesf", MakeFileCommand.class);
		commands.put("aufero", RemoveCommand.class);
		commands.put("cio", MoveCommand.class);
		commands.put("posuit", InsertContentCommand.class);
		commands.put("specto", ReadFileContentCommand.class);
		
		fileTypes.put("html", HTMLFile.class);
		fileTypes.put("txt", TextFile.class);
	}
}
