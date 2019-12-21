package command;

import java.util.Optional;

import facade.FileFacade;
import file.File;
import file.Folder;
import file.PlainFile;

public class InsertContentCommand extends QueryCommand
{
	private static final int CONTENT_INDEX = 0;
	private static final int FILENAME_INDEX = 1;
	private static final int ARGUMENT_LENGTH = 2;
	
	private String content;
	private String filename;

	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;
		
		this.content = this.getArguments()[CONTENT_INDEX];
		this.filename = this.getArguments()[FILENAME_INDEX];
		
		processCommand();
	}

	@Override
	public boolean isValidArguments()
	{
		if (hasExceedMaximunArgumentLength())
		{
			System.err.println("Too many arguments.");
			return false;
		}
		else if (hasTooShortArgumentLength())
		{
			System.err.println("Missing arguments.");
			return false;
		}
		
		return true;
	}

	private boolean hasExceedMaximunArgumentLength()
	{
		return this.getArguments().length > ARGUMENT_LENGTH;
	}

	private boolean hasTooShortArgumentLength()
	{
		return this.getArguments().length < ARGUMENT_LENGTH;
	}
	
	private void processCommand()
	{
		Folder currentFolder = FileFacade.getInstance()
				.getCurrentFolder();
		
		Optional<File> optFile = currentFolder.getFiles().stream()
			.filter(x -> x.getName().equals(this.filename))
			.findAny();

		if (optFile.isPresent())
		{
			File file = optFile.get();
			
			if (file instanceof PlainFile)
				((PlainFile) file).setContent(this.content);
			else
				System.err.println(String.format("'%s' is a folder.", file.getName()));
		}
		else
			System.err.println("File not found.");
	}
}
