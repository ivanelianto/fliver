package command;

import file.File;

public class DeleteCommand implements Command
{
	private File file;

	public DeleteCommand(File file)
	{
		this.file = file;
	}

	@Override
	public void execute()
	{

	}

}
