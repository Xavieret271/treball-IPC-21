/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballipc;

import model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.property.SimpleBooleanProperty;


/**
 *
 * @author Xavi
 */
public class TreballIPC extends Application{ 
    
    
    public static SimpleBooleanProperty confirming = new SimpleBooleanProperty(false);
    public static int confirmationCode = 0;
    
    public static Connect4 game;
    public static SimpleBooleanProperty turn = new SimpleBooleanProperty(true);
    
    static Player j1;
    static Player j2;
    
    static int[][] state = new int[8][7];//////////////////////////////////////////////
    
    public static SimpleBooleanProperty playing = new SimpleBooleanProperty(false);
    
    @Override
    public void start(Stage stage) throws Exception {
        
        game = Connect4.getSingletonConnect4();
        game.removeAllData();
        game.createDemoData(6,10,10);
        
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
    public static int buscarFila(int c) {
        int i = 6;
        int v = 0;
        
         while(v != 0 && i >= 0) {
             v = state[c][i];
             if(v == 0) { return i; }
             i++;
         }
         return i;
         
    }
            
    
    /*
    
    Torna la longitud de la cadena més llarga en fila.
    Es considerarà victòria si la cadena supera o iguala els 4 de longitud
    */
    public static int esFinalDeJoc(int c, int f) {
        if(c < 0 || f < 0) {
            return -99; //algo ha anat terriblement mal, crideu-me
        }
        
        return Math.max(Math.max(buscarVert(c,f),buscarHorz(c,f)),
                Math.max(buscarDiag1(c,f),buscarDiag2(c,f)));
    }
    
   public static int buscarHorz(int c,int f) {
       int i = 0;
       int res = 0;
       while(f < 7 && state[c][f] == state[c][f+i]) {
           res++;
           i++;
       }
       i = 0;
       
       while(f >= 0 && state[c][f] == state[c][f+i]) {
           res++;
           i--;
       }
       
       return res;
   }
   public static int buscarVert(int c,int f) {
       int i = 0;
       int res = 0;
       while(c < 8 && state[c][f] == state[c+i][f]) {
           res++;
           i++;
       }
       i = 0;
       
       while(c >= 0 && state[c][f] == state[c+i][f]) {
           res++;
           i--;
       }
       
       return res;
   }
   public static int buscarDiag1(int c,int f) {
       int i = 0;
       int res = 0;
       while((c+i < 7 && f+i < 8) && state[c][f] == state[c+i][f+i]) {
           res++;
           i++;
       }
       i = 0;
       
       while(c+i >= 0 && f+i >= 0 && state[c][f] == state[c+i][f+i]) {
           res++;
           i--;
       }
       
       return res;
   }
   public static int buscarDiag2(int c,int f) {
       int i = 0;
       int res = 0;
       while((c+i < 7 && f-i >= 0) && state[c][f] == state[c+i][f-1]) {
           res++;
           i++;
       }
       i = 0;
       
       while((c+i >= 0 && f-i < 8)&& state[c][f] == state[c+i][f-1]) {
           res++;
           i--;
       }
       
       return res;
   }
}
    
    


