package essai2;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Auteur {
    
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private int actif = 1;

    public Auteur() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom.toUpperCase();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom.toUpperCase();
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance.toUpperCase();
    }

    public int getActif() {
        return actif;
    }

    public void setActif(int actif) {
        this.actif = actif;
    }
    
    
    public void inserer() throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "insert into AUTEUR(nomAuteur,prenomAuteur,dateNaissanceAuteur,lieuNaissanceAuteur,actifAuteur) "
                + "values(?,?,?,?,?) ";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, nom);
        pstm.setString(2, prenom);
        pstm.setString(3, dateNaissance);
        pstm.setString(4, lieuNaissance);       
        pstm.setInt(5, actif);

        pstm.executeUpdate();
        pstm.close();
    }

    public void modifier(int id) throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "update AUTEUR "
                + "set nomAuteur = ?,prenomAuteur = ?,dateNaissanceAuteur = ?,lieuNaissanceAuteur = ?,actifAuteur=? "
                + "where idAuteur = ?";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, nom);
        pstm.setString(2, prenom);
        pstm.setString(3, dateNaissance);
        pstm.setString(4, lieuNaissance);       
        pstm.setInt(5, actif);
        pstm.setInt(6, id);

        pstm.executeUpdate();
        pstm.close();
    }

    public void supprimer(int id) throws ClassNotFoundException, SQLException {
        MaConnexion mc = MaConnexion.getInstance();
        String req = "update AUTEUR "
                + "set actifAuteur = ? "
                + "where idAuteur = ?";
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

