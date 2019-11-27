package facade;

import file.Folder;

public class FileFacade
{
	private static FileFacade instance;
	private Folder mainFolder;

	private FileFacade()
	{
		mainFolder = new Folder();
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
}
