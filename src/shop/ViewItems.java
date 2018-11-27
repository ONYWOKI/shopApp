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
import shop.model.dB.Queries;
import shop.model.item.Item;

import javax.swing.table.TableModel;

public class ViewItems extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Items");
        stage.setResizable(false);

        GridPane grid=new GridPane();
        Queries queries=new Queries();

        ObservableList<Item> items = FXCollections.observableArrayList();
        for (Item item:queries.itemsList())
            items.add(item);

        TableView<Item> view=new TableView<>();

        TableColumn <Item,String> id=new TableColumn<>("Item ID");
        id.setCellValueFactory(new PropertyValueFactory<Item,String>("itemID"));
        id.setPrefWidth(100);
        
        TableColumn <Item,String> name=new TableColumn<>("Item Name");
        name.setCellValueFactory(new PropertyValueFactory<Item,String>("itemName"));
        name.setPrefWidth(200);
        
        TableColumn <Item,String>category=new TableColumn<>("Item Category");
        category.setCellValueFactory(new PropertyValueFactory<Item,String>("itemCategory"));
        category.setPrefWidth(250);
        
        TableColumn <Item,Double> buying_price=new TableColumn<>("Buying price");
        buying_price.setCellValueFactory(new PropertyValueFactory<Item,Double>("buyingPrice"));
        buying_price.setPrefWidth(150);
        
        TableColumn <Item,Double> selling_price=new TableColumn<>("Buying price");
        selling_price.setCellValueFactory(new PropertyValueFactory<Item,Double>("buyingPrice"));
        selling_price.setPrefWidth(150);

        TableColumn <Item,Integer> quantity=new TableColumn<>("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<Item,Integer>("quantity"));
        quantity.setPrefWidth(150);

        view.setItems(items);
        view.getColumns().addAll(id,name,category,buying_price,selling_price,quantity);

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
