/**
 * Sample Skeleton for 'FXMLIniciSessio.fxml' Controller Class
 */

package treballipc;

import model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.beans.property.*;

public class FXMLIniciSessioController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="window"
    private VBox window; // Value injected by FXMLLoader

    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML // fx:id="passField"
    private PasswordField passField; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader
    
    @FXML // fx:id="errorMessage"
    private Label errorMessage; // Value injected by FXMLLoader
    @FXML
    private TextField emailField;
    @FXML
    private Label advertLabel;

    @FXML
    private Label forgotPassLink;

    @FXML
    void cancelWindow(ActionEvent event) {
            ((Stage) cancelButton.getScene().getWindow()).close();
    }
    static boolean forgot = false;
    static SimpleIntegerProperty confirCode = new SimpleIntegerProperty(0);
    
    @FXML
    void forgotPass(MouseEvent event) {
            if(!forgot) {
                passField.setVisible(false);
                emailField.setVisible(true);
                advertLabel.setVisible(true);
                loginButton.setText("Enviar email");
                forgot = true;
            }
            
            else{
                passField.setVisible(true);
                emailField.setVisible(false);
                
                advertLabel.setVisible(false);
                loginButton.setText("Iniciar Sessio");
                forgot = false;
            }
    }
    
    @FXML
            
    void loginAttm(ActionEvent event) throws Exception{
        if(forgot) {
            if(TreballIPC.game.exitsNickName(usernameField.getText()) && 
                    TreballIPC.game.getPlayer(usernameField.getText()).getEmail().equals(emailField.getText())) {
                confirCode.setValue((int) (Math.random()*999999));
                TreballIPC.retrievingJ = TreballIPC.game.getPlayer(usernameField.getText());
                Parent root = FXMLLoader.load(getClass().getResource("FXMLConfirmationPane.fxml"));
            
                Scene scene = new Scene(root);
        
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            
            
                Parent code = FXMLLoader.load(getClass().getResource("FXMLConfirmationCode.fxml"));
        
                Scene scene2 = new Scene(code);
        
                Stage stage2 = new Stage();
                stage2.setScene(scene2);
                stage2.show();
            
                ((Stage) cancelButton.getScene().getWindow()).close();
            }
        
            else {
                    errorMessage.setText("El correu electronic no correspon amb el nom d'usuari aportat");
            }
        }
        else {
            boolean loginWorked = false;
        if(TreballIPC.game.exitsNickName(usernameField.getText())) {
            if(TreballIPC.game.getPlayer(usernameField.getText()).checkCredentials(usernameField.getText(), passField.getText())) {
                if(!FXMLDocumentController.loggedIn.getValue()) {
                    TreballIPC.j1 = TreballIPC.game.loginPlayer(usernameField.getText(), passField.getText());
                
                    FXMLDocumentController.loggedIn.setValue(true);
                    ((Stage) cancelButton.getScene().getWindow()).close();
                }
                else {
                    TreballIPC.j2 = TreballIPC.game.loginPlayer(usernameField.getText(), passField.getText());
                    TreballIPC.multiplayer = true;
                    TreballIPC.playing.setValue(true);
                    ((Stage) cancelButton.getScene().getWindow()).close();
                }
                errorMessage.setText("");
            }
            else{
                errorMessage.setText("L'usuari i la contrasenya no coincideixen");
            }
        }
        else{
            errorMessage.setText("L'usuari proporcionat no existeix");
        }
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert window != null : "fx:id=\"window\" was not injected: check your FXML file 'FXMLIniciSessio.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'FXMLIniciSessio.fxml'.";
        assert passField != null : "fx:id=\"passField\" was not injected: check your FXML file 'FXMLIniciSessio.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'FXMLIniciSessio.fxml'.";
        assert errorMessage != null : "fx:id=\"errorMessage\" was not injected: check your FXML file 'FXMLIniciSessio.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'FXMLIniciSessio.fxml'.";
            forgot = false;
    }
    @FXML
    void cancelHover(MouseEvent event) {
            cancelButton.setStyle("-fx-background-color: #4f4f4f;-fx-border-color: #e7d3af");

    }
    
    @FXML
    void cancelNoHover(MouseEvent event) {
            cancelButton.setStyle("-fx-background-color: #2f2f2f;-fx-border-color: #e7d3af");

    }
    
    
    @FXML
    void loginHover(MouseEvent event) {
            loginButton.setStyle("-fx-background-color: #4f4f4f;-fx-border-color: #e7d3af");

    }
    
    
    @FXML
    void loginNoHover(MouseEvent event) {
            loginButton.setStyle("-fx-background-color: #2f2f2f;-fx-border-color: #e7d3af");

    }
    @FXML
    void oblitNoHover(MouseEvent event) {
            forgotPassLink.setStyle("-fx-text-fill:BLUE");

    }
    @FXML
    void oblitHover(MouseEvent event) {
            forgotPassLink.setStyle("-fx-text-fill:#8A2BE2");

    }
}
