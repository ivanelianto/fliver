package command;

import java.util.ArrayList;
import java.util.Optional;

import facade.FileFacade;
import file.File;
import file.Folder;

public class ChangeDirectoryCommand extends QueryCommand
{
	private FileFacade fileFacade;

	public ChangeDirectoryCommand()
	{
		fileFacade = FileFacade.getInstance();
	}

	@Override
	public void execute()
	{
		if (!isValidArguments())
			return;

		String path = this.getArguments()[0];
		String[] folderNames = path.split("/");

		boolean isFound = true;

		for (String folderName : folderNames)
		{
			Folder currentFolder = fileFacade.getCurrentFolder();

			if (isDot(folderName))
				fileFacade.setCurrentFolder(currentFolder);
			else if (folderName.equals("..")
					&& currentFolder.getParentFolder() != null)
				fileFacade.setCurrentFolder(currentFolder.getParentFolder());
			else
			{
				ArrayList<File> sources = currentFolder.getFiles();
				Folder selectedFolder = this.findDirectory(sources, folderName);

				if (selectedFolder == null)
				{
					isFound = false;
					break;
				}

				fileFacade.setCurrentFolder(selectedFolder);
			}
		}

		if (!isFound)
			System.err.println("No such file or directory.");
	}
	
	private boolean isValidArguments()
	{
		if (this.getArguments().length > 1)
		{
			System.err.println("Too many arguments.");
			return false;
		}
		
		return true;
	}

	private boolean isDot(String folderName)
	{
		return folderName.equals(".");
	}

	private Folder findDirectory(ArrayList<File> sources, String folderName)
	{
		Optional<File> optFile = sources.stream().filter(x -> x.getName().equals(folderName)).findFirst();

		if (optFile.isPresent())
		{
			if (!(optFile.get() instanceof Folder))
				System.err.println(String.format("'%s' is not a directory.", folderName));
			else
				return (Folder) optFile.get();
		}

		return null;
	}
}
