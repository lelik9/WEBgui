package windows.actionListeners;

import windows.ConfGroupWindow;
import windows.ErrorWindow;
import windows.accordionPane.ConfDeviceMenuPane;
import lnmWeb.LnmWeb;
import controller.NetInteractionController;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.AccordionPane;

public class ConfMainMenuListeners 
{

	private NetInteractionController netController;
	
	public ConfMainMenuListeners(NetInteractionController NetController)
	{
		this.netController = NetController;
	}
	////////////////////////////////
	////////////////////////////////
	public ActionListener devRequest = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb().lnmWeb();
        	
        	
        	//Получаем доступ к окну
        	Component label = lnmWeb.getDefaultWindow().getComponent("confPanelLabel");
        	Label label2 = (Label) label;
        	label2.setText("Устройства");
        	
        	Component button = lnmWeb.getDefaultWindow().getComponent("addButton");
        	Button addButton = (Button) button;
        	addButton.setVisible(true);
        	
        	//Обработчик для кнопки вызывающий окно добавления устройств
        	addButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb();
        	lnmWeb.DiscoverDeviceWindow(netController);
        }
        });
        	
        	Component ebutton = lnmWeb.getDefaultWindow().getComponent("editButton");
        	Button editButton = (Button) ebutton;
        	editButton.setVisible(true);
        	
        	//Обработчик для кнопки вызывающий окно редактирования устройств
        	editButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb();
        	lnmWeb.DiscoverDeviceWindow(netController);
        }
        });
        	
      	
        	// Создаем AccordionPane для устройств и групп
        	AccordionPane groupPane = new ConfDeviceMenuPane(netController);
        	lnmWeb.getDefaultWindow().getComponent("confMainWindow").add(groupPane);
        }
    };
	////////////////////////////////
	////////////////////////////////
    public ActionListener groupRequest = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	
        	LnmWeb lnmWeb = new LnmWeb().lnmWeb();
        	ConfGroupWindow confWind = new ConfGroupWindow(netController);
        	
        	//Получаем доступ к окну
        	Component label = lnmWeb.getDefaultWindow().getComponent("confPanelLabel");
        	Label label2 = (Label) label;
        	label2.setText("Группы устройств");
        	
        	Component button = lnmWeb.getDefaultWindow().getComponent("addButton");
        	Button addButton = (Button) button;
        	addButton.setVisible(true);
        	
        	//Обработчик для кнопки вызывающий окно добавления группы
        	addButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb().lnmWeb();
        	ConfGroupWindow confWind = new ConfGroupWindow(netController);
        	lnmWeb.getDefaultWindow().getContent().add(confWind.AddGroupWindow());
       	
        	
        }
        });
        	
        	Component ebutton = lnmWeb.getDefaultWindow().getComponent("editButton");
        	Button editButton = (Button) ebutton;
        	editButton.setVisible(true);
        	
        	//Обработчик для кнопки вызывающий окно редактирования групп
        	editButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb().lnmWeb();
        	ConfGroupWindow confWind = new ConfGroupWindow(netController);
        	lnmWeb.getDefaultWindow().getContent().add(confWind.EditGroupWindow());
        }
        });
        	
        }
    };

}
