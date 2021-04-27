/**
 * Sample Skeleton for 'FXMLDocument.fxml' Controller Class
 */

package treballipc;

import model.*;
import java.net.URL;
import javafx.beans.value.ObservableValue;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;

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
    private HBox panel;
    @FXML
    private VBox vbox1;

    @FXML
    private GridPane grid1;

    @FXML
    private VBox vbox2;

    @FXML
    private GridPane grid2;

    @FXML
    private VBox vbox3;

    @FXML
    private GridPane grid3;

    @FXML
    private VBox vbox4;

    @FXML
    private GridPane grid4;

    @FXML
    private VBox vbox5;

    @FXML
    private GridPane grid5;

    @FXML
    private VBox vbox6;

    @FXML
    private GridPane grid6;

    @FXML
    private VBox vbox7;

    @FXML
    private GridPane grid7;

    @FXML
    private VBox vbox8;

    @FXML
    private GridPane grid8;
    
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
        assert singleplayerButton != null : "fx:id=\"singleplayerButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert multiplayerButton != null : "fx:id=\"multiplayerButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert staticsButton != null : "fx:id=\"staticsButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert highContrast != null : "fx:id=\"highContrast\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox1 != null : "fx:id=\"vbox1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid1 != null : "fx:id=\"grid1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox2 != null : "fx:id=\"vbox2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid2 != null : "fx:id=\"grid2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox3 != null : "fx:id=\"vbox3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid3 != null : "fx:id=\"grid3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox4 != null : "fx:id=\"vbox4\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid4 != null : "fx:id=\"grid4\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox5 != null : "fx:id=\"vbox5\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid5 != null : "fx:id=\"grid5\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox6 != null : "fx:id=\"vbox6\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid6 != null : "fx:id=\"grid6\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox7 != null : "fx:id=\"vbox7\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid7 != null : "fx:id=\"grid7\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert vbox8 != null : "fx:id=\"vbox8\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert grid8 != null : "fx:id=\"grid8\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        
        
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
        
            
        TreballIPC.playing.addListener(new ChangeListener(){
                public void changed(ObservableValue o,Object oldVal, 
                 Object newVal){
                    if(TreballIPC.playing.getValue()) {
                        panel.setDisable(false);
                }
                    else {
                        panel.setDisable(true);
                    }
                }
                });
                }
    ///// funcions del panel de joc no es bonic pero es el que hi ha
    
    
    
    
    @FXML
    void vbox1click(MouseEvent event) {
    }

    @FXML
    void vbox1hover(MouseEvent event) {

    }

    @FXML
    void vbox1nohover(MouseEvent event) {

    }

    @FXML
    void vbox2click(MouseEvent event) {

    }

    @FXML
    void vbox2hover(MouseEvent event) {

    }

    @FXML
    void vbox2nohover(MouseEvent event) {

    }

    @FXML
    void vbox3click(MouseEvent event) {

    }

    @FXML
    void vbox3hover(MouseEvent event) {

    }

    @FXML
    void vbox3nohover(MouseEvent event) {

    }

    @FXML
    void vbox4click(MouseEvent event) {

    }

    @FXML
    void vbox4hover(MouseEvent event) {

    }

    @FXML
    void vbox4nohover(MouseEvent event) {

    }

    @FXML
    void vbox5click(MouseEvent event) {

    }

    @FXML
    void vbox5hover(MouseEvent event) {

    }

    @FXML
    void vbox5nohover(MouseEvent event) {

    }

    @FXML
    void vbox6click(MouseEvent event) {

    }

    @FXML
    void vbox6hover(MouseEvent event) {

    }

    @FXML
    void vbox6nohover(MouseEvent event) {

    }

    @FXML
    void vbox7click(MouseEvent event) {

    }

    @FXML
    void vbox7hover(MouseEvent event) {

    }

    @FXML
    void vbox7nohover(MouseEvent event) {

    }

    @FXML
    void vbox8click(MouseEvent event) {

    }

    @FXML
    void vbox8hover(MouseEvent event) {

    }

    @FXML
    void vbox8nohover(MouseEvent event) {

    }
}
