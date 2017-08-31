/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbage;

import Model.PDFCreator;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author claudio
 */
public class MAin {
    
    public static void main(String [] args) throws IOException{
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDateTime now = LocalDateTime.now();
       System.out.println(dtf.format(now)); //2016/11/16 12:08:43
       PDFCreator a =  new PDFCreator();
      // a.addPage(new PDPage(),dtf.format(now));
    }
}
