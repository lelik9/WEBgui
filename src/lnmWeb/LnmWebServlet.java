package lnmWeb;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.webcontainer.WebContainerServlet;

public class LnmWebServlet extends WebContainerServlet
{

	@Override
	public ApplicationInstance newApplicationInstance()
	{
		return new LnmWeb();
	}

}
