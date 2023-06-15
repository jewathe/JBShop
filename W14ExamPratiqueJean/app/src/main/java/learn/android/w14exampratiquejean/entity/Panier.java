package learn.android.w14exampratiquejean.entity;

public class Panier extends Entity{
    int produit;
    int quantite;

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Panier(int id, int produit, int quantite) {
        super(id);
        this.produit = produit;
        this.quantite = quantite;
    }

    public Panier(int id) {
        super(id);
    }
}
