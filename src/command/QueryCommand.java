package command;

public abstract class QueryCommand implements Command
{
	private String[] arguments;
	
	public String[] getArguments()
	{
		return this.arguments;
	}

	public void setArguments(String... arguments)
	{
		this.arguments = arguments;
	}
}
