package lnmWeb;



import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import windows.ErrorWindow;
import windows.LoginWindow;
import windows.ViewWindow;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Window;

public class LnmWeb extends ApplicationInstance
{
	Window window;
	
	public static LnmWeb lnmWeb()
	{
		return (LnmWeb) getActive();
	}
	
	@Override
	public Window init()
	{
		window = new Window();
		//window.setContent(new LoginWindow());
		window.setContent(new ViewWindow());
  
		return window;
	}
	
	public void connect() 
	{
		
		lnmWeb().getDefaultWindow().setContent(new ViewWindow());
	
	}
	
	public void AddError(String error)
	{
		
		ErrorWindow errorWindow = new ErrorWindow();
		Component content = lnmWeb().getDefaultWindow().getContent();
		content.add(errorWindow.ErrorWindow("Не верное имя пользователя или пароль."));
	}

}
