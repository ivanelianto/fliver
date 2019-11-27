package file;

public abstract class PlainFile extends File
{
	private Folder container;

	@Override
	public final String getName()
	{
		String nameParts[] = super.getName().split(" ");
		
		String permission = nameParts[PERMISSION_INDEX];
		String createTime = nameParts[CREATE_TIME_INDEX];
		String fileName = nameParts[FILENAME_INDEX];
		
		fileName = fileName.substring(0, 4) 
				+ "..." 
				+ getLastCharacter(7)
				+ "/";
		
		return String.format("%s %s %s", 
				permission,
				createTime,
				fileName);
	}

	@Override
	public final Folder getFileContainer()
	{
		return this.container;
	}

	@Override
	public final void setFileContainer(Folder container)
	{
		this.container = container;
	}

}
