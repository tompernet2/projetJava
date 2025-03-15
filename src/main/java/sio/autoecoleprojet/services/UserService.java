package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.User;
import sio.autoecoleprojet.repositories.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public ArrayList<User> getAll() throws SQLException {
        return userRepository.getAll();
    }
    public void create(String login , String mdp , int statut) throws SQLException {
        User user = new User(login, mdp, statut);
        userRepository.create(user);
    }
    public int getNumCompte(String login) throws SQLException {
        return userRepository.getNumCompte(login);
    }

    public boolean verifConnexion(String login, String mdp) throws SQLException {
        return userRepository.verifConnexion(login, mdp);

    }

    public User recupUserCo(int numCompte) throws SQLException {
        return userRepository.recupUserCo(numCompte);
    }
    public boolean estUnEleve(int numCompte) throws SQLException {
        return userRepository.estUnEleve(numCompte);
    }
    public boolean estUnMoniteur(int numCompte) throws SQLException {
        return userRepository.estUnMoniteur(numCompte);
    }
    public boolean estUnResponsable(int numCompte) throws SQLException {
        return userRepository.estUnResponsable(numCompte);
    }



    }