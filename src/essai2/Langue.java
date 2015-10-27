
package essai2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Langue {
    
    private int id;
    private String langue;
    private int actif = 1;

    public Langue() {
    }

    public int getId() {
        return id;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue.toUpperCase();
    }

    public int getActif() {
        return actif;
    }

    public void setActif(int actif) {
        this.actif = actif;
    }
    
    
    
    public void inserer() throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "insert into LANGUE(nomLangue,actifLangue) "
                + "values(?,?) ";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, langue);
         pstm.setInt(2, actif);

        pstm.executeUpdate();
        pstm.close();
    }

    public void modifier(int id) throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "update LANGUE "
                + "set nomLangue = ?, actifLangue = ? "
                + "where idLangue = ?";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, langue); 
        pstm.setInt(2, actif);
        pstm.setInt(3, id);

        pstm.executeUpdate();
        pstm.close();
    }

    public void supprimer(int id) throws ClassNotFoundException, SQLException {
        MaConnexion mc = MaConnexion.getInstance();
        String req = "update LANGUE "
                + "set actifLangue = ? "
                + "where idLangue = ?";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setInt(1, 0);
        pstm.setInt(2, id);
        pstm.executeUpdate();
        pstm.close();
    }

    public ResultSet selectionner(String req) throws ClassNotFoundException, SQLException, Exception {
        MaConnexion mc = MaConnexion.getInstance();
        Statement stm = mc.createStatement();
        ResultSet rs = stm.executeQuery(req);
        return rs;
    }
    
    public ResultSet rechercher(String req,String nomRecherche) throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, nomRecherche);
        ResultSet rs=pstm.executeQuery();
        
        return rs;
        
    
    }
    
}
