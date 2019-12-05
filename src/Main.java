import command.OpenExplorerCommand;
import facade.FileFacade;
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
		FileFacade.getInstance().getMainFolder().addFile(new HTMLFile("index.html"));
		new Main();
	}

}
