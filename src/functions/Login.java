package functions;

import controller.NetInteractionController;
import lnmWeb.LnmWeb;
import windows.LoginWindow;

public class Login
{
	public void Login(String login, String password)
	{
		LnmWeb lnm = new LnmWeb();
		NetInteractionController netController = new NetInteractionController();
		
		if(login.equals("Alex") || password.equals(" "))
		{
			lnm.connect();
		}else
		{
			lnm.AddError("Не верное имя пользователя или пароль.");
		}
		
	}


}
