package windows.accordionPane;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



import windows.actionListeners.ViewMainMenuListeners;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

public class ViewMainMenuPane extends AccordionPane
{
	NetInteractionController netController;
	private static LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
	private AccordionPaneLayoutData layoutData;
	private Button button;
	private Column buttonColumn;
	
	public String buttonName;
	
	public String getButtonName()
	{
		return buttonName;
	}

	public void setButtonName(String buttonName)
	{
		this.buttonName = buttonName;
	}

	public ViewMainMenuPane(NetInteractionController netController)  
	{
	//	netController = netController;
		Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();
		
		data.put("windowName", "ViewWindow");
		getData = netController.getInfo(data, "button");
		
		List<String> tmpTab = new ArrayList<String>();
		List<String> tab = getData.get(1);
		List<String> buttonName = getData.get(0);
		
		int n = 0;
		while(buttonName.size() > n)
		{
			if(!tmpTab.contains(tab.get(n)))
			{
				layoutData = new AccordionPaneLayoutData();
				layoutData.setTitle(tab.get(n));
				
				buttonColumn = new Column();
				buttonColumn.setLayoutData(layoutData);
				add(buttonColumn);				
				tmpTab.add(tab.get(n));

			}

			button = new Button(buttonName.get(n)); 
			button.addActionListener(new ViewMainMenuListeners(buttonName.get(n), netController));
	        buttonColumn.add(button);
	        
	        n++;
		}
		

        

	}
}
