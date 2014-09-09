package windows.actionListeners;

import windows.ConfWindow;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;


public class TopPanelActionListeners 
{
	public ActionListener conf = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	System.out.println("conf");
        }
    };
    
	public ActionListener admin = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	System.out.println("admin");
        }
    };
    
	public ActionListener view = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	System.out.println("view");
        }
    };
    
}
