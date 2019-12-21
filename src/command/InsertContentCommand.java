package command;

import java.util.Optional;

import facade.FileFacade;
import file.File;
import file.Folder;
import file.PlainFile;

public class InsertContentCommand extends QueryCommand
{
	private static final int CONTENT_INDEX = 0;
	private static final int INPUT_REDIRECTION_INDEX = 1;
	private static final int FILENAME_INDEX = 2;
	private static final int ARGUMENT_LENGTH = 3;
	
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
		else if (!hasInputRedirectionArgument())
		{
			System.err.println("Missing the input redirection.");
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
	
	private boolean hasInputRedirectionArgument()
	{
		return this.getArguments()[INPUT_REDIRECTION_INDEX].contains(">");
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
			{
				if (isWriteInputRedirection())
					((PlainFile) file).setContent(this.content);
				else if (isAppendInputRedirection())
				{
					String content = ((PlainFile) file).getContent() + this.content;
					((PlainFile) file).setContent(content);
				}
			}
			else
				System.err.println(String.format("'%s' is a folder.", file.getName()));
		}
		else
			System.err.println("File not found.");
	}
	
	private boolean isWriteInputRedirection()
	{
		return this.getArguments()[INPUT_REDIRECTION_INDEX].equals(">>");
	}
	
	private boolean isAppendInputRedirection()
	{
		return this.getArguments()[INPUT_REDIRECTION_INDEX].equals(">");
	}
}
