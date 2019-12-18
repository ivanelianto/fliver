package file;

import java.util.ArrayList;

public class Folder extends File
{
	private static final int MAX_NAME_LENGTH_THRESHOLD = 15;
	private ArrayList<File> files;
	private Folder container;
	
	public Folder(String name)
	{
		super(name);
		files = new ArrayList<File>();
	}

	@Override
	public final String getFormattedName()
	{
		String name = super.getFormattedName();

		String nameParts[] = name.split(" ");

		String permission = nameParts[PERMISSION_INDEX];
		String createTime = nameParts[CREATE_TIME_INDEX];
		String fileName = nameParts[FILENAME_INDEX];

		if (fileName.length() > MAX_NAME_LENGTH_THRESHOLD)
		{
			fileName = fileName.substring(0, 4) + "..." + getLastCharacter(3) + "/";

			return String.format("%s %s %s", permission, createTime, fileName);
		}
		
		return name;
	}

	public void addFile(File file)
	{
		if (this.files.stream()
				.filter(x -> x.getName().trim()
							.equals(file.getName().trim()))
				.findAny()
				.isPresent())
		{
			System.err.println(String.format("'%s' directory already exists.", 
					file.getName()));
			
			return;
		}
		
		files.add(file);
		file.setParentFolder(this);
	}

	public void deleteFile(File file)
	{
		files.remove(file);
	}

	public void retrieveAll()
	{
		for (File file : files)
		{
			System.out.println(file.getFormattedName());
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

	public ArrayList<File> getFiles()
	{
		 return this.files;
	}
}
