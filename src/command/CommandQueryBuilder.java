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
		String[] queryParts = this.getArgument(query);

		this.firstCommand = queryParts[FIRST_COMMAND_INDEX];

		arguments = new ArrayList<String>();
		for (int i = 1; i < queryParts.length; i++)
		{
			arguments.add(queryParts[i]);
		}
	}

	private String[] getArgument(String query)
	{
		ArrayList<String> result = new ArrayList<>();

		String[] queryParts = query.split(" ");

		int startPartIndex = -1;

		for (int i = 0; i < queryParts.length; i++)
		{
			String queryPart = queryParts[i];

			if (queryPart.contains("\""))
			{
				if (startPartIndex != -1)
				{
					StringBuilder sb = new StringBuilder();

					for (int j = startPartIndex; j <= i; j++)
					{
						sb.append(queryParts[j]);
						sb.append(" ");
					}

					result.add(sb.toString().replace("\"", "").trim());

					startPartIndex = -1;
					continue;
				}

				startPartIndex = i;
			}
			else
			{
				if (startPartIndex != -1)
					continue;

				result.add(queryPart.trim());
			}
		}

		return result.toArray(new String[] {});
	}

	public QueryCommand getCommand()
	{
		try
		{
			QueryCommand queryCommand = Constants.commands.get(this.firstCommand).newInstance();

			if (!this.arguments.isEmpty())
				queryCommand.setArguments(this.arguments.toArray(new String[] {}));

			return queryCommand;
		}
		catch (Exception e)
		{
			return new ErrorQueryCommand(firstCommand);
		}
	}

}
