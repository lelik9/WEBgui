package lnmWeb;



import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controller.NetInteractionController;
import windows.AdminWindow;
import windows.ConfWindow;
import windows.ErrorWindow;
import windows.LoginWindow;
import windows.ViewWindow;
import windows.ConfDeviceWindow;
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
	
	public void viewWindow(NetInteractionController netController) 
	{
		//Переход в окно просмотра информации
		lnmWeb().getDefaultWindow().setContent(new ViewWindow());
	
	}
	
	public void confWindow(NetInteractionController netController) 
	{
		//Переход в окно настроек
		lnmWeb().getDefaultWindow().setContent(new ConfWindow(netController));
	
	}
	
	public void adminWindow(NetInteractionController netController) 
	{
		//Переход в окно администрирования
		lnmWeb().getDefaultWindow().setContent(new AdminWindow());
	
	}
	
	public void AddError(String error)
	{
		//Всплывающее окно ошибок
		ErrorWindow errorWindow = new ErrorWindow();
		Component content = lnmWeb().getDefaultWindow().getContent();
		content.add(errorWindow.ErrorWindow(error));
	}
	

}
