package windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lnmWeb.LnmWeb;
import windows.table.FieldListModel;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class ConfGroupWindow extends ContentPane
{
	private NetInteractionController netController;
	private static Map<String, Object> data = new HashMap<String, Object>();
	private Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();
	
	public ConfGroupWindow(NetInteractionController NetController)
	{
		this.netController = NetController;
	}
	
	//Окно создания группы
	public WindowPane AddGroupWindow()
	{
		final WindowPane addGroupWindow = new WindowPane();
		addGroupWindow.setTitle("Добавление группы");
		addGroupWindow.setContentHeight(new Extent(100));
		
		Column mainCol = new Column();
		Row addRow = new Row();
		Row buttonRow = new Row();
		Label label = new Label("Имя группы");
		final TextField groupName = new TextField();
		Button addButton = new Button("OK");
		Button cancelButton = new Button("Отмена");

		addGroupWindow.add(mainCol);
		mainCol.add(addRow);
		mainCol.add(buttonRow);
		addRow.add(label);
		addRow.add(groupName);
		buttonRow.add(addButton);
		buttonRow.add(cancelButton);
		
		//Обработчик добавления групп
		addButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        
        	data.put("func", "DevGroupUpdate");
        	data.put("update", "insert");
        	data.put("name", groupName.getText());
        	getData = netController.getInfo(data);

        	LnmWeb lnm = new LnmWeb();
        	lnm.AddError(getData.get(0).get(0));
        	}
        });
		
		cancelButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	addGroupWindow.userClose();	        	
	        	}
	        });
		
		return addGroupWindow;
	}
	
	//Окно изменения параметров группы
	public WindowPane EditGroupWindow()
	{
		FieldListModel listModel = new FieldListModel();
		
		final WindowPane editGroupWindow = new WindowPane();
		editGroupWindow.setTitle("Редактирование");
		editGroupWindow.setContentHeight(new Extent(200));
		
		Column mainCol = new Column();
		Row nameRow = new Row();
		Row boxRow = new Row();
		Row buttonRow = new Row();
		final SelectField groupsField = new SelectField(listModel);
		Label namelabel = new Label("Имя группы");
		Label newlabel = new Label("Новое имя группы");
		final TextField groupName = new TextField();
		Button changeButton = new Button("Изменить");
		Button delButton = new Button("Удалить");
		Button cancelButton = new Button("Отмена");
		
		editGroupWindow.add(mainCol);
		mainCol.add(boxRow);
		mainCol.add(nameRow);
		mainCol.add(buttonRow);
		
		boxRow.add(namelabel);
		boxRow.add(groupsField);
		nameRow.add(newlabel);
		nameRow.add(groupName);
		buttonRow.add(changeButton);
		buttonRow.add(delButton);
		buttonRow.add(cancelButton);
		
		data.put("func", "confDevice");
		data.put("confFunc", "groupInfo");
		getData = netController.getInfo(data);
		listModel.setList(getData.get(0));
		
		groupName.setText((String) groupsField.getSelectedItem());
		groupsField.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	groupName.setText((String) groupsField.getSelectedItem());
	        }
	        });
		
		//Обработчик изменения групп
		changeButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	data.clear();
	        	getData.clear();
	        	data.put("func", "DevGroupUpdate");
	        	data.put("update", "update");
	        	data.put("new", groupName.getText());
	        	data.put("old", (String) groupsField.getSelectedItem());
	        	
	        	getData = netController.getInfo(data);
	        	
	        	LnmWeb lnm = new LnmWeb();
	        	lnm.AddError(getData.get(0).get(0));
	        }
	        });
		
		//Обработчик удаления групп
		delButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	data.clear();
	        	getData.clear();
	        	data.put("func", "DevGroupUpdate");
	        	data.put("update", "delete");
	        	data.put("name", (String) groupsField.getSelectedItem());
	        	
	        	getData = netController.getInfo(data);
	        	
	        	LnmWeb lnm = new LnmWeb();
	        	lnm.AddError(getData.get(0).get(0));
	        }
	        });
		
		cancelButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	editGroupWindow.userClose();	        	
	        	}
	        });
		return editGroupWindow;
		
	}

}
