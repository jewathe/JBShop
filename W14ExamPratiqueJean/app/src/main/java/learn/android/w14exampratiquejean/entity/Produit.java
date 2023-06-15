package learn.android.w14exampratiquejean.entity;

public class Produit extends Entity{
    String titre;
    String description;
    float prix;
    int typeMenu;
    String NomImage;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(int typeMenu) {
        this.typeMenu = typeMenu;
    }

    public String getNomImage() {
        return NomImage;
    }

    public void setNomImage(String nomImage) {
        NomImage = nomImage;
    }

    public Produit(int id, String titre, String description, float prix, int typeMenu, String nomImage) {
        super(id);
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.typeMenu = typeMenu;
        NomImage = nomImage;
    }

    public Produit(int id) {
        super(id);
    }
}
