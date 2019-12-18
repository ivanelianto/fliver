package builder;

import command.ErrorQueryCommand;
import command.QueryCommand;
import util.Constants;

public class CommandQueryBuilder extends BaseBuilder
{
	public CommandQueryBuilder(String query)
	{
		super(query);
	}

	@Override
	public Object getResult()
	{
		try
		{
			QueryCommand queryCommand = Constants.commands.get(this.getCommandName()).newInstance();

			if (!this.getArguments().isEmpty())
				queryCommand.setArguments(this.getArguments().toArray(new String[] {}));

			return queryCommand;
		}
		catch (Exception e)
		{
			return new ErrorQueryCommand(this.getCommandName());
		}
	}
}
