package view;

import java.text.ParseException;

import model.RegisterModel;

public interface IRegisterView {
	public void newRegisterAdded(RegisterView form) throws ParseException;
}
