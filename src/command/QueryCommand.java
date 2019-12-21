package command;

import builder.QueryCommandBuilder;
import facade.FileFacade;
import util.MyScanner;

public class QueryCommand implements Command
{
	private static final String DUMMY_USER_AND_HOST_NAME = "trainee@fliver";
	private static final String EXIT_TEXT = "exit";

	private String[] arguments;

	public final String[] getArguments()
	{
		if (arguments == null)
			return new String[] {};

		return this.arguments;
	}

	public final void setArguments(String... arguments)
	{
		this.arguments = arguments;
	}

	public boolean isValidArguments()
	{
		return true;
	}

	@Override
	public void execute()
	{
		do
		{
			String text = String.format("%s:%s$ ", DUMMY_USER_AND_HOST_NAME,
					FileFacade.getInstance().getCurrentFolder().getCompleteFilePath());

			System.out.print(text);

			String queryCommandInput = MyScanner.getString();

			if (queryCommandInput.equalsIgnoreCase(EXIT_TEXT))
				return;

			QueryCommandBuilder builder = new QueryCommandBuilder(queryCommandInput);
			QueryCommand queryCommand = (QueryCommand) builder.getResult();
			queryCommand.execute();

			try
			{
				Thread.sleep(110);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		while (true);
	}
}
