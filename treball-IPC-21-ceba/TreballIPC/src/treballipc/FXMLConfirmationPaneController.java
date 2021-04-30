/**
 * Sample Skeleton for 'FXMLConfirmationPane.fxml' Controller Class
 */

package treballipc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLConfirmationPaneController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="confirmationCode"
    private TextField confirmationCode; // Value injected by FXMLLoader

    @FXML // fx:id="errorMessage"
    private Label errorMessage; // Value injected by FXMLLoader

    @FXML // fx:id="confirmButton"
    private Button confirmButton; // Value injected by FXMLLoader

    @FXML
    void confirmAttempt(ActionEvent event) {
        if(FXMLIniciSessioController.confirCode.getValue().equals(Integer.parseInt(confirmationCode.getText()))) {
            
            FXMLIniciSessioController.confirCode.setValue(FXMLIniciSessioController.confirCode.getValue()+1);
            ((Stage) errorMessage.getScene().getWindow()).close();
        }
        else {
            errorMessage.setText("El codi introduit no es correpon amb el que s'ha enviat");
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
        assert confirmationCode != null : "fx:id=\"confirmationCode\" was not injected: check your FXML file 'FXMLConfirmationPane.fxml'.";
        assert errorMessage != null : "fx:id=\"errorMessage\" was not injected: check your FXML file 'FXMLConfirmationPane.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'FXMLConfirmationPane.fxml'.";
    }
}
