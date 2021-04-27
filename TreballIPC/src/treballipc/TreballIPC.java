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
    
    static Player j1;
    static Player j2;
    
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
    


}
