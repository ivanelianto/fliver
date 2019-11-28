package file;

public abstract class PlainFile extends File
{
	private static final int MAX_NAME_LENGTH_THRESHOLD = 20;
	private Folder container;

	public PlainFile(String name)
	{
		super(name);
	}

	@Override
	public final String getName()
	{
		String name = super.getName();

		String nameParts[] = name.split(" ");

		String permission = nameParts[PERMISSION_INDEX];
		String createTime = nameParts[CREATE_TIME_INDEX];
		String fileName = nameParts[FILENAME_INDEX];

		if (fileName.length() > MAX_NAME_LENGTH_THRESHOLD)
		{
			fileName = fileName.substring(0, 4) + "..." + getLastCharacter(7) + "/";

			return String.format("%s %s %s", permission, createTime, fileName);
		}
		
		return name;
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
