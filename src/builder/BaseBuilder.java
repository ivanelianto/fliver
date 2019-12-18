package builder;

import java.util.ArrayList;

public abstract class BaseBuilder
{
	private ArrayList<String> arguments;
	
	public void setArguments(ArrayList<String> arguments)
	{
		this.arguments = arguments;
	}
	
	public ArrayList<String> getArguments()
	{
		return arguments;
	}

//	public String[] getArguments()
//	{
//		ArrayList<String> result = new ArrayList<>();
//
//		String[] queryParts = text.split(" ");
//
//		int startPartIndex = -1;
//
//		for (int i = 0; i < queryParts.length; i++)
//		{
//			String queryPart = queryParts[i];
//
//			if (queryPart.contains("\""))
//			{
//				if (startPartIndex != -1)
//				{
//					StringBuilder sb = new StringBuilder();
//
//					for (int j = startPartIndex; j <= i; j++)
//					{
//						sb.append(queryParts[j]);
//						sb.append(" ");
//					}
//
//					result.add(sb.toString().replace("\"", "").trim());
//
//					startPartIndex = -1;
//					continue;
//				}
//
//				startPartIndex = i;
//			}
//			else
//			{
//				if (startPartIndex != -1)
//					continue;
//
//				result.add(queryPart.trim());
//			}
//		}
//
//		return result.toArray(new String[] {});
//	}

	public abstract Object getResult();
}
