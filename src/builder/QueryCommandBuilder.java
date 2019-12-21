package builder;

import java.util.ArrayList;

import command.ErrorQueryCommand;
import command.QueryCommand;
import util.Constants;

public class QueryCommandBuilder extends BaseBuilder
{
	private final static int COMMAND_NAME_INDEX = 0;
	private String commandName;

	public QueryCommandBuilder(String query)
	{
		int firstSpaceIndex = query.indexOf(" ");

		if (firstSpaceIndex == -1)
			this.commandName = query;
		else
		{
			this.commandName = query.substring(COMMAND_NAME_INDEX, firstSpaceIndex);

			String argumentsString = query.substring(firstSpaceIndex + 1);

			ArrayList<String> queryParts = this.getArguments(argumentsString);

			if (queryParts.size() > 0)
				this.setArguments(queryParts);
		}
	}

	@Override
	public Object getResult()
	{
		try
		{
			QueryCommand queryCommand = Constants.commands.get(this.commandName).newInstance();

			ArrayList<String> arguments = this.getArguments();

			if (arguments != null)
				queryCommand.setArguments(arguments.toArray(new String[] {}));

			return queryCommand;
		}
		catch (Exception e)
		{
			return new ErrorQueryCommand(this.commandName);
		}
	}

	private ArrayList<String> getArguments(String query)
	{
		ArrayList<String> result = new ArrayList<>();

		String[] queryParts = query.split(" ");

		int startPartIndex = -1;

		for (int i = 0; i < queryParts.length; i++)
		{
			String queryPart = queryParts[i];
			
			if (queryPart.equals(""))
				continue;

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

					result.add(sb.toString().replace("\"", ""));

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

		return result;
	}
}
