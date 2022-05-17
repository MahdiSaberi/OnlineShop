package com.onlineshop.project;

import com.onlineshop.project.domain.Cart;
import com.onlineshop.project.domain.User;
import com.onlineshop.project.util.ApplicationContext;
import com.onlineshop.project.util.DatabaseUtil;
import com.onlineshop.project.util.Menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();
        //context.getDatabaseInitializer().init();
        //int select = context.getIntScanner().nextInt();
        Menu menu = new Menu();
        User user = new User();
        Cart proInCart = new Cart();
        boolean addOrRem = true;

        Register(menu, context, user);
        context.getUserRepository().insertUser(user);
        //
        int user_id = settingForeignKey(user);
        //
        context.getAddressRepository().insertAddress(user, user_id);

        menu.showSuccessfully();
        menu.showWelcome(user);
        menu.showProductsList();
        menu.showSelectProduct();

        int select = context.getIntScanner().nextInt();

        context.getProductRepository().calculateAvailableProducts(select, addOrRem);

        //show carts
        settingCart(context, select, user_id);
        //
        selectInCartMenu(context, menu, select, addOrRem, user_id);
    }


    public static int userIdForFK(User user) throws SQLException, ClassNotFoundException {
        DatabaseUtil databaseUtil = new DatabaseUtil();
        Statement statement = databaseUtil.getConnection().createStatement();
        String query = "select * from shop_db.user_table order by id";
        ResultSet resultSet = statement.executeQuery(query);
        //System.out.println("username: "+user.getUsername());
        int user_id = 0;
        while (resultSet.next()) {
            if (user.getUsername() != null) {
                if (user.getUsername().equals(resultSet.getString("username"))) {
                    user_id = resultSet.getInt("id");
                    return user_id;
                }
            }
        }
        return user_id;
    }

    public static void selectInCartMenu(ApplicationContext context, Menu menu, int select, boolean addOrRem, int user_id) throws SQLException, ClassNotFoundException {

        while (true) {

            menu.cartMenu();

            int choose = context.getIntScanner().nextInt();

            if (choose == 1) {
                menu.showProductsList();
                menu.showSelectProduct();
                select = context.getIntScanner().nextInt();
                context.getProductRepository().calculateAvailableProducts(select, addOrRem);
                context.getCartRepository().insertIntoCart(select, user_id);
                context.getCartRepository().updateCart(select, user_id, false);
            }

            if (choose == 2) {
                addOrRem = false;
                context.getCartRepository().removeProductFromCart(select, user_id);
                context.getProductRepository().calculateAvailableProducts(select, addOrRem);

            }

            if (choose == 3) {
                context.getCartRepository().emptyCart(user_id);
                System.out.println("Done!");
                System.exit(0);
            }

            if (choose == 4)
                loginMenu();
        }
    }

    public static void Register(Menu menu, ApplicationContext context, User user) {
        menu.showGetUsername();
        String username = context.getIntScanner().nextLine();

        menu.showGetLastName();
        String lastName = context.getIntScanner().nextLine();

        menu.showGetPassword();
        String password = context.getIntScanner().nextLine();

        menu.showGetState();
        String state = context.getIntScanner().nextLine();

        menu.showGetCity();
        String city = context.getIntScanner().nextLine();

        menu.showGetStreet();
        String street = context.getIntScanner().nextLine();

        menu.showGetPhone();
        String phoneNumber = context.getIntScanner().nextLine();

        menu.showGetEmail();
        String email = context.getIntScanner().nextLine();

        menu.showGetPostalCode();
        String postalCode = context.getIntScanner().nextLine();

        user.setFirstName(username);
        user.setUsername(username);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(1, user.getId(), state, city, street, postalCode);

    }

    public static int settingForeignKey(User user) throws SQLException, ClassNotFoundException {
        Application application = new Application();
        int user_id = application.userIdForFK(user);
        return user_id;
    }

    public static void settingCart(ApplicationContext context, int select, int user_id) throws SQLException, ClassNotFoundException {
        context.getCartRepository().insertIntoCart(select, user_id);
        context.getCartRepository().updateCart(select, user_id, true);
    }

    public static void loginMenu() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ApplicationContext();
        Menu menu = new Menu();
        User user = new User();
        while (true) {
            System.out.println("username:");
            String username = context.getStringScanner().nextLine();
            System.out.println("password:");
            String password = context.getStringScanner().nextLine();
            String query = "select * from shop_db.user_table where username = '" + (username) + "' and password = '" + (password) + "'";
            PreparedStatement preparedStatement = context.getDatabaseUtil().getConnection().prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery(query);
            boolean userIsIn = false;
            boolean addOrRem = true;
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)) {
                    userIsIn = true;
                    menu.showSuccessfully();
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setPassword(resultSet.getString("password"));
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    user.setEmail(resultSet.getString("email"));
                    user.setId(resultSet.getInt("id"));
                    menu.showWelcome(user);
                    menu.showProductsList();
                    menu.showSelectProduct();
                    int select = context.getIntScanner().nextInt();
                    int user_id = user.getId();
                    context.getProductRepository().calculateAvailableProducts(select, addOrRem);

                    //show carts
                    settingCart(context, select, user_id);
                    //
                    selectInCartMenu(context, menu, select, addOrRem, user_id);
                }
            }
            if (userIsIn == false)
                System.out.println("Wrong user or password!");
        }


    }
}
