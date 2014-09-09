package windows.actionListeners;

import lnmWeb.LnmWeb;
import controller.NetInteractionController;
import windows.accordionPane.ViewDeviceMenuPane;
import windows.accordionPane.ViewMainMenuPane;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Window;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class ViewMainMenuListeners implements ActionListener
{	
	private String buttonName;
	private NetInteractionController netcontroller;

	public ViewMainMenuListeners(String name, NetInteractionController netController)
	{
		buttonName = name;
		netcontroller = netController;
	}
	
@Override
public void actionPerformed(ActionEvent arg0)
{
	System.out.println(buttonName);
//	mainMenu.setButtonName(buttonName);
	ViewDeviceMenuPane viewDevice = new ViewDeviceMenuPane(netcontroller);
	LnmWeb lnm = new LnmWeb().lnmWeb();
	if(lnm.getDefaultWindow().getComponent("bottomRightSplitPane").getComponent("viewDevice") == null)
	{
		lnm.getDefaultWindow().getComponent("bottomRightSplitPane").add(viewDevice);

	}else{

	lnm.getDefaultWindow().getComponent("bottomRightSplitPane").getComponent("viewDevice").removeAll();
	lnm.getDefaultWindow().getComponent("bottomRightSplitPane").getComponent("viewDevice").add(viewDevice);
	}

}

}
