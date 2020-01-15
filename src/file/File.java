package file;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class File
{
	public static final int PERMISSION_INDEX = 0;
	public static final int CREATE_TIME_INDEX = 1;
	public static final int FILENAME_INDEX = 2;

	protected String name;
	private Folder parentFolder;
	private Date createdAt;

	public File()
	{
		this.createdAt = new Date();
	}

	public File(String name)
	{
		this();
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Folder getParentFolder()
	{
		return parentFolder;
	}

	public void setParentFolder(Folder folder)
	{
		this.parentFolder = folder;
	}

	public String getCompleteFilePath()
	{
		if (this.parentFolder != null)
		{
			String parentFolderName = this.parentFolder.getCompleteFilePath();

			if (parentFolderName.equals("/"))
				return String.format("%s%s", parentFolderName, this.name);

			return String.format("%s/%s", parentFolderName, this.name);
		}

		return this.name;
	}

	public abstract void run();

	public String getFormattedName()
	{
		StringBuilder sb = new StringBuilder();

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		sb.append(String.format("%s | ", dateFormatter.format(this.createdAt)));

		sb.append(name);
		return sb.toString();
	}

	public String getLastCharacter(int length)
	{
		int nameLength = this.name.length();

		return this.name.substring(nameLength - length, nameLength - 1);
	}

	public abstract File copy();
}
