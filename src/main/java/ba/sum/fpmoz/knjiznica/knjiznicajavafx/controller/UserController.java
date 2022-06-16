package ba.sum.fpmoz.knjiznica.knjiznicajavafx.controller;

import ba.sum.fpmoz.knjiznica.knjiznicajavafx.Program;
import ba.sum.fpmoz.knjiznica.knjiznicajavafx.model.Table;
import ba.sum.fpmoz.knjiznica.knjiznicajavafx.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    TextField firstnameTxt;

    @FXML
    TextField lastnameTxt;

    @FXML
    TextField uidTxt;

    @FXML
    TextField emailTxt;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    TableColumn tableColumnID;

    @FXML
    TableColumn tableColumnFirstname;

    @FXML
    TableColumn tableColumnLastname;

    @FXML
    TableColumn tableColumnUid;

    @FXML
    TableColumn tableColumnEmail;

    @FXML
    TableColumn tableColumnRole;

    @FXML
    TableView tableViewUsers;

    @FXML
    Button deleteBtn;

    User selectedUser;

    @FXML
    protected void selectUser (){
        this.selectedUser = (User) this.tableViewUsers.getSelectionModel().getSelectedItem();
        this.deleteBtn.setDisable(false);
        this.firstnameTxt.setText(this.selectedUser.getFirstname());
        this.lastnameTxt.setText(this.selectedUser.getLastname());
        this.uidTxt.setText(this.selectedUser.getJMBG());
        this.emailTxt.setText(this.selectedUser.getEmail());
        this.comboBox.setValue(this.selectedUser.getRole());
    }

    @FXML
    protected void deleteUser() throws Exception {
        if(this.selectedUser != null){
            this.selectedUser.delete();
            this.fillUsers();
        }
    }


   @FXML
    protected void saveUser() throws Exception {
        if(this.selectedUser == null) {
            User newUser = new User();
            System.out.println(this.comboBox.getValue());
            newUser.setFirstname(this.firstnameTxt.getText());
            newUser.setLastname(this.lastnameTxt.getText());
            newUser.setJMBG(this.uidTxt.getText());
            newUser.setEmail(this.emailTxt.getText());
            newUser.setRole(this.comboBox.getValue());
            newUser.save();
        } else{
            this.selectedUser.setFirstname(this.firstnameTxt.getText());
            this.selectedUser.setLastname(this.lastnameTxt.getText());
            this.selectedUser.setJMBG(this.uidTxt.getText());
            this.selectedUser.setEmail(this.emailTxt.getText());
            this.selectedUser.setRole(this.comboBox.getValue());
            this.selectedUser.update();
            this.selectedUser = null;
        }

       this.fillUsers();
       this.firstnameTxt.setText("");
       this.lastnameTxt.setText("");
       this.uidTxt.setText("");
       this.emailTxt.setText("");
   }

   private void fillUsers(){
       try {
           ObservableList<User> users = (ObservableList<User>) FXCollections.observableArrayList(Table.list(User.class));
           this.tableViewUsers.setItems(users);
       } catch (Exception e) {
           System.out.println("Nastala je pogreška: " + e.getMessage());
       }
   }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        comboBox.setItems(FXCollections.observableArrayList("Student", "Knjižničar", "Profesor"));
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableColumnFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        this.tableColumnLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.tableColumnUid.setCellValueFactory(new PropertyValueFactory<>("JMBG"));
        this.tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.tableColumnRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        this.fillUsers();

    }

    @FXML
    public void natrag(ActionEvent evt) {
        Stage stage = (Stage)((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "intro-view.fxml");
    }

}
