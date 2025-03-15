package sio.autoecoleprojet.repositories;

import sio.autoecoleprojet.models.Eleve;

import sio.autoecoleprojet.models.Lecon;

import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MoniteurRepository implements RepositoryInterface<Moniteur, String>{
    private Connection connexionBDD;

    public MoniteurRepository()
    {
        this.connexionBDD = ConnexionBDD.getCnx();
    }
    @Override
    public void create(Moniteur moniteur) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("INSERT INTO `moniteur` (`CodeMoniteur`, `Nom`, `Prenom`, `Sexe`, `DateDeNaissance`, `Adresse1`, `CodePostal`, `Ville`, `Telephone`, `numCompte`, `imgPdp`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        preparedStatement.setInt(1, moniteur.getCodeMoniteur());
        preparedStatement.setString(2, moniteur.getNom());
        preparedStatement.setString(3, moniteur.getPrenom());
        preparedStatement.setString(4, moniteur.getSexe());
        preparedStatement.setString(5, moniteur.getDateNaissance());
        preparedStatement.setString(6, moniteur.getAdresse());
        preparedStatement.setInt(7, moniteur.getCodePostal());
        preparedStatement.setString(8, moniteur.getVille());
        preparedStatement.setInt(9, moniteur.getTel());
        preparedStatement.setInt(10, moniteur.getNumCompte());
        preparedStatement.setString(11, moniteur.getImg());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Moniteur moniteur) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("UPDATE moniteur SET Nom = ?, Prenom = ?, Sexe = ?, DateDeNaissance = ?, CodePostal = ?, Ville = ?, Telephone = ? , adresse1 = ? WHERE moniteur.numCompte = ?;");
        preparedStatement.setString(1, moniteur.getNom());
        preparedStatement.setString(2, moniteur.getPrenom());
        preparedStatement.setString(3, moniteur.getSexe());
        preparedStatement.setString(4, moniteur.getDateNaissance());
        preparedStatement.setInt(5, moniteur.getCodePostal());
        preparedStatement.setString(6, moniteur.getVille());
        preparedStatement.setInt(9, moniteur.getTel());
        preparedStatement.setString(8, moniteur.getAdresse());
        preparedStatement.setInt(9, moniteur.getNumCompte());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void delete(Moniteur moniteur) {

    }

    @Override
    public Moniteur get(String s) {
        return null;
    }

    @Override
    public ArrayList<Moniteur> getAll() throws SQLException {
        ArrayList<Moniteur> moniteurs = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT CodeMoniteur, Nom, Prenom, Sexe, DateDeNaissance,Adresse1, CodePostal, Ville, Telephone, numCompte FROM moniteur;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            moniteurs.add(new Moniteur(
                    resultSet.getInt("CodeMoniteur"),
                    resultSet.getString("Nom"),
                    resultSet.getString("Prenom"),
                    resultSet.getString("Sexe"),
                    resultSet.getString("DateDeNaissance"),
                    resultSet.getString("Adresse1"),
                    resultSet.getString("CodePostal"),
                    resultSet.getString("Ville"),
                    resultSet.getString("Telephone"),
                    resultSet.getInt("numCompte")));
        }
        return moniteurs;
    }

    public Moniteur recupMoniteurCo(int numCompte) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT CodeMoniteur, Nom, Prenom, Sexe, DateDeNaissance,Adresse1, CodePostal, Ville, Telephone, numCompte FROM moniteur WHERE numCompte = ?");
        preparedStatement.setInt(1,numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Moniteur.moniteurCo = new Moniteur(
                    resultSet.getInt("CodeMoniteur"),
                    resultSet.getString("Nom"),
                    resultSet.getString("Prenom"),
                    resultSet.getString("Sexe"),
                    resultSet.getString("DateDeNaissance"),
                    resultSet.getString("Adresse1"),
                    resultSet.getInt("CodePostal"),
                    resultSet.getString("Ville"),
                    resultSet.getInt("Telephone"),
                    resultSet.getInt("numCompte"));
        }

        return Moniteur.moniteurCo;
    }



    public ArrayList<Moniteur> getMoniteursDisponibles(String date, String heure) throws SQLException {
        ArrayList<Moniteur> moniteursDisponibles = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(" SELECT m.CodeMoniteur, m.Nom, m.Prenom " +
                "FROM Moniteur m " +
                "WHERE m.CodeMoniteur NOT IN ( SELECT l.CodeMoniteur FROM Lecon l " +
                "WHERE l.Date = ? AND l.Heure = ?); ");

        preparedStatement.setString(1, date);
        preparedStatement.setString(2, heure);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            moniteursDisponibles.add(new Moniteur(
                    resultSet.getInt("CodeMoniteur"),
                    resultSet.getString("Nom"),
                    resultSet.getString("Prenom")
            ));
        }
        return moniteursDisponibles;
    }

    public ArrayList<Moniteur> getMoniteurDispo(int codeCategorie, String date, String heure) throws SQLException {
        ArrayList<Moniteur> moniteursDisponibles = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT m.CodeMoniteur, m.Nom, m.Prenom" +
                " FROM moniteur m " +
                " JOIN licence l ON m.CodeMoniteur = l.CodeMoniteur" +
                " WHERE l.CodeCategorie = ? " +
                " AND m.CodeMoniteur NOT IN (SELECT lecon.CodeMoniteur FROM lecon WHERE lecon.Date = ? AND lecon.Heure = ?)");

        preparedStatement.setInt(1, codeCategorie);
        preparedStatement.setString(2, date);
        preparedStatement.setString(3, heure);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            moniteursDisponibles.add(new Moniteur(
                    resultSet.getInt("CodeMoniteur"),
                    resultSet.getString("Nom"),
                    resultSet.getString("Prenom")
            ));
        }
        return moniteursDisponibles;
    }

    public int getNewCodeMoniteur() throws SQLException {

        int newCodeMoniteur = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT MAX(CodeMoniteur) FROM moniteur");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            newCodeMoniteur = resultSet.getInt(1);
        }
        newCodeMoniteur+= 1;
        return newCodeMoniteur;
    }

    public ArrayList<Moniteur> recupMoniteur() throws SQLException {
        ArrayList<Moniteur> moniteurs = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT moniteur.codeMoniteur , moniteur.prenom, moniteur.nom FROM moniteur;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            moniteurs.add(new Moniteur(
                            resultSet.getInt("CodeMoniteur"),
                            resultSet.getString("Prenom"),
                            resultSet.getString("Nom")
                    )
            );
        }
        return moniteurs;
    }


    public HashMap<String,Integer> getDatasMoniteur() throws SQLException {
        HashMap<String, Integer> datas = new HashMap();

        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT c.libelle , COUNT(l.CodeMoniteur)\n" +
                "FROM categorie c\n" +
                "LEFT JOIN licence l ON c.CodeCategorie = l.CodeCategorie\n" +
                "GROUP BY c.libelle;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            datas.put(resultSet.getString("libelle"), resultSet.getInt("COUNT(l.CodeMoniteur)"));
        }
        preparedStatement.close();
        resultSet.close();
        return datas;
    }


    public int getNblicence(int codeMoniteur) throws SQLException {

        int NbLicenceTotal = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT COUNT(CodeLicence) FROM licence WHERE CodeMoniteur = ?");
        preparedStatement.setInt(1,codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            NbLicenceTotal = resultSet.getInt(1);
        }
        return NbLicenceTotal;
    }
    public int getNbLeconPasse(int codeMoniteur) throws SQLException {

        int NbLeconPasse = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT COUNT(CodeLecon) FROM lecon WHERE CodeMoniteur = ? AND Date < CURRENT_DATE");
        preparedStatement.setInt(1,codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            NbLeconPasse = resultSet.getInt(1);
        }
        return NbLeconPasse;
    }
    public int getNbLeconAVenir(int codeMoniteur) throws SQLException {

        int NbLeconAVenir = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT COUNT(CodeLecon) FROM lecon WHERE CodeMoniteur = ? AND Date > CURRENT_DATE");
        preparedStatement.setInt(1,codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            NbLeconAVenir = resultSet.getInt(1);
        }
        return NbLeconAVenir;
    }

    public int getNbLeconTotal(int codeMoniteur) throws SQLException {

        int NbLeconTotal = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT COUNT(CodeLecon) FROM lecon WHERE CodeMoniteur = ?");
        preparedStatement.setInt(1,codeMoniteur);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            NbLeconTotal = resultSet.getInt(1);
        }
        return NbLeconTotal;
    }



}
