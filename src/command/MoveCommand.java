package command;

import facade.FileFacade;
import file.EmptyFile;
import file.File;
import file.Folder;

public class MoveCommand extends QueryCommand
{
	private static final int ARGUMENT_LENGTH = 2;
	private static final int SOURCE_INDEX = 0;
	private static final int DESTINATION_INDEX = 1;

	private String sourceFilePath;
	private String destinationFilePath;
	private File sourceFile;
	private File destinationFile;

	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;

		sourceFilePath = this.getArguments()[SOURCE_INDEX];
		destinationFilePath = this.getArguments()[DESTINATION_INDEX];

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
		if (processSourceFile() && processDestinationFile())
		{
			if (!(destinationFile instanceof Folder))
				System.err.println("The destination file should be directory.");
			else
			{
				File copiedFile = sourceFile.copy();
				((Folder) destinationFile).addFile(copiedFile);

				sourceFile.getParentFolder().deleteFile(sourceFile.getName());
				System.out.println("File moved.");
			}
		}
	}

	private boolean processSourceFile()
	{
		sourceFile = getFile(sourceFilePath);

		if (sourceFile instanceof EmptyFile)
		{
			System.err.println("Couldn't find the source file specified.");
			return false;
		}

		return true;
	}

	private boolean processDestinationFile()
	{
		destinationFile = getFile(destinationFilePath);

		if (destinationFile instanceof EmptyFile)
		{
			System.err.println("Couldn't find the destination file specified.");
			return false;
		}

		return true;
	}

	private File getFile(String fileName)
	{
		Folder currentFolder = FileFacade.getInstance().getCurrentFolder();

		return currentFolder.getFiles().stream()
				.filter(x -> x.getName().trim().equals(fileName))
				.findAny()
				.orElse(new EmptyFile(""));
	}
}
