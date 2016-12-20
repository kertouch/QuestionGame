/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author karimNasri
 */
public class GameExceptions extends Exception {
    
    public GameExceptions(){
      
    
    }
       
public void alert(String msg){
Alert alert = new Alert(Alert.AlertType.WARNING,msg + "!", ButtonType.OK);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    //do stuff
}
}
}
