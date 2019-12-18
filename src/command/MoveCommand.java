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

	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;
		
		String sourcePath = this.getArguments()[SOURCE_INDEX];
		String destinationPath = this.getArguments()[DESTINATION_INDEX];

		File sourceFile = getFile(sourcePath);
		File destinationFile = getFile(destinationPath);
		
		if (!(sourceFile instanceof EmptyFile))
		{
			if (!(destinationFile instanceof EmptyFile))
			{
				if (!(destinationFile instanceof Folder))
				{
					System.err.println("The destination file should be directory.");
				}
				else
				{
					File copiedFile = sourceFile.copy();
					((Folder) destinationFile).addFile(copiedFile);
					
					sourceFile.getParentFolder().deleteFile(sourceFile.getName());
					System.out.println("File moved.");
				}
			}
			else
			{
				System.err.println("Couldn't find the destination file specified.");
			}
		}
		else
		{
			System.err.println("Couldn't find the source file specified.");
		}
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

	private File getFile(String fileName)
	{
		Folder currentFolder = FileFacade.getInstance()
				.getCurrentFolder();
		
		return currentFolder.getFiles().stream()
				.filter(x -> x.getName().trim().equals(fileName))
				.findAny()
				.orElse(new EmptyFile(""));
	}
}
