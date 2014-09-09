package windows;

import windows.accordionPane.ViewMainMenuPane;
import windows.actionListeners.TopPanelActionListeners;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImage;
import nextapp.echo.app.Label;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.SplitPane;
import nextapp.echo.extras.app.AccordionPane;

public class ConfWindow extends ContentPane
{
	private ResourceImageReference back = new ResourceImageReference("/windows/background.png");
	private FillImage fil = new FillImage(back);
	
	public ConfWindow()
	{
		super();

	//	setBackgroundImage(fil);
		Label label = new Label("test");
		TopPanelActionListeners listner = new TopPanelActionListeners();
		
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
		SplitPane bottomSplitPane = new SplitPane(SplitPane.ORIENTATION_HORIZONTAL, new Extent(30, Extent.PERCENT));
		bottomSplitPane.setBackground(Color.LIGHTGRAY);
		mainSplitPane.add(bottomSplitPane);
		
		AccordionPane accordionPane = new ViewMainMenuPane();
		bottomSplitPane.add(accordionPane);
		//////		
		SplitPane bottomRightSplitPane = new SplitPane();
		bottomRightSplitPane.setBackground(Color.YELLOW);
		bottomSplitPane.add(bottomRightSplitPane);

	}
}
