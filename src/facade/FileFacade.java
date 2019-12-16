package facade;

import file.Folder;

public class FileFacade
{
	private static FileFacade instance;
	private Folder mainFolder;
	private Folder currentFolder;

	private FileFacade()
	{
		this.mainFolder = new Folder("/");
		this.currentFolder = this.mainFolder;
	}

	public static FileFacade getInstance()
	{
		if (instance == null)
			instance = new FileFacade();
		return instance;
	}

	public Folder getMainFolder()
	{
		return this.mainFolder;
	}

	public Folder getCurrentFolder()
	{
		return this.currentFolder;
	}

	public void setCurrentFolder(Folder currentFolder)
	{
		this.currentFolder = currentFolder;
	}
}
