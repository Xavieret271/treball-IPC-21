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


    @FXML // fx:id="confirmationCode"
    private Label confirmationCode; // Value injected by FXMLLoader
@FXML
    void initialize() {
        assert confirmationCode != null : "fx:id=\"confirmationCode\" was not injected: check your FXML file 'FXMLConfirmationCode.fxml'.";
        
        confirmationCode.setText(Integer.toString(FXMLIniciSessioController.confirCode.getValue()));
            FXMLIniciSessioController.confirCode.addListener(new ChangeListener(){
                public void changed(ObservableValue o,Object oldVal, 
                 Object newVal){
            ((Stage) confirmationCode.getScene().getWindow()).close();
        }
                
               
      });
            inicialitzarEstil();
    }
    
    void inicialitzarEstil() {
        
                if(FXMLDocumentController.dark.getValue()) {
                    String e = "treballipc/dark.css";
                    confirmationCode.getStylesheets().clear();
                    confirmationCode.getStylesheets().add(e);
                }
                else {
                    String e = "treballipc/clear.css";
                    confirmationCode.getStylesheets().clear();
                    confirmationCode.getStylesheets().add(e);
                }
            FXMLDocumentController.dark.addListener( //EXEMPLE DE LISTENER!!!!
            (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                if(FXMLDocumentController.dark.getValue()) {
                    String e = "treballipc/dark.css";
                    confirmationCode.getStylesheets().clear();
                    confirmationCode.getStylesheets().add(e);
                }
                else {
                    String e = "treballipc/clear.css";
                    confirmationCode.getStylesheets().clear();
                    confirmationCode.getStylesheets().add(e);
                }
            });
    }
    
}
