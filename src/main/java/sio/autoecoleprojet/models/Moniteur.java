package sio.autoecoleprojet.models;

public class Moniteur {
    private int codeMoniteur;
    private String nom;
    private String prenom;
    private String sexe;
    private String dateNaissance;
    private String adresse;
    private int codePostal;
    private String ville;
    private int tel;
    private int numCompte;
    private String telephone;
    private String codePostale;
    private String img;


    public static Moniteur moniteurCo;


    public Moniteur(String nom, String prenom, String sexe, String dateNaissance, String adresse, int codePostal, String ville, int tel, int numCompte) {
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


    public Moniteur(int codeMoniteur, String nom, String prenom) {
        this.codeMoniteur = codeMoniteur;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Moniteur(int codeMoniteur, String nom, String prenom, String sexe, String dateNaissance, String adresse, int codePostal, String ville, int tel, int numCompte ,String img) {
        this.codeMoniteur = codeMoniteur;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tel = tel;
        this.numCompte = numCompte;
        this.img = img;
    }

    public Moniteur(int codeMoniteur, String nom, String prenom, String sexe, String dateNaissance, String adresse, int codePostal, String ville, int tel, int numCompte) {
        this.codeMoniteur = codeMoniteur;
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

    public Moniteur(int codeMoniteur, String nom, String prenom, String sexe, String dateNaissance, String adresse, String codePostale, String ville, String telephone, int numCompte) {
        this.codeMoniteur = codeMoniteur;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostale = codePostale;
        this.ville = ville;
        this.telephone = telephone;
        this.numCompte = numCompte;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Moniteur(int codeMoniteur) {
        this.codeMoniteur = codeMoniteur;
    }


    public int getCodeMoniteur() {
        return codeMoniteur;
    }

    public void setCodeMoniteur(int codeMoniteur) {
        this.codeMoniteur = codeMoniteur;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }
}
