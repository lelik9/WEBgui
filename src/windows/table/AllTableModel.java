package windows.table;

import java.util.List;
import java.util.Map;

import nextapp.echo.app.table.AbstractTableModel;

public class AllTableModel extends AbstractTableModel
{
	private static int row;
	private static int column;
	private static Map<String, Object> columnName;
	private static Map<Integer, List<String>> DeviceInfo;
	
	public static Map<Integer, List<String>> getDeviceInfo() {
		return DeviceInfo;
	}

	public static Map<String, Object> getColumnName()
	{
		return columnName;
	}

	public static void setColumnName(Map<String, Object> data)
	{
		AllTableModel.columnName = data;
	}

	public static void setDeviceInfo(Map<Integer, List<String>> deviceInfo) {
		DeviceInfo = deviceInfo;
	}



	public AllTableModel(int rows, int columns)
		{
			row = rows;
			column = columns;
		}

	@Override
	public int getColumnCount()
		{
			// TODO Auto-generated method stub
			return column;
		}

	@Override
	public int getRowCount()
		{
			// TODO Auto-generated method stub
			return row;
		}

    @Override
    public String getColumnName(int index) 
    	{
    	return (String) columnName.get(""+index+"");
    	}
    
	@Override
	public Object getValueAt(int row, int col)
		{
		

			getColumnName(col);
			if(DeviceInfo.get(col).size() == 0)
			{
				return "";
			}else
			{
				return DeviceInfo.get(col).get(row);
			}

/*
			// TODO Auto-generated method stub
		//	Map<Integer, List<String>> device = DeviceInfo;

			List<String> err = DeviceInfo.get(arg1);
			row = err.size()-1;

			String data = err.get(arg0+1);
			if(data == null){data = "0";}
			fireTableDataChanged();
			
			return data;
*/
		}
}
