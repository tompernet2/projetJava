package sio.autoecoleprojet.repositories;

import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.models.User;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class EleveRepository  implements RepositoryInterface<Eleve, String>{

    private Connection connexionBDD;

    public EleveRepository()
    {
        this.connexionBDD = ConnexionBDD.getCnx();
    }
    @Override
    public void create(Eleve eleve) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("INSERT INTO `eleve` (`CodeEleve`, `Nom`, `Prenom`, `Sexe`, `DateDeNaissance`, `Adresse1`, `CodePostal`, `Ville`, `Telephone`, `numCompte`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        preparedStatement.setInt(1, eleve.getCodeEleve());
        preparedStatement.setString(2, eleve.getNom());
        preparedStatement.setString(3, eleve.getPrenom());
        preparedStatement.setString(4, eleve.getSexe());
        preparedStatement.setString(5, eleve.getDateNaissance());
        preparedStatement.setString(6, eleve.getAdresse());
        preparedStatement.setInt(7, eleve.getCodePostal());
        preparedStatement.setString(8, eleve.getVille());
        preparedStatement.setInt(9, eleve.getTel());
        preparedStatement.setInt(10, eleve.getNumCompte());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


    @Override
    public void update(Eleve eleve) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("UPDATE eleve SET Nom = ?, Prenom = ?, Sexe = ?, DateDeNaissance = ?, CodePostal = ?, Ville = ?, Telephone = ? , adresse1 = ? WHERE eleve.numCompte = ?;");
        preparedStatement.setString(1, eleve.getNom());
        preparedStatement.setString(2, eleve.getPrenom());
        preparedStatement.setString(3, eleve.getSexe());
        preparedStatement.setString(4, eleve.getDateNaissance());
        preparedStatement.setInt(5, eleve.getCodePostal());
        preparedStatement.setString(6, eleve.getVille());
        preparedStatement.setInt(7, eleve.getTel());
        preparedStatement.setString(8, eleve.getAdresse());
        preparedStatement.setInt(9, eleve.getNumCompte());
        preparedStatement.executeUpdate();
        preparedStatement.close();


    }

    @Override
    public void delete(Eleve eleve) {

    }

    @Override
    public Eleve get(String s) {
        return null;
    }

    @Override
    public ArrayList<Eleve> getAll() throws SQLException {
        return null;
    }



    public int getNewCodeEleve() throws SQLException {

        int newCodeEleve = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT MAX(CodeEleve) FROM eleve");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            newCodeEleve = resultSet.getInt(1);
        }
        newCodeEleve+= 1;
        return newCodeEleve;
    }

    public ArrayList<Eleve> recupEleve() throws SQLException {
        ArrayList<Eleve> eleves = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT eleve.CodeEleve , eleve.Prenom, eleve.Nom FROM eleve;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            eleves.add(new Eleve(
                    resultSet.getInt("CodeEleve"),
                    resultSet.getString("Prenom"),
                    resultSet.getString("Nom")
                    )
            );
        }
        return eleves;
    }


    public Eleve recupEleveCo(int numCompte) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT CodeEleve, Nom, Prenom, Sexe, DateDeNaissance,Adresse1, CodePostal, Ville, Telephone, numCompte FROM eleve WHERE numCompte = ?");
        preparedStatement.setInt(1,numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Eleve.eleveCo = new Eleve(
                    resultSet.getInt("CodeEleve"),
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

        return Eleve.eleveCo;
    }

    public boolean verifPermis(int codeEleve) throws SQLException {
        boolean verif = false;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("Select count(CodeLecon) from lecon where CodeEleve = ? and Date < CURRENT_DATE ");
        preparedStatement.setInt(1,codeEleve);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            if (resultSet.getInt("count(CodeLecon)") > 11 ) {
                verif = true;
            }
        }

        return verif;
    }

    public HashMap<String,Integer> getDatas() throws SQLException {
        HashMap<String, Integer> datas = new HashMap();

        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT e.sexe, COUNT(l.CodeLecon) \n" +
                "FROM eleve e \n" +
                "JOIN lecon l ON e.codeEleve = l.codeEleve \n" +
                "GROUP BY e.sexe; ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            datas.put(resultSet.getString("sexe"), resultSet.getInt("COUNT(l.CodeLecon)"));
        }
        preparedStatement.close();
        resultSet.close();
        return datas;
    }

    public int getNbLeconAVenir(int codeEleve) throws SQLException {

        int NbLeconAVenir = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT COUNT(CodeLecon) FROM lecon WHERE CodeEleve = ? AND Date > CURRENT_DATE");
        preparedStatement.setInt(1,codeEleve);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            NbLeconAVenir = resultSet.getInt(1);
        }
        return NbLeconAVenir;
    }

    public int getNbLeconPasse(int codeEleve) throws SQLException {

        int NbLeconPasse = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT COUNT(CodeLecon) FROM lecon WHERE CodeEleve = ? AND Date < CURRENT_DATE");
        preparedStatement.setInt(1,codeEleve);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            NbLeconPasse = resultSet.getInt(1);
        }
        return NbLeconPasse;
    }

    public int getNbLeconTotal(int codeEleve) throws SQLException {

        int NbLeconTotal = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT COUNT(CodeLecon) FROM lecon WHERE CodeEleve = ?");
        preparedStatement.setInt(1,codeEleve);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            NbLeconTotal = resultSet.getInt(1);
        }
        return NbLeconTotal;
    }





}
