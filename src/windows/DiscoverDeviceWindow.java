package windows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lnmWeb.LnmWeb;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class DiscoverDeviceWindow extends ContentPane
{
	private WindowPane disvoverWindow;
	private NetInteractionController netController;
	private static Map<String, Object> data = new HashMap<String, Object>();
	private Map<Integer, List<String>> getData = new HashMap<Integer, List<String>>();
	private TextField ip1 = new TextField();
	private TextField ip2 = new TextField();
	private TextField ip3 = new TextField();
	private TextField ip4 = new TextField();
	private TextField mask4 = new TextField();
	private TextField community = new TextField();
	private TextField port = new TextField();
	
	public Component DiscoverDeviceWindow(NetInteractionController NetController)
	{
		this.netController = NetController;
		Label label;
		
		disvoverWindow = new WindowPane();
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
			TextField mask1 = new TextField();
			mask1.setText("255");
			mask1.setEditable(false);
			TextField mask2 = new TextField();
			mask2.setText("255");
			mask2.setEditable(false);
			TextField mask3 = new TextField();
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
			discovery.addActionListener(AddDevice);
			Button cancel = new Button();
			cancel.setText("Отмена");
			cancel.addActionListener(Cancel);
			buttonRow.add(discovery);
			buttonRow.add(cancel);
			
		return disvoverWindow;
		
	}
	
	ActionListener Cancel = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	disvoverWindow.userClose();
        }
    };
    
	ActionListener AddDevice = new ActionListener(){
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
    };

}
