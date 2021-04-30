/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballipc;

import model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.image.ImageView;


/**
 *
 * @author Xavi
 */
public class TreballIPC extends Application{ 
    
    
    public static SimpleBooleanProperty confirming = new SimpleBooleanProperty(false);
    public static int confirmationCode = 0;
    
    public static Connect4 game;
    public static SimpleBooleanProperty turn = new SimpleBooleanProperty(true);
    
    static int activePlayer = 1; // 0 per a j1 i 1 per a j2
    
    static Player j1 = null;
    static Player j2 = null;
    static Player retrievingJ = null;
    static boolean multiplayer = false;
    
    static int[][] state = new int[8][7];//////////////////////////////////////////////
    
    public static SimpleBooleanProperty playing = new SimpleBooleanProperty(false);
    
    @Override
    public void start(Stage stage) throws Exception {
        
        game = Connect4.getSingletonConnect4();
        game.removeAllData();
        game.createDemoData(6,10,10);
        
        File file = new File("FXMLDocument.fxml");
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        launch(args);
    }
    
   /*
    Metode que donat un estat del joc (state) i una columna a la que col-locar la fitxa
    el numero de la fila on cau la fitxa començant per baix; si no cap la fitxa torna un -1
        0|
        1|
        2|
        3|
        4|
        5|
        6|
    */
    
    public static int clavarFitxa(int c) {
        return buscarFila(c);
        
    }
    public static int buscarFila(int c) {
        int i = 6;
        int v;
        
         while(i >0) {
             v = state[c][i];
             if(v != 0 && state[c][i-1] == 0) { return i-1; }
             if(i == 6 && v == 0) { return i; }
             i--;
         }
         
         
         return -1;
         
    }
            
    
    /*
    
    Torna la longitud de la cadena més llarga en fila.
    Es considerarà victòria si la cadena supera o iguala els 4 de longitud
    */
    public static List<ImageView> esFinalDeJoc(int c, int f) {
        if(c < 0 || f < 0) {
            return null; //algo ha anat terriblement mal, crideu-me
        }
        List<ImageView> res = buscarHorz(c,f);
        List<ImageView> res2 = buscarVert(c,f);
        if(res.size() > res2.size()) {}
        else { res = res2; }
        res2 = buscarDiag1(c,f);
        if(res.size() > res2.size()) {}
        else { res = res2; }
        res2 = buscarDiag2(c,f);
        if(res.size() > res2.size()) {}
        else { res = res2; }
        return res;
    }
    
   public static List<ImageView> buscarHorz(int c,int f) {
       int i = 1;
       List<ImageView> res = new LinkedList<ImageView>();
       res.add(FXMLDocumentController.pane[c][f]);
       while(c+i < 7 && state[c][f] == state[c+i][f]) {
           res.add(FXMLDocumentController.pane[c+i][f]);
           i++;
       }
       i = -1;
       
       while(c+i>= 0 && state[c][f] == state[c+i][f]) {
           res.add(FXMLDocumentController.pane[c+i][f]);
           i--;
       }
       
       return res;
   }
   public static List<ImageView> buscarVert(int c,int f) {
       int i = 1;
       List<ImageView> res = new LinkedList<ImageView>();
       res.add(FXMLDocumentController.pane[c][f]);
       while(f+i < 7 && state[c][f] == state[c][f+i]) {
           res.add(FXMLDocumentController.pane[c][f+i]);
           i++;
       }
       i = -1;
       
       while(f+i >= 0 && state[c][f] == state[c][f+i]) {
           res.add(FXMLDocumentController.pane[c][f+i]);
           i--;
       }
       
       return res;
   }
   public static List<ImageView> buscarDiag1(int c,int f) {
       int i = 1;
       List<ImageView> res = new LinkedList<ImageView>();
       res.add(FXMLDocumentController.pane[c][f]);
       while((c+i < 8 && f+i < 7) && state[c][f] == state[c+i][f+i]) {
           res.add(FXMLDocumentController.pane[c+i][f+i]);
           i++;
       }
       i = -1;
       
       while(c+i >= 0 && f+i >= 0 && state[c][f] == state[c+i][f+i]) {
           res.add(FXMLDocumentController.pane[c+i][f+i]);
           i--;
       }
       
       return res;
   }
   public static List<ImageView> buscarDiag2(int c,int f) {
       int i = 1;
       List<ImageView> res = new LinkedList<ImageView>();
       res.add(FXMLDocumentController.pane[c][f]);
       while((c+i < 8 && f-i >= 0) && state[c][f] == state[c+i][f-i]) {
           res.add(FXMLDocumentController.pane[c+i][f-i]);
           i++;
       }
       i = -1;
       
       while((c+i >= 0 && f-i < 7)&& state[c][f] == state[c+i][f-i]) {
           res.add(FXMLDocumentController.pane[c+i][f-i]);
           i--;
       }
       
       return res;
   }
}
    
    


