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
import java.io.FileOutputStream;
import java.io.IOException;

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
    
    public void createPDF() throws IOException{
            PDFPage newPage = pdfDoc.createPage(new PageFormat());     
            // Draw to the page
            Graphics2D g2d = newPage.createGraphics();
            g2d.setFont (PDFGraphics.HELVETICA.deriveFont(24f));
            g2d.drawString("Hello World", 100, 100);
            // Add the page to the document and save it
            pdfDoc.addPage(newPage);
            pdfDoc.saveDocument("Pdfs/output.pdf");
    }
    
}
