package shop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ManagerWindow extends Application {
    public static void main(String[] args) {
        launch (args);

    }
    public void start(Stage stage)throws Exception{
        stage.setTitle("MANAGER : "+ManagerLogIn.getMng().getFirstName()+ "  "+ManagerLogIn.getMng().getLastName());
        GridPane grid3=new GridPane();
        grid3.setPadding(new Insets(10,10,10,10));
        grid3.setVgap(8);
        grid3.setHgap(10);

        Button addItem=new Button("Add Item");
        Button viewItem=new Button("View Items");
        Button viewOrders=new Button("Orders");

        addItem.setOnAction(event -> addItem(stage));
        addItem.setPrefSize(120,50);
        viewItem.setOnAction(event -> viewItem(stage));
        viewItem.setPrefSize(120,50);
        viewOrders.setOnAction(event -> viewOrders(stage));
        viewOrders.setPrefSize(120,50);

        grid3.add(addItem,1,1);
        grid3.add(viewItem,2,1);
        grid3.add(viewOrders,3,1);

        Scene scene=new Scene(grid3,400,200);
        stage.setScene(scene);
        stage.show();

    }

    private void viewOrders(Stage stage) {
        Orders orders=new Orders();
        orders.start(stage);
    }

    private void viewItem(Stage stage) {
        ViewItems items=new ViewItems();
        items.start(stage);
    }

    private void addItem(Stage stage) {
        AddItem add=new AddItem();
        add.start(stage);
    }
}
