package windows.actionListeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.XMLParser;
import windows.accordionPane.ViewMainMenuPane;
import windows.table.AllTableModel;
import windows.table.TableCreate;
import lnmWeb.LnmWeb;
import controller.NetInteractionController;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class ViewDeviceMenuListeners implements ActionListener
{
	private String buttonName;
	private String menubutton;
	private NetInteractionController netcontroller;
	private static Map<String, Object> data = new HashMap<String, Object>();
	private static Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();

	
	public ViewDeviceMenuListeners(String name, NetInteractionController netController, String menuButton)
	{
		buttonName = name;
		netcontroller = netController;
		menubutton = menuButton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		LnmWeb lnm = new LnmWeb().lnmWeb();
		TableCreate table = new TableCreate();
		XMLParser xml = new XMLParser();
		
		List<String> inf = new ArrayList<String>();
		ViewMainMenuPane mainMenu = new ViewMainMenuPane(netcontroller);

		inf = xml.XMLParser("button", menubutton);
				
		int n = 0;
		while(n<inf.size())
		{
			data.put(""+n+"", inf.get(n));
			n++;
		}
		
		data.put("devName", buttonName);
		data.put("func", "devInfo");
		
		getData = netcontroller.getInfo(data);
		
		

		if(lnm.getDefaultWindow().getComponent("bottomCentralSplitPane").getComponent("dataTable") == null)
		{
			AllTableModel.setDeviceInfo(getData);
			AllTableModel.setColumnName(data);
			lnm.getDefaultWindow().getContent().getComponent("bottomCentralSplitPane").add(table.TableCreate(getData.size(), data.size()-2));
		}else
			{
				AllTableModel.setDeviceInfo(getData);
				AllTableModel.setColumnName(data);
				lnm.getDefaultWindow().getComponent("bottomCentralSplitPane").removeAll();
				lnm.getDefaultWindow().getComponent("bottomCentralSplitPane").add(table.TableCreate(getData.size(), data.size()-2));
			}
		
	}

}
