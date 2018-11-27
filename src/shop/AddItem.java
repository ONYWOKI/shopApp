package shop;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import shop.model.dB.Queries;
import shop.model.item.Item;

public class AddItem extends Application {
	TextField id_text=new TextField();
    TextField name_text=new TextField();
    ComboBox category=new ComboBox();
    TextField buying_text=new TextField();
    TextField selling_text=new TextField();
    TextField quantity_text=new TextField();
    
	Queries queries=new Queries();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("ADD ITEM");
        stage.setResizable(false);

        GridPane grid3=new GridPane();
        grid3.setPadding(new Insets(10,10,10,10));
        grid3.setVgap(8);
        grid3.setHgap(10);

        Label item_id=new Label("Item ID");
        Label item_name=new Label("Item Name");
        Label item_category=new Label("Item Category");
        Label buying_price=new Label("Selling Price");
        Label selling_price=new Label("Buying price");
        Label quantity_purchased=new Label("Quantity Purchased");

        
        id_text.setPrefColumnCount(25);
        name_text.setPrefColumnCount(25);
        category.getItems().addAll("Soap","Unga","Oil","Cerial","Beverage");
        buying_text.setPrefColumnCount(25);
        selling_text.setPrefColumnCount(25);
        quantity_text.setPrefColumnCount(25);

        grid3.add(item_name,1,2);
        grid3.add(item_category,1,3);
        grid3.add(buying_price,1,4);
        grid3.add(selling_price,1,5);
        grid3.add(quantity_purchased,1,6);

        grid3.add(name_text,2,2);
        grid3.add(category,2,3);
        grid3.add(buying_text,2,4);
        grid3.add(selling_text,2,5);
        grid3.add(quantity_text,2,6);

        GridPane btn=new GridPane();
        btn.setPadding(new Insets(10,10,10,10));
        btn.setVgap(5);
        btn.setHgap(5);

        Button save=new Button("Save");
        save.setOnAction(event->saveItem());
        Button delete=new Button("Delete");
        delete.setOnAction(event->deleteItem());
        Button close=new Button("Close");
        close.setOnAction(event -> openManagerWindow(stage));
        btn.add(save,1,1);
        btn.add(delete,2,1);
        btn.add(close,3,1);

        GridPane pane=new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(grid3,1,1);
        pane.add(btn,1,2);

        Scene scene=new Scene(pane,550,350);
        stage.setScene(scene);
        stage.show();
    }
    private void clear() {
    	name_text.setText("");
        buying_text.setText("");
        selling_text.setText("");
        quantity_text.setText("");
    }
    private boolean deleteItem() {
    	Item item=new Item(id_text.getText(),name_text.getText(),category.getValue().toString(),Double.parseDouble(buying_text.getText()),
    			Double.parseDouble(selling_text.getText()),Integer.parseInt(quantity_text.getText()));
    	
    	if(queries.remove(item)) {
    		return true;
    	}
    	return false;
	}

	private void saveItem() {
    	Item item=new Item(id_text.getText(),name_text.getText(),category.getValue().toString(),Double.parseDouble(buying_text.getText()),
    			Double.parseDouble(selling_text.getText()),Integer.parseInt(quantity_text.getText()));
		
    
    	if(queries.AddItem(item)) {
    		JOptionPane.showMessageDialog(null, JOptionPane.PLAIN_MESSAGE, "Item Saved",JOptionPane.CLOSED_OPTION);
    	}
    	
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
