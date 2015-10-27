package essai2;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class MaConnexion {
    
    private static MaConnexion mc = null;
    private Connection cnt;
    
    public static synchronized MaConnexion getInstance() throws ClassNotFoundException, SQLException{
        if(mc ==null){
            mc = new MaConnexion();
        }    
        return mc;
    }
           
    private MaConnexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=LIBRAIRIE";
            String user = "sa";
            String mdp = "aaa$$$111";
            cnt = DriverManager.getConnection(url, user, mdp);
    }    
    
    public Statement createStatement() throws SQLException{
        Statement stm = cnt.createStatement();
        return stm;
    }
    
    public PreparedStatement prepareStatement(String requete) throws SQLException{
        PreparedStatement pstm= cnt.prepareStatement(requete);
        return pstm;
    }
    
    public CallableStatement prepareCall(String req) throws SQLException{
        return cnt.prepareCall(req);
    }
    
    public void close() throws SQLException {
         mc=null;
         if(cnt!=null){
             cnt.close();
         }         
    }

    @Override
    public void finalize() {
        if(cnt !=null) {
            try {
                cnt.close();
            } catch (SQLException ex) {
                //on peut rien faire
            }
        }
    }
    
    
    
}
