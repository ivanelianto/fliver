package file;

import java.util.ArrayList;

public class Folder implements File
{
	private ArrayList<File> files;
	private Folder container;

	public Folder()
	{
		files = new ArrayList<File>();
	}

	public void addFile(File file)
	{
		files.add(file);
	}

	public void deleteFile(File file)
	{
		files.remove(file);
	}

	@Override
	public void run()
	{

	}

	@Override
	public Folder getFileContainer()
	{
		return this.container;
	}

	@Override
	public void setFileContainer(Folder container)
	{
		this.container = container;
	}

}
