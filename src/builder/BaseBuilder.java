package builder;

import java.util.ArrayList;

public abstract class BaseBuilder
{
	private final static int COMMAND_NAME_INDEX = 0;
	private String commandName;
	private ArrayList<String> arguments;

	public BaseBuilder(String query)
	{
		String[] queryParts = this.getArgument(query);

		this.commandName = queryParts[COMMAND_NAME_INDEX];

		arguments = new ArrayList<String>();

		for (int i = 1; i < queryParts.length; i++)
			arguments.add(queryParts[i]);
	}

	public String getCommandName()
	{
		return this.commandName;
	}

	public ArrayList<String> getArguments()
	{
		return arguments;
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

	public abstract Object getResult();
}
