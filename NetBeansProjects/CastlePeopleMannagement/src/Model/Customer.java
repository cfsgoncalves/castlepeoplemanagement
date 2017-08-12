/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * NOTA : ver atributos no SMemo e fazer bd
 * @author filipe
 */
public class Customer {
    private String age;
    private String gender;
    private boolean excursion;
    private String nacionality;
    private boolean pvl;
    
    public Customer(String age, String gender,boolean excursion,String nacionality,boolean pvl){
        this.age = age;
        this.gender = gender;
        this.excursion = excursion;
        this.nacionality = nacionality;
        this.pvl = pvl;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isExcursion() {
        return excursion;
    }

    public void setExcursion(boolean excursion) {
        this.excursion = excursion;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public boolean isPvl() {
        return pvl;
    }

    public void setPvl(boolean pvl) {
        this.pvl = pvl;
    }
}
