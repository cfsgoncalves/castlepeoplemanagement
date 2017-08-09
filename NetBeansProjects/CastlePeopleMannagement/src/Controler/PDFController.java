/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.PDFCreator;
import Viewer.MainMenuUI;

/**
 *
 * @author claudio
 */
public class PDFController {
    PDFCreator pdfCreator;
    MainMenuUI main;
    
    public PDFController(PDFCreator pdf,MainMenuUI main){
        this.pdfCreator = pdf;
        this.main = main;
    }

    public PDFCreator getPdfCreator() {
        return pdfCreator;
    }

    public void setPdfCreator(PDFCreator pdfCreator) {
        this.pdfCreator = pdfCreator;
    }

    public MainMenuUI getMain() {
        return main;
    }

    public void setMain(MainMenuUI main) {
        this.main = main;
    }
    
}
