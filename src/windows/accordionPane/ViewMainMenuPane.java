package windows.accordionPane;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




import util.XMLParser;
import windows.actionListeners.ViewMainMenuListeners;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

public class ViewMainMenuPane extends AccordionPane
{
	NetInteractionController netController;

	private AccordionPaneLayoutData layoutData;
	private Button button;
	private Column buttonColumn;
	
	public String buttonName;
	


	public ViewMainMenuPane(NetInteractionController netController)  
	{

		List<String> tab = new ArrayList<String>();		
		List<String> buttons = new ArrayList<String>();	
		XMLParser xml = new XMLParser();
		
		tab = xml.XMLParser("Tabs","¬кладки");

		System.out.println(tab);
		List<String> tmpTab = new ArrayList<String>();

		
		int n = 0;
		while(tab.size() > n)
		{
			if(!tmpTab.contains(tab.get(n)))
			{
				layoutData = new AccordionPaneLayoutData();
				layoutData.setTitle(tab.get(n));
				buttons = xml.XMLParser("tab",tab.get(n));
				int i = 0;
	
						buttonColumn = new Column();
						buttonColumn.setLayoutData(layoutData);
						add(buttonColumn);	
						tmpTab.add(tab.get(n));
				while(buttons.size() > i)
				{					
				
					button = new Button(buttons.get(i)); 
					button.addActionListener(new ViewMainMenuListeners(buttons.get(i), netController));
					buttonColumn.add(button);
					
					i++;
				}
			}
	        n++;
		}
		

        

	}
}
