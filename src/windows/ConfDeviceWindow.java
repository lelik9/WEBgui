package windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import windows.table.FieldListModel;
import lnmWeb.LnmWeb;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.ListDataEvent;
import nextapp.echo.app.event.ListDataListener;
import nextapp.echo.extras.app.TabPane;
import nextapp.echo.extras.app.layout.TabPaneLayoutData;

public class ConfDeviceWindow extends ContentPane
{

	private NetInteractionController netController;
	private static Map<String, Object> data = new HashMap<String, Object>();
	private Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();
	private TextField ip1 = new TextField();
	private TextField ip2 = new TextField();
	private TextField ip3 = new TextField();
	private TextField ip4 = new TextField();
	private TextField mask1 = new TextField();
	private TextField mask2 = new TextField();
	private TextField mask3 = new TextField();
	private TextField mask4 = new TextField();
	private TextField community = new TextField();
	private TextField port = new TextField();
	private final FieldListModel deviceListModel = new FieldListModel() ;
	
	public ConfDeviceWindow(NetInteractionController NetController)
	{
		this.netController = NetController;
	}
	
	public WindowPane DiscoverDeviceWindow()
	{
		
		Label label;
		
		final WindowPane disvoverWindow = new WindowPane();
		disvoverWindow.setTitle("Обнаружение устройств");
		disvoverWindow.setContentHeight(new Extent(60, Extent.PERCENT));
		disvoverWindow.setResizable(true);
		disvoverWindow.setClosable(true);
		disvoverWindow.setMovable(true);
		
			Column mainCol = new Column();
			disvoverWindow.add(mainCol);
					
			Row ipRow = new Row();
			Row maskRow = new Row();
			Row communityRow = new Row();
			Row buttonRow = new Row();
			
			mainCol.add(ipRow);
			mainCol.add(maskRow);
			mainCol.add(communityRow);
			mainCol.add(buttonRow);
			
			//ipRow content
			label = new Label("IP address: ");
			ipRow.add(label);
			ipRow.add(ip1);
			ipRow.add(ip2);
			ipRow.add(ip3);
			ipRow.add(ip4);
			
			//maskRow content
			label = new Label("Network mask: ");
			mask1.setText("255");
			mask1.setEditable(false);
			mask2.setText("255");
			mask2.setEditable(false);
			mask3.setText("255");
			mask3.setEditable(false);
			maskRow.add(label);
			maskRow.add(mask1);
			maskRow.add(mask2);
			maskRow.add(mask3);
			maskRow.add(mask4);
			
			//communityRow content
			label = new Label("Community: ");
			communityRow.add(label);
			communityRow.add(community);
			label = new Label("Port: ");
			communityRow.add(label);
			communityRow.add(port);
			
			//buttonRow content
			Button discovery = new Button();
			discovery.setText("Добавить");
			Button cancel = new Button();
			cancel.setText("Отмена");
			buttonRow.add(discovery);
			buttonRow.add(cancel);
			
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					disvoverWindow.userClose();
				}
				});
			
			discovery.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e) {
		        	data.put("ip1", ip1.getText());
		        	data.put("ip2", ip2.getText());
		        	data.put("ip3", ip3.getText());
		        	data.put("ip4", ip4.getText());
		        	data.put("mask", mask4.getText());
		        	data.put("port", port.getText());
		        	data.put("community", community.getText());
		        	data.put("func", "DiscoverDevice");
		        	
		        	System.out.println(netController);
		        	getData = netController.getInfo(data);
		        	
		        	LnmWeb lnmWeb = new LnmWeb();
		        	lnmWeb.AddError(getData.get(0).get(0));
		        }
				});
			
			
		return disvoverWindow;
		
	}
	
	public WindowPane EditDevWindow()
	{
		
		final WindowPane editWindow = new WindowPane();
		editWindow.setTitle("Изменение параметров устройств");
		editWindow.setContentHeight(new Extent(60, Extent.PERCENT));
		
		TabPane tab = new TabPane();
		editWindow.add(tab);

		//Первая вкладка Tab панели
		TabPaneLayoutData devEditTab = new TabPaneLayoutData();
		devEditTab.setTitle("Конфигурация устройства");
		
		//Основное поле панели
		Column devEditColumn = new Column();
		devEditColumn.setLayoutData(devEditTab);
		tab.add(devEditColumn);
		
		//Строка выбора группы и устройства
		Row groupDev = new Row();
		Label group = new Label("Группа");
		Label dev = new Label("Устройство");
		FieldListModel groupsListModel = new FieldListModel();
		final SelectField groupsField = new SelectField(groupsListModel);
	//	final FieldListModel deviceListModel = new FieldListModel();
		final SelectField deviceField = new SelectField(deviceListModel);
		groupDev.add(group);
		groupDev.add(groupsField);
		groupDev.add(dev);
		groupDev.add(deviceField);
		devEditColumn.add(groupDev);
		
		//Строка IP адреса
		Row ipRow = new Row();
		Label label = new Label("IP address: ");
		ipRow.add(label);
		ipRow.add(ip1);
		ipRow.add(ip2);
		ipRow.add(ip3);
		ipRow.add(ip4);
		devEditColumn.add(ipRow);
		
		//maskRow content
		Row maskRow = new Row();
		label = new Label("Network mask: ");
		mask1.setText("255");
		mask1.setEditable(false);
		mask2.setText("255");
		mask2.setEditable(false);
		mask3.setText("255");
		mask3.setEditable(false);
		maskRow.add(label);
		maskRow.add(mask1);
		maskRow.add(mask2);
		maskRow.add(mask3);
		maskRow.add(mask4);
		devEditColumn.add(maskRow);
		
		//communityRow content
		Row communityRow = new Row();
		label = new Label("Community: ");
		communityRow.add(label);
		communityRow.add(community);
		label = new Label("Port: ");
		communityRow.add(label);
		communityRow.add(port);
		devEditColumn.add(communityRow);
		
		//buttonRow content
		Row buttonRow = new Row();
		Button edit = new Button();
		edit.setText("Изменить");
		Button del = new Button();
		del.setText("Удалить");
		Button cancel = new Button();
		cancel.setText("Отмена");
		buttonRow.add(edit);
		buttonRow.add(del);
		buttonRow.add(cancel);
		devEditColumn.add(buttonRow);
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				editWindow.userClose();
			}
			});
		
		edit.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	data.put("ip1", ip1.getText());
	        	data.put("ip2", ip2.getText());
	        	data.put("ip3", ip3.getText());
	        	data.put("ip4", ip4.getText());
	        	data.put("mask", mask4.getText());
	        	data.put("port", port.getText());
	        	data.put("community", community.getText());
	        	data.put("func", "editDevice");
	        	
	        	System.out.println(netController);
	        	getData = netController.getInfo(data);
	        	
	        	LnmWeb lnmWeb = new LnmWeb();
	        	lnmWeb.AddError(getData.get(0).get(0));
	        }
			});
		
		//Обработчик удаления устройства
		del.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	data.clear();
	        	getData.clear();
	        	data.put("func", "DevUpdate");
	        	data.put("update", "delete");
	        	data.put("name", (String) deviceField.getSelectedItem());
	        	
	        	getData = netController.getInfo(data);
	        	
	        	LnmWeb lnm = new LnmWeb();
	        	lnm.AddError(getData.get(0).get(0));
	        }
	        });
		
		data.put("func", "confDevice");
		data.put("confFunc", "groupInfo");
		getData = netController.getInfo(data);
		groupsListModel.setList(getData.get(0));
		deviceListModel.setList(new ArrayList<String>());
		
		//получение списка устройств для выбранной группы
		groupsField.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	data.clear();
	        	getData.clear();
	    		data.put("func", "confDevice");
	    		data.put("confFunc", "devInfo");
	    		data.put("name", groupsField.getSelectedItem());
	    		getData = netController.getInfo(data);
	    		deviceListModel.setList(getData.get(0));
	    		deviceListModel.
	        }
	        });
		
		return editWindow;
		
	}


    


}
