package sio.autoecoleprojet;

import com.google.protobuf.StringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.security.core.parameters.P;
import sio.autoecoleprojet.controllers.*;
import sio.autoecoleprojet.models.*;
import javafx.scene.control.TableColumn;
import sio.autoecoleprojet.tools.ConnexionBDD;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.ResourceBundle;

public class PageResponsableController implements Initializable {

    UserController userController;
    MoniteurController moniteurController;
    VehiculeController vehiculeController;
    LeconController leconController;
    LicenceController licenceController;
    CategorieController categorieController;
    EleveController eleveController;
    ConnexionBDD connexionBDD;


    @javafx.fxml.FXML
    private AnchorPane apProfil;
    @javafx.fxml.FXML
    private Label lblMdp;
    @javafx.fxml.FXML
    private Button btnGestionCatR;
    @javafx.fxml.FXML
    private Label lblNom;
    @javafx.fxml.FXML
    private Button btnPlanningR;
    @javafx.fxml.FXML
    private Label lblLogin;
    @javafx.fxml.FXML
    private Button btnGestionVehiculesR;
    @javafx.fxml.FXML
    private Button btnGestionMoniteursR;
    @javafx.fxml.FXML
    private Label lblPrenom;
    @javafx.fxml.FXML
    private Button btnDeconnexionR;
    @javafx.fxml.FXML
    private AnchorPane apGestionCat;
    @javafx.fxml.FXML
    private AnchorPane apGestionMoniteurs;
    @javafx.fxml.FXML
    private AnchorPane apGestionVehicules;
    @javafx.fxml.FXML
    private Button btnProfilR;
    @javafx.fxml.FXML
    private TableView<Vehicule> tvGestionVehicule;
    @javafx.fxml.FXML
    private TableColumn tcModèle;
    @javafx.fxml.FXML
    private TableColumn tcMarque;
    @javafx.fxml.FXML
    private TableColumn tcImmat;
    @javafx.fxml.FXML
    private TableColumn tcAnnee;
    @javafx.fxml.FXML
    private TableColumn tcCategorie;
    @javafx.fxml.FXML
    private AnchorPane apAjoutVehicule;
    @javafx.fxml.FXML
    private TextField txtFieldMarqueVehicule;
    @javafx.fxml.FXML
    private TextField txtFiedlAnneeVehicule;
    @javafx.fxml.FXML
    private TextField txtFieldImmatVehicule;
    @javafx.fxml.FXML
    private TextField txtFieldModeleVehicule;
    @javafx.fxml.FXML
    private ComboBox cboCat;
    @javafx.fxml.FXML
    private AnchorPane apModifierVehicule;
    @javafx.fxml.FXML
    private TextField txtFieldModeleVehiculeModif;
    @javafx.fxml.FXML
    private TextField txtFieldMarqueVehiculeModif;
    @javafx.fxml.FXML
    private TextField txtFieldImmatVehiculeModif;
    @javafx.fxml.FXML
    private ComboBox cboCatModif;
    @javafx.fxml.FXML
    private TextField txtFiedlAnneeVehiculeModif;
    @javafx.fxml.FXML
    private TableColumn tcLibelleCat;
    @javafx.fxml.FXML
    private TextField txtFieldModifierPrixCat;
    @javafx.fxml.FXML
    private AnchorPane apModifierCat;
    @javafx.fxml.FXML
    private TextField txtFieldModifLibelleCat;
    @javafx.fxml.FXML
    private TableColumn tcPrixCat;
    @javafx.fxml.FXML
    private TextField txtFieldLibelleCat;
    @javafx.fxml.FXML
    private TableView<Categorie> tvGestionCat;
    @javafx.fxml.FXML
    private AnchorPane apAjouterCat;
    @javafx.fxml.FXML
    private TextField txtFieldPrixCat;
    @javafx.fxml.FXML
    private TableColumn tcNomM;
    @javafx.fxml.FXML
    private TableColumn tcAdresseM;
    @javafx.fxml.FXML
    private TableColumn tcTelM;
    @javafx.fxml.FXML
    private TableColumn tcSexeM;
    @javafx.fxml.FXML
    private TableColumn tcVilleM;
    @javafx.fxml.FXML
    private TableColumn tcDateNaissanceM;
    @javafx.fxml.FXML
    private TableColumn tcPrenomM;
    @javafx.fxml.FXML
    private TableColumn tcCodePostM;
    @javafx.fxml.FXML
    private TableView<Moniteur> tvGestionMoniteur;
    @javafx.fxml.FXML
    private TableColumn tcDateL;
    @javafx.fxml.FXML
    private TableColumn tcHeureL;
    @javafx.fxml.FXML
    private TableColumn tcMoniteurNomL;
    @javafx.fxml.FXML
    private TableColumn tcImmatL;
    @javafx.fxml.FXML
    private AnchorPane apPlanningLecon;
    @javafx.fxml.FXML
    private TableColumn tcPrenomEleveL;
    @javafx.fxml.FXML
    private TableColumn tcTypePermisL;
    @javafx.fxml.FXML
    private TableColumn tcNomEleveL;
    @javafx.fxml.FXML
    private TableColumn tcRegleeL;
    @javafx.fxml.FXML
    private TableView tvPlanningLecon;
    @javafx.fxml.FXML
    private ListView<Eleve> lViewAfficheEleve;
    @javafx.fxml.FXML
    private AnchorPane apChoixPlanning;
    @javafx.fxml.FXML
    private AnchorPane apPlanningEleve;
    @javafx.fxml.FXML
    private TableView tvPlanningLeconByEleve;
    @javafx.fxml.FXML
    private TableColumn tcMoniteurNomE;
    @javafx.fxml.FXML
    private TableColumn tcDateE;
    @javafx.fxml.FXML
    private TableColumn tcModeleE;
    @javafx.fxml.FXML
    private TableColumn tcHeureE;
    @javafx.fxml.FXML
    private TableColumn tcVehiculeMarqueE;
    @javafx.fxml.FXML
    private TableColumn tcTypePermisE;
    @javafx.fxml.FXML
    private ListView<Moniteur> lViewAfficheMoniteur;
    @javafx.fxml.FXML
    private TableView tvPlanningLeconByMoniteur;
    @javafx.fxml.FXML
    private TableColumn tcDateM;
    @javafx.fxml.FXML
    private AnchorPane apPlanningMoniteur;
    @javafx.fxml.FXML
    private TableColumn tcHeureM;
    @javafx.fxml.FXML
    private TableColumn tcElevePrenomM;
    @javafx.fxml.FXML
    private TableColumn tcVehiculeModelM;
    @javafx.fxml.FXML
    private TableColumn tcTypePermisM;
    @javafx.fxml.FXML
    private TableColumn tcEleveNomM;
    @javafx.fxml.FXML
    private TableColumn tcVehiculeMarqueM;
    @javafx.fxml.FXML
    private DatePicker dpNaissanceM;
    @javafx.fxml.FXML
    private TextField txtFieldCodePostalM;
    @javafx.fxml.FXML
    private TextField txtFieldTelM;
    @javafx.fxml.FXML
    private TextField txtFieldNomM;
    @javafx.fxml.FXML
    private Button btnConnexion;
    @javafx.fxml.FXML
    private TextField txtFieldMdpM;
    @javafx.fxml.FXML
    private TextField txtFieldSexeM;
    @javafx.fxml.FXML
    private TextField txtFieldLoginM;
    @javafx.fxml.FXML
    private TextField txtFieldPrenomM;
    @javafx.fxml.FXML
    private TextField txtFieldAdresseM;
    @javafx.fxml.FXML
    private AnchorPane apInscriptionMoniteur;
    @javafx.fxml.FXML
    private TextField txtFieldVilleM;

    @javafx.fxml.FXML
    public void btnMenuClicked(MouseEvent mouseEvent) throws SQLException {
        apInvisible();
        if (mouseEvent.getSource() == btnProfilR) {
            apProfil.setVisible(true);
        } else if (mouseEvent.getSource() == btnGestionVehiculesR) {
            apGestionVehicules.setVisible(true);
        } else if (mouseEvent.getSource() == btnGestionCatR) {
            apGestionCat.setVisible(true);
        } else if (mouseEvent.getSource() == btnGestionMoniteursR) {
            apGestionMoniteurs.setVisible(true);
        }  else if (mouseEvent.getSource() == btnPlanningR) {
            apChoixPlanning.setVisible(true);
        }
        else if (mouseEvent.getSource() == btnDeconnexionR) {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public void apInvisible() {
        apInscriptionMoniteur.setVisible(false);
        apGestionCat.setVisible(false);
        apModifierCat.setVisible(false);
        apGestionVehicules.setVisible(false);
        apAjouterCat.setVisible(false);
        apProfil.setVisible(false);
        apModifierVehicule.setVisible(false);
        apGestionMoniteurs.setVisible(false);
        apAjoutVehicule.setVisible(false);
        apPlanningLecon.setVisible(false);
        apPlanningEleve.setVisible(false);
        apChoixPlanning.setVisible(false);
        apPlanningMoniteur.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apInvisible();
        apProfil.setVisible(true);
        try {
            connexionBDD = new ConnexionBDD();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        userController = new UserController();
        moniteurController = new MoniteurController();
        leconController = new LeconController();
        vehiculeController = new VehiculeController();
        licenceController = new LicenceController();
        categorieController = new CategorieController();
        eleveController = new EleveController();


        lblLogin.setText(User.userCo.getLogin());
        lblMdp.setText(User.userCo.getMdp());
        lblPrenom.setText(Responsable.reponsableCo.getPrenom());
        lblNom.setText(Responsable.reponsableCo.getNom());

        //Gestion vehicule
        tcImmat.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        tcModèle.setCellValueFactory(new PropertyValueFactory<>("modele"));
        tcMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        tcAnnee.setCellValueFactory(new PropertyValueFactory<>("annee"));
        tcCategorie.setCellValueFactory(new PropertyValueFactory<>("categorieVehicule"));

        //gestion categorie
        tcLibelleCat.setCellValueFactory(new PropertyValueFactory<>("Libelle"));
        tcPrixCat.setCellValueFactory(new PropertyValueFactory<>("Prix"));


        //gestion moniteurs
        tcNomM.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        tcPrenomM.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        tcSexeM.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        tcDateNaissanceM.setCellValueFactory(new PropertyValueFactory<>("DateNaissance"));
        tcAdresseM.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        tcCodePostM.setCellValueFactory(new PropertyValueFactory<>("CodePostale"));
        tcVilleM.setCellValueFactory(new PropertyValueFactory<>("Ville"));
        tcTelM.setCellValueFactory(new PropertyValueFactory<>("Telephone"));

        //planning lecon
        tcDateL.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tcHeureL.setCellValueFactory(new PropertyValueFactory<>("Heure"));
        tcMoniteurNomL.setCellValueFactory(new PropertyValueFactory<>("PrenomMoniteur"));
        tcPrenomEleveL.setCellValueFactory(new PropertyValueFactory<>("PrenomEleve"));
        tcNomEleveL.setCellValueFactory(new PropertyValueFactory<>("NomEleve"));
        tcImmatL.setCellValueFactory(new PropertyValueFactory<>("Immatriculation"));
        tcRegleeL.setCellValueFactory(new PropertyValueFactory<>("Reglee"));
        tcTypePermisL.setCellValueFactory(new PropertyValueFactory<>("TypePermis"));

        //planing lecon eleve
        tcDateE.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tcHeureE.setCellValueFactory(new PropertyValueFactory<>("Heure"));
        tcMoniteurNomE.setCellValueFactory(new PropertyValueFactory<>("NomMoniteur"));
        tcVehiculeMarqueE.setCellValueFactory(new PropertyValueFactory<>("marqueVehicule"));
        tcModeleE.setCellValueFactory(new PropertyValueFactory<>("modeleVehicule"));
        tcTypePermisE.setCellValueFactory(new PropertyValueFactory<>("TypePermis"));

        //planning lecon moniteur
        tcDateM.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tcHeureM.setCellValueFactory(new PropertyValueFactory<>("heure"));
        tcEleveNomM.setCellValueFactory(new PropertyValueFactory<>("nomEleve"));
        tcElevePrenomM.setCellValueFactory(new PropertyValueFactory<>("prenomEleve"));
        tcVehiculeMarqueM.setCellValueFactory(new PropertyValueFactory<>("marqueVehicule"));
        tcVehiculeModelM.setCellValueFactory(new PropertyValueFactory<>("modeleVehicule"));
        tcTypePermisM.setCellValueFactory(new PropertyValueFactory<>("typePermis"));


        try {

            ArrayList<String> categories = vehiculeController.getCategorieVehicule();

            cboCat.getItems().addAll(categories);
            cboCatModif.getItems().addAll(categories);

            tvGestionVehicule.setItems(FXCollections.observableArrayList(vehiculeController.getAll()));
            tvGestionCat.setItems(FXCollections.observableArrayList(categorieController.getAll()));
            tvGestionMoniteur.setItems(FXCollections.observableArrayList(moniteurController.getAll()));
            tvPlanningLecon.setItems(FXCollections.observableArrayList(leconController.getAll()));
            lViewAfficheEleve.setItems(FXCollections.observableArrayList(eleveController.recupEleve()));
            lViewAfficheMoniteur.setItems(FXCollections.observableArrayList(moniteurController.recupMoniteur()));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void btnAjouterVehicules(MouseEvent event) throws SQLException {
        apInvisible();
        apAjoutVehicule.setVisible(true);
    }


    @javafx.fxml.FXML
    public void btnAjouterCat(MouseEvent event) {
        apInvisible();
        apAjouterCat.setVisible(true);
    }

    @javafx.fxml.FXML
    public void btnAjouterMoniteur(MouseEvent event) {
        apInvisible();
        apInscriptionMoniteur.setVisible(true);
    }

    @javafx.fxml.FXML
    public void btnPlanningEleve(MouseEvent event) {
        apInvisible();
        apPlanningEleve.setVisible(true);
    }

    @javafx.fxml.FXML
    public void btnPlanningLecon(MouseEvent event) {
        apInvisible();
        apPlanningLecon.setVisible(true);
    }

    @javafx.fxml.FXML
    public void btnPlanningMoniteur(MouseEvent event) throws SQLException {
        apInvisible();
        apPlanningMoniteur.setVisible(true);
    }


    @javafx.fxml.FXML
    public void btnModifierInfoVehicules(MouseEvent event) throws SQLException {
        Vehicule selectedVehicule = tvGestionVehicule.getSelectionModel().getSelectedItem();
        if (selectedVehicule != null) {
            txtFieldImmatVehiculeModif.setText(selectedVehicule.getImmatriculation());
            txtFieldMarqueVehiculeModif.setText(selectedVehicule.getMarque());
            txtFieldModeleVehiculeModif.setText(selectedVehicule.getModele());
            txtFiedlAnneeVehiculeModif.setText(String.valueOf(selectedVehicule.getAnnee()));
            cboCatModif.getSelectionModel().select(selectedVehicule.getCategorieVehicule());
            apInvisible();
            apModifierVehicule.setVisible(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sélection manquante");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un véhicule à modifier.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void btnValiderAjoutVehicule(MouseEvent event) throws SQLException {
        if (txtFieldImmatVehicule.getText().isEmpty() ||
                txtFieldMarqueVehicule.getText().isEmpty() ||
                txtFieldModeleVehicule.getText().isEmpty() ||
                txtFiedlAnneeVehicule.getText().isEmpty() ||
                cboCat.getSelectionModel().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs manquants");
            alert.setContentText("Veuillez remplir tous les champs avant d'ajouter un véhicule.");
            alert.showAndWait();
            return;
        }

        String anneeText = txtFiedlAnneeVehicule.getText();
        try {
            Integer.parseInt(anneeText);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Année invalide");
            alert.setContentText("Veuillez entrer une année valide.");
            alert.showAndWait();
            return;
        }

        String categorie = cboCat.getSelectionModel().getSelectedItem().toString();

        try {
            vehiculeController.create(txtFieldImmatVehicule.getText(), txtFieldMarqueVehicule.getText(), txtFieldModeleVehicule.getText(), Integer.parseInt(txtFiedlAnneeVehicule.getText()), vehiculeController.getCodeCategorieByLibelle(categorie));
            tvGestionVehicule.setItems(FXCollections.observableArrayList(vehiculeController.getAll()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Le véhicule a été ajouté avec succès !");
            alert.showAndWait();

            apInvisible();
            apGestionVehicules.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @javafx.fxml.FXML
    public void btnValiderModifierVehicule(MouseEvent event) throws SQLException {
        String categorieLibelle = cboCatModif.getValue().toString();
        vehiculeController.update(txtFieldImmatVehiculeModif.getText(),txtFieldMarqueVehiculeModif.getText(), txtFieldModeleVehiculeModif.getText(), Integer.parseInt(txtFiedlAnneeVehiculeModif.getText()),vehiculeController.getCodeCategorieByLibelle(categorieLibelle));
        tvGestionVehicule.setItems(FXCollections.observableArrayList(vehiculeController.getAll()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("Le véhicule a été modifié avec succès !");
        alert.showAndWait();
        apInvisible();
        apGestionVehicules.setVisible(true);
    }


    @javafx.fxml.FXML
    public void btnValiderAjoutCat(MouseEvent event) throws SQLException {
        if (txtFieldLibelleCat.getText().isEmpty() || txtFieldPrixCat.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs manquants");
            alert.setContentText("Veuillez remplir tous les champs avant d'ajouter une catégorie.");
            alert.showAndWait();
            return;
        }

        try {
            Float.parseFloat(txtFieldPrixCat.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Prix invalide");
            alert.setContentText("Veuillez entrer un prix valide.");
            alert.showAndWait();
            return;
        }
        categorieController.create(categorieController.getNewCodeCategorie(),txtFieldLibelleCat.getText(), Float.parseFloat(txtFieldPrixCat.getText()));
        tvGestionCat.setItems(FXCollections.observableArrayList(categorieController.getAll()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("La Catégorie a été ajoutée avec succès !");
        alert.showAndWait();

        apInvisible();
        apGestionCat.setVisible(true);

    }



    @javafx.fxml.FXML
    public void btnModifierInfoCat(MouseEvent event) {
        Categorie selectedCategorie = tvGestionCat.getSelectionModel().getSelectedItem();
        if (tvGestionCat.getSelectionModel().getSelectedItem() != null) {
            txtFieldModifLibelleCat.setText(selectedCategorie.getLibelle());
            txtFieldModifierPrixCat.setText(String.valueOf(selectedCategorie.getPrix()));
            apInvisible();
            apModifierCat.setVisible(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sélection manquante");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un véhicule à modifier.");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void btnValiderModifierCat(MouseEvent event) throws SQLException {
        Categorie selectedCategorie = tvGestionCat.getSelectionModel().getSelectedItem();
            int codeCategorie = selectedCategorie.getCodeCategorie();

            categorieController.update(codeCategorie, txtFieldModifLibelleCat.getText(), Float.parseFloat(txtFieldModifierPrixCat.getText()));
            tvGestionCat.setItems(FXCollections.observableArrayList(categorieController.getAll()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("La catégorie a été modifiée avec succès !");
            alert.showAndWait();
            apInvisible();
            apGestionCat.setVisible(true);
        }

    @javafx.fxml.FXML
    public void clickedBtnInscriptionM(MouseEvent event) throws SQLException {
        userController.create(txtFieldLoginM.getText(), txtFieldMdpM.getText(), 1);
        moniteurController.create(moniteurController.getNewCodeMoniteur(), txtFieldNomM.getText(), txtFieldPrenomM.getText(), txtFieldSexeM.getText(), String.valueOf(dpNaissanceM.getValue()), txtFieldAdresseM.getText(), Integer.parseInt(txtFieldCodePostalM.getText()), txtFieldVilleM.getText(), Integer.parseInt(txtFieldTelM.getText()), userController.getNumCompte(txtFieldLoginM.getText()), String.valueOf(0));
        tvGestionMoniteur.setItems(FXCollections.observableArrayList(moniteurController.getAll()));
        apInvisible();
        apGestionMoniteurs.setVisible(true);
    }


    @javafx.fxml.FXML
    public void btnRechercherLeconEleve(MouseEvent event) throws SQLException {

        Eleve selectedEleve = lViewAfficheEleve.getSelectionModel().getSelectedItem();
        if (selectedEleve != null) {
            int codeEleve = selectedEleve.getCodeEleve();
            ArrayList<Lecon> lecons = leconController.getLeconEleve(codeEleve);
            if (lecons.isEmpty()) {
                tvPlanningLeconByEleve.setItems(FXCollections.observableArrayList());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Aucune leçons trouvée");
                alert.setHeaderText(null);
                alert.setContentText("L'eleve n'a pas de lecon");
                alert.showAndWait();
            } else {
                tvPlanningLeconByEleve.setItems(FXCollections.observableArrayList(lecons));
            }
        }
    }


    @javafx.fxml.FXML
    public void btnRecherchePlanningMoniteur(MouseEvent event) throws SQLException {
        Moniteur selectedMoniteur = lViewAfficheMoniteur.getSelectionModel().getSelectedItem();
        if (selectedMoniteur != null) {
            int codeMoniteur = selectedMoniteur.getCodeMoniteur();
            ArrayList<Lecon> lecons = leconController.getLeconMoniteur(codeMoniteur);
            if (lecons.isEmpty()) {
                tvPlanningLeconByMoniteur.setItems(FXCollections.observableArrayList());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Aucune leçons trouvée");
                alert.setHeaderText(null);
                alert.setContentText("Le moniteur n'a pas de lecon");
                alert.showAndWait();
            } else {
                tvPlanningLeconByMoniteur.setItems(FXCollections.observableArrayList(lecons));
            }
        }
    }

}
