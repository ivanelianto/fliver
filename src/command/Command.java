package command;

public interface Command
{
	default void clearScreen()
	{
		for (int i = 0; i < 25; i++)
		{
			System.out.println();
		}
	}

	void execute();
}
