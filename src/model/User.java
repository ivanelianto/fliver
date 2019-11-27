package model;

import java.util.UUID;

public class User
{
	private String id;
	private String username;
	private String password;
	private String workgroup;

	public User()
	{
		this.id = UUID.randomUUID().toString();
	}

	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getWorkgroup()
	{
		return workgroup;
	}

	public void setWorkgroup(String workgroup)
	{
		this.workgroup = workgroup;
	}
}
