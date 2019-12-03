package model;


import java.util.List;

public interface IServiceBase<Object> {
	public void addUser(Object form);
	public Object getUser(Object form);
	public List<Object> getAllUsers();
	public void DeleteUser(int id);
}
