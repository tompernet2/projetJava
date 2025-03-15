package sio.autoecoleprojet.models;

public class Eleve {
    private int codeEleve;
    private String nom;
    private String prenom;
    private String sexe;
    private String dateNaissance;
    private String adresse;
    private int codePostal;
    private String ville;
    private int tel;
    private int numCompte;

    public static Eleve eleveCo ;


    public Eleve(int codeEleve, String nom, String prenom, String sexe, String dateNaissance, String adresse, int codePostal, String ville, int tel, int numCompte) {
        this.codeEleve = codeEleve;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tel = tel;
        this.numCompte = numCompte;
    }

    public Eleve(String nom, String prenom, String sexe, String dateNaissance, int codePostal, String ville, String adresse, int tel, int numCompte) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.codePostal = codePostal;
        this.ville = ville;
        this.adresse = adresse;
        this.tel = tel;
        this.numCompte = numCompte;
    }

    public Eleve(int codeEleve, String prenom, String nom) {
        this.codeEleve = codeEleve;
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public  String toString() {
        return prenom + " " + nom; 
    }



    public int getCodeEleve() {
        return codeEleve;
    }

    public void setCodeEleve(int codeEleve) {
        this.codeEleve = codeEleve;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
