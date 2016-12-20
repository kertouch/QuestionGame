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

import javafxapplication1.GameExceptions;
 * @author karimNasri
 */
public class ReponseException extends GameExceptions{
    public ReponseException(String msg){
        alert(msg);
    }

    @Override
    public void alert(String msg) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION,msg + "!", ButtonType.OK);
            alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
    //do stuff
} //To change body of generated methods, choose Tools | Templates.
    }
    
}
