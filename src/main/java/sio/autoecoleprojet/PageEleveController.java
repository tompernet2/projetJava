package sio.autoecoleprojet;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.css.converter.StringConverter;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import sio.autoecoleprojet.controllers.*;
import sio.autoecoleprojet.models.*;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.ResourceBundle;

public class PageEleveController implements Initializable {
    UserController userController;
    EleveController eleveController;
    LeconController leconController;
    VehiculeController vehiculeController;

    MoniteurController moniteurController;
    CategorieController categorieController;



    @javafx.fxml.FXML
    private AnchorPane apPlanningE;
    @javafx.fxml.FXML
    private Button btnStatistiqueE;
    @javafx.fxml.FXML
    private Button btnProfilE;
    @javafx.fxml.FXML
    private Button btnInscriptionE;
    @javafx.fxml.FXML
    private Button btnDeconnexion;
    @javafx.fxml.FXML
    private Button btnPlanningE;
    @javafx.fxml.FXML
    private Label lblSexe;
    @javafx.fxml.FXML
    private Label lblVille;
    @javafx.fxml.FXML
    private Label lblCodePostal;
    @javafx.fxml.FXML
    private Label lblDate;
    @javafx.fxml.FXML
    private Label lblPrenom;
    @javafx.fxml.FXML
    private Label lblNom;
    @javafx.fxml.FXML
    private AnchorPane apProfil;
    @javafx.fxml.FXML
    private Label lblMdp;
    @javafx.fxml.FXML
    private TextField txtFCodePostEleve;
    @javafx.fxml.FXML
    private TextField txtFNomEleve;
    @javafx.fxml.FXML
    private AnchorPane apProfilModif;
    @javafx.fxml.FXML
    private DatePicker datePickDateNaissanceEleve;
    @javafx.fxml.FXML
    private TextField txtFTelEleve;
    @javafx.fxml.FXML
    private TextField txtFPrenomEleve;
    @javafx.fxml.FXML
    private Label lblLogin;
    @javafx.fxml.FXML
    private Label lblAdresse;
    @javafx.fxml.FXML
    private Label lblTel;
    @javafx.fxml.FXML
    private TextField txtFVilleEleve;
    @javafx.fxml.FXML
    private TextField txtFSexeEleve;
    @javafx.fxml.FXML
    private TextField txtFAdresse;
    @javafx.fxml.FXML
    private TableColumn tcMoniteur;
    @javafx.fxml.FXML
    private TableView<Lecon> tvLecon;
    @javafx.fxml.FXML
    private TableColumn tcModele;
    @javafx.fxml.FXML
    private TableColumn tcMarque;
    @javafx.fxml.FXML
    private TableColumn tcHeure;
    @javafx.fxml.FXML
    private TableColumn tcDate;
    @javafx.fxml.FXML

    private TableView<Moniteur> tvMoniteurDispo;
    @javafx.fxml.FXML
    private AnchorPane apInscription;
    @javafx.fxml.FXML
    private DatePicker dpDateLecon;
    @javafx.fxml.FXML
    private Spinner<String> spHeureLecon;
    @javafx.fxml.FXML
    private ComboBox<Categorie> cboCategorieLecon;
    @javafx.fxml.FXML
    private TableColumn tcMoniteurDispo;
    @javafx.fxml.FXML
    private TableColumn tcTypePermis;


    int codeCategorieSave;
    String dateSave;
    String heureSave;
    @javafx.fxml.FXML
    private TableView<Vehicule> tvVehiculeDispo;
    @javafx.fxml.FXML
    private TableColumn<Vehicule, String> tcVehiculeDispo;
    @javafx.fxml.FXML
    private AnchorPane apStatistique;
    @javafx.fxml.FXML
    private PieChart graphPie;
    @javafx.fxml.FXML
    private Label lblNbLeconAVenir;
    @javafx.fxml.FXML
    private Label lblNbLeconPasse;
    @javafx.fxml.FXML
    private Label lblNbLeconTotal;


    @javafx.fxml.FXML
    public void btnMenuClicked(Event event) throws SQLException {

        if (event.getSource() == btnProfilE) {
            apProfil.toFront();
        }
        else if (event.getSource() == btnPlanningE) {
            apPlanningE.toFront();
        }

        else if (event.getSource() == btnInscriptionE) {
            apInscription.toFront();
        }
        else if (event.getSource() == btnStatistiqueE) {
            apStatistique.toFront();

            graphPie.getData().clear();
            graphPie.setTitle("Nombre de leçons par sexe");
            graphPie.setStyle("-fx-background-color: white;");

            for (String sexe : eleveController.getDatas().keySet())
            {
                graphPie.getData().add(new PieChart.Data(sexe, eleveController.getDatas().get(sexe)));
            }

            for (PieChart.Data entry : graphPie.getData()) {
                Tooltip t = new Tooltip(entry.getPieValue()+ " : "+entry.getName());
                t.setStyle("-fx-background-color:#3D9ADA");
                Tooltip.install(entry.getNode(), t);
            }
            graphPie.lookup(".chart-title").setStyle("-fx-text-fill: black; -fx-font-size: 14px; -fx-font-weight: bold;"); // Titre
            for (Node node : graphPie.lookupAll(".chart-legend-item")) {
                node.setStyle("-fx-text-fill: black; -fx-font-size: 12px; -fx-font-weight: bold;");
            }

            lblNbLeconAVenir.setText(String.valueOf(eleveController.getNbLeconAVenir(Eleve.eleveCo.getCodeEleve())));
            lblNbLeconPasse.setText(String.valueOf(eleveController.getNbLeconPasse(Eleve.eleveCo.getCodeEleve())));
            lblNbLeconTotal.setText(String.valueOf(eleveController.getNbLeconTotal(Eleve.eleveCo.getCodeEleve())));

        }

        else if (event.getSource() == btnDeconnexion) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userController = new UserController();
        eleveController = new EleveController();
        leconController = new LeconController();
        vehiculeController = new VehiculeController();

        moniteurController = new MoniteurController();
        categorieController = new CategorieController();



        lblLogin.setText(User.userCo.getLogin());
        lblMdp.setText(User.userCo.getMdp());

        lblNom.setText(Eleve.eleveCo.getNom());
        lblPrenom.setText(Eleve.eleveCo.getPrenom());
        lblSexe.setText(Eleve.eleveCo.getSexe());
        lblDate.setText(Eleve.eleveCo.getDateNaissance());
        lblAdresse.setText(Eleve.eleveCo.getAdresse());
        lblCodePostal.setText(String.valueOf(Eleve.eleveCo.getCodePostal()));
        lblTel.setText(String.valueOf(Eleve.eleveCo.getTel()));
        lblVille.setText(Eleve.eleveCo.getVille());


        txtFCodePostEleve.setText(String.valueOf(Eleve.eleveCo.getCodePostal()));
        txtFNomEleve.setText(Eleve.eleveCo.getNom());
        txtFPrenomEleve.setText(Eleve.eleveCo.getPrenom());
        txtFSexeEleve.setText(Eleve.eleveCo.getSexe());
        txtFTelEleve.setText(String.valueOf(Eleve.eleveCo.getTel()));
        txtFVilleEleve.setText(Eleve.eleveCo.getVille());
        datePickDateNaissanceEleve.setValue(LocalDate.parse(Eleve.eleveCo.getDateNaissance()));
        txtFAdresse.setText(Eleve.eleveCo.getAdresse());


        tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        tcMoniteur.setCellValueFactory(new PropertyValueFactory<>("nomMoniteur"));
        tcMarque.setCellValueFactory(new PropertyValueFactory<>("marqueVehicule"));
        tcModele.setCellValueFactory(new PropertyValueFactory<>("modeleVehicule"));

        tcTypePermis.setCellValueFactory(new PropertyValueFactory<>("typePermis"));




        try {
            tvLecon.setItems(FXCollections.observableArrayList(leconController.getLeconAffBy(Eleve.eleveCo.getCodeEleve())));
            ArrayList<Categorie> categories = categorieController.getAll();
            cboCategorieLecon.getItems().addAll(categories);
            cboCategorieLecon.getSelectionModel().selectFirst();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ObservableList<String> heures = FXCollections.observableArrayList();
        heures.add("08:00:00");
        heures.add("09:00:00");
        heures.add("10:00:00");
        heures.add("11:00:00");
        heures.add("12:00:00");
        heures.add("13:00:00");
        heures.add("14:00:00");
        heures.add("15:00:00");
        heures.add("16:00:00");
        heures.add("17:00:00");
        heures.add("18:00:00");
        heures.add("19:00:00");
        heures.add("20:00:00");

        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(heures);
        spHeureLecon.setValueFactory(valueFactory);
        spHeureLecon.getValueFactory().setValue("08:00:00");


        try {
            if (eleveController.verifPermis(Eleve.eleveCo.getCodeEleve())){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Vous êtes éligible a passer votre permis");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void btnModifierInfoEleve(MouseEvent mouseEvent) throws SQLException {

        //Modif-->Profil

        eleveController.update(txtFNomEleve.getText(), txtFPrenomEleve.getText(), txtFSexeEleve.getText(),datePickDateNaissanceEleve.getValue().toString(), Integer.parseInt(txtFCodePostEleve.getText()), txtFVilleEleve.getText(), txtFAdresse.getText(), Integer.parseInt(txtFTelEleve.getText()), userController.getNumCompte(User.userCo.getLogin()) );

        Eleve.eleveCo = eleveController.recupEleveCo(userController.getNumCompte(User.userCo.getLogin()));

        lblLogin.setText(User.userCo.getLogin());
        lblMdp.setText(User.userCo.getMdp());

        lblNom.setText(Eleve.eleveCo.getNom());
        lblPrenom.setText(Eleve.eleveCo.getPrenom());
        lblSexe.setText(Eleve.eleveCo.getSexe());
        lblDate.setText(Eleve.eleveCo.getDateNaissance());
        lblAdresse.setText(Eleve.eleveCo.getAdresse());
        lblCodePostal.setText(String.valueOf(Eleve.eleveCo.getCodePostal()));
        lblTel.setText(String.valueOf(Eleve.eleveCo.getTel()));
        lblVille.setText(Eleve.eleveCo.getVille());

        apProfil.toFront();
    }

    @javafx.fxml.FXML
    public void clickedBtnModif(Event event) {
        apProfilModif.toFront();
        //Profil-->Modif
    }


    @javafx.fxml.FXML
    public void clickedRecherche(Event event) throws SQLException {

        if (dpDateLecon.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Veuillez choisir une date");
            alert.showAndWait();
        }
        else {
            codeCategorieSave = cboCategorieLecon.getSelectionModel().getSelectedItem().getCodeCategorie();
            dateSave = dpDateLecon.getValue().toString();
            heureSave = spHeureLecon.getValue();
            //tvMoniteurDispo.setItems(FXCollections.observableArrayList(moniteurController.getMoniteursDisponibles(dpDateLecon.getValue().toString(), spHeureLecon.getValue())));
            tvMoniteurDispo.setItems(FXCollections.observableArrayList(moniteurController.getMoniteurDispo(codeCategorieSave,dateSave, heureSave)));
            tvVehiculeDispo.setItems(FXCollections.observableArrayList(vehiculeController.getVehiculeDispo(codeCategorieSave,dateSave, heureSave)));
            tcMoniteurDispo.setCellValueFactory(new PropertyValueFactory<>("nom"));
           tcVehiculeDispo.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().getMarqueModele())
            );
        }




    }


    @javafx.fxml.FXML
    public void clickedInscription(Event event) throws SQLException {
        if (tvMoniteurDispo.getItems().isEmpty() || tvMoniteurDispo.getSelectionModel().getSelectedItem() == null ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Aucun moniteur sélectionné");
            alert.setContentText("Veuillez sélectionner un moniteur avant de continuer.");
            alert.showAndWait();
        }
        else {
            if (tvVehiculeDispo.getItems().isEmpty() || tvVehiculeDispo.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Aucun véhicule sélectionné");
                alert.setContentText("Veuillez sélectionner un véhicule avant de continuer.");
                alert.showAndWait();
                return;
            }

            Vehicule vehiculeSelectionne = tvVehiculeDispo.getSelectionModel().getSelectedItem();
            String immatriculation = vehiculeSelectionne.getImmatriculation();

            int codeLecon = leconController.getNewCodeLecon();
            int codeMoniteur = tvMoniteurDispo.getSelectionModel().getSelectedItem().getCodeMoniteur();
            int codeEleve = Eleve.eleveCo.getCodeEleve();
            boolean leconDejaPrise = leconController.verifLecon(codeEleve, dateSave, heureSave);

            if (leconDejaPrise == false){
                if (immatriculation == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Aucun véhicule disponible");
                    alert.showAndWait();
                }
                else {
                    leconController.create(codeLecon, dateSave, heureSave, codeMoniteur, codeEleve, immatriculation, 1, codeCategorieSave);
                    tvLecon.setItems(FXCollections.observableArrayList(leconController.getLeconAffBy(Eleve.eleveCo.getCodeEleve())));

                    tvMoniteurDispo.setItems(FXCollections.observableArrayList(moniteurController.getMoniteurDispo(codeCategorieSave, dateSave, heureSave)));
                    tvVehiculeDispo.setItems(FXCollections.observableArrayList(vehiculeController.getVehiculeDispo(codeCategorieSave, dateSave, heureSave)));
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Inscription Réussie");
                    alert.showAndWait();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Il y a déjà une leçon à cette date et cette heure");
                alert.showAndWait();
            }
        }
    }




}

