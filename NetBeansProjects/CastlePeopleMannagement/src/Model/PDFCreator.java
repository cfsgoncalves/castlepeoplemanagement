/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
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
      createDirectory();
      int acumulator = 0;
      boolean swap = true;
      int iterator = 0;
      int pageNumber = 0;
      int counter = -1;
      int max = 35;
      int aged = 0;
      int child = 0;
      int adult = 0;
      int student = 0;
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
            if(customerList.get(iterator).getAge().equals("Aged")){
                aged++;
                customerList.get(iterator).setAge("Idoso");
            }else if(customerList.get(iterator).getAge().equals("Student")){
                student++;
                customerList.get(iterator).setAge("Estudante");
            }else if(customerList.get(iterator).getAge().equals("Adult")){
                adult++;
                customerList.get(iterator).setAge("Adulto");
            }else{
                child++;
                customerList.get(iterator).setAge("Criança");
            }
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
      addContability(contentStream,date,child,adult,student,aged);
      contentStream.close();
      //Create multiple files
      File file = new File("Pdfs/" + data + ".pdf");
      if(file.exists()){
          while(file.exists()){
              file = new File("Pdf/" + data + "(" + acumulator + ")" + ".pdf");
              acumulator++;
          }
          document.save("Pdfs" + data + "(" + acumulator + ")" + ".pdf");
      }else{
        document.save("Pdfs/" + data + ".pdf");
      }
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
      contentStream.newLineAtOffset(25, 720);
      String age = "Tipo";
      contentStream.showText(age);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(95, 720);
      String gender = "Género";
      contentStream.showText(gender);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(170, 720);
      String nacionality = "Nacionalidade";
      contentStream.showText(nacionality);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(280, 720);
      String excursion = "Excursão";
      contentStream.showText(excursion);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(360, 720);
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
            contentStream.newLineAtOffset(95,iterator);
            String gender = a.getGender();
            contentStream.showText(gender);
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(170,iterator);
            String nacionality = a.getNacionality();
            contentStream.showText(nacionality);
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(280,iterator);
            String excursion = a.isExcursion() + "";
            if(excursion.equals("true")){
                contentStream.showText("Sim");
            }else{
                contentStream.showText("Não");
            }
            contentStream.endText();
            contentStream.beginText();
            contentStream.newLineAtOffset(360,iterator);
            String pvl = a.isPvl() + "";
            if(pvl.equals("true")){
                contentStream.showText("Sim");
            }else{
                contentStream.showText("Não");
            }
            //Ending the content stream
            contentStream.endText();
    }

    //Needs work tho
    private void addContability(PDPageContentStream contentStream
            ,String date,int child,int adult,int student, int aged)
            throws IOException{
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
      String text = "Contabilidade de clientes da data : " + date;
      //Adding text in the form of string 
      contentStream.showText(text);
      contentStream.endText();
      //Adding the titles
      contentStream.beginText();
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);
      contentStream.newLineAtOffset(25,720);
      String pChild = "Preço de criança: " + Settings.childPrice;
      contentStream.showText(pChild);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 700);
      String pAged = "Preço de >65 anos: " + Settings.agedPrice;
      contentStream.showText(pAged);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 680);
      String pAdult = "Preço de adulto: " + Settings.adultPrice;
      contentStream.showText(pAdult);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 660);
      String pStudent = "Preço de estudante : " + Settings.studentPrice;
      contentStream.showText(pStudent);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25,620);
      String nChild = "Número de crianças: " + child;
      contentStream.showText(nChild);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 600);
      String nAdult = "Número de adultos: " + adult;
      contentStream.showText(nAdult);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 580);
      String nAged = "Número de idosos: " + aged;
      contentStream.showText(nAged);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 560);
      String nStudents = "Número de estudantes : " + student;
      contentStream.showText(nStudents);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 520);
      String totalPeople = "Número total de pessoas : " + ( student + aged + adult + child );
      contentStream.showText(totalPeople);
      contentStream.endText();
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 500);
      String gains = "Total ganhos : " + (student * Settings.studentPrice + 
              child * Settings.childPrice + aged * Settings.agedPrice + adult * Settings.adultPrice);
      contentStream.showText(gains);
      //Ending the content stream
      contentStream.endText();
    
    }

    private void createDirectory(){
        File theDir = new File("Pdfs/");
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;
            try{
                theDir.mkdir();
                result = true;
            }catch(SecurityException se){
            //handle it
            }        
            if(result) {    
                System.out.println("DIR created");  
            }
        }
    }
    
    
}

