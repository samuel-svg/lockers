package lockers;

import java.sql.SQLException;

public class Lockers {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MainMenu main = new MainMenu();
        main.setVisible(true);
        DataBaseConnection db = new DataBaseConnection();
        db.executeQuery();
    }
    
}
