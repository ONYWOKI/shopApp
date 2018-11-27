package shop.model.dB;

import shop.model.Customer;
import shop.model.Manager;
import shop.model.item.Item;
import shop.model.item.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queries {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;
    private String err;

    public Queries() {
    }

    public Manager authenticateManager(Manager manager) {
        try {
            connection = Database.getConnection();
            String sql = ("SELECT * FROM Manager WHERE username=? AND password=?");

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, manager.getUsername());
            preparedStatement.setString(2, manager.getPassword());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                manager = new Manager(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return manager;
    }

    public Customer authenticateCustomer(Customer customer) {
        try {
            connection = Database.getConnection();
            String sql = ("SELECT * FROM Customer WHERE userName=? AND password=?");

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getPassword());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customer;
    }

    public boolean AddItem(Item item) {
        try {
            connection = Database.getConnection();
            String sql = ("INSERT INTO item (itemName,category,buying_price,selling_price,quantity) VALUES (?,?,?,?,?)");

            preparedStatement = connection.prepareStatement(sql);
            System.out.print(item.getItemName());
            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setString(2, item.getItemCategory());
            preparedStatement.setDouble(3, item.getBuyingPrice());
            preparedStatement.setDouble(4, item.getSellingPrice());
            preparedStatement.setInt(5, item.getQuantity());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public Item getItem(Item item) {
        try {
            connection = Database.getConnection();
            String sql = ("SELECT * FROM Items WHERE itemName=?");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getItemName());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                item=new Item(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return item;
    }
    public boolean submitOrder(Order order) {
        try {
            connection = Database.getConnection();
            String sql = ("INSERT INTO Orders (itemID,phone,quantity,cost) VALUES (?,?,?,?)");

            preparedStatement = connection.prepareStatement(sql);

                      
            
            preparedStatement.setInt(1, order.getItemID());
            preparedStatement.setString(2, order.getPhone());
            preparedStatement.setInt(3, order.getQuantityBought());
            preparedStatement.setDouble(4, order.getTotalCost());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public List<Item> itemsList() {
        List<Item> items = null;
        try {
            connection = Database.getConnection();
            String sql = ("SELECT * FROM Item");

            preparedStatement = connection.prepareStatement(sql);

            items = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                items.add(new Item(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getInt(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return items;
    }
    public List<Order> orderList() {
        List<Order> orders = null;
        try {
            connection = Database.getConnection();
            String sql = ("SELECT Item.itemName,Customer.phoneNumber,Orders.quantity,Orders.cost,Orders.itemID FROM Item,Customer,Orders WHERE Orders.phone=Customer.phoneNumber AND Orders.itemID=Item.itemID");

            preparedStatement = connection.prepareStatement(sql);

            orders = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                orders.add(new Order(resultSet.getString(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public boolean remove(Item item) {
        try {
            connection = Database.getConnection();
            String sql = ("DELETE FROM Item WHERE itemName=?");

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, item.getItemName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    
  
    }
    

}