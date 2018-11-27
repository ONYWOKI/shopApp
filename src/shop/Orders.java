package shop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import shop.model.Customer;
import shop.model.dB.Queries;
import shop.model.item.Item;
import shop.model.item.Order;

public class Orders extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Orders");
        stage.setResizable(false);

        GridPane grid=new GridPane();
        Queries queries=new Queries();

        ObservableList<Order> orders = FXCollections.observableArrayList();
        for (Order order:queries.orderList())
            orders.add(order);

        TableView<Order> view=new TableView<>();
        TableColumn <Order,String> customer=new TableColumn<>("Customer");
        customer.setCellValueFactory(new PropertyValueFactory<Order,String>("phone"));
        customer.setPrefWidth(200);
        
        TableColumn <Order,String> itemName=new TableColumn<>("Item Name");
        itemName.setCellValueFactory(new PropertyValueFactory<Order,String>("itemName"));
        itemName.setPrefWidth(100);
        
        
        TableColumn <Order,Integer>q=new TableColumn<>("Quantity");
        q.setCellValueFactory(new PropertyValueFactory<Order,Integer>("quantityBought"));
        q.setPrefWidth(250);
        
        TableColumn <Order,Double> cost=new TableColumn<>("Buying price");
        cost.setCellValueFactory(new PropertyValueFactory<Order,Double>("totalCost"));
        cost.setPrefWidth(150);
      
        view.setItems(orders);
        view.getColumns().addAll(itemName,customer,q,cost);

        Button close=new Button("Close");
        close.setOnAction(event -> openManagerWindow(stage));

        grid.setVgap(5);
        grid.setHgap(5);
        grid.setPadding(new Insets(10,0,10,25));

        grid.add(view,1,1);
        grid.add(close,1,2);

        Scene scene=new Scene(grid,870,350);

        stage.setScene(scene);
        stage.show();

    }

    private void openManagerWindow(Stage stage) {
        ManagerWindow window=new ManagerWindow();
        try {
            window.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
