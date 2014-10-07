package windows.accordionPane;

import java.util.HashMap;
import java.util.Map;

import windows.actionListeners.ConfMainMenuListeners;
import windows.actionListeners.ViewMainMenuListeners;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

public class ConfMainMenuPane extends AccordionPane
{
	NetInteractionController netController;
	private static Map<String, Object> data = new HashMap<String, Object>();
	private AccordionPaneLayoutData layoutData;
	private Button button;
	private Column buttonColumn;
	
	public ConfMainMenuPane(NetInteractionController netController)
	{
		ConfMainMenuListeners listner = new ConfMainMenuListeners(netController);
		
		//Добавляем вкладку "Настройки"
		layoutData = new AccordionPaneLayoutData();
		layoutData.setTitle("Настройки");
		
		//Добавляем стобец для кнопок в созданную вкладку
		buttonColumn = new Column();
		buttonColumn.setLayoutData(layoutData);
		add(buttonColumn);	
		
		button = new Button("Устройства"); 
		button.addActionListener(listner.devRequest);
		buttonColumn.add(button);
		
		button = new Button("Группы устройств"); 
		button.addActionListener(listner.groupRequest);
		buttonColumn.add(button);
		
		button = new Button("Шаблоны"); 
		button.addActionListener(listner.devRequest);
		buttonColumn.add(button);
	}

}
