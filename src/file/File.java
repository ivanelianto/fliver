package file;

public abstract class File
{
	public static final int PERMISSION_INDEX = 0;
	public static final int CREATE_TIME_INDEX = 1;
	public static final int FILENAME_INDEX = 2;
	
	private String name;
	
	public abstract void run();
	
	public String getName() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------- ");
		sb.append("00:00 ");
		return sb.toString();
	}
	
	public String getLastCharacter(int length)
	{
		int nameLength = this.getName().length();
		
		return this.getName().substring(
				nameLength - length,
				nameLength - 1);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public abstract Folder getFileContainer();

	public abstract void setFileContainer(Folder container);
}
