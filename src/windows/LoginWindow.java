package windows;





import lnmWeb.LnmWeb;
import functions.Login;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.FillImage;
import nextapp.echo.app.Grid;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.SplitPane;
import nextapp.echo.app.TextField;
import nextapp.echo.app.Window;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.layout.GridLayoutData;


public class LoginWindow extends ContentPane
{
	private Alignment CENTER;
	private Alignment ALIGN_LEFT ;
	private Color red = Color.CYAN;
	private ResourceImageReference back = new ResourceImageReference("/windows/background.png");
	private FillImage fil = new FillImage(back);
	private TextField loginEntryField = new TextField();
	private PasswordField passEntryField = new PasswordField();

public LoginWindow()
{


	  super();
	  setOverflow(OVERFLOW_AUTO);
	//  setBackgroundImage(fil);
		

	  loginEntryField.setAlignment(ALIGN_LEFT);
  
      Label label;


      
		WindowPane loginWindow = new WindowPane();
		loginWindow.setTitle("Welcom to LNM");
		loginWindow.setContentHeight(new Extent(100));
		loginWindow.setResizable(false);
		loginWindow.setClosable(false);
		loginWindow.setMovable(false);
		add(loginWindow);
      
      SplitPane splitPane = new SplitPane(SplitPane.ORIENTATION_VERTICAL_BOTTOM_TOP);
      loginWindow.add(splitPane);
      
      Row buttonRow = new Row();
      splitPane.add(buttonRow);
      
      Button OKbutton = new Button("OK");
      buttonRow.setAlignment(CENTER);
      OKbutton.addActionListener(logOK);
      buttonRow.add(OKbutton);

      Grid loginGrid = new Grid();
      splitPane.add(loginGrid);

      Column loginColumn = new Column();
      GridLayoutData gridLayoutData = new GridLayoutData();
      gridLayoutData.setColumnSpan(2);
      loginColumn.setLayoutData(gridLayoutData);
      loginGrid.add(loginColumn);
      
      label = new Label("Login: ");
      loginGrid.add(label);
      loginGrid.add(loginEntryField);
      
      label = new Label("Password: ");
      loginGrid.add(label);
      loginGrid.add(passEntryField);
      

      

  }
  
	ActionListener logOK = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        	Login login = new Login();
        	login.Login(loginEntryField.getText(), passEntryField.getText());      	
        }
    };

}


