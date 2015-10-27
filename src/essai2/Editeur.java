package essai2;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Editeur {

    private int id;
    private String nom;
    private String noRue;
    private String rue;
    private String pays;
    private String ville;
    private String codePostal;
    private String telephone;
    private String email;
    private int actif = 1;

    private boolean verifNoRue(String numero) {
        return numero.matches("[^0][0-9]{0,2}"); //accepte les nombres 1 à 999 ne commençant pas par 0       
    }

    private boolean verifNom(String nom) {
        return nom.matches("[-' a-zA-Z]+"); //accepte uniquement les lettres de l'alphabet (minuscules et majuscules)     
    }

    private boolean verifCodePostal(String cp) {
        return cp.matches("[0-9]{5}"); //accepte les nombres de 5 chiffres      
    }

    private boolean verifTelephone(String tel) {
        return tel.matches("^(0|(\\+33))[1-9][0-9]{8}"); //accepte les nombres de 10 chiffres, 
        //le premier est un 0 ou +33, le second est un chiffre de 1 à 9
        // les huit autres sont des chiffres de 0 à 9
    }

    private boolean verifEmail(String email) {
        return email.matches("[a-zA-Z][-._a-zA-Z0-9]*@[a-zA-Z][-._a-zA-Z0-9]*.[a-zA-Z]{2,6}"); //accepte les emails contenant chiffres,lettres caractères -. et _      
    }

    public Editeur() {
    }

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        this.nom = nom.toUpperCase();
    }

    public String getNoRue() {
        return noRue;
    }

    public void setNoRue(String noRue) throws Exception {
        if (verifNoRue(noRue)) {    // vérification si le format du numéro de rue est valide              
            this.noRue = noRue;
        } else {
            throw new Exception("Veuillez écrire un numéro de rue valide.");
        }
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) throws Exception {
        if (verifNom(rue)) {    // vérification si le format du nom de rue est valide            
            this.rue = rue.toUpperCase();
        } else {
            throw new Exception("Veuillez écrire un nom de rue valide.");
        }
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) throws Exception {
        if (verifNom(pays)) {    // vérification si le format du nom de pays est valide            
            this.pays = pays.toUpperCase();
        } else {
            throw new Exception("Veuillez écrire un nom de pays valide.");
        }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) throws Exception {
        if (verifNom(ville)) {    // vérification si le format du nom de pays est valide            
            this.ville = ville.toUpperCase();
        } else {
            throw new Exception("Veuillez écrire un nom de ville valide.");
        }
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) throws Exception {
        if (verifCodePostal(codePostal)) {    // vérification si le format du nom de pays est valide            
            this.codePostal = codePostal;
        } else {
            throw new Exception("Veuillez écrire un code postal valide.");
        }
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) throws Exception {
        if (verifTelephone(telephone)) {    // vérification si le format du numéro de téléphone est valide            
            this.telephone = telephone;
        } else {
            throw new Exception("Veuillez écrire un numéro de téléphone valide.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (verifEmail(email)) {    // vérification si le format du numéro de téléphone est valide            
            this.email = email.toUpperCase();
        } else {
            throw new Exception("Veuillez écrire un email valide.");
        }
    }

    public int getActif() {
        return actif;
    }

    public void setactif(int actif) {
        this.actif = actif;
    }

    public void inserer() throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "insert into EDITEUR(nomEditeur,noRueEditeur,rueEditeur,codePostalEditeur,villeEditeur,paysEditeur,telephoneEditeur,emailEditeur,actifEditeur) "
                + "values(?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, nom);
        pstm.setString(2, noRue);
        pstm.setString(3, rue);
        pstm.setString(4, codePostal);
        pstm.setString(5, ville);
        pstm.setString(6, pays);
        pstm.setString(7, telephone);
        pstm.setString(8, email);
        pstm.setInt(9, actif);

        pstm.executeUpdate();
        pstm.close();
    }

    public void modifier(int id) throws ClassNotFoundException, SQLException {

        MaConnexion mc = MaConnexion.getInstance();
        String req = "update EDITEUR "
                + "set nomEditeur = ?,noRueEditeur = ?,rueEditeur = ?,codePostalEditeur = ?,villeEditeur = ?,paysEditeur = ?,telephoneEditeur = ?,emailEditeur = ?,actifEditeur=? "
                + "where idEditeur = ?";
        PreparedStatement pstm = mc.prepareStatement(req);
        pstm.setString(1, nom);
        pstm.setString(2, noRue);
        pstm.setString(3, rue);
        pstm.setString(4, codePostal);
        pstm.setString(5, ville);
        pstm.setString(6, pays);
        pstm.setString(7, telephone);
        pstm.setString(8, email);
        pstm.setInt(9, actif);
        pstm.setInt(10, id);

        pstm.executeUpdate();
        pstm.close();
    }

    public void supprimer(int id) throws ClassNotFoundException, SQLException {
        MaConnexion mc = MaConnexion.getInstance();
        String req = "update EDITEUR "
                + "set actifEditeur = ? "
                + "where idEditeur = ?";
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
