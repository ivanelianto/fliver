package command;

import java.util.ArrayList;

import builder.FileBuilder;
import facade.FileFacade;
import file.PlainFile;

public class MakeFileCommand extends QueryCommand
{
	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;
		
		FileBuilder builder = new FileBuilder(String.join(" ", this.getArguments()));
		ArrayList<PlainFile> files = (ArrayList<PlainFile>) builder.getResult();
		for (PlainFile file : files)
		{
			FileFacade.getInstance()
				.getCurrentFolder()
				.addFile(file);
		}
	}
	
	private boolean isValidArguments()
	{
		if (!isValidArgumentLength())
			return false;
		
		return true;
	}

	private boolean isValidArgumentLength()
	{
		return this.getArguments().length > 0;
	}
}
