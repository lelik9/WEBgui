package windows;


import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.SplitPane;
import nextapp.echo.app.Window;
import nextapp.echo.app.WindowPane;
import nextapp.echo.extras.app.AccordionPane;

public class ViewWindow extends ContentPane

{
	
	public ViewWindow()
	{
		super();

		Column col = new Column();
		add(col);
		SplitPane topSplitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL_BOTTOM_TOP);
		topSplitPane.setSeparatorVisible(true);
	//	add(topSplitPane);

		AccordionPane accordionPane = new AccordionPane();
		SplitPane bottomSplitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM);
		bottomSplitPane.add(accordionPane);
	//	add(bottomSplitPane);

	}
}


