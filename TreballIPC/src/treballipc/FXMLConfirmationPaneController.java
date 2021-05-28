/**
 * Sample Skeleton for 'FXMLConfirmationPane.fxml' Controller Class
 */

package treballipc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static treballipc.FXMLDocumentController.dark;

public class FXMLConfirmationPaneController {


    @FXML // fx:id="confirmationCode"
    private TextField confirmationCode; // Value injected by FXMLLoader

    @FXML // fx:id="errorMessage"
    private Label errorMessage; // Value injected by FXMLLoader

    @FXML // fx:id="confirmButton"
    private Button confirmButton; // Value injected by FXMLLoader
    @FXML
    private Label passAcces;
    @FXML
    private Button cancelButton;

            String fixTxt = "La teua contrasenya d'acces és: ";
            String pass = TreballIPC.retrievingJ.getPassword();
            String hid = ""; 
    @FXML
    private VBox window;
    @FXML
    void confirmAttempt(ActionEvent event) {
        if(FXMLIniciSessioController.confirCode.getValue().equals(Integer.parseInt(confirmationCode.getText()))) {
            
            FXMLIniciSessioController.confirCode.setValue(FXMLIniciSessioController.confirCode.getValue()+1);
            passAcces.setVisible(true);
            for(int i = 0; i < pass.length(); i++) {hid += "█";}
            passAcces.setText(fixTxt + hid);
            cancelButton.setText("Tancar");
            confirmButton.setVisible(false);
        }
        else {
            errorMessage.setText("El codi introduit no es correpon amb el que s'ha enviat");
        }
    }
@FXML
    void initialize() {
        
        assert confirmationCode != null : "fx:id=\"confirmationCode\" was not injected: check your FXML file 'FXMLConfirmationPane.fxml'.";
        assert errorMessage != null : "fx:id=\"errorMessage\" was not injected: check your FXML file 'FXMLConfirmationPane.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'FXMLConfirmationPane.fxml'.";
        
        inicialitzarEstil();
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
    
    

    @FXML
    void passHide(MouseEvent event) {
        passAcces.setText(fixTxt + hid);
    }

    @FXML
    void passShow(MouseEvent event) {

        passAcces.setText(fixTxt + pass);
    }
    @FXML
    void cancel(ActionEvent event) {
        TreballIPC.retrievingJ = null;
        
                    ((Stage) cancelButton.getScene().getWindow()).close();
    }
}
