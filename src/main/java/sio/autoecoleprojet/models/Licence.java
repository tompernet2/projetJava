package sio.autoecoleprojet.models;

public class Licence {
    private int codeLicence;
    private int codeMoniteur;
    private int codeCategorie;
    private String dateObtention;


    private String libelle;

    public Licence(int codeLicence, int codeMoniteur, int codeCategorie, String dateObtention) {
        this.codeLicence = codeLicence;
        this.codeMoniteur = codeMoniteur;
        this.codeCategorie = codeCategorie;
        this.dateObtention = dateObtention;
    }

    public Licence(String libelle, int codeCategorie) {
        this.libelle = libelle;
        this.codeCategorie = codeCategorie;
    }

    @Override
    public String toString() {
        return "Licence{" +
                "libelle='" + libelle + '\'' +
                '}';
    }

    public int getCodeLicence() {
        return codeLicence;
    }

    public void setCodeLicence(int codeLicence) {
        this.codeLicence = codeLicence;
    }

    public int getCodeMoniteur() {
        return codeMoniteur;
    }

    public void setCodeMoniteur(int codeMoniteur) {
        this.codeMoniteur = codeMoniteur;
    }

    public int getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(int codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public String getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(String dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
