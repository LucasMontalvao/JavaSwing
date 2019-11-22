package service;

import java.text.ParseException;

import view.RegisterView;

public interface IService {
	public void addUser(RegisterView form) throws ParseException;
	public void notifyError();
}
