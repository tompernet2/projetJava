package sio.autoecoleprojet;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sio.autoecoleprojet.controllers.*;
import sio.autoecoleprojet.models.Eleve;
import sio.autoecoleprojet.models.Licence;
import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.models.User;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PageMoniteurController implements Initializable {

    UserController userController;
    MoniteurController moniteurController;
    VehiculeController vehiculeController;
    LeconController leconController;
    LicenceController licenceController;

    XYChart.Series<String,Number> serieGraphBar;


    @javafx.fxml.FXML
    private Button btnPlanningM;
    @javafx.fxml.FXML
    private Button btnStatistiqueM;
    @javafx.fxml.FXML
    private Button btnAjoutLicenceM;
    @javafx.fxml.FXML
    private Button btnProfilM;
    @javafx.fxml.FXML
    private AnchorPane apProfil;
    @javafx.fxml.FXML
    private TextField txtFVilleMoniteur;
    @javafx.fxml.FXML
    private TextField txtFSexeMoniteur;
    @javafx.fxml.FXML
    private TextField txtFTelMoniteur;
    @javafx.fxml.FXML
    private AnchorPane apProfilModif;
    @javafx.fxml.FXML
    private DatePicker datePickDateNaissanceMoniteur;
    @javafx.fxml.FXML
    private TextField txtFPrenomMoniteur;
    @javafx.fxml.FXML
    private Button btnDeconnexionM;
    @javafx.fxml.FXML
    private TextField txtFCodePostMoniteur;
    @javafx.fxml.FXML
    private TextField txtFNomMoniteur;
    @FXML
    private Label lblMdp;
    @FXML
    private Label lblNom;
    @FXML
    private Label lblLogin;
    @FXML
    private Label lblSexe;
    @FXML
    private Label lblAdresse;
    @FXML
    private Label lblVille;
    @FXML
    private AnchorPane apPlanning;
    @FXML
    private Label lblCodePostal;
    @FXML
    private Label lblTel;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblPrenom;
    @FXML
    private TextField txtFAdresseMoniteur;
    @FXML
    private TableColumn tcHeurePlanningMoniteur;
    @FXML
    private TableView tViewPlanningMoniteur;
    @FXML
    private TableColumn tcDatePlanningMoniteur;
    @FXML
    private TableColumn tcVehiculePlanningMoniteur;
    @FXML
    private TableColumn tcNomElevePlanningMoniteur;
    @FXML
    private AnchorPane apAjoutLicence;
    @FXML
    private TableColumn tcLibelle;
    @FXML
    private TableView<Licence> tvLicence;
    @FXML
    private TableColumn tcLibelleAquis;
    @FXML
    private TableView tvLicence1;

    @FXML
    private TableColumn tcTypePermis;
    @FXML
    private DatePicker dpDateOptentionLicence;
    @FXML
    private Label nbLeconAVenir;
    @FXML
    private Label nbLicenceTotal;
    @FXML
    private BarChart graphBar;
    @FXML
    private Label nbLeconTotal;
    @FXML
    private AnchorPane apStatistique;
    @FXML
    private Label nbLeconPasse;


    @javafx.fxml.FXML
    public void btnMenuClicked(Event event) throws SQLException {
        if (event.getSource() == btnProfilM) {
            apProfil.toFront();
        }
        else if (event.getSource() == btnPlanningM) {
            apPlanning.toFront();
        } else if (event.getSource() == btnAjoutLicenceM) {
            apAjoutLicence.toFront();
        } else if (event.getSource() == btnStatistiqueM) {
            apStatistique.toFront();
            graphBar.getData().clear();

            serieGraphBar = new XYChart.Series<>();
            serieGraphBar.setName("Nombre de moniteur qui possède cette licence");

            for (String valeur : moniteurController.getDatasMoniteur().keySet()) {
                XYChart.Data<String, Number> data = new XYChart.Data<>(valeur, moniteurController.getDatasMoniteur().get(valeur));
                serieGraphBar.getData().add(data);
            }

            graphBar.getData().add(serieGraphBar);

            CategoryAxis xAxis = (CategoryAxis) graphBar.getXAxis();
            xAxis.setTickLabelGap(10);
            xAxis.setAnimated(false);

            NumberAxis yAxis = (NumberAxis) graphBar.getYAxis();
            yAxis.setLowerBound(0);
            yAxis.setTickUnit(1);
            yAxis.setMinorTickVisible(false);

            graphBar.setCategoryGap(10);
            graphBar.setBarGap(5);

            graphBar.lookup(".chart-title").setStyle("-fx-text-fill: black; -fx-font-size: 14px; -fx-font-weight: bold;"); // Titre
            for (Node node : graphBar.lookupAll(".chart-legend-item")) {
                node.setStyle("-fx-text-fill: black; -fx-font-size: 12px; -fx-font-weight: bold;");
            }

            nbLicenceTotal.setText(String.valueOf(moniteurController.getNblicence(Moniteur.moniteurCo.getCodeMoniteur())));
            nbLeconPasse.setText(String.valueOf(moniteurController.getNbLeconPasse(Moniteur.moniteurCo.getCodeMoniteur())));
            nbLeconAVenir.setText(String.valueOf(moniteurController.getNbLeconAVenir(Moniteur.moniteurCo.getCodeMoniteur())));
            nbLeconTotal.setText(String.valueOf(moniteurController.getNbLeconTotal(Moniteur.moniteurCo.getCodeMoniteur())));



        } else if (event.getSource() == btnDeconnexionM) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userController = new UserController();
        moniteurController = new MoniteurController();
        leconController = new LeconController();
        vehiculeController = new VehiculeController();
        licenceController = new LicenceController();

        lblLogin.setText(User.userCo.getLogin());
        lblMdp.setText(User.userCo.getMdp());


        lblNom.setText(Moniteur.moniteurCo.getNom());
        lblPrenom.setText(Moniteur.moniteurCo.getPrenom());
        lblSexe.setText(Moniteur.moniteurCo.getSexe());
        lblDate.setText(Moniteur.moniteurCo.getDateNaissance());
        lblAdresse.setText(Moniteur.moniteurCo.getAdresse());
        lblCodePostal.setText(String.valueOf(Moniteur.moniteurCo.getCodePostal()));
        lblTel.setText(String.valueOf(Moniteur.moniteurCo.getTel()));
        lblVille.setText(Moniteur.moniteurCo.getVille());


        txtFCodePostMoniteur.setText(String.valueOf(Moniteur.moniteurCo.getCodePostal()));
        txtFNomMoniteur.setText(Moniteur.moniteurCo.getNom());
        txtFPrenomMoniteur.setText(Moniteur.moniteurCo.getPrenom());
        txtFSexeMoniteur.setText(Moniteur.moniteurCo.getSexe());
        txtFTelMoniteur.setText(String.valueOf(Moniteur.moniteurCo.getTel()));
        txtFVilleMoniteur.setText(Moniteur.moniteurCo.getVille());
        datePickDateNaissanceMoniteur.setValue(LocalDate.parse(Moniteur.moniteurCo.getDateNaissance()));
        txtFAdresseMoniteur.setText(Moniteur.moniteurCo.getAdresse());

        tcDatePlanningMoniteur.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcHeurePlanningMoniteur.setCellValueFactory(new PropertyValueFactory<>("heure"));
        tcNomElevePlanningMoniteur.setCellValueFactory(new PropertyValueFactory<>("nomEleve"));
        tcVehiculePlanningMoniteur.setCellValueFactory(new PropertyValueFactory<>("modeleVehicule"));

        tcTypePermis.setCellValueFactory(new PropertyValueFactory<>("typePermis"));



        tcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tcLibelleAquis.setCellValueFactory(new PropertyValueFactory<>("libelle"));


        try {
            tViewPlanningMoniteur.setItems(FXCollections.observableList(leconController.getLeconAffByMoniteur(Moniteur.moniteurCo.getCodeMoniteur())));
            tvLicence.setItems(FXCollections.observableList(licenceController.getLicenceNonAcquis(Moniteur.moniteurCo.getCodeMoniteur())));
            tvLicence1.setItems(FXCollections.observableList(licenceController.getLicenceAcquis(Moniteur.moniteurCo.getCodeMoniteur())));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void btnModifierInfoMoniteur(MouseEvent mouseEvent) throws SQLException {
        //Modif-->Profil

        moniteurController.update(txtFNomMoniteur.getText(), txtFPrenomMoniteur.getText(), txtFSexeMoniteur.getText(),datePickDateNaissanceMoniteur.getValue().toString(), txtFVilleMoniteur.getText(), Integer.parseInt(txtFCodePostMoniteur.getText()), txtFAdresseMoniteur.getText(), Integer.parseInt(txtFTelMoniteur.getText()), userController.getNumCompte(User.userCo.getLogin()) );

        //Recupérer les nouvelles valeurs
        Moniteur.moniteurCo = moniteurController.recupMoniteurCo(userController.getNumCompte(User.userCo.getLogin()));


        lblLogin.setText(User.userCo.getLogin());
        lblMdp.setText(User.userCo.getMdp());

        lblNom.setText(Moniteur.moniteurCo.getNom());
        lblPrenom.setText(Moniteur.moniteurCo.getPrenom());
        lblSexe.setText(Moniteur.moniteurCo.getSexe());
        lblDate.setText(Moniteur.moniteurCo.getDateNaissance());
        lblAdresse.setText(Moniteur.moniteurCo.getAdresse());
        lblCodePostal.setText(String.valueOf(Moniteur.moniteurCo.getCodePostal()));
        lblTel.setText(String.valueOf(Moniteur.moniteurCo.getTel()));
        lblVille.setText(Moniteur.moniteurCo.getVille());


        apProfil.toFront();
    }

    @FXML
    public void clickedBtnModif(MouseEvent mouseEvent) {
        apProfilModif.toFront();
    }


    @FXML
    public void clickedBtnAjouterLicence(Event event) throws SQLException {
        if (tvLicence.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choix de la licence");
            alert.setHeaderText("");
            alert.setContentText("Veuillez sélectionner une licence");
            alert.showAndWait();
        } else {
            // Récupérer la date sélectionnée à partir du DatePicker
            String dateObtention = dpDateOptentionLicence.getValue() != null ? dpDateOptentionLicence.getValue().toString() : "";

            for (Licence licence : tvLicence.getSelectionModel().getSelectedItems()) {
                licenceController.create(licenceController.getNewCodeLicence(), Moniteur.moniteurCo.getCodeMoniteur(), licence.getCodeCategorie(), dateObtention);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Licences Ajoutée");
                alert.setHeaderText("");
                alert.setContentText("Licence Ajoutée ");
                alert.showAndWait();
            }
            tvLicence.setItems(FXCollections.observableArrayList(licenceController.getLicenceNonAcquis(Moniteur.moniteurCo.getCodeMoniteur())));
        }
        tvLicence1.setItems(FXCollections.observableList(licenceController.getLicenceAcquis(Moniteur.moniteurCo.getCodeMoniteur())));
    }

}
