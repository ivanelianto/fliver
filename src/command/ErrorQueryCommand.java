package command;

public class ErrorQueryCommand extends QueryCommand
{
	private String firstCommand;

	public ErrorQueryCommand(String firstCommand)
	{
		this.firstCommand = firstCommand;
	}

	@Override
	public void execute()
	{
		String text = String.format("'%s' is not recognized as an internal or external command.", this.firstCommand);
		
		System.err.println(text);
	}

}
