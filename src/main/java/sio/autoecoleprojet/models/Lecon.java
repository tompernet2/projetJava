package sio.autoecoleprojet.models;

public class Lecon {
    private int codeLecon;
    private String date;
    private String heure;
    private int codeMoniteur;
    private int codeEleve;
    private String immatriculation;
    private int reglee;

    private String nomMoniteur;
    private String marqueVehicule;
    private String modeleVehicule;
    private String nomEleve;
    private String prenomMoniteur;
    private String prenomEleve;


    private String typePermis;
    private int codeCategorie;

    public Lecon(String date, String heure, String prenomMoniteur, String prenomEleve, String nomEleve ,String immatriculation, int reglee , String typePermis) {
        this.date = date;
        this.heure = heure;
        this.prenomMoniteur = prenomMoniteur;
        this.prenomEleve = prenomEleve;
        this.nomEleve = nomEleve;
        this.immatriculation = immatriculation;
        this.reglee = reglee;
        this.typePermis = typePermis;
    }



    public Lecon(int codeEleve, int codeLecon, String date, String heure, int codeMoniteur, String immatriculation, int codeCategorie, int reglee) {
        this.codeEleve = codeEleve;
        this.codeLecon = codeLecon;
        this.date = date;
        this.heure = heure;
        this.codeMoniteur = codeMoniteur;
        this.immatriculation = immatriculation;
        this.codeCategorie = codeCategorie;
        this.reglee = reglee;
    }


    public Lecon(int codeLecon, String date, String heure, int codeMoniteur, int codeEleve, String immatriculation, int reglee) {
        this.codeLecon = codeLecon;
        this.date = date;
        this.heure = heure;
        this.codeMoniteur = codeMoniteur;
        this.codeEleve = codeEleve;
        this.immatriculation = immatriculation;
        this.reglee = reglee;
    }


    public Lecon(String date, String heure, String nomMoniteur, String marqueVehicule, String modeleVehicule, String typePermis) {

        this.date = date;
        this.heure = heure;
        this.nomMoniteur = nomMoniteur;
        this.marqueVehicule = marqueVehicule;
        this.modeleVehicule = modeleVehicule;
        this.typePermis = typePermis;
    }

    public Lecon(String date, String heure, String modeleVehicule , String nomEleve, String typePermis) {

        this.date = date;
        this.heure = heure;
        this.modeleVehicule = modeleVehicule;
        this.nomEleve = nomEleve;
        this.typePermis = typePermis;

    }


    public Lecon(String date, String heure, String prenomEleve, String nomEleve , String marqueVehicule, String modeleVehicule, String typePermis) {
        this.date = date;
        this.heure = heure;
        this.prenomEleve = prenomEleve;
        this.nomEleve = nomEleve;
        this.marqueVehicule = marqueVehicule;
        this.modeleVehicule = modeleVehicule;
        this.typePermis = typePermis;
    }




    @Override
    public String toString() {
        return "Lecon{" +
                "date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                ", nomMoniteur='" + nomMoniteur + '\'' +
                ", marqueVehicule='" + marqueVehicule + '\'' +
                ", modeleVehicule='" + modeleVehicule + '\'' +
                '}';
    }


    public int getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(int codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public String getPrenomMoniteur() {
        return prenomMoniteur;
    }

    public void setPrenomMoniteur(String prenomMoniteur) {
        this.prenomMoniteur = prenomMoniteur;
    }

    public String getTypePermis() {
        return typePermis;
    }

    public void setTypePermis(String typePermis) {
        this.typePermis = typePermis;
    }


    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getNomMoniteur() {
        return nomMoniteur;
    }

    public void setNomMoniteur(String nomMoniteur) {
        this.nomMoniteur = nomMoniteur;
    }

    public String getMarqueVehicule() {
        return marqueVehicule;
    }

    public void setMarqueVehicule(String marqueVehicule) {
        this.marqueVehicule = marqueVehicule;
    }

    public String getModeleVehicule() {
        return modeleVehicule;
    }

    public void setModeleVehicule(String modeleVehicule) {
        this.modeleVehicule = modeleVehicule;
    }



    public int getCodeLecon() {
        return codeLecon;
    }

    public void setCodeLecon(int codeLecon) {
        this.codeLecon = codeLecon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getCodeMoniteur() {
        return codeMoniteur;
    }

    public void setCodeMoniteur(int codeMoniteur) {
        this.codeMoniteur = codeMoniteur;
    }

    public int getCodeEleve() {
        return codeEleve;
    }

    public void setCodeEleve(int codeEleve) {
        this.codeEleve = codeEleve;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getReglee() {
        return reglee;
    }

    public void setReglee(int reglee) {
        this.reglee = reglee;
    }
}
