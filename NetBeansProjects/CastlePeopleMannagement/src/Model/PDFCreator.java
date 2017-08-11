/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author claudio
 */
public class PDFCreator {
    PDDocument document;
    
    public PDFCreator(){
        document = new PDDocument();  
    }
    
    public void addPage(PDPage page,String date) throws IOException{
      PDImageXObject pdImage = PDImageXObject.createFromFile("/home/claudio/NetBeansProjects/"
              + "NewFolder/CastleMannagement/NetBeansProjects/CastlePeopleMannagement"
              + "/src/Images/brasao.jpg", document);
      document.addPage(page);
      PDPageContentStream contentStream = new PDPageContentStream(document, document.getPage(0));
      contentStream.drawImage(pdImage,560,740,50,50);
      //Begin the Content stream 
      contentStream.beginText();
      //Setting the font to the Content stream  
      
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
      //Setting the position for the line 
      contentStream.newLineAtOffset(25, 760);
      String text = "Contagem de clientes da data : " + date;
      //Adding text in the form of string 
      contentStream.showText(text);
      contentStream.endText();
      //Adding the titles
      contentStream.beginText();
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);
      contentStream.newLineAtOffset(25,720);
      String age = "Idade";
      contentStream.showText(age);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(80, 720);
      String gender = "Género";
      contentStream.showText(gender);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(150, 720);
      String nacionality = "Nacionalidade";
      contentStream.showText(nacionality);
      //Ending the content stream
      contentStream.endText();
      //Closing the content stream
      contentStream.close();
      System.out.println("PDF created");
      document.save("Pdfs/my_doc.pdf");
      document.close();
    }   
}
