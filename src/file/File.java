package file;

public abstract class File
{
	public static final int PERMISSION_INDEX = 0;
	public static final int CREATE_TIME_INDEX = 1;
	public static final int FILENAME_INDEX = 2;
	
	protected String name;
	
	public File(String name)
	{
		this.name = name;
	}

	public abstract void run();
	
	public String getName() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------- ");
		sb.append("00:00 ");
		sb.append(name);
		return sb.toString();
	}
	
	public String getLastCharacter(int length)
	{
		int nameLength = this.name.length();
		
		return this.name.substring(
				nameLength - length,
				nameLength - 1);
	}

	public abstract Folder getFileContainer();

	public abstract void setFileContainer(Folder container);
}
