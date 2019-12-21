package command;

import java.util.Optional;

import facade.FileFacade;
import file.File;
import file.PlainFile;

public class ReadFileContentCommand extends QueryCommand
{
	private static final int FILENAME_INDEX = 0;
	
	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;
		
		String filename = this.getArguments()[FILENAME_INDEX];
		
		Optional<File> optFile = FileFacade.getInstance()
			.getCurrentFolder()
			.getFiles()
			.stream()
			.filter(x -> x.getName().equals(filename))
			.findAny();
		
		if (optFile.isPresent())
		{
			File file = optFile.get();
			
			if (file instanceof PlainFile)
				System.out.println(((PlainFile) file).getContent());
			else
				System.err.println(String.format("'%s' is a folder.", file.getName()));
		}
		else
			System.err.println("File not found.");
	}

	@Override
	public boolean isValidArguments()
	{
		if (!isValidArgumentLength())
		{
			System.err.println("Missing arguments.");
			return false;
		}
		
		return true;
	}
	
	private boolean isValidArgumentLength()
	{
		return this.getArguments().length == 1;
	}
}
