/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFGraphics;
import com.qoppa.pdfWriter.PDFPage;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author claudio
 */
public class PDFCreator {
    PDFDocument pdfDoc;
    
    public PDFCreator(){
        // Create a document and a page in default Locale format
        pdfDoc = new PDFDocument();
    }
    
    public void createPDF(ArrayList<Customer> customer) throws IOException{
            PDFPage newPage = pdfDoc.createPage(new PageFormat());     
            // Draw to the page
            Graphics2D g2d = newPage.createGraphics();
            g2d.setFont (PDFGraphics.HELVETICA.deriveFont(24f));
            g2d.drawString("Castelo da Povoa de Lanhoso - Pessoas", 100, 100);
            g2d.drawString("Sexo", 70, 150);
            g2d.drawString("Nacionalidade",140, 150);
            g2d.drawString("Género", 320, 150);
            g2d.drawString("Excursão", 420, 150);
            for(Customer a : customer){
                g2d.drawString(a.getAge(), 0, 0);
            }
            //g2d.drawString("claudio", 100, 150);
            //g2d.drawString("filipe", 100, 180);
            // Add the page to the document and save it
            pdfDoc.addPage(newPage);
            pdfDoc.saveDocument("Pdfs/output2.pdf");
    }
    
}
