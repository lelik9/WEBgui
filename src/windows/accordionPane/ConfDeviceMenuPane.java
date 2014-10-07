package windows.accordionPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import windows.table.AllTableModel;
import windows.table.TableCreate;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

public class ConfDeviceMenuPane extends AccordionPane
{
	NetInteractionController netController;
	private static Map<String, Object> data = new HashMap<String, Object>();

	private AccordionPaneLayoutData layoutData;
	private Button button;
	private Column devColumn;
	
	public ConfDeviceMenuPane(NetInteractionController netController)
	{		
		Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();
		data.put("func", "confDevice");
		data.put("confFunc", "devInfo");
		
		//Лист с именами столбцов таблицы
		Map<String, Object> columnName = new HashMap<String, Object>();
		columnName.put("0", "Имя");
		columnName.put("1", "Адресс");
		columnName.put("2", "Community");
		columnName.put("3", "Порт");
		
		//Обращение к серверу
		getData = netController.getInfo(data);
		
		//Временный лист для хранения имен групп
		List<String> tmp = new ArrayList<String>();
		Map<Integer, List<String>> tmpData = new HashMap<Integer, List<String>>();
		
		//Create groups menu
		int n = 0;
		while(getData.size() > n)
		{
			String groupName = getData.get(n).get(4);

			if(!tmp.contains(groupName))
			{
				TableCreate table = new TableCreate();
				
				layoutData = new AccordionPaneLayoutData();
				layoutData.setTitle(groupName);
				
				devColumn = new Column();
				devColumn.setLayoutData(layoutData);
				add(devColumn);	
				
				int i = 0;
				while(getData.size() > i)
				{
					if(getData.get(i).get(4).equals(groupName))
					{
						tmpData.put(i, getData.get(i));
					}
					i++;
				}
				System.out.println(tmpData);
				AllTableModel.setDeviceInfo(tmpData);
				AllTableModel.setColumnName(columnName);
				devColumn.add(table.TableCreate(tmpData.size(), columnName.size()));
				tmp.add(groupName);
			}
		//	tmpData.clear();
			n++;
		}
		tmp.clear();

	}
}
