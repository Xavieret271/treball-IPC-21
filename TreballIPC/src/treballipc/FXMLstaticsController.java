/**
 * Sample Skeleton for 'FXMLstatics.fxml' Controller Class
 */

package treballipc;

import com.sun.javafx.collections.ObservableListWrapper;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.beans.binding.ListBinding;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Connect4;
import model.DayRank;
import model.Player;
import model.Round;
import static treballipc.FXMLDocumentController.dark;

public class FXMLstaticsController {

    
    @FXML
    private ListView<HBox> rankingList;
    
    @FXML
    private MenuButton modePick;

    @FXML // fx:id="partidesTab"
    private Tab partidesTab; // Value injected by FXMLLoader
    @FXML
    private Label labelPartides;
    @FXML
    private VBox vboxgraf;

    @FXML // fx:id="filtrePartides"
    private MenuButton filtrePartides; // Value injected by FXMLLoader

    @FXML
    private StackedAreaChart<String, Integer> chart;

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
    private BarChart<String, Integer> bars;

    @FXML
    private MenuItem onlyLost;
    @FXML
    private MenuItem winnlose;

    @FXML
    private MenuItem opoContar;
    @FXML
    private BorderPane window;

    @FXML
    void fiDate(ActionEvent event) {
        recalcularTaula();
        recalcularGraf();
    }

    @FXML
    void iniciDate(ActionEvent event) {
        recalcularTaula();
        recalcularGraf();

    }

    @FXML
    void seleccionarFiltrePartides(ActionEvent event) {
        recalcularTaula();
        recalcularGraf();

    }

    @FXML
    void usuariConfirmat(ActionEvent event) {
        recalcularTaula();
        recalcularGraf();
        if(filtreUsuari.getText().equals("")) {
            filtrePartides.setDisable(true);
            filtrePartides.setText("Partides Jugades");
            
            modePick.setDisable(true);
        }
        else {
            filtrePartides.setDisable(false);
            
            modePick.setDisable(false);
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
    @FXML
    void contarOpos(ActionEvent event) {
        modeGraf = 1;
        recalcularGraf();
        modePick.setText("Nre Oponents");
    }

    @FXML
    void contarPerdudesIGuanyades(ActionEvent event) {
        modeGraf = 2;
        recalcularGraf();
        modePick.setText("Guanyades i Perdudes");
    }
    
    static int modeShow = 0;
    static int modeGraf = 0;

    @FXML
    void initialize() {
        assert partidesTab != null : "fx:id=\"partidesTab\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert filtrePartides != null : "fx:id=\"filtrePartides\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        
        assert dadesTab != null : "fx:id=\"dadesTab\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert dataInici != null : "fx:id=\"dataInici\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert dataFi != null : "fx:id=\"dataFi\" was not injected: check your FXML file 'FXMLstatics.fxml'.";
        assert filtreUsuari != null : "fx:id=\"filtreUsuari\" was not injected: check your FXML file 'FXMLstatics.fxml'.";

        list.setFixedCellSize(60);
        filtrePartides.setDisable(true);
        modePick.setDisable(true);
        
        
        recalcularTaula();
        recalcularGraf();
        
        inicialitzarEstil();
    }
    
    
    void inicialitzarEstil() {
        dataInici.setPromptText(LocalDate.now().minusYears(1).toString());
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
    
    void recalcularTaula() {
        calcularRanking();
        System.out.println("recalc");
        
            LocalDate starting = LocalDate.now().minusYears(1); //Suposarem que fa 50 anys i un dia aquest programa no es podia correr
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
        List<Round> r = new ArrayList();
        
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
                    if(TreballIPC.game.getPlayer(filtreUsuari.getText()).getPoints() == 0) {break;}
                    r = TreballIPC.game.getRoundsPlayer(TreballIPC.game.getPlayer(filtreUsuari.getText()));
                    break;
                case 1:
                    if(TreballIPC.game.getPlayer(filtreUsuari.getText()).getPoints() == 0) {break;}
                    r = TreballIPC.game.getWinnedRoundsPlayer(TreballIPC.game.getPlayer(filtreUsuari.getText()));
                    break;
                case 2:
                    if(TreballIPC.game.getPlayer(filtreUsuari.getText()).getPoints() == 0) {break;}
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
    //////////////////////////
    static LocalDate starting;
    static LocalDate ending;
    
    void recalcularGraf() {
        recuadrarSpai();
        
        
        TreeMap<LocalDate,Integer> t = TreballIPC.game.getRoundCountsPerDay();
        
            Player o = TreballIPC.game.getPlayer(filtreUsuari.getText());
        List<Round> w = new ArrayList<Round>();        
        List<Round> v = new ArrayList<Round>();
        if(o != null && o.getPoints() != 0) {
                w = TreballIPC.game.getWinnedRoundsPlayer(o);
                v = TreballIPC.game.getLostRoundsPlayer(o);
        }

        
        starting = LocalDate.now().minusYears(1); //Suposarem que fa 1 anys i un dia aquest programa no es podia correr
            if(dataInici.getValue() != null) {
                starting = dataInici.getValue();
            }
            ending = LocalDate.now();
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
        
        if(modeGraf == 1) {
            calcularGrafOpos();
            return;
        }
        chart.setData(new ObservableListWrapper<StackedAreaChart.Series<String,Integer>>(new ArrayList<StackedAreaChart.Series<String, Integer>>()));
            
        chart.getData().add(new StackedAreaChart.Series<>());
        
        List<StackedAreaChart.Data<String, Integer>> a = new ArrayList<>();
        a.add(new StackedAreaChart.Data<String,Integer>("",0));
        List<StackedAreaChart.Data<String, Integer>> b = new ArrayList<>();
        b.add(new StackedAreaChart.Data<String,Integer>("",0));
        
        if(filtreUsuari.getText().equals("")) {
            
        chart.setTitle("Partides Jugades en el Sistema");
        for(;starting.compareTo(ending)<= 0; starting = starting.plusDays(1)) {
            Integer c = t.get(starting);
            if(c == null) { c = 0; }
            a.add(new StackedAreaChart.Data<>(starting.toString(), c));
        }
        }
        else {
            int c = 0;
            int d = 0;
            System.out.println(w.size() + " " + v.size());
            
            LocalDate date2;
            date2 = starting.plusDays(0);
            
            for(;starting.compareTo(ending)<=0 && (c < w.size());starting = starting.plusDays(1)) {
                
                a.add(new StackedAreaChart.Data<String,Integer>(starting.toString(),0));
                while(c < w.size() && (w.get(c).getLocalDate().equals(starting))) {
                        a.set(a.size() - 1,new StackedAreaChart.Data<String,Integer>(a.get(a.size() - 1).getXValue(),a.get(a.size() - 1).getYValue() + 1));
                        c++;
                } 
            }
            for(; date2.compareTo(ending)<= 0 && d<v.size(); date2 = date2.plusDays(1)) { 
                
                b.add(new StackedAreaChart.Data<String,Integer>(date2.toString(),0));
                while(d < v.size() && (v.get(d).getLocalDate().equals(date2))) {
                        
                        b.set(b.size() - 1,new StackedAreaChart.Data<String,Integer>(b.get(b.size() - 1).getXValue(),b.get(b.size() - 1).getYValue() + 1));
                        d++;
                } 
                
            }
            
            chart.setTitle("Partides Guanyades/Perdudes");
            
        }
            
                
            
            chart.getData().get(0).getData().addAll(a);
            chart.getData().get(0).setName("Partides Jugades");
            if(!filtreUsuari.getText().equals("")) {
                StackedAreaChart.Series<String,Integer> s = new StackedAreaChart.Series<String,Integer>(new ObservableListWrapper<StackedAreaChart.Data<String,Integer>>(b));
                chart.getData().add(s);
                        System.out.println("colorins?");
                        s.setName("Perdudes");
                        chart.getData().get(0).setName("Guanyades");
                        
                        
            }
            
        }
    
    
    void calcularGrafOpos() {
        
        StackedAreaChart.Series<String,Integer> s = new StackedAreaChart.Series<>();
        if(TreballIPC.game.getPlayer(filtreUsuari.getText()) == null) {
            bars.getData().clear();
            return;
        }
        TreeMap<LocalDate, DayRank> t = TreballIPC.game.getDayRanksPlayer(TreballIPC.game.getPlayer(filtreUsuari.getText()));
        for(;starting.compareTo(ending) <= 0; starting = starting.plusDays(1)) {
            if(t.get(starting) == null) { 
            s.getData().add(new StackedAreaChart.Data<String,Integer>(starting.toString(),0));
            } 
            else {
            s.getData().add(new StackedAreaChart.Data<String,Integer>(starting.toString(),t.get(starting).getOponents())); }
            
        }
        
        bars.getData().clear();
        bars.getData().add(s);
        bars.getData().get(0).setName("Nre Oponents");
        bars.setTitle("Nre Oponents Diaris");
    }
    
    void recuadrarSpai() {
        vboxgraf.getChildren().clear();
        vboxgraf.getChildren().add(modePick);
        
        if((filtreUsuari.getText().equals("")||modeGraf == 2)) {
            vboxgraf.getChildren().add(chart); 
            modeGraf = 2;
            return;
        }
            
        
        if(modeGraf == 1) {
            vboxgraf.getChildren().add(bars);
            return;
        }
    }
    
    void calcularRanking() {
        List<Player> l = TreballIPC.game.getConnect4Ranking();
        rankingList.getItems().clear();
        if(TreballIPC.game.getPlayer(filtreUsuari.getText()) == null) {
            for(int i = 0; i < l.size(); i++) {
                HBox h = crearPosicioRank(l.get(i), i);
                rankingList.getItems().add(h);
            } 
        }
        else {
            int i = 0;
            while( i < l.size() && 
                    !TreballIPC.game.getPlayer(filtreUsuari.getText()).equals(l.get(i))) {
                i++;
            }
            if(TreballIPC.game.getPlayer(filtreUsuari.getText()).equals(l.get(i))) {
                rankingList.getItems().add(crearPosicioRank(l.get(i), i));
            }
        }
    }
    
    HBox crearPosicioRank(Player p, int i) {
        HBox res = new HBox();
        
        ImageView f = new ImageView(p.getAvatar());
        f.setFitHeight(60);
        f.setFitWidth(60);
        res.getChildren().add(f);
        
        Label l = new Label(((Integer)(i+1)).toString() + "  ");
        l.setFont(new Font("Times New Roman", 60));
        res.getChildren().add(l);
        
        Label n = new Label(p.getNickName());
        n.setFont(new Font("Times New Roman", 30));
        n.setMaxWidth(200);
        n.setMinWidth(30);
        n.translateYProperty().setValue(15);
        res.getChildren().add(n);
        
        Label s = new Label(((Integer)p.getPoints()).toString());
        s.setFont(new Font("Times New Roman", 30));
        s.translateYProperty().setValue(15);
        
        VBox w = new VBox();
        w.setAlignment(Pos.TOP_RIGHT);
        w.setMinWidth(300);
        w.setMaxWidth(3000);
        w.getChildren().add(s);
        res.getChildren().add(w);
        
        
        return res;
    }


        
}

