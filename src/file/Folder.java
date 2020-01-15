package file;

import java.util.ArrayList;
import java.util.Optional;

public class Folder extends File
{
	private static final int MAX_NAME_LENGTH_THRESHOLD = 15;
	private ArrayList<File> files;
	
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

	public boolean addFile(File file)
	{
		Optional<File> optFile = this.files.stream()
				.filter(x -> x.getName().trim()
							.equals(file.getName().trim()))
				.findAny();
		
		if (optFile.isPresent())
		{
			System.err.println(String.format("'%s' directory or file already exists.", 
					file.getName()));
			
			return false;
		}
		
		files.add(file);
		file.setParentFolder(this);
		return true;
	}

	public void deleteFile(String fileName)
	{
		Optional<File> optSelectedFile = files.stream()
				.filter(x -> x.getName().trim().equals(fileName.trim()))
				.findAny();
		
		if (!optSelectedFile.isPresent())
		{
			System.err.println("The system cannot find the file specified.");
			return;
		}
		
		files.remove(optSelectedFile.get());
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
	public File copy()
	{
		Folder folder = new Folder(this.name);
		folder.setParentFolder(this.getParentFolder());
		return folder;
	}

	public ArrayList<File> getFiles()
	{
		 return this.files;
	}
}
