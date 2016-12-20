/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *
 * @author karimNasri
 */
public class SavePlayer extends GameExceptions {
    public SavePlayer(String nom){
        alert(nom+"veuillez sauvgarder d'abord");
    }
    
}
