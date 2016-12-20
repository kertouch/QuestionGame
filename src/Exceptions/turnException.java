/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *

import javafxapplication1.GameExceptions;
 * @author karimNasri
 */
public class turnException extends GameExceptions{

    public turnException() {
        alert("C'est pas votre tour");
    }
    
}
