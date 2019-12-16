package command;

import facade.FileFacade;
import util.MyScanner;

public class QueryCommand implements Command
{
	private static final String DUMMY_USER_AND_HOST_NAME = "trainee@fliver";

	private static final String EXIT_TEXT = "exit";
	
	private String[] arguments;

	public String[] getArguments()
	{
		return this.arguments;
	}

	public void setArguments(String... arguments)
	{
		this.arguments = arguments;
	}

	@Override
	public void execute()
	{
		do
		{
			String text = String.format("%s:%s$ ", 
					DUMMY_USER_AND_HOST_NAME, 
					FileFacade.getInstance()
						.getCurrentFolder()
						.getCompleteFilePath());
			
			System.out.print(text);
			
			String queryCommandInput = MyScanner.getString();

			if (queryCommandInput.equalsIgnoreCase(EXIT_TEXT))
				return;

			CommandQueryBuilder builder = new CommandQueryBuilder(queryCommandInput);
			QueryCommand queryCommand = builder.getCommand();
			queryCommand.execute();
		}
		while (true);
	}
}
