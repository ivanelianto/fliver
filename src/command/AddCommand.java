package command;

import file.File;

public class AddCommand implements Command 
{
	private File file;
	
	public AddCommand(File file)
	{
		this.file = file;
	}

	@Override
	public void execute()
	{
		
	}

}
