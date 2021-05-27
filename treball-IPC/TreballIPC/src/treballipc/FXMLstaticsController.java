/**
 * Sample Skeleton for 'FXMLstatics.fxml' Controller Class
 */

package treballipc;

import com.sun.javafx.collections.ObservableListWrapper;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.beans.binding.ListBinding;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Round;

public class FXMLstaticsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="partidesTab"
    private Tab partidesTab; // Value injected by FXMLLoader
    @FXML
    private Label labelPartides;

    @FXML // fx:id="filtrePartides"
    private MenuButton filtrePartides; // Value injected by FXMLLoader


    @FXML // fx:id="dadesTab"
    private Tab dadesTab; // Value injected by FXMLLoader

    @FXML // fx:id="dataInici"
    private DatePicker dataInici; // Value injected by FXMLLoader

    @FXML // fx:id="dataFi"
    private DatePicker dataFi; // Value injected by FXMLLoader

    @FXML // fx:id="filtreUsuari"
    private TextField filtreUsuari; // Value injected by FXMLLoader
    @FXML // fx:id="list"
    private ListView<String> list; // Value injected by FXMLLoader
    @FXML
    private MenuItem allVisible;

    @FXML
    private MenuItem onlyWins;

    @FXML
    private MenuItem onlyLost;

    @FXML
    void fiDate(ActionEvent event) {
        recalcularTaula();
    }

    @FXML
    void iniciDate(ActionEvent event) {
        recalcularTaula();

    }

    @FXML
    void seleccionarFiltrePartides(ActionEvent event) {
        recalcularTaula();

    }

    @FXML
    void usuariConfirmat(ActionEvent event) {
        recalcularTaula();
        if(filtreUsuari.getText().equals("")) {
            filtrePartides.setVisible(false);
            labelPartides.setVisible(false);
        }
        else {
            filtrePartides.setVisible(true);
            labelPartides.setVisible(true);
        }
    }
    
    @FXML
    void showAll(ActionEvent event) {
        modeShow = 0;
        recalcularTaula();
        filtrePartides.setText("Guanyades i Perdudes");
    }

    @FXML
    void showLost(ActionEvent event) {
        modeShow = 2;
        recalcularTaula();
        filtrePartides.setText("Sols Perdudes");
    }

    @FXML
    void showWin(ActionEvent event) {
        modeShow = 1;
        recalcularTaula();
        filtrePartides.setText("Sols Guanyades");
        
    }
    
    static int modeShow = 0;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert partidesTab != null : "fx:id=\"partidesTab\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert filtrePartides != null : "fx:id=\"filtrePartides\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        
        assert dadesTab != null : "fx:id=\"dadesTab\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert dataInici != null : "fx:id=\"dataInici\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert dataFi != null : "fx:id=\"dataFi\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert filtreUsuari != null : "fx:id=\"filtreUsuari\" was not injected: check your FXML file 'FXMLstatics.fxml'.";

        list.setFixedCellSize(60);
        filtrePartides.setVisible(false);
        recalcularTaula();
    }
    
    void recalcularTaula() {
        System.out.println("recalc");
        
            LocalDate starting = LocalDate.now().minusYears(50); //Suposarem que fa 50 anys i un dia aquest programa no es podia correr
            if(dataInici.getValue() != null) {
                starting = dataInici.getValue();
            }
            LocalDate ending = LocalDate.now();
            if(dataFi.getValue() != null) {
                ending = dataFi.getValue();
            }
            System.out.println(starting.toString());
            if(starting.compareTo(ending)> 0) {
                list.setItems(null);
                list.refresh();
                return;
            }
            System.out.println(ending.toString());
            
        TreeMap<LocalDate, List<Round>> t = null;
        List<Round> r = null;
        
        list.setItems(new ObservableListWrapper<>(new ArrayList<String>()) );
        if(filtreUsuari.getText().equals("")) {
            t = TreballIPC.game.getRoundsPerDay();
            System.out.println("gotit");
            for(;starting.compareTo(ending)<= 0; ending = ending.minusDays(1)) {
                List<Round> l = t.get(ending);
                List<String> st = new ArrayList<String>();
            
                if(l != null) {
                    for(int i = 0; i < l.size(); i++) {
                        Round w = l.get(i);
                        String a = "Data: " + w.getTimeStamp().getYear() + "-" +w.getTimeStamp().getMonth().getValue() + "-" + w.getTimeStamp().getDayOfMonth() + "\n" +
                               "Guanyador: " + w.getWinner().getNickName() + "\n" + 
                               "Perdedor: " + w.getLoser().getNickName();
                        st.add(a);
                    }
                    list.getItems().addAll(st);
                }
            }
        }
        
        else {
            if(TreballIPC.game.getPlayer(filtreUsuari.getText()) == null) {return;}
            list.setItems(new ObservableListWrapper<>(new ArrayList<String>()) );
            switch(modeShow) {
                case 0:
                    r = TreballIPC.game.getRoundsPlayer(TreballIPC.game.getPlayer(filtreUsuari.getText()));
                    break;
                case 1:
                    r = TreballIPC.game.getWinnedRoundsPlayer(TreballIPC.game.getPlayer(filtreUsuari.getText()));
                    break;
                case 2:
                    r = TreballIPC.game.getLostRoundsPlayer(TreballIPC.game.getPlayer(filtreUsuari.getText()));
                    break;
                    
            }
            int i = r.size()-1;
            Round p = null;
            if(r.size() != 0) {
                p = r.get(i);
            }
            else {
                p = new Round(LocalDateTime.MAX, null, null);
            }
            while(i >= 0 && (p.getTimeStamp()).compareTo(starting.atStartOfDay()) > 0) {
                p=r.get(i);
                if(p.getTimeStamp().compareTo(ending.plusDays(1).atStartOfDay()) <= 0){
                    String a = "Data: " + p.getTimeStamp().getYear() + "-" +p.getTimeStamp().getMonth().getValue() + "-" + p.getTimeStamp().getDayOfMonth() + "\n" +
                        "Guanyador: " + p.getWinner().getNickName() + "\n" + 
                        "Perdedor: " + p.getLoser().getNickName();
                    list.getItems().add(a);
                }
                i--;
            }
        }
        
        
        System.out.println("refreshing");
        list.refresh();
    }
}
