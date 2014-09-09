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
	private static LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
	private AccordionPaneLayoutData layoutData;
	private Button button;
	private Column buttonColumn;
	
	private String buttonName;
	ViewMainMenuPane mainMenu;
	
	public ViewDeviceMenuPane(NetInteractionController netController)
	{
	//	buttonName = mainMenu.getButtonName();
		Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();
		getData = netController.getInfo(data, "groups");
		
		List<String> groups = getData.get(0);
		List<String> devices = getData.get(1);

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
		
		n = 0;
		
				layoutData = new AccordionPaneLayoutData();
				layoutData.setTitle("Устройства");
				
				buttonColumn = new Column();
				buttonColumn.setLayoutData(layoutData);
				add(buttonColumn);			
		while(devices.size() > n)
			{
				button = new Button(devices.get(n)); 
				button.addActionListener(new ViewDeviceMenuListeners(devices.get(n), netController));
				buttonColumn.add(button);
	        n++;
		}
		setId("viewDevice");
	}
}
