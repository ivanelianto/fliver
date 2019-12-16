import command.OpenExplorerCommand;
import facade.FileFacade;
import file.Folder;
import file.HTMLFile;
import handler.FileHandler;

public class Main
{

	public Main()
	{
		System.out.println("==========");
		System.out.println("| Fliver |");
		System.out.println("==========");

//		ApplicationHandler handler = new ApplicationHandler();
//		handler.setNext(new AuthenticationHandler()).setNext(new FileHandler());
//
//		while (true)
//			handler.process(new StartupCommand());
		
		FileHandler fileHandler = new FileHandler();
		fileHandler.process(new OpenExplorerCommand());
	}

	public static void main(String[] args)
	{
		Folder mainFolder = FileFacade.getInstance()
			.getMainFolder();
		
		mainFolder.addFile(new HTMLFile("index.html"));
		
		Folder something = new Folder("something");
		mainFolder.addFile(something);
		
		Folder a = new Folder("a");
		something.addFile(a);
		
		new Main();
	}

}
