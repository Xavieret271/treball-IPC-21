/**
 * Sample Skeleton for 'FXMLDocument.fxml' Controller Class
 */

package treballipc;

import model.*;
import java.net.URL;
import javafx.beans.value.ObservableValue;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="registerButton"
    private Button registerButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML // fx:id="staticsButton"
    private Button staticsButton; // Value injected by FXMLLoader

    @FXML // fx:id="highContrast"
    private CheckBox highContrast; // Value injected by FXMLLoader
    
    @FXML
    private Button singleplayerButton;

    @FXML
    private Button multiplayerButton;
    @FXML
    private Button logoutButton;

    @FXML
    void loginStart(MouseEvent event) throws Exception{
        
        //// Codi per llançar una nova finestra
        Parent root = FXMLLoader.load(getClass().getResource("FXMLIniciSessio.fxml"));
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        /////
    }

    

    @FXML
    void registerOpen(MouseEvent event) throws Exception{
        
        //// Codi per llançar una nova finestra
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRegistre.fxml"));
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        /////
    }
    
    @FXML
    void logoutJ1(ActionEvent event) {
        loggedIn.setValue(false);
        TreballIPC.j1 = null;
    }
    @FXML
    void setContrast(ActionEvent event) {
    }

    @FXML
    void statsStart(MouseEvent event) {
    }
    

    public static SimpleBooleanProperty loggedIn = new SimpleBooleanProperty(false);

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert staticsButton != null : "fx:id=\"staticsButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert highContrast != null : "fx:id=\"highContrast\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert singleplayerButton != null : "fx:id=\"singleplayerButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert multiplayerButton != null : "fx:id=\"multiplayerButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert logoutButton != null : "fx:id=\"logout\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        
        
        
        loggedIn.addListener( //EXEMPLE DE LISTENER!!!!
            (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                if(new_val.equals(true)) {
                    singleplayerButton.setVisible(true);
                    multiplayerButton.setVisible(true);
                    loginButton.setVisible(false);
                    registerButton.setVisible(false);
                    logoutButton.setVisible(true);
                }
                else {
                    singleplayerButton.setVisible(false);
                    multiplayerButton.setVisible(false);
                    loginButton.setVisible(true);
                    registerButton.setVisible(true);
                    logoutButton.setVisible(false);
                }
        });
            
    }
}
