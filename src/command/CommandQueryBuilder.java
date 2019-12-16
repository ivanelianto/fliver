package command;

import java.util.ArrayList;

import util.Constants;

public class CommandQueryBuilder
{

	private static final int FIRST_COMMAND_INDEX = 0;

	private String firstCommand;
	private ArrayList<String> arguments;

	public CommandQueryBuilder(String query)
	{
		String[] queryParts = query.split(" ");
		this.firstCommand = queryParts[FIRST_COMMAND_INDEX];

		arguments = new ArrayList<String>();
		for (int i = 1; i < queryParts.length; i++)
		{
			arguments.add(queryParts[i]);
		}
	}

	public QueryCommand getCommand()
	{
		try
		{
			QueryCommand queryCommand = Constants.commands.get(this.firstCommand).newInstance();

			if (!this.arguments.isEmpty())
				queryCommand.setArguments(this.arguments.toArray(new String[]{}));

			return queryCommand;
		}
		catch (Exception e)
		{
			return new ErrorQueryCommand(firstCommand);
		}
	}

}
