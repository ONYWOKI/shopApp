package shop;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import shop.model.Manager;
import shop.model.dB.Queries;

public class ManagerLogIn extends Application{
	private static Manager mng=new Manager();
    public static void main(String[] args)
    {
        launch(args);
    }
    TextField nameInput;
    PasswordField pass;
    public  void start(Stage stage)throws Exception
    {
        stage.setTitle("LogIn");
        stage.setResizable(false);

        GridPane grid=new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //name label
        Label label=new Label("Username:");
        GridPane.setConstraints(label, 5,1);
        //name input
        nameInput=new TextField();
        GridPane.setConstraints(nameInput, 6, 1);

        //password
        Label PswdLabel=new Label("Password:");
        GridPane.setConstraints(PswdLabel, 5,3);

        // TextField password=new TextField();
        // password.setPromptText("password:");

        pass=new PasswordField();
        pass.setPromptText("password:");
        GridPane.setConstraints(pass, 6, 3);


        Button logInButton=new Button("Log In");
        GridPane.setConstraints(logInButton,6,4);
        logInButton.setOnAction(e-> authenticate(stage));

        grid.getChildren().addAll(label,nameInput,PswdLabel, pass,logInButton);

        Scene scene=new Scene(grid,350,150);
        stage.setScene(scene);

        stage.show();
    }
    private void authenticate(Stage stage)  {
        Manager manager=new Manager(nameInput.getText(),pass.getText().trim());
        Queries queries=new Queries();
        try {
             mng=queries.authenticateManager(manager);
            if(mng !=null) {
            	ManagerWindow window=new ManagerWindow();
            	window.start(stage);
            }else {
            	this.start(stage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	public static Manager getMng() {
		return mng;
	}
	public static void setMng(Manager mng) {
		ManagerLogIn.mng = mng;
	}
    
    
}
