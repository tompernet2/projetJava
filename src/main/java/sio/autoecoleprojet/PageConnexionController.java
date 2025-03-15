package sio.autoecoleprojet;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sio.autoecoleprojet.controllers.EleveController;
import sio.autoecoleprojet.controllers.MoniteurController;
import sio.autoecoleprojet.controllers.ResponsableController;
import sio.autoecoleprojet.controllers.UserController;
import sio.autoecoleprojet.models.*;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PageConnexionController implements Initializable {
    UserController userController;
    EleveController eleveController;
    MoniteurController moniteurController;
    ResponsableController responsableController;

    @javafx.fxml.FXML
    private TextField txtFieldId;
    @javafx.fxml.FXML
    private TextField txtFieldMdp;
    @javafx.fxml.FXML
    private Button btnConnexion;
    @javafx.fxml.FXML
    private ComboBox cboType;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userController = new UserController();
        eleveController = new EleveController();
        moniteurController = new MoniteurController();
        responsableController = new ResponsableController();

        Eleve.eleveCo = new Eleve(0, null, null, null, null, null, 0, null, 0, 0);
        User.userCo = new User(0, null, null, 0);
        Moniteur.moniteurCo = new Moniteur(0, null, null, null, null, null, 0, null, 0, 0);
        Responsable.reponsableCo = new Responsable(0, null, null, 0);

        cboType.getItems().addAll("Eleve","Moniteur", "Responsable");
        cboType.getSelectionModel().selectFirst();
    }
    @javafx.fxml.FXML
    public void clickedBtnConnexion(Event event) throws IOException {
            try {
                String cbo = cboType.getSelectionModel().getSelectedItem().toString();
                //System.out.println(userController.verifConnexion(txtFieldId.getText(), txtFieldMdp.getText()));
                if(userController.verifConnexion(txtFieldId.getText(), txtFieldMdp.getText())){
                    if (cbo.equals("Eleve") && userController.estUnEleve(userController.getNumCompte(txtFieldId.getText()))){
                        System.out.println("Eleve connecté");
                        //System.out.println(userController.recupUserCo(userController.getNumCompte(txtFieldId.getText())));
                        //System.out.println(eleveController.recupEleveCo(userController.getNumCompte(txtFieldId.getText())));
                        userController.recupUserCo(userController.getNumCompte(txtFieldId.getText()));
                        eleveController.recupEleveCo(userController.getNumCompte(txtFieldId.getText()));

                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pageEleve.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage = new Stage();
                        stage.setTitle("ELEVE");
                        stage.setScene(scene);
                        stage.show();
                    }

                    else if (cbo.equals("Moniteur") && userController.estUnMoniteur(userController.getNumCompte(txtFieldId.getText()))) {
                        System.out.println("Moniteur connecté");

                        userController.recupUserCo(userController.getNumCompte(txtFieldId.getText()));
                        moniteurController.recupMoniteurCo(userController.getNumCompte(txtFieldId.getText()));

                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pageMoniteur.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage = new Stage();
                        stage.setTitle("MONITEUR");
                        stage.setScene(scene);
                        stage.show();
                    }

                    else if (cbo.equals("Responsable") && userController.estUnResponsable(userController.getNumCompte(txtFieldId.getText()))) {
                        System.out.println("Responsable connecté");

                        userController.recupUserCo(userController.getNumCompte(txtFieldId.getText()));
                        responsableController.recupResponsableCo(userController.getNumCompte(txtFieldId.getText()));

                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pageResponsable.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage = new Stage();
                        stage.setTitle("RESPONSABLE");
                        stage.setScene(scene);
                        stage.show();
                    }

                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Choix Eleve/Moniteur/Responsable incorrect");
                        alert.showAndWait();
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Login ou mot de passe incorrect");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



    }


}
