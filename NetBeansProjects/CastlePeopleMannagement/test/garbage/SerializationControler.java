/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garbage;

import Model.Serialization;
import Viewer.MainMenuUI;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author claudio
 */
public class SerializationControler implements Serializable{
    private Serialization serialization;
    private ArrayList users;
    private ArrayList customers;
    private ArrayList changes;
    private ArrayList settings;
    private MainMenuUI main;
    
    public SerializationControler(Serialization serializable,MainMenuUI main){
        this.serialization = serializable;
        this.main = main;
    }
    
}
