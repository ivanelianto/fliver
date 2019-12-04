package util;
import java.util.Stack;

import command.Command;

public class ApplicationCommandHistory
{
	private static Stack<Command> commands = new Stack<>();

	public static void add(Command command)
	{
		commands.add(command);
	}

	public static Command undo()
	{
		return commands.pop();
	}
}
