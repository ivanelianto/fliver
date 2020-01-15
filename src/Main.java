import command.QueryCommand;
import facade.FileFacade;
import file.Folder;
import file.HTMLFile;
import handler.QueryCommandHandler;

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
		
		QueryCommandHandler queryCommandHandler = new QueryCommandHandler();
		queryCommandHandler.process(new QueryCommand());
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
