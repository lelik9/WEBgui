package windows.actionListeners;

import controller.NetInteractionController;
import lnmWeb.LnmWeb;
import windows.ConfWindow;
import windows.ViewWindow;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;


public class TopPanelActionListeners 
{
	private NetInteractionController netController;
	
	public TopPanelActionListeners(NetInteractionController NetController)
	{
		this.netController = NetController;
	}
	
	public ActionListener conf = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb();
        	lnmWeb.confWindow(netController);
        }
    };
    
	public ActionListener admin = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb();
        	lnmWeb.adminWindow(netController);
        }
    };
    
	public ActionListener view = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	LnmWeb lnmWeb = new LnmWeb();
        	lnmWeb.viewWindow(netController);
        }
    };
    
}
