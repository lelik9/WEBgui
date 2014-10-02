package windows.accordionPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import windows.actionListeners.ViewDeviceMenuListeners;
import windows.actionListeners.ViewMainMenuListeners;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

public class ViewDeviceMenuPane extends AccordionPane
{
	NetInteractionController netController;
	private static Map<String, Object> data = new HashMap<String, Object>();
	private AccordionPaneLayoutData layoutData;
	private Button button;
	private Column buttonColumn;
	
	private String buttonName;

	
	public ViewDeviceMenuPane(NetInteractionController netController, String menuButton)
	{

		Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();
		data.put("func", "groups");
		getData = netController.getInfo(data);
		
		List<String> groups = getData.get(0);
		List<String> devices = getData.get(1);
		//Create groups menu
		int n = 0;

				layoutData = new AccordionPaneLayoutData();
				layoutData.setTitle("Группы");
				
				buttonColumn = new Column();
				buttonColumn.setLayoutData(layoutData);
				add(buttonColumn);			
		while(groups.size() > n)
			{
				button = new Button(groups.get(n)); 
				buttonColumn.add(button);
	        
	        n++;
		}
		//Create devices menu
		n = 0;
		
				layoutData = new AccordionPaneLayoutData();
				layoutData.setTitle("Устройства");
				
				buttonColumn = new Column();
				buttonColumn.setLayoutData(layoutData);
				add(buttonColumn);			
		while(devices.size() > n)
			{
				button = new Button(devices.get(n)); 
				button.addActionListener(new ViewDeviceMenuListeners(devices.get(n), netController, menuButton));
				buttonColumn.add(button);
	        n++;
		}
		setId("viewDevice");
	}
}
