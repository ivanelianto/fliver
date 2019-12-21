package file;

public abstract class PlainFile extends File
{
	private static final int MAX_NAME_LENGTH_THRESHOLD = 20;

	private String content;

	public PlainFile()
	{
	}

	public PlainFile(String name)
	{
		super(name);
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
			fileName = fileName.substring(0, 4) + "..." + getLastCharacter(7) + "/";

			return String.format("%s %s %s", permission, createTime, fileName);
		}

		return name;
	}

	public String getContent()
	{
		if (this.content == null)
			this.content = "";
		
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}

}
