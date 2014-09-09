package windows.actionListeners;

import lnmWeb.LnmWeb;
import controller.NetInteractionController;
import functions.TableCreate;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class ViewDeviceMenuListeners implements ActionListener
{
	private String buttonName;
	private NetInteractionController netcontroller;
	
	public ViewDeviceMenuListeners(String name, NetInteractionController netController)
	{
		buttonName = name;
		netcontroller = netController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		TableCreate table = new TableCreate();
		LnmWeb lnm = new LnmWeb().lnmWeb();
		lnm.getDefaultWindow().getContent().getComponent("bottomCentralSplitPane").add(table.TableCreate());
		
	}

}
