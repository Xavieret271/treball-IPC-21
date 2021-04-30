/**
 * Sample Skeleton for 'FXMLConfirmationCode.fxml' Controller Class
 */

package treballipc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static treballipc.FXMLDocumentController.loggedIn;

public class FXMLConfirmationCodeController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="confirmationCode"
    private Label confirmationCode; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert confirmationCode != null : "fx:id=\"confirmationCode\" was not injected: check your FXML file 'FXMLConfirmationCode.fxml'.";
        
        confirmationCode.setText(Integer.toString(FXMLIniciSessioController.confirCode.getValue()));
            FXMLIniciSessioController.confirCode.addListener(new ChangeListener(){
                public void changed(ObservableValue o,Object oldVal, 
                 Object newVal){
            ((Stage) confirmationCode.getScene().getWindow()).close();
        }
      });

    }
}
