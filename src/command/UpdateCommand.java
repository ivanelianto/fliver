package command;

import file.File;

public class UpdateCommand implements Command
{
	private File file;

	public UpdateCommand(File file)
	{
		this.file = file;
	}

	@Override
	public void execute()
	{

	}

}
