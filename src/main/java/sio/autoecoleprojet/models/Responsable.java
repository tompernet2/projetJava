package sio.autoecoleprojet.models;

public class Responsable {
    private int codeResponsable;
    private String nom;
    private String prenom;
    private int numCompte;


    public static Responsable reponsableCo;

    public Responsable(int codeResponsable, String nom, String prenom, int numCompte) {
        this.codeResponsable = codeResponsable;
        this.nom = nom;
        this.prenom = prenom;
        this.numCompte = numCompte;
    }



    public int getCodeResponsable() {
        return codeResponsable;
    }

    public void setCodeResponsable(int codeResponsable) {
        this.codeResponsable = codeResponsable;
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

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }
}
