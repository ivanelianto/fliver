package file;

import java.util.ArrayList;

public class Folder extends File
{
	private ArrayList<File> files;
	private Folder container;

	public Folder()
	{
		files = new ArrayList<File>();
	}
	
	@Override
	public final String getName()
	{
		String nameParts[] = super.getName().split(" ");
		
		String permission = nameParts[PERMISSION_INDEX];
		String createTime = nameParts[CREATE_TIME_INDEX];
		String fileName = nameParts[FILENAME_INDEX];
		
		fileName = fileName.substring(0, 4) 
				+ "..." 
				+ getLastCharacter(3)
				+ "/";
		
		return String.format("%s %s %s", 
				permission,
				createTime,
				fileName);
	}

	public void addFile(File file)
	{
		files.add(file);
	}

	public void deleteFile(File file)
	{
		files.remove(file);
	}
	
	public void retrieveAll()
	{
		for (File file : files)
		{
			System.out.println(file.getName());
		}
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
