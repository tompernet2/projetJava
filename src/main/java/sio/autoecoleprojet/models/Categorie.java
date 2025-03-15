package sio.autoecoleprojet.models;

public class Categorie {
    private int codeCategorie;
    private String libelle;
    private float prix;

    public Categorie(int codeCategorie, String libelle, float prix) {
        this.codeCategorie = codeCategorie;
        this.libelle = libelle;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return libelle;
    }

    public int getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(int codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
