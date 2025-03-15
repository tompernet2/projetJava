package sio.autoecoleprojet.controllers;

import sio.autoecoleprojet.models.User;
import sio.autoecoleprojet.services.UserService;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserController
{
    private UserService userService;

    public UserController(){
        this.userService = new UserService();
    }

    public ArrayList<User> getAll() throws SQLException {
        return userService.getAll();
    }
    public void create(String login , String mdp , int statut) throws SQLException {
        userService.create(login, mdp, statut);
    }
    public int getNumCompte(String login) throws SQLException {
        return userService.getNumCompte(login);
    }
    public boolean verifConnexion(String login, String mdp) throws SQLException {
        return userService.verifConnexion(login, mdp);
    }


    public User recupUserCo(int numCompte) throws SQLException {
        return userService.recupUserCo(numCompte);
    }


    public boolean estUnEleve(int numCompte) throws SQLException {
        return userService.estUnEleve(numCompte);
    }

    public boolean estUnMoniteur(int numCompte) throws SQLException {
        return userService.estUnMoniteur(numCompte);
    }

    public boolean estUnResponsable(int numCompte) throws SQLException {
        return userService.estUnResponsable(numCompte);
    }
    }
