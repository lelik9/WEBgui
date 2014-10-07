package windows;

import lnmWeb.LnmWeb;
import controller.NetInteractionController;
import windows.accordionPane.ConfMainMenuPane;
import windows.actionListeners.TopPanelActionListeners;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImage;
import nextapp.echo.app.Label;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.SplitPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.AccordionPane;

public class ConfWindow extends ContentPane
{
	private ResourceImageReference back = new ResourceImageReference("/windows/background.png");

	
	public ConfWindow(NetInteractionController netController)
	{
		super();

	//	setBackgroundImage(fil);

		TopPanelActionListeners listner = new TopPanelActionListeners(null);
		
		SplitPane mainSplitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL, new Extent(10, Extent.PERCENT));
		mainSplitPane.setBackground(Color.CYAN);
		add(mainSplitPane);
		//////		
		SplitPane topSplitPane = new SplitPane();
		
		Row topRow = new Row();
		
		Button viewButton = new Button("Просмотр данных");
		
		Button confButton = new Button("Настройка");
		//confButton.addActionListener(listner.conf);
		
		Button adminButton = new Button("Администрирование");
		adminButton.addActionListener(listner.admin);
		
		topRow.add(viewButton);
		topRow.add(confButton);
		topRow.add(adminButton);
		
		topSplitPane.add(topRow);
		
		mainSplitPane.add(topSplitPane);
		//////
		SplitPane bottomSplitPane = new SplitPane(SplitPane.ORIENTATION_HORIZONTAL, new Extent(20, Extent.PERCENT));
		bottomSplitPane.setBackground(Color.LIGHTGRAY);
		mainSplitPane.add(bottomSplitPane);
		
		AccordionPane accordionPane = new ConfMainMenuPane(netController);
		bottomSplitPane.add(accordionPane);
		//////		
		SplitPane bottomRightSplitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL, new Extent(5, Extent.PERCENT));
		bottomRightSplitPane.setBackground(Color.YELLOW);
		bottomRightSplitPane.setId("confMainWindow");
		bottomSplitPane.add(bottomRightSplitPane);// Добавляем bottomRightSplitPane

    	//Создаем строку для кнопок и надписи
		Column mainColumn = new Column();
		Row titleRow = new Row();
		bottomRightSplitPane.add(mainColumn);
		mainColumn.add(titleRow);
		
    	Label label = new Label();
    	label.setId("confPanelLabel");
    	
    	Button addButton = new Button("Добавить");  	
    	addButton.setId("addButton");
    	addButton.setVisible(false);
    	
    	Button editButton = new Button("Изменить");  	
    	editButton.setId("editButton");
    	editButton.setVisible(false);
   	
    	titleRow.add(label);
    	titleRow.add(addButton);
    	titleRow.add(editButton);

	}
}
