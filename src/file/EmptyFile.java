package file;

public class EmptyFile extends File
{
	public EmptyFile(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public File copy()
	{
		EmptyFile file = new EmptyFile(this.name);
		file.setParentFolder(this.getParentFolder());
		return file;
	}
}
