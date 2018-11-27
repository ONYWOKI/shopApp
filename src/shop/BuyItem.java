package shop;
import shop.ManagerLogIn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import shop.model.Customer;
import shop.model.dB.Queries;
import shop.model.item.Item;
import shop.model.item.Order;
public class BuyItem extends Application {
	    TextField id_text=new TextField();
	    TextField item_name_text=new TextField();
	    ComboBox category=new ComboBox();
	    TextField quantity_text=new TextField();
	    TextField cost=new TextField();
	    TextField phone=new TextField();
	    TextField price=new TextField();
		Queries queries=new Queries();
        Button submit=new Button("Submit");



	    public static void main(String[] args) {
	        launch(args);
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public void start(Stage stage) {
	        stage.setTitle(" Buy ITEM");
	        stage.setResizable(false);

	        GridPane table=new GridPane();
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
	        
	        TableColumn <Item,Double> selling_price=new TableColumn<>("Price ");
	        selling_price.setCellValueFactory(new PropertyValueFactory<Item,Double>("SellingPrice"));
	        selling_price.setPrefWidth(150);

	        view.setItems(items);
	        view.getColumns().addAll(id,name,category,selling_price);
	        
	        view.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent me) {
	                    if (me.getClickCount() >= 1) {
	                        String  id = view.getItems().get(view.getSelectionModel().getSelectedIndex()).getItemID();
	                        String  item_name = view.getItems().get(view.getSelectionModel().getSelectedIndex()).getItemName();
	                        Double  cost = view.getItems().get(view.getSelectionModel().getSelectedIndex()).getSellingPrice();
	                        price.setText(""+cost); 
	                        item_name_text.setText(""+item_name);
	                        id_text.setText(id); 
	                   }
	                }
	         });
	        
	        table.add(view, 1,1);
	        
	        GridPane grid=new GridPane();
	        grid.setPadding(new Insets(10,10,10,10));
	        grid.setVgap(5);
	        grid.setHgap(5);
	        
	        Label itd=new Label("Item ID");
	        Label item_name=new Label("Item Name");
	        Label quantity_purchased=new Label("quantity Purchased");	        
	        Label cost_label=new Label("Total cost");
	        Label price_label=new Label("Cost");	
	        Label customer=new Label("Customer Phone");	
	        
	        id_text.setPrefColumnCount(25);	
	        item_name_text.setPrefColumnCount(25);	
	        item_name_text.setEditable(false);
	        price.setEditable(false);
	        quantity_text.setPrefColumnCount(25);
	        cost.setPrefColumnCount(25);
	        price.setEditable(false);
	        phone.setPrefColumnCount(25);
	        phone.setText(CustomerLogIn.getCustomerInstance().getPhone());
	        phone.setEditable(false);
	        cost.setText(""+0);
	        price.setText(""+0);
	        
	        grid.add(itd, 1,1);
	        grid.add(item_name, 1,2);
	        grid.add(price_label, 1,3);
	        grid.add(quantity_purchased, 1,4);
	        grid.add(customer, 1,5);
	        grid.add(cost_label, 3,3);

	        grid.add(id_text, 2, 1);
	        grid.add(item_name_text, 2, 2);
	        grid.add(price, 2, 3);
	        grid.add(quantity_text, 2, 4);
	        grid.add(phone, 2, 5);
	        grid.add(cost, 4, 3);

	       
	        GridPane btn=new GridPane();
	        btn.setPadding(new Insets(10,10,10,10));
	        btn.setVgap(5);
	        btn.setHgap(5);
	       

	        Button cost=new Button("Calculate Cost");
	        cost.setOnAction(event->calculateCost());
	        Button submit=new Button("Submit");
	        submit.setOnAction(event->Submit());
	        Button close=new Button("Close");
			close.setOnAction(event ->stage.hide() );
	        btn.add(cost,2,1);
	        btn.add(submit,3,1);
	        btn.add(close,4,1);
	        
	        GridPane pane=new GridPane();
	        pane.setPadding(new Insets(10,10,10,10));
	        pane.setVgap(10);
	        pane.setHgap(10);

	        pane.add(table,1,1);
	        pane.add(grid,1,2);
	        pane.add(btn,1,3);

	        Scene scene=new Scene(pane,900,450);
	        stage.setScene(scene);
	        stage.show();
	    }

		private void Submit() {
			Order order=new Order(Integer.parseInt(id_text.getText()),phone.getText(),Integer.parseInt(quantity_text.getText()),Double.parseDouble(cost.getText()),item_name_text.getText(),Double.parseDouble(price.getText()));
			
			Queries queries=new Queries();
			if(queries.submitOrder(order)) {
	    		JOptionPane.showMessageDialog(null, JOptionPane.PLAIN_MESSAGE, "Order Submitted ",JOptionPane.CLOSED_OPTION);
	    	}
	
		}

		private void calculateCost() {
			cost.setText(""+(Double.parseDouble(price.getText())* Integer.parseInt(quantity_text.getText())));			
		}
		
	}


