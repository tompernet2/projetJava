package sio.autoecoleprojet.repositories;

import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.User;
import sio.autoecoleprojet.tools.ConnexionBDD;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository implements RepositoryInterface<User, String>{

    private Connection connexionBDD;
    private BCryptPasswordEncoder passwordEncoder;


    public UserRepository()
    {
        this.connexionBDD = ConnexionBDD.getCnx();
        this.passwordEncoder = new BCryptPasswordEncoder();

    }



    @Override
    public void create(User user) throws SQLException {
        String hashedPassword = passwordEncoder.encode(user.getMdp()); // Hash du mot de passe
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(
                "INSERT INTO compte (login, motDePasse, statut) VALUES (?, ?, ?)"
        );
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, hashedPassword); // Enregistre le mot de passe haché
        preparedStatement.setInt(3, user.getStatut());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }



    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User get(String s) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("select login, motDePasse, statut from compte");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            users.add(new User(resultSet.getString("login"), resultSet.getString("motDePasse"), resultSet.getInt("statut")));
        }
        return users;
    }

    public int getNumCompte(String login) throws SQLException {

        int newNumCompte = 0;
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT numCompte FROM compte WHERE login = ? ");
        preparedStatement.setString(1,login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            newNumCompte = resultSet.getInt(1);
        }

        return newNumCompte;
    }


    public boolean verifConnexion(String login, String mdp) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(
                "SELECT motDePasse FROM compte WHERE login = ?"
        );
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String hashedPassword = resultSet.getString("motDePasse");
            return passwordEncoder.matches(mdp, hashedPassword); // Vérifie le mot de passe haché
        }
        return false;
    }

    public User recupUserCo(int numCompte) throws SQLException {
        PreparedStatement preparedStatement = connexionBDD.prepareStatement("SELECT numCompte, login, motDePasse ,statut FROM compte WHERE numCompte = ?");
        preparedStatement.setInt(1,numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            User.userCo = new User(
                    resultSet.getInt("numCompte"),
                    resultSet.getString("login"),
                    resultSet.getString("motDePasse"),
                    resultSet.getInt("statut"));
        }
        return User.userCo;
    }

    public boolean estUnEleve(int numCompte) throws SQLException {
        boolean estUnEleve = false;
        String query = "SELECT numCompte FROM eleve WHERE numCompte = ?";
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(query);
        preparedStatement.setInt(1, numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            estUnEleve = true;
        }
        return estUnEleve;
    }
    public boolean estUnMoniteur(int numCompte) throws SQLException {
        boolean estUnMoniteur = false;
        String query = "SELECT numCompte FROM moniteur WHERE numCompte = ?";
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(query);
        preparedStatement.setInt(1, numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            estUnMoniteur = true;
        }
        return estUnMoniteur;
    }
    public boolean estUnResponsable(int numCompte) throws SQLException {
        boolean estUnResponsable = false;
        String query = "SELECT numCompte FROM responsable WHERE numCompte = ?";
        PreparedStatement preparedStatement = connexionBDD.prepareStatement(query);
        preparedStatement.setInt(1, numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            estUnResponsable = true;
        }
        return estUnResponsable;
    }

}
