package functions;

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
	public Table TableCreate()
	{
		TableModel model = new MultiplicationTableModel();
		TableModel model2 = new DefaultTableModel();
		Table table = new Table(model2);
		table.setBorder(new Border(Border.STYLE_SOLID, Color.BLACK, 1));
		return table;
	}
}
class MultiplicationTableModel 
extends AbstractTableModel {

    public Object getValueAt(int column, int row) {

        return new Integer((column + 1) * (row + 1));
    }

    public int getColumnCount() {
        return 12;
    }

    public int getRowCount() {
        return 12;
    }
}
