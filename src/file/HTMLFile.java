package file;

public class HTMLFile extends PlainFile
{
	public HTMLFile() { }

	public HTMLFile(String name)
	{
		super(name);
	}

	@Override
	public void run()
	{

	}

	@Override
	public File copy()
	{
		HTMLFile file = new HTMLFile(this.name);
		file.setParentFolder(this.getParentFolder());
		return file;
	}
}
