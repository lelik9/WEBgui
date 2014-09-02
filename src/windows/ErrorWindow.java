package windows;

import functions.Login;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.SplitPane;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class ErrorWindow extends ContentPane
{
	private WindowPane errorWindow;

	public Component ErrorWindow (String error)
	{
		Label label;
		
		errorWindow = new WindowPane();
		errorWindow.setTitle("error");
		errorWindow.setContentHeight(new Extent(100));
		errorWindow.setResizable(false);
		errorWindow.setClosable(true);
		errorWindow.setMovable(false);
		
	      SplitPane splitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL_BOTTOM_TOP);
	      errorWindow.add(splitPane);
	      
	      Row buttonRow = new Row();
	      splitPane.add(buttonRow);
	      
	      Button OKbutton = new Button("OK");
	      OKbutton.addActionListener(logOK);
	      buttonRow.add(OKbutton);
	      
	      Grid errorGrid = new Grid();
	      splitPane.add(errorGrid);
	      
	      Column errorColumn = new Column();
	      label = new Label(error);
	      errorColumn.add(label);
	      errorGrid.add(errorColumn);

		return errorWindow;
	}
	ActionListener logOK = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	errorWindow.userClose();
        }
    };
}
