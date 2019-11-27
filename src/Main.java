import command.StartupCommand;
import handler.ApplicationHandler;
import handler.AuthenticationHandler;
import handler.FileHandler;

public class Main
{

	public Main()
	{
		System.out.println("==========");
		System.out.println("| Fliver |");
		System.out.println("==========");

		ApplicationHandler handler = new ApplicationHandler();
		handler.setNext(new AuthenticationHandler()).setNext(new FileHandler());

		while (true)
			handler.process(new StartupCommand());
	}

	public static void main(String[] args)
	{
		new Main();
	}

}
