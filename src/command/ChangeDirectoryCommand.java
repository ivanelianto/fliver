package command;

import java.util.ArrayList;
import java.util.Optional;

import facade.FileFacade;
import file.File;
import file.Folder;

public class ChangeDirectoryCommand extends QueryCommand
{
	@Override
	public void execute()
	{
		if (this.getArguments() == null)
			return;
		else if (this.getArguments().length > 1)
		{
			System.err.println("Too many arguments.");
			return;
		}

		String path = this.getArguments()[0];
		String[] folderNames = path.split("/");

		boolean isFound = false;

		for (String folderName : folderNames)
		{
			Folder currentFolder = FileFacade.getInstance().getCurrentFolder();
			
			ArrayList<File> sources = currentFolder.getFiles();
			
			Folder selectedFolder = this.findDirectory(sources, folderName);

			if (selectedFolder == null)
			{
				System.err.println(String.format("'%s' is not a directory.", folderName));
				continue;
			}

			isFound = true;
			FileFacade.getInstance().setCurrentFolder(selectedFolder);
		}

		if (!isFound)
			System.err.println("No such file or directory.");
	}

	private Folder findDirectory(ArrayList<File> sources, String folderName)
	{
		Optional<File> optFile = sources.stream().filter(x -> x.getName().equals(folderName)).findFirst();

		if (optFile.isPresent())
		{
			if (optFile.get() instanceof Folder)
				return (Folder) optFile.get();
		}

		return null;
	}
}
