package file;

public class TextFile extends PlainFile
{
	public TextFile() { }

	public TextFile(String name)
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
		TextFile file = new TextFile(this.name);
		file.setParentFolder(this.getParentFolder());
		return file;
	}
}
