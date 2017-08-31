/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    
    public void createDocument(String date,List<Customer> list) throws IOException{
      boolean swap = true;
      int iterator = 0;
      int pageNumber = 0;
      int counter = -1;
      int max = 35;
      ArrayList<Customer> customerList = (ArrayList<Customer>) list; 
      String [] split = date.split("/");
      String data = split[0] + "-" + split[1] + "-" + split[2];
      if(list.size() < 35){
            max = list.size();
      }
      //Iterating over a list
      while(iterator < list.size() - 1){
        pageNumber = 700;
        counter++;
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, document.getPage(counter));
        beginPage(contentStream,date);
        if((list.size() - iterator) < 35){
            max = list.size() - iterator;
        }
        for(int i=0;i<max;i++){
            addCustomers(contentStream,pageNumber,customerList.get(iterator));
            iterator++;
            pageNumber = pageNumber - 20;
        }
        contentStream.close();
      }
      //Add Contability
      PDPage page = new PDPage();
      document.addPage(page);
      PDPageContentStream contentStream = new PDPageContentStream(document,document.getPage(counter+1));
      addContability(contentStream,date);
      contentStream.close();
      document.save("Pdfs/" + data + ".pdf");
      document.close();
      System.out.println("PDF Created");
    } 
    
    private void beginPage(PDPageContentStream contentStream, String date) throws IOException{
      PDImageXObject pdImage = PDImageXObject.createFromFile("/home/claudio/NetBeansProjects/"
              + "NewFolder/CastleMannagement/NetBeansProjects/CastlePeopleMannagement"
              + "/src/Images/brasao.jpg", document);
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
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(260, 720);
      String excursion = "Excursão";
      contentStream.showText(excursion);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(340, 720);
      String pvl = "É da povoa de Lanhoso?";
      contentStream.showText(pvl);
      //Ending the content stream
      contentStream.endText();
    }
    
    private void addCustomers(PDPageContentStream contentStream,int iterator,Customer a) throws IOException{
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);
            contentStream.newLineAtOffset(25,iterator);
            String age = a.getAge() ;
            contentStream.showText(age);
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(80,iterator);
            String gender = a.getGender();
            contentStream.showText(gender);
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(150,iterator);
            String nacionality = a.getNacionality();
            contentStream.showText(nacionality);
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(260,iterator);
            String excursion = a.isExcursion() + "";
            contentStream.showText(excursion);
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(340,iterator);
            String pvl = a.isPvl() + "";
            contentStream.showText(pvl);
            //Ending the content stream
            contentStream.endText();
    }

    private void addContability(PDPageContentStream contentStream,String date) throws IOException{
        PDImageXObject pdImage = PDImageXObject.createFromFile("/home/claudio/NetBeansProjects/"
              + "NewFolder/CastleMannagement/NetBeansProjects/CastlePeopleMannagement"
              + "/src/Images/brasao.jpg", document);
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
      String age = "Preço de Criança: " + Settings.childPrice;
      contentStream.showText(age);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 700);
      String gender = "Preço de >65 anos: " + Settings.agedPrice;
      contentStream.showText(gender);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 680);
      String nacionality = "Preço de adulto: " + Settings.adultPrice;
      contentStream.showText(nacionality);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 660);
      String excursion = "Preço de estudante : " + Settings.studentPrice;
      contentStream.showText(excursion);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 640);
      String pvl = "Total ganhos : ";
      contentStream.showText(pvl);
      //Ending the content stream
      contentStream.endText();
    
    }
}
