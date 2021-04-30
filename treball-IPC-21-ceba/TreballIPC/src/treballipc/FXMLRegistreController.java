/**
 * Sample Skeleton for 'FXMLRegistre.fxml' Controller Class
 */

package treballipc;

import java.net.URL;
import java.util.ResourceBundle;
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

    }

    @FXML
    void registerAttempt(ActionEvent event) throws Exception {
        boolean registerOK = true;
        if(usernameField.getText().equals("")) {
            registerOK = false;
            registerError.setText("Es necessita un nom d'usuari");
        }
        else if(emailField.getText().equals("")) {
            registerOK = false;
            registerError.setText("Es necessita un correu electronic");
        }
        else if(emailField.getText().indexOf('@') > 0 && emailField.getText().indexOf('.') > emailField.getText().indexOf('@')) {
            registerError.setText("Es necessita un correu electronic valid");
            registerOK = false;
        }
        else if(PasswordField.getText().equals("")) {
            registerError.setText("Es necessita una contrasenya");
            registerOK = false;
        }
        else if(!PasswordField.getText().equals(ConfirmPasswordField.getText())) {
            registerOK = false;
            registerError.setText("Les contrasenyes no coincideixen");
        }
        
        else try {
            DateOBField.getValue();
        }
        catch(Exception e) {
            registerOK = false;
            registerError.setText("S'ha d'incloure una data vàlida");
        }
        
        if(registerOK) {
            registerError.setText("");
            Parent root = FXMLLoader.load(getClass().getResource("FXMLConfirmationPane.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

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

    }
}
