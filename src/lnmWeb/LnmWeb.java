package lnmWeb;



import windows.ErrorWindow;
import windows.LoginWindow;
import windows.ViewWindow;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Window;

public class LnmWeb extends ApplicationInstance
{
	Window window;
	
	@Override
	public Window init()
	{
		 window = new Window();

        window.setContent(new LoginWindow());
   
		return window;
	}
	
	public void connect() 
	{
		
		getDefaultWindow().setContent(new ViewWindow());
	
	}
	
	public void AddError(String error)
	{
		ErrorWindow errorWindow = new ErrorWindow();
		
		ContentPane content = getDefaultWindow().getContent();
		
		content.add(new Column());
		content.add(errorWindow.ErrorWindow("Не верное имя пользователя или пароль."));
	}

}
