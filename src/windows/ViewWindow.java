package windows;


import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controller.NetInteractionController;
import windows.accordionPane.ViewDeviceMenuPane;
import windows.accordionPane.ViewMainMenuPane;
import windows.actionListeners.TopPanelActionListeners;
import windows.table.TableCreate;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImage;
import nextapp.echo.app.Label;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.SplitPane;
import nextapp.echo.app.layout.RowLayoutData;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;



public class ViewWindow extends ContentPane

{
	private ResourceImageReference back = new ResourceImageReference("/windows/background.png");
	private FillImage fil = new FillImage(back);
	
	private NetInteractionController netController;
	
	public ViewWindow()
	{
		super();
		netController = new NetInteractionController();

		//	setBackgroundImage(fil);
		Alignment ALIGN_BOTTOM = new Alignment(Alignment.BOTTOM, Alignment.DEFAULT);
		Label label = new Label("test");
		TopPanelActionListeners listner = new TopPanelActionListeners(netController);
		
		SplitPane mainSplitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL, new Extent(10, Extent.PERCENT));
		mainSplitPane.setBackground(Color.BLUE);
		add(mainSplitPane);
		//////		
		SplitPane topSplitPane = new SplitPane();
		
		Row topRow = new Row();
		
		Button viewButton = new Button("Просмотр данных");
		RowLayoutData rowLayout = new RowLayoutData();
		rowLayout.setAlignment(ALIGN_BOTTOM);
		Button confButton = new Button("Настройка");
		confButton.addActionListener(listner.conf);
		confButton.setAlignment(ALIGN_BOTTOM);
		
		Button adminButton = new Button("Администрирование");
		adminButton.addActionListener(listner.admin);
		
		topRow.add(viewButton);
		topRow.add(confButton);
		topRow.add(adminButton);
		
		topSplitPane.add(topRow);
		
		mainSplitPane.add(topSplitPane);
		
		SplitPane bottomSplitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL,new Extent(95, Extent.PERCENT) );
		bottomSplitPane.setBackground(Color.RED);
		mainSplitPane.add(bottomSplitPane);
		
		//Left SplitPane for main menu
		SplitPane bottomLeftSplitPane = new SplitPane(SplitPane.ORIENTATION_HORIZONTAL, new Extent(20, Extent.PERCENT));
		bottomLeftSplitPane.setBackground(Color.GREEN);
		bottomLeftSplitPane.setResizable(true);
		bottomSplitPane.add(bottomLeftSplitPane);
		
		AccordionPane mainMenuPane = new ViewMainMenuPane(netController);
		bottomLeftSplitPane.add(mainMenuPane);
		
		// Right SplitPane for device list		
		SplitPane bottomRightSplitPane = new SplitPane(SplitPane.ORIENTATION_HORIZONTAL, new Extent(80, Extent.PERCENT));
		bottomRightSplitPane.setBackground(Color.LIGHTGRAY);
		bottomRightSplitPane.setResizable(true);
		bottomRightSplitPane.setId("bottomRightSplitPane");
		bottomLeftSplitPane.add(bottomRightSplitPane);
		
		
		//Central main window
		SplitPane bottomCentralSplitPane = new SplitPane(SplitPane.ORIENTATION_HORIZONTAL, new Extent(100, Extent.PERCENT));
		bottomCentralSplitPane.setBackground(Color.ORANGE);
		bottomCentralSplitPane.setResizable(true);
		bottomCentralSplitPane.setId("bottomCentralSplitPane");
		bottomRightSplitPane.add(bottomCentralSplitPane);
		
	//	AccordionPane deviceMenuPain = new ViewDeviceMenuPane(netController);
	//	bottomRightSplitPane.add(deviceMenuPain);

	}
}




