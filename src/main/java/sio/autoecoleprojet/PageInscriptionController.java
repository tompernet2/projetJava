package sio.autoecoleprojet;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sio.autoecoleprojet.controllers.EleveController;
import sio.autoecoleprojet.controllers.UserController;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PageInscriptionController implements Initializable {
    EleveController eleveController;
    UserController userController;
    ConnexionBDD connexionBDD;
    @FXML
    private Button btnConnexion;
    @FXML
    private TextField txtFieldNom;
    @FXML
    private DatePicker dpNaissance;
    @FXML
    private TextField txtFieldPrenom;
    @FXML
    private TextField txtFieldCodePostal;
    @FXML
    private TextField txtFieldTel;
    @FXML
    private TextField txtFieldSexe;
    @FXML
    private TextField txtFieldVille;
    @FXML
    private TextField txtFieldLogin;
    @FXML
    private TextField txtFieldMdp;
    @FXML
    private TextField txtFieldAdresse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            connexionBDD = new ConnexionBDD();
            userController = new UserController();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        eleveController = new EleveController();
    }
    @FXML
    public void clickedBtnInscription(MouseEvent mouseEvent) throws SQLException {
        if(txtFieldLogin.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Login");
            alert.setHeaderText("Saisir un Login");
            alert.showAndWait();
        }
        else if(txtFieldMdp.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Mot de passe");
            alert.setHeaderText("Saisir un mot de passe");
            alert.showAndWait();
        }
        else if (txtFieldPrenom.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Prénom");
            alert.setHeaderText("Saisir un Prénom");
            alert.showAndWait();
        }
        else if (txtFieldNom.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Nom");
            alert.setHeaderText("Saisir un Nom");
            alert.showAndWait();
        }
        else if (dpNaissance.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Date de Naissance");
            alert.setHeaderText("Saisir une Date de Naissance");
            alert.showAndWait();
        }
        else if (txtFieldTel.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Téléphone");
            alert.setHeaderText("Saisir un Numéro de Téléphone");
            alert.showAndWait();
        }
        else if (txtFieldVille.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Ville");
            alert.setHeaderText("Saisir une Ville");
            alert.showAndWait();
        }
        else if (txtFieldCodePostal.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Code Postal");
            alert.setHeaderText("Saisir un Code Postal");
            alert.showAndWait();
        }
        else if (txtFieldAdresse.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Adresse");
            alert.setHeaderText("Saisir une Adresse");
            alert.showAndWait();
        }
        else if (txtFieldSexe.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Sexe");
            alert.setHeaderText("Saisir un Sexe");
            alert.showAndWait();
        }
        else {
            userController.create(txtFieldLogin.getText(), txtFieldMdp.getText(), 0);
            eleveController.create(eleveController.getNewCodeEleve(), txtFieldNom.getText(), txtFieldPrenom.getText(), txtFieldSexe.getText(), String.valueOf(dpNaissance.getValue()), txtFieldAdresse.getText(), Integer.valueOf(txtFieldCodePostal.getText()), txtFieldVille.getText(), Integer.valueOf(txtFieldTel.getText()), userController.getNumCompte(txtFieldLogin.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inscription Réussie");
            alert.setHeaderText("Inscription Terminée");
            alert.setContentText("Votre inscription a été réussie avec succès !");
            alert.showAndWait();

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();
        }



    }




}
