/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author claudio
 */
public class MAin {
    
    public static void main(String [] args){
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDateTime now = LocalDateTime.now();
System.out.println(dtf.format(now)); //2016/11/16 12:08:43
    }
}
