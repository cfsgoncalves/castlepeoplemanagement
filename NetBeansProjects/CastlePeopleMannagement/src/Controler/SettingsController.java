/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Settings;
import Viewer.MainMenuUI;

/**
 *
 * @author claudio
 */
public class SettingsController {
    private Settings settings;
    private MainMenuUI mainMenu;
    
    public SettingsController(MainMenuUI main){
        this.settings = new Settings();
        this.mainMenu = main;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public MainMenuUI getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenuUI mainMenu) {
        this.mainMenu = mainMenu;
    }
}
