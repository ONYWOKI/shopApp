package shop.model;

import shop.util.User;

public class Manager extends User {
    public Manager() {
    }

    public Manager(String username, String password) {
        super(username, password);
    }

    public Manager(String firstName, String lastName, String gender, String nationalId, String phone) {
        super(firstName, lastName, gender, nationalId, phone);
    }
}
