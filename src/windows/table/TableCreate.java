package windows.table;

import java.util.List;
import java.util.Map;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Label;
import nextapp.echo.app.Table;
import nextapp.echo.app.table.AbstractTableModel;
import nextapp.echo.app.table.DefaultTableModel;
import nextapp.echo.app.table.TableCellRenderer;
import nextapp.echo.app.table.TableModel;

public class TableCreate extends Table
{

	public Table TableCreate(int row, int column)
	{
		TableModel model = new AllTableModel(row, column);
		Table table = new Table(model);
		table.setId("dataTable");
		table.setBorder(new Border(Border.STYLE_SOLID, Color.BLACK, 1));
		return table;
	}
}


