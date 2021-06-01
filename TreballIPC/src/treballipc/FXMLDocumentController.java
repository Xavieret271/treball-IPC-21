/**
 * Sample Skeleton for 'FXMLDocument.fxml' Controller Class
 */

package treballipc;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ObservableValue;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
 import javafx.scene.image.Image;
import javafx.scene.control.Label;

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
    private ImageView im00;

    @FXML
    private ImageView im10;

    @FXML
    private ImageView im20;

    @FXML
    private ImageView im30;

    @FXML
    private ImageView im40;

    @FXML
    private ImageView im50;

    @FXML
    private ImageView im60;

     @FXML
    private ImageView im01;

    @FXML
    private ImageView im11;

    @FXML
    private ImageView im21;

    @FXML
    private ImageView im31;

    @FXML
    private ImageView im41;

    @FXML
    private ImageView im61;

    @FXML
    private ImageView im51;

    @FXML
    private ImageView im02;

    @FXML
    private ImageView im12;

    @FXML
    private ImageView im22;

    @FXML
    private ImageView im32;

    @FXML
    private ImageView im42;

    @FXML
    private ImageView im52;

    @FXML
    private ImageView im62;

     @FXML
    private ImageView im03;

    @FXML
    private ImageView im13;

    @FXML
    private ImageView im23;

    @FXML
    private ImageView im33;

    @FXML
    private ImageView im43;

    @FXML
    private ImageView im53;

    @FXML
    private ImageView im63;

    @FXML
    private ImageView im04;

    @FXML
    private ImageView im14;

    @FXML
    private ImageView im24;

    @FXML
    private ImageView im34;

    @FXML
    private ImageView im44;

    @FXML
    private ImageView im54;

    @FXML
    private ImageView im64;

    @FXML
    private ImageView im05;

    @FXML
    private ImageView im15;

    @FXML
    private ImageView im25;

    @FXML
    private ImageView im35;

    @FXML
    private ImageView im45;

    @FXML
    private ImageView im55;

    @FXML
    private ImageView im65;

    @FXML
    private ImageView im06;

    @FXML
    private ImageView im16;

    @FXML
    private ImageView im26;

    @FXML
    private ImageView im36;

    @FXML
    private ImageView im46;

    @FXML
    private ImageView im56;

    @FXML
    private ImageView im66;

    @FXML
    private ImageView im07;

    @FXML
    private ImageView im17;

    @FXML
    private ImageView im27;

    @FXML
    private ImageView im37;

    @FXML
    private ImageView im47;

    @FXML
    private ImageView im57;

    @FXML
    private ImageView im67;
    
    @FXML
    private BorderPane finestra;
    public static ImageView[][] pane = new ImageView[8][7];
    
    
    @FXML
    private Label j1;

    @FXML
    private Label p1;

    @FXML
    private Label j2;

    @FXML
    private Label p2;
    @FXML
    private Label winnerLabel;
    @FXML
    private Button closingButton;
    @FXML
    private BorderPane mainBox;
    @FXML
    void endMe(ActionEvent event) {
                //task.interrupt();
                Thread[] a = new Thread[10];
                Thread[] www = Thread.getAllStackTraces().keySet().toArray(a);
                for(int i = 0; i < www.length; i++) {
                    www[i].interrupt();
                }
                ((Stage) closingButton.getScene().getWindow()).close();
    }
    
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
        TreballIPC.playing.setValue(false);
    }
    
    public static SimpleBooleanProperty dark = new SimpleBooleanProperty(true);
    @FXML
    void setContrast(ActionEvent event) {
        dark.setValue(highContrast.isSelected());
    }
    
    @FXML
    void multiplayerGameStart(ActionEvent event) throws Exception{
        Parent pop = FXMLLoader.load(getClass().getResource("FXMLIniciSessio.fxml"));
        
        Scene pot = new Scene(pop);
        
        Stage pou = new Stage();
        pou.setScene(pot);
        pou.show();

    }
    
    @FXML
    void singlePlayerGameStart(ActionEvent event) {
        TreballIPC.multiplayer = false;
        TreballIPC.playing.setValue(true);
    }

    @FXML
    void statsStart(MouseEvent event) throws Exception{
        
        Parent pop = FXMLLoader.load(getClass().getResource("FXMLstatics.fxml"));
        
        Scene pot = new Scene(pop);
        
        Stage pou = new Stage();
        pou.setScene(pot);
        pou.show();
        
    }
    static    Image circle;
    static    Image cross;
 

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
        
        circle = new Image(getClass().getResourceAsStream("circle.png"));
        cross = new Image(getClass().getResourceAsStream("cross.png"));
                
        paneInit();
                    String d = "treballipc/dark.css";
                    mainBox.getStylesheets().add(d);
        panel.setOpacity(0.5);
        loggedIn.setValue(false);
        TreballIPC.multiplayer = false;
        registerButton.setDisable(false);
        highContrast.setDisable(false);
        panel.setDisable(false);
                j1.setVisible(false);
                j2.setVisible(false);
                p1.setVisible(false);
                p2.setVisible(false);
        
        staticsButton.setDisable(false);

            ai = new Thread(aivsai);
            ai.start();
                
        loggedIn.addListener( //EXEMPLE DE LISTENER!!!!
            (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                if(new_val.equals(true)) {
                    singleplayerButton.setVisible(true);
                    multiplayerButton.setVisible(true);
                    singleplayerButton.setDisable(false);
                    multiplayerButton.setDisable(false);
                    loginButton.setVisible(false);
                    registerButton.setText("Modificar Perfil");
                    modifying = 1;
                    loginButton.setDisable(true);
                    logoutButton.setVisible(true);
                    logoutButton.setDisable(false);
                }
                else {
                    singleplayerButton.setVisible(false);
                    multiplayerButton.setVisible(false);
                    singleplayerButton.setDisable(true);
                    multiplayerButton.setDisable(true);
                    loginButton.setVisible(true);
                    loginButton.setDisable(false);
                    
                    registerButton.setText("Registrar");
                    modifying = 0;
                    logoutButton.setVisible(false);
                    logoutButton.setDisable(true);
                }
        });
        TreballIPC.playing.addListener( //EXEMPLE DE LISTENER!!!!
            (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                
                    paneInit();
                    //task.interrupt();
                if(TreballIPC.playing.getValue()){
                j1.setText(TreballIPC.j1.getNickName());
                
                j1.setVisible(true);
                j2.setVisible(true);
                p1.setVisible(true);
                    panel.setOpacity(1);
                singleplayerButton.setVisible(false);
                modifying = 1;
                p1.setText((new Integer(TreballIPC.j1.getPoints())).toString());
                if(TreballIPC.multiplayer) {
                    j2.setText(TreballIPC.j2.getNickName());
                    p2.setText((new Integer(TreballIPC.j2.getPoints())).toString());
                    panel.setOpacity(1);
                    p2.setVisible(true);
                    multiplayerButton.setVisible(false);
                }
                else {j2.setText("Computer[RANDOM PLAYS]");}
                    logoutButton.setVisible(true);
                    panel.setOpacity(1);
                    multiplayerButton.setVisible(true);
                }
                else {
                
                    j1.setVisible(false);
                    j2.setVisible(false);
                    p1.setVisible(false);
                    p2.setVisible(false);
                    paneInit();
                    panel.setOpacity(0.5);
                    loggedIn.setValue(false);
                    
            ai = new Thread(aivsai);
            ai.start();
                }
            });

        
            
        dark.addListener( //EXEMPLE DE LISTENER!!!!
            (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                if(dark.getValue()) {
                    s = "treballipc/dark.css";
                    mainBox.getStylesheets().clear();
                    mainBox.getStylesheets().add(s);
        circle = new Image(getClass().getResourceAsStream("circle.png"));
        cross = new Image(getClass().getResourceAsStream("cross.png"));
                }
                else {
                    s = "treballipc/clear.css";
                    mainBox.getStylesheets().clear();
                    mainBox.getStylesheets().add(s);
        circle = new Image(getClass().getResourceAsStream("circle_clear.png"));
        cross = new Image(getClass().getResourceAsStream("cross_clear.png"));
                }
                reloadMap();
            });
        
        
    }
    static int modifying = 0;
    static String s = "treballipc/dark.css";
    static Thread ai;
    Runnable aivsai = () -> { while(!TreballIPC.playing.getValue()) {
        runAI();
        try{
        wait();} catch (Exception e) {}
    }};
    ///// funcions del panel de joc no es bonic pero es el que hi ha
    static boolean closed = false;
    
    SimpleBooleanProperty vbox1hover = new SimpleBooleanProperty(false);
    SimpleBooleanProperty vbox2hover = new SimpleBooleanProperty(false);
    SimpleBooleanProperty vbox3hover = new SimpleBooleanProperty(false);
    SimpleBooleanProperty vbox4hover = new SimpleBooleanProperty(false);
    SimpleBooleanProperty vbox5hover = new SimpleBooleanProperty(false);
    SimpleBooleanProperty vbox6hover = new SimpleBooleanProperty(false);
    SimpleBooleanProperty vbox7hover = new SimpleBooleanProperty(false);
    SimpleBooleanProperty vbox8hover = new SimpleBooleanProperty(false);
    
    void setImage(int c, int f) {
        if(f < 0) {return;}
        if(TreballIPC.activePlayer == 1) {
            pane[c][f].setImage(circle);
        }
        else if(TreballIPC.activePlayer == 2){
            pane[c][f].setImage(cross);
        }
    }
    
    void runAI() {
        if(!aiing &&(!TreballIPC.playing.getValue()||!TreballIPC.multiplayer)) {
            
            iters = new SimpleIntegerProperty(0);
            timeing = 10;
            waga = (0);
            wagi = (0);
            aiing = true;
            
            //task = new Thread(task2);
                    
            //task.start();            
            task2();
        }
    }
    static Thread task;
    
    void task2(){ 
            while(iters.getValue() <15) {
                do {
                waga = ((int)(Math.random()*8));
                wagi = TreballIPC.buscarFila(waga);
                } while(wagi < 0);
                pane[waga][wagi].setOpacity(0.20);
                setImage(waga,wagi);
                aiing = true;
                try{
                Thread.sleep((int) timeing);}catch(Exception e){}
                pane[waga][wagi].setOpacity(1);
                
                iters.setValue(iters.getValue()+1);
                timeing*=1.25;
                pane[waga][wagi].setImage(null);
            }
            if(!TreballIPC.playing.getValue() || !TreballIPC.multiplayer) {
            testnset(waga,wagi); }
                aiing = false;
            }
    //no estan declarades dal per que si no no va
    static int waga;
    static int wagi;
    static boolean aiing;
    static double timeing;
    static SimpleIntegerProperty iters;
    
    
    void testnset(int c,int f) {
    
        if(f == -1) {}
        else { 
            setImage(c,f);
            winnerLabel.setVisible(false);
            
            pane[c][f].setOpacity(1);
            TreballIPC.state[c][f] = TreballIPC.activePlayer+1;
            int count = 0;
            int i = 0;
            int j = 0;
            while(i < 8) {
                j=0;
                while(j < 7 && TreballIPC.state[i][j] != 0) {
                    j++;
                    count++;
                }
                i++;
            }
            List<ImageView> win = TreballIPC.esFinalDeJoc(c,f);
             if(win.size() >= 4 || count >= 56) {
                 if(TreballIPC.playing.getValue()) {
                     winnerLabel.setVisible(true);
                     endedGame = true;
                     if(count >= 56) {
                         winnerLabel.setText("Ha estat un empat");
                     }
                     else{
                         try{
                         if(TreballIPC.multiplayer) {
                             String a = "ha estat el guanyador!";
                             if(TreballIPC.activePlayer == 1) {
                                 a = TreballIPC.j1.getNickName() + a;
                                 TreballIPC.game.regiterRound(LocalDateTime.now(), TreballIPC.j1, TreballIPC.j2);
                                 TreballIPC.j1.setPoints(TreballIPC.j1.getPoints()+50);
                             }
                             else {a = TreballIPC.j2.getNickName() + a;
                             try {
                             
                                 TreballIPC.game.regiterRound(LocalDateTime.now(), TreballIPC.j2, TreballIPC.j1); }
                             catch (Exception e) {}
                             
                                 TreballIPC.j2.setPoints(TreballIPC.j2.getPoints()+50);
                             } 
                             
                             winnerLabel.setText(a);
                         }
                         else {
                             String a = "ha estat el guanyador!";
                             if(TreballIPC.activePlayer == 1) {
                                 a = TreballIPC.j1.getNickName() + a;
                                 TreballIPC.j1.setPoints(TreballIPC.j1.getPoints()+5);
                                 
                             }
                             else {
                                 a = TreballIPC.j1.getNickName() + "has perdut :(";
                                 
                             }
                             
                             winnerLabel.setText(a);
                             
                         }
                     }catch(Exception e) {}
                     }
                     p1.setText(((Integer)TreballIPC.j1.getPoints()).toString());
                     p2.setText(((Integer)TreballIPC.j2.getPoints()).toString());
                 }
                 else{
                 for(i = 0; i < 8; i++) {
                     for(j = 0; j < 7; j++ ){
                         pane[i][j].setImage(null);
                         TreballIPC.state[i][j] = 0;
                     }
                 }
                 }
             }
             
             else {}
             TreballIPC.activePlayer = (TreballIPC.activePlayer) % 2 +1;
        }
    }
    boolean endedGame = false;
    
    
    @FXML
    void tryRegame(MouseEvent event) {
        tryRegamee();
    }
    void tryRegamee() {
        if(endedGame) {
            paneInit();
            endedGame=false;
        }}
    
    @FXML
    void vbox1click(MouseEvent event) {
        if(endedGame) {tryRegamee(); return;} else
        if(!aiing){
            int f = TreballIPC.buscarFila(0);
            testnset(0,f);
            if(!TreballIPC.multiplayer) {
            if(f>=0 && !aiing) {runAI();}
            
            }
            
        }
        
    }

    @FXML
    void vbox1hover(MouseEvent event) {
        if(!aiing){
        vbox1hover.setValue(true);
            int f = TreballIPC.buscarFila(0);
            if(f < 0) {return; }
        setImage(0,f);
        pane[0][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox1nohover(MouseEvent event) {
        if(!aiing){
        vbox1hover.setValue(false);
            int f = TreballIPC.buscarFila(0);
            if(f < 0) {return; }
            pane[0][f].setOpacity(1);
        pane[0][f].setImage(null);
        }
    }

    @FXML
    void vbox2click(MouseEvent event) {
        if(endedGame) {tryRegamee();return;}else
        if(!aiing){
        int f = TreballIPC.clavarFitxa(1);
            testnset(1,f);
            if(!TreballIPC.multiplayer&& !aiing && f >=0) {
            runAI();
            }
        }
    }

    @FXML
    void vbox2hover(MouseEvent event) {
        if(!aiing){
        vbox2hover.setValue(true);
            int f = TreballIPC.buscarFila(1);
            if(f < 0) {return; }
        setImage(1,f);
        pane[1][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox2nohover(MouseEvent event) {
        if(!aiing){
        vbox2hover.setValue(false);
            int f = TreballIPC.buscarFila(1);
            if(f < 0) {return; }
            pane[1][f].setOpacity(1);
        pane[1][f].setImage(null);
        }
    }

    @FXML
    void vbox3click(MouseEvent event) {
        if(endedGame) {tryRegamee();return;}else
        if(!aiing){
        int f = TreballIPC.clavarFitxa(2);
            testnset(2,f);
            if(!TreballIPC.multiplayer &&f>=0 && !aiing) {
            runAI();
            }
        }
    }

    @FXML
    void vbox3hover(MouseEvent event) {
        if(!aiing){
        vbox3hover.setValue(true);
            int f = TreballIPC.buscarFila(2);
            if(f < 0) {return; }
        setImage(2,f);
        pane[2][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox3nohover(MouseEvent event) {
        if(!aiing){
        vbox3hover.setValue(false);
            int f = TreballIPC.buscarFila(2);
            if(f < 0) {return; }
            pane[2][f].setOpacity(1);
        pane[2][f].setImage(null);
        }
    }

    @FXML
    void vbox4click(MouseEvent event) {
        if(endedGame) {tryRegamee();return;}else
        if(!aiing){
        int f = TreballIPC.clavarFitxa(3);
            testnset(3,f);
            if(!TreballIPC.multiplayer&&f>=0 && !aiing) {
            runAI();
            }
        }
    }

    @FXML
    void vbox4hover(MouseEvent event) {
        if(!aiing){
        vbox4hover.setValue(true);
            int f = TreballIPC.buscarFila(3);
            if(f < 0) { return; }
        setImage(3,f);
        pane[3][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox4nohover(MouseEvent event) {
        if(!aiing){
        vbox4hover.setValue(false);
            int f = TreballIPC.buscarFila(3);
            if(f < 0) { return; }
            pane[3][f].setOpacity(1);
        pane[3][f].setImage(null);
        }
    }

    @FXML
    void vbox5click(MouseEvent event) {
        if(endedGame) {tryRegamee();return;}else
        if(!aiing){
        int f = TreballIPC.clavarFitxa(4);
            testnset(4,f);
            if(!TreballIPC.multiplayer&&f>=0 && !aiing) {
            runAI();
            }
        }
    }

    @FXML
    void vbox5hover(MouseEvent event) {
        if(!aiing){
        vbox5hover.setValue(true);
            int f = TreballIPC.buscarFila(4);
            if(f < 0) {return; }
        setImage(4,f);
        pane[4][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox5nohover(MouseEvent event) {
        if(!aiing){
        vbox5hover.setValue(false);
            int f = TreballIPC.buscarFila(4);
            if(f < 0) {return; }
            pane[4][f].setOpacity(1);
        pane[4][f].setImage(null);
        }
    }

    @FXML
    void vbox6click(MouseEvent event) {
        if(endedGame) {tryRegamee();return;}else
        if(!aiing){
        int f = TreballIPC.clavarFitxa(5);
            testnset(5,f);
            if(!TreballIPC.multiplayer&&f>=0 && !aiing) {
            runAI();
            }
        }
    }

    @FXML
    void vbox6hover(MouseEvent event) {
        if(!aiing){
        vbox6hover.setValue(true);
            int f = TreballIPC.buscarFila(5);
            if(f < 0) {return; }
        setImage(5,f);
        pane[5][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox6nohover(MouseEvent event) {
        if(!aiing){
        vbox6hover.setValue(false);
            int f = TreballIPC.buscarFila(5);
            if(f < 0) {return; }
            pane[5][f].setOpacity(1);
        pane[5][f].setImage(null);
        }
    }

    @FXML
    void vbox7click(MouseEvent event) {
        if(endedGame) {tryRegamee();return;}else
        if(!aiing){
        int f = TreballIPC.clavarFitxa(6);
            testnset(6,f);
            if(!TreballIPC.multiplayer&&f>=0 && !aiing) {
            runAI();
            }
        }
    }

    @FXML
    void vbox7hover(MouseEvent event) {
        if(!aiing){
        vbox7hover.setValue(true);
            int f = TreballIPC.buscarFila(6);
            if(f < 0) {return; }
        setImage(6,f);
        pane[6][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox7nohover(MouseEvent event) {
        if(!aiing){
        vbox7hover.setValue(false);
            int f = TreballIPC.buscarFila(6);
            if(f < 0) {return; }
            pane[6][f].setOpacity(1);
        pane[6][f].setImage(null);
        }
    }

    @FXML
    void vbox8click(MouseEvent event) {
        if(endedGame) {tryRegamee();return;}else
        if(!aiing){
        int f = TreballIPC.clavarFitxa(7);
            testnset(7,f);
            if(!TreballIPC.multiplayer&&f>=0 && !aiing) {
            runAI();
            }
        }
    }

    @FXML
    void vbox8hover(MouseEvent event) {
        if(!aiing){
        vbox8hover.setValue(true);
            int f = TreballIPC.buscarFila(7);
            if(f < 0) {return; }
        setImage(7,f);
        pane[7][f].setOpacity(0.2);
        }
    }

    @FXML
    void vbox8nohover(MouseEvent event) {
        if(!aiing){
        vbox8hover.setValue(false);
            int f = TreballIPC.buscarFila(7);
            if(f < 0) {return; }
            pane[7][f].setOpacity(1);
        pane[7][f].setImage(null);
        }
    }
    public void paneInit() {
        pane[0][0] = im00;
        pane[0][1] = im10;
        pane[0][2] = im20;
        pane[0][3] = im30;
        pane[0][4] = im40;
        pane[0][5] = im50;
        pane[0][6] = im60;
        
        pane[1][0] = im01;
        pane[1][1] = im11;
        pane[1][2] = im21;
        pane[1][3] = im31;
        pane[1][4] = im41;
        pane[1][5] = im51;
        pane[1][6] = im61;
        
        pane[2][0] = im02;
        pane[2][1] = im12;
        pane[2][2] = im22;
        pane[2][3] = im32;
        pane[2][4] = im42;
        pane[2][5] = im52;
        pane[2][6] = im62;
        
        pane[3][0] = im03;
        pane[3][1] = im13;
        pane[3][2] = im23;
        pane[3][3] = im33;
        pane[3][4] = im43;
        pane[3][5] = im53;
        pane[3][6] = im63;
        
        pane[4][0] = im04;
        pane[4][1] = im14;
        pane[4][2] = im24;
        pane[4][3] = im34;
        pane[4][4] = im44;
        pane[4][5] = im54;
        pane[4][6] = im64;
        
        pane[5][0] = im05;
        pane[5][1] = im15;
        pane[5][2] = im25;
        pane[5][3] = im35;
        pane[5][4] = im45;
        pane[5][5] = im55;
        pane[5][6] = im65;
        
        pane[6][0] = im06;
        pane[6][1] = im16;
        pane[6][2] = im26;
        pane[6][3] = im36;
        pane[6][4] = im46;
        pane[6][5] = im56;
        pane[6][6] = im66;
        
        pane[7][0] = im07;
        pane[7][1] = im17;
        pane[7][2] = im27;
        pane[7][3] = im37;
        pane[7][4] = im47;
        pane[7][5] = im57;
        pane[7][6] = im67;
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 7; j++) {
                pane[i][j].setImage(null);
                pane[i][j].setOpacity(1);
                TreballIPC.state[i][j] = 0;
            }       
        }
        
    }
    

    @FXML
    void exitHover(MouseEvent event) {
            //closingButton.setStyle("-fx-background-color: #3f3f3f;-fx-border-color: #e7d3af");

    }

    @FXML
    void exitNoHover(MouseEvent event) {
           // closingButton.setStyle("-fx-background-color: #2f2f2f;-fx-border-color: #e7d3af");

    }

    @FXML
    void loginHover(MouseEvent event) {
         //   loginButton.setStyle("-fx-background-color: #3f3f3f;-fx-border-color: #e7d3af");

    }

    @FXML
    void loginNoHover(MouseEvent event) {
          //  loginButton.setStyle("-fx-background-color: #2f2f2f;-fx-border-color: #e7d3af");

    }
    @FXML
    void multiPlayerHover(MouseEvent event) {
         //   multiplayerButton.setStyle("-fx-background-color: #3f3f3f;-fx-border-color: #e7d3af");

    }

    @FXML
    void multiPlayerNoHover(MouseEvent event) {
          //  multiplayerButton.setStyle("-fx-background-color: #2f2f2f;-fx-border-color: #e7d3af");

    }
    @FXML
    void singlePlayerHover(MouseEvent event) {
          //  singleplayerButton.setStyle("-fx-background-color: #3f3f3f;-fx-border-color: #e7d3af");

    }

    @FXML
    void singlePlayerNoHover(MouseEvent event) {
           // singleplayerButton.setStyle("-fx-background-color: #2f2f2f;-fx-border-color: #e7d3af");

    }
    
    void reloadMap() {
        for(int i = 0; i < TreballIPC.state.length; i++) {
            for(int j = 0; j < TreballIPC.state[0].length; j++) {
                if(TreballIPC.state[i][j] == 0) {}
                if(TreballIPC.state[i][j] == 3) {pane[i][j].setImage(cross);}
                if(TreballIPC.state[i][j] == 2) {pane[i][j].setImage(circle);}
            }
        }
    }
    
}

