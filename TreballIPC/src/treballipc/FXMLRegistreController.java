/**
 * Sample Skeleton for 'FXMLRegistre.fxml' Controller Class
 */

package treballipc;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Player;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import static treballipc.FXMLDocumentController.dark;

public class FXMLRegistreController {


    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML // fx:id="emailField"
    private TextField emailField; // Value injected by FXMLLoader

    @FXML // fx:id="PasswordField"
    private PasswordField PasswordField; // Value injected by FXMLLoader

    @FXML // fx:id="ConfirmPasswordField"
    private PasswordField ConfirmPasswordField; // Value injected by FXMLLoader

    @FXML // fx:id="DateOBField"
    private DatePicker DateOBField; // Value injected by FXMLLoader

    @FXML // fx:id="av1"
    private ImageView av1; // Value injected by FXMLLoader

    @FXML // fx:id="av2"
    private ImageView av2; // Value injected by FXMLLoader

    @FXML // fx:id="av3"
    private ImageView av3; // Value injected by FXMLLoader

    @FXML // fx:id="av4"
    private ImageView av4; // Value injected by FXMLLoader

    @FXML // fx:id="av5"
    private ImageView av5; // Value injected by FXMLLoader

    @FXML // fx:id="registerButton"
    private Button registerButton; // Value injected by FXMLLoader

    @FXML // fx:id="CancelButton"
    private Button CancelButton; // Value injected by FXMLLoader
    
    @FXML // fx:id="registerError"
    private Label registerError; // Value injected by FXMLLoader
    @FXML
    private VBox window;

    @FXML
    void av1Select(MouseEvent event) {

    }

    @FXML
    void av2Select(MouseEvent event) {

    }

    @FXML
    void av3Select(MouseEvent event) {

    }

    @FXML
    void av4Select(MouseEvent event) {

    }

    @FXML
    void av5Select(MouseEvent event) {

    }

    @FXML
    void cancelAction(ActionEvent event) {
        
            ((Stage) CancelButton.getScene().getWindow()).close();
    }

    @FXML
    void registerAttempt(ActionEvent event) throws Exception {
        boolean registerOK = true;
        
        LocalDate dob = null;
        
        if(usernameField.getText().equals("")) {
            registerOK = false;
            registerError.setText("Es necessita un nom d'usuari");
        
        }
        if(!Player.checkNickName(usernameField.getText())) {
            registerOK = false;
            registerError.setText("Es necessita un nom d'usuari valid");
        }
        if(!TreballIPC.game.exitsNickName(usernameField.getText())) {
            registerOK = false;
            registerError.setText("Nom d'usuari ja registrat");
        }
        else if(emailField.getText().equals("")) {
            registerOK = false;
            registerError.setText("Es necessita un correu electronic");
        }
        else if(!Player.checkEmail(emailField.getText())) {
            registerError.setText("Es necessita un correu electronic valid");
            registerOK = false;
        }
        else if(PasswordField.getText().equals("") || FXMLDocumentController.modifying == 1) {
            registerError.setText("Es necessita una contrasenya");
            registerOK = false;
        }
        else if(!(PasswordField.getText().equals("") && FXMLDocumentController.modifying == 1) && !Player.checkPassword(PasswordField.getText())) {
            registerOK = false;
            registerError.setText("Les contrasenyes ha de complir els següents requisits: \n"
                    + "\t-Entre 8 i 20 caracters \n"
                    + "\t-Contenir com a minim una lletra majuscula \n"
                    + "\t-Contenir com a minim una lletra minuscula \n"
                    + "\t-Contenir com a minim un digit (0-9) \n"
                    + "\t-Contenir com a minim un d'aquests caracters: !@#$%&*()-+=  \n"
                    + "\t-NO Contenir cap espai en blanc");
        }
        else 
            if(!PasswordField.getText().equals(ConfirmPasswordField.getText())) {
            registerOK = false;
            registerError.setText("Les contrasenyes no coincideixen");
        }
        else try {
            dob = DateOBField.getValue();
        }
        catch(Exception e) {
            registerOK = false;
            registerError.setText("S'ha d'incloure una data vàlida");
        }
        
        if(dob != null && dob.compareTo(LocalDate.now().minusYears(12)) > 0) {
            registerOK = false;
            registerError.setText("No es pot haver nascut en el futur");
        }
        
        if(registerOK) {
            registerError.setText("Usuari registrat amb exit!");
            CancelButton.setText("Tancar");
            registerButton.setVisible(false);
            
            if(FXMLDocumentController.modifying == 0) {
            TreballIPC.game.registerPlayer(usernameField.getText(), emailField.getText(), PasswordField.getText(), fotos[avatar], dob, 0); }
            else {
                Player juga = TreballIPC.game.getPlayer(usernameField.getText());
                juga.setBirthdate(dob);
                juga.setEmail(emailField.getText());
                if(PasswordField.getText() != "") {
                juga.setPassword(PasswordField.getText()); }
                //juga.setAvatar(avatar);
            }
            
        }
    }

        static int avatar = 0;
        static Image[] fotos = new Image[5];
        @FXML
    void initialize() {
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert PasswordField != null : "fx:id=\"PasswordField\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert ConfirmPasswordField != null : "fx:id=\"ConfirmPasswordField\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert DateOBField != null : "fx:id=\"DateOBField\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert av1 != null : "fx:id=\"av1\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert av2 != null : "fx:id=\"av2\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert av3 != null : "fx:id=\"av3\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert av4 != null : "fx:id=\"av4\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert av5 != null : "fx:id=\"av5\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert CancelButton != null : "fx:id=\"CancelButton\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";
        assert registerError != null : "fx:id=\"registerError\" was not injected: check your FXML file 'FXMLRegistre.fxml'.";

        fotos[0] = new Image(getClass().getResourceAsStream("default.png"));
        for(int i= 1; i < 5; i++) {
            fotos[i] = new Image(getClass().getResourceAsStream("avatar" + i + ".png"));
        }
        
        inicialitzarEstil();
        if(FXMLDocumentController.modifying == 1) {
            inicialitzarModif();
        }
    }
    
    void inicialitzarModif() {
        Player juga = TreballIPC.j1;
        usernameField.setText(juga.getNickName());
        usernameField.setDisable(true);
        emailField.setText(juga.getEmail());
        ConfirmPasswordField.setPromptText("Confirmar Nova Contrasenya");
        PasswordField.setPromptText("Nova Contrasenya");
        DateOBField.setValue(juga.getBirthdate());
        
        registerButton.setText("Modificar");
        
    }
    
    void inicialitzarEstil() {
        
                if(FXMLDocumentController.dark.getValue()) {
                    String e = "treballipc/dark.css";
                    window.getStylesheets().clear();
                    window.getStylesheets().add(e);
                }
                else {
                    String e = "treballipc/clear.css";
                    window.getStylesheets().clear();
                    window.getStylesheets().add(e);
                }
            FXMLDocumentController.dark.addListener( //EXEMPLE DE LISTENER!!!!
            (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                if(FXMLDocumentController.dark.getValue()) {
                    String e = "treballipc/dark.css";
                    window.getStylesheets().clear();
                    window.getStylesheets().add(e);
                }
                else {
                    String e = "treballipc/clear.css";
                    window.getStylesheets().clear();
                    window.getStylesheets().add(e);
                }
            });
    }
    
}
