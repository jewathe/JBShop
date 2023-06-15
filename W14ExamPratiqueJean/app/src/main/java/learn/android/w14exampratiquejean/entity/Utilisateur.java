package learn.android.w14exampratiquejean.entity;

public class Utilisateur extends Entity{
    String nom;
    String prenom;
    String login;
    String password;
    public Utilisateur(int id) {
        super(id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilisateur(int id, String nom, String prenom, String login, String password) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }
}
