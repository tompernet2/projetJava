package sio.autoecoleprojet.models;

public class Vehicule {
    private String immatriculation;
    private String marque;
    private String modele;
    private int annee;
    private String categorieVehicule;
    private int codeCategorie;

    public Vehicule(String immatriculation, String marque, String modele, int annee , int codeCategorie) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.codeCategorie = codeCategorie;
    }

    public Vehicule(String immatriculation, String marque, String modele, int annee, String categorieVehicule) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.categorieVehicule = categorieVehicule;
    }

    public Vehicule(String immatriculation, String modele, String marque) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.marque = marque;
    }


    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getCategorieVehicule() {
        return categorieVehicule;
    }

    public void setCategorieVehicule(String categorieVehicule) {
        this.categorieVehicule = categorieVehicule;
    }

    public int getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(int codeCategorie) {
        this.codeCategorie = codeCategorie;
    }


    public String getMarqueModele() {
        return marque + " " + modele;
    }
}


