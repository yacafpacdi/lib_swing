package essai2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Livre {

    private int isbn;
    private int idLangue;
    private int idEditeur;
    private Date dateEdition;
    private String image;
    private String titre;
    private String sousTitre;
    private String resume;
    private String theme;
    private String sousTheme;
    private int stock;
    private float prix;
    private float tva;
    private int actif = 1;

    public Livre() {
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(int idLangue) {
        this.idLangue = idLangue;
    }

    public int getIdEditeur() {
        return idEditeur;
    }

    public void setIdEditeur(int idEditeur) {
        this.idEditeur = idEditeur;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSousTheme() {
        return sousTheme;
    }

    public void setSousTheme(String sousTheme) {
        this.sousTheme = sousTheme;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public int getActif() {
        return actif;
    }

    public void setActif(int actif) {
        this.actif = actif;
    }

    public void inserer() throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "insert into LIVRE(isbnLivre,idLangue,idEditeur,dateEditionLivre,titreLivre,sousTitreLivre,resumeLivre,stockLivre,prixHTLivre,tvaLivre,actifLivre,imageivre) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setInt(1, isbn);
        pstm.setInt(2, idLangue);
        pstm.setInt(3, idEditeur);
        pstm.setDate(4, (java.sql.Date) dateEdition);
        pstm.setString(5, titre);
        pstm.setString(6, sousTitre);
        pstm.setString(7, resume);
        pstm.setInt(8, stock);
        pstm.setFloat(9, prix);
        pstm.setFloat(10, tva);
        pstm.setInt(11, actif);
        pstm.setString(12, image);
        pstm.executeUpdate();

        /*int i;
         req = "insert into IMAGE(isbn,cheminImage,actifImage) "
         + "values(?,?,?) ";
         pstm = mc.prepareStatement(req);
         pstm.setInt(1,isbn);
         for (i = 0; i < image.size(); i++) {
         pstm.setString(i+2,image.get(i));           
         }
         pstm.setInt(i+1,actif);*/
       

        req = "insert into THEME(nomTheme,actifTheme) "
                + "values(?,?) ";
        pstm = mc.prepareStatement(req);
        pstm.setString(1, theme);
        pstm.setInt(2, actif);
        pstm.executeUpdate();

        req = "insert into SOUSTHEME(nomSousTheme,actifSousTheme) "
                + "values(?,?) ";
        pstm = mc.prepareStatement(req);
        pstm.setString(1, sousTheme);
        pstm.setInt(2, actif);
        pstm.executeUpdate();

        pstm.close();
    }

    public void modifier(int idLivre,int idImage, int idTheme, int idSousTheme) throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "update LIVRE"
                   + " set isbnLivre=?,idLangue=?,idEditeur=?,dateEditionLivre=?,titreLivre=?,sousTitreLivre=?,resumeLivre=?,stockLivre=?,prixHTLivre=?,tvaLivre=?,actifLivre=?,imageLivre=?"
                   + " where isbnLivre = ?";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setInt(1, isbn);
        pstm.setInt(2, idLangue);
        pstm.setInt(3, idEditeur);
        pstm.setDate(4, (java.sql.Date) dateEdition);
        pstm.setString(5, titre);
        pstm.setString(6, sousTitre);
        pstm.setString(7, resume);
        pstm.setInt(8, stock);
        pstm.setFloat(9, prix);
        pstm.setFloat(10, tva);
        pstm.setInt(11, actif);
         pstm.setString(12, image);
        pstm.setInt(13, idLivre);
        pstm.executeUpdate();

        

        req = "update THEME"
            + " set nomTheme=?,actifTheme=?"
            + " where idTheme=? ";
        pstm = mc.prepareStatement(req);
        pstm.setString(1, theme);
        pstm.setInt(2, actif);
        pstm.setInt(3, idTheme);
        pstm.executeUpdate();

        req = "update SOUSTHEME"
            + " nomSousTheme=?,actifSousTheme=?"
            + " where idSousTheme=? ";
        pstm = mc.prepareStatement(req);
        pstm.setString(1, sousTheme);
        pstm.setInt(2, actif);
        pstm.setInt(3, idSousTheme);
        pstm.executeUpdate();

        pstm.close();
    }

    public void supprimer(int idLivre, int idImage) throws ClassNotFoundException, SQLException {
        MaConnexion mc = MaConnexion.getInstance();
        String req = "update LIVRE "
                + "set actifLivre = ? "
                + "where isbnLivre = ?";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setInt(1, 0);
        pstm.setInt(2, idLivre);
        pstm.executeUpdate();
        
        
        pstm.close();
    }

    public ResultSet selectionner(String req) throws ClassNotFoundException, SQLException, Exception {
        MaConnexion mc = MaConnexion.getInstance();
        Statement stm = mc.createStatement();
        ResultSet rs = stm.executeQuery(req);
        return rs;
    }

    public ResultSet rechercher(String req, String nomRecherche) throws ClassNotFoundException, SQLException {

        MaConnexion mc =MaConnexion.getInstance();
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, nomRecherche);
        ResultSet rs = pstm.executeQuery();

        return rs;

    }

}
