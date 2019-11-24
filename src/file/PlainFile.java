package file;

public class PlainFile implements File
{
	private Folder container;
	
	@Override
	public void run()
	{
		
	}

	@Override
	public Folder getFileContainer()
	{
		return this.container;
	}

	@Override
	public void setFileContainer(Folder container)
	{
		this.container = container;
	}

}
