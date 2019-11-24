package util;

import java.util.Scanner;

public class MyScanner
{
	private static Scanner scanner = new Scanner(System.in);

	public static String getString()
	{
		return scanner.nextLine();
	}

	public static int getInteger()
	{
		int result = -1;

		try
		{
			result = scanner.nextInt();
			getString();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}

		return result;
	}
}
