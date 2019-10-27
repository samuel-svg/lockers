package lockers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DataBaseConnection {
    
    private String driver = "com.mysql.jdbc.Driver";
    private String strConection = "jdbc:mysql://127.0.0.1/lockers";
    private String user = "root";
    private String pass = "";
    public Connection conector = null;
    
    /*public DataBaseConnection() throws ClassNotFoundException{
        DataBaseCon();
    }
    */
    public Connection DataBaseCon() throws ClassNotFoundException{
        try  {
            Class.forName(driver);
            conector = DriverManager.getConnection(strConection,user,pass);
            JOptionPane.showMessageDialog(null,"Se ha conectado a la base de datos "+strConection);
        }
        catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Algo no anda bien "); //:/ \n"+e.getMessage());
        }
        return conector ;
    }
    
    public void executeQuery() throws SQLException, ClassNotFoundException{
        try{
            String query = "SELECT * FROM user;";
            Connection conector = DataBaseCon();
            Statement stmt = conector.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) System.out.println(rs.getString("ID_USER") + " " 
                    + rs.getString("NAME")+
                    " "+ rs.getString("APPAT")+
                    " "+ rs.getString("APMAT")+
                    " "+ rs.getString("INST")+
                    " "+ rs.getString("SEM")+
                    " "+ rs.getString("GRUPO"));
            rs.close();
            stmt.close();
            conector.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algo no anda bien :/ ");// \n"+e.getMessage());
        }
    }
    
        public void insertQuery(Usuario u) throws SQLException{
        int id = u.numeroCuenta;
        String name = u.Nombre ;
        String ap = u.apellido ;
        String am = u.apellidoMat ;
        String i = u.Instituto ;
        int sem = u.semestre ;
        char grupo = u.grupo ;
        String nip = u.NIP ;
        
        try{
            String query = "INSERT INTO user ('ID_USER','NAME',"
                    + "'APPAT', 'APMAT',"
                    + "'INST','SEM','GRUPO','NIP') "
                    + "VALUES (id,name,ap,am,i,pe,sem,grupo,nip) ;";
            
            Connection conector = DriverManager.getConnection(strConection,user,pass);
            Statement stmt = conector.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            PreparedStatement pi = conector.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pi.execute();
            
            rs = pi.getGeneratedKeys();
            
            while(rs.next()) System.out.println("GENERADO : "+rs.getString("ID_USER") + " " 
                    + rs.getString("NAME")+
                    " "+ rs.getString("APPAT")+
                    " "+ rs.getString("APMAT")+
                    " "+ rs.getString("INST")+
                    " "+ rs.getString("SEM")+
                    " "+ rs.getString("GRUPO"));
            JOptionPane.showMessageDialog(null,"Usuario registrado \n"+id+"\n"+name);
            rs.close();
            stmt.close();
            conector.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Algo no anda bien :/ \n"+e.getMessage());
        } 
    }
    
}
