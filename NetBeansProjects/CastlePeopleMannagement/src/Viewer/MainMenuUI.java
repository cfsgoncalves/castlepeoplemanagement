/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Controler.CustomerControler;
import Controler.UserControler;
import Model.Customer;
import Model.DesSerialization;
import Model.PDFCreator;
import Model.Serialization;
import Model.Settings;
import Model.User;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author filipe
 */
public class MainMenuUI extends javax.swing.JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private UserControler userControler;
    private final CustomerControler costumerControler;
    private DefaultTableModel model;
    private final DefaultTableModel tablemodel;
    private final DefaultListModel definitionChangeListModel;
    private final User user;
    /**ial;
     * Creates new form MenuPrincipalUI
     */
    public MainMenuUI(User user) throws ClassNotFoundException{
        initComponents();
        this.user = user;
        this.userControler = new UserControler();
        //Close options and save
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(new JFrame(), 
                    "Tem a certeza que pretende encerrar o programa?", "Really Closing?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    Serialization a = new Serialization();
                    //Customer Searilization
                    a.doSerialization("./costumer.ser",costumerControler.getCustomerList());
                    //User Serialization
                    a.doSerialization("./user.ser", userControler.getUserList());
                    //Settings Serialization
                    Float aux[] = {Settings.childPrice , Settings.studentPrice, Settings.adultPrice,
            Settings.agedPrice};
                    a.doSerialization("./settings.ser",aux);
                    //Settings Log Serialization
                    ArrayList<String> logList = new ArrayList<String>();
                    for(int i=0;i<jList1.getModel().getSize();i++){
                        logList.add(jList1.getModel().getElementAt(i));
                    }
                    a.doSerialization("./settingsLog.ser", logList);
                    System.exit(0);
                }
            }
        });
        this.costumerControler = new CustomerControler(this.jPanel3);
        this.jTable2.setModel(new DefaultTableModel());
        this.jList1.setModel(new DefaultListModel());
        definitionChangeListModel = (DefaultListModel) this.jList1.getModel();
        tablemodel = (DefaultTableModel) this.jTable2.getModel();
        model = (DefaultTableModel) this.jTable1.getModel();
        model.addColumn("Gender");
        model.addColumn("Age");
        model.addColumn("Excursion");
        model.addColumn("Nacionality");
        model.addColumn("Povoa de Lanhoso");
        tablemodel.addColumn("Username");
        DesSerialization des = new DesSerialization();
        //Customer desSerialization
        if(new File("./costumer.ser").exists()){
            customerDesSerialization(des);
            System.out.println("DesSerializing customers\n");
        }
        //User desSerialization
        if(new File("./user.ser").exists()){
            userDesSerialization(des);
            System.out.println("DesSerializing users\n");
        }    
        
        if(new File("./settings.ser").exists()){
            settingsDesSerialization(des);
            System.out.println("DesSerializing settings");
        }
        
        if(new File("./settingsLog.ser").exists()){
            settingsLogDesSerialization(des);
            System.out.println("DesSerializing settingsLog");
        }
        this.jTextField1.setText(Settings.adultPrice + "");
        this.jTextField5.setText(Settings.studentPrice + "");
        this.jTextField3.setText(Settings.adultPrice + "");
        this.jTextField2.setText(Settings.agedPrice + "");
        
           // JOptionPane.showMessageDialog(new JFrame(),"Error: Can't load data from serialization", "Dialog", JOptionPane.ERROR_MESSAGE);
            //System.out.println(e);
        
    }
    
    
    private void customerDesSerialization(DesSerialization des) throws ClassNotFoundException{
        des.doDesSerialization("./costumer.ser");
        ArrayList<Customer> l = (ArrayList<Customer>) des.getObject();
        this.costumerControler.setCustomerList(l);
        for(Customer customer : costumerControler.getCustomerList()){
            String string[] = {customer.getGender(), customer.getAge(),
                customer.isExcursion() + "",customer.getNacionality(),customer.isPvl() + ""};
            model.addRow(string);
        }
    }
    
    private void userDesSerialization(DesSerialization des) throws ClassNotFoundException{
        des.doDesSerialization("./user.ser");
        ArrayList<User> u = (ArrayList<User>) des.getObject();
        userControler.setUserList(u);
        for(User user : u){
            String username[] = {user.getUserName()};
            this.tablemodel.addRow(username);
        }
    }
    
    private void settingsDesSerialization(DesSerialization des) throws ClassNotFoundException{
        des.doDesSerialization("./settings.ser");
        Float aux[] = (Float[]) des.getObject();
        Settings.childPrice = aux[0];
        Settings.studentPrice = aux[1];
        Settings.adultPrice = aux[2];
        Settings.agedPrice = aux[3];
    }
    
    private void settingsLogDesSerialization(DesSerialization des) throws ClassNotFoundException{
        des.doDesSerialization("./settingsLog.ser");
        ArrayList<String> aux  = (ArrayList<String>) des.getObject();
        for(String s : aux){
            this.definitionChangeListModel.addElement(s);
        }
    }
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel24 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton10 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(233, 207, 180));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Utilizadores");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Definições");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setText("Relatório");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pvl.png"))); // NOI18N
        jPanel2.add(jLabel2, "card2");

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Adicionar Clientes");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel5.setText("Género");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jCheckBox3.setText("Masculino");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jCheckBox4.setText("Feminino");
        jPanel3.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 130, -1, -1));

        jLabel3.setText("Idade");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jCheckBox1.setText("Criança");
        jPanel3.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jCheckBox2.setText("Estudante");
        jPanel3.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jCheckBox5.setText("Adulto");
        jPanel3.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, -1));

        jLabel6.setText("Excorsão");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jCheckBox6.setText("Sim");
        jPanel3.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jButton5.setText("Adicionar Cliente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 373, -1, 40));

        jLabel7.setText("Lista Clientes Registados - Diarios");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 12, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 35, 438, 378));

        jButton6.setText("Apagar Ultimo Cliente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 419, -1, 43));

        jButton7.setText("Apagar Cliente");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 419, 162, 43));

        jCheckBox7.setText(">65 anos");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel22.setText("Nacionalidade");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alemanha", "Inglaterra", "Espanha", "França", "Outro" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 190, -1));

        jLabel23.setText("Povoa de Lanhoso");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        jCheckBox8.setText("Sim");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jTabbedPane1.addTab("Adicionar Cliente", jPanel3);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 667, 513));

        jPanel2.add(jPanel4, "card3");

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Definições de Administrador");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel9.setText("Preços por pessoa");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel10.setText("Estudantes");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        jPanel6.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 58, -1));

        jLabel11.setText("Euros");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        jLabel12.setText("Adultos");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel13.setText("Crianças");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));
        jPanel6.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 58, -1));
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 58, -1));

        jLabel14.setText("Euros");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        jLabel15.setText("Euros");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        jButton9.setText("Confirmar Alterações");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 418, 201, 62));

        jLabel16.setText("Ultimas alterações nos preços");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 39, -1, -1));

        jScrollPane2.setViewportView(jList1);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 68, 381, 412));

        jLabel24.setText(">65 Anos");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 58, -1));

        jLabel25.setText("Euros");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jPanel2.add(jPanel6, "card4");

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("Utilizadores");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel18.setText("Adicionar Utilizador");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 301, -1, -1));

        jLabel19.setText("Username");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 336, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 365, 200, -1));

        jLabel20.setText("Password");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 404, -1, -1));
        jPanel7.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 433, 200, -1));

        jButton10.setText("Adicionar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 472, -1, -1));

        jLabel21.setText("Lista de Utilizadores");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jButton11.setText("Remover");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 90, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(

        ));
        jScrollPane4.setViewportView(jTable2);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 60, 290, -1));

        jPanel2.add(jPanel7, "card5");

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         for(int i=0;i<this.jPanel2.getComponentCount();i++){
                this.jPanel2.getComponent(i).setVisible(false);
            }
        this.jPanel4.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    int i = 0;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        for(int i=0;i<this.jPanel2.getComponentCount();i++){
                this.jPanel2.getComponent(i).setVisible(false);
            }
        this.jPanel6.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         for(int i=0;i<this.jPanel2.getComponentCount();i++){
                this.jPanel2.getComponent(i).setVisible(false);
            }
        this.jPanel7.setVisible(true);   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String password = "";
        for(int i=0;i<jPasswordField1.getPassword().length;i++){
            password = password + jPasswordField1.getPassword()[i];
        }
        if(this.jTextField4.getText().equals("") || password.equals("")){
            JOptionPane.showMessageDialog(new JFrame(),"Please fill the empty fields!", "Dialog",
        JOptionPane.ERROR_MESSAGE);
        }else{
            User user = new User(this.jTextField4.getText(),password);
            JOptionPane.showMessageDialog(new JFrame(),"User added with sucess!", "Dialog",
        JOptionPane.INFORMATION_MESSAGE);
            this.userControler.addUser(user);
            String userName[] = {user.getUserName()};
            this.tablemodel.addRow(userName);
            this.jTextField4.setText("");
            this.jPasswordField1.setText("");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(jTable2.getSelectedRow() != -1){
            tablemodel.removeRow(this.jTable2.getSelectedRow());
            System.out.println(tablemodel.getValueAt(1, 0));
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Error: Please select an user to remove", "Dialog",
            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try{
            if(Settings.studentPrice != Float.parseFloat(this.jTextField1.getText()) ||
                Settings.childPrice != Float.parseFloat(this.jTextField5.getText()) ||
                    Settings.childPrice != Float.parseFloat(this.jTextField5.getText()) ||
                    Settings.agedPrice != Float.parseFloat(this.jTextField2.getText())){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                String split[] = now.toString().split("T");
                Settings.studentPrice = Float.parseFloat(this.jTextField1.getText());
                Settings.childPrice = Float.parseFloat(this.jTextField5.getText());
                Settings.adultPrice = Float.parseFloat(this.jTextField3.getText());
                Settings.agedPrice = Float.parseFloat(this.jTextField2.getText());
                this.definitionChangeListModel.addElement("Username: " + user.getUserName() 
                + " " + "Data: " + split[0] + " Hora: " + split[1]);
                JOptionPane.showMessageDialog(new JFrame(),"Settings changed with success!", "Dialog",
                JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"Error: If you want to change settings change"
                    + " at least one of the values", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(),"Error: Insert only numeric values ", "Dialog",
            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende gerar o relatório diário?", 
                "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            int secondWarning = JOptionPane.showConfirmDialog(null, "Esta ação irá transferir todos os clientes do sistema para um documento pdf. Deseja continuar?", 
                "", JOptionPane.YES_NO_OPTION);
            if(secondWarning == JOptionPane.YES_OPTION){
                PDFCreator a = new PDFCreator();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                try {
                    a.createDocument(dtf.format(now),this.costumerControler.getCustomerList());
                    List<Customer> list = new ArrayList<Customer>();
                    this.costumerControler.setCustomerList(list);
                    this.jTable1.setModel(new DefaultTableModel());
                    this.model = (DefaultTableModel) this.jTable1.getModel();
                    model = (DefaultTableModel) this.jTable1.getModel();
                    model.addColumn("Gender");
                    model.addColumn("Age");
                    model.addColumn("Excursion");
                    model.addColumn("Nacionality");
                    model.addColumn("Povoa de Lanhoso");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(new JFrame(),"Error: Report couldn't be generated!", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(this.jTable1.getSelectedRow() != -1){
            model.removeRow(jTable1.getSelectedRow());
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Error: Please select a customer to be deleted!", "Dialog",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int lastElementIndex = this.jTable1.getModel().getRowCount() - 1;
        model.removeRow(lastElementIndex);
        costumerControler.getCustomerList().remove(lastElementIndex);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        boolean genderException = false;
        boolean ageException = false;
        float price = 0;
        String gender = "";
        String age = "";
        boolean pvl = false;
        String nacionality = this.jComboBox1.getSelectedItem().toString();
        boolean excursion = false;
        if(this.jCheckBox3.isSelected() && this.jCheckBox4.isSelected()){
            JOptionPane.showMessageDialog(new JFrame(),"Error: Can't select the two genders", "Dialog",
                JOptionPane.ERROR_MESSAGE);
            genderException = true;
        }else if(this.jCheckBox3.isSelected()){
            gender = "Masculino";
        }else if(this.jCheckBox4.isSelected()){
            gender = "Feminino";
        }

        if(this.jCheckBox1.isSelected()){
            age = "Child";
            price = Settings.childPrice;
        }else if(this.jCheckBox2.isSelected()){
            age = "Student";
            price = Settings.studentPrice;
        }else if(this.jCheckBox5.isSelected()){
            age = "Adult";
            price = Settings.adultPrice;
        }else if(this.jCheckBox7.isSelected()){
            age = "Aged";
            price = Settings.agedPrice;
        }
        if((this.jCheckBox1.isSelected() && this.jCheckBox2.isSelected()) ||
            (this.jCheckBox1.isSelected() && this.jCheckBox5.isSelected()) ||
            (this.jCheckBox1.isSelected() && this.jCheckBox7.isSelected()) ||
            (this.jCheckBox2.isSelected() && this.jCheckBox5.isSelected()) ||
            (this.jCheckBox2.isSelected() && this.jCheckBox7.isSelected()) ||
            (this.jCheckBox5.isSelected() && this.jCheckBox7.isSelected())){
            JOptionPane.showMessageDialog(new JFrame(),"Error: Can't select only one age type", "Dialog",
                JOptionPane.ERROR_MESSAGE);
            ageException = true;
        }
        if(this.jCheckBox6.isSelected()){
            excursion =  true;
        }
        if(this.jCheckBox8.isSelected()){
            pvl =  true;
        }
        if(!genderException && !ageException && !age.equals("") && !gender.equals("")){
            Customer customer = new Customer(age,gender,excursion,nacionality,pvl);
            String string[] = {customer.getGender(), customer.getAge(),
                customer.isExcursion() + "",customer.getNacionality(),customer.isPvl() + ""};
            model.addRow(string);
            this.costumerControler.addCustomer(customer);
            JOptionPane.showMessageDialog(new JFrame(),"O cliente deve pagar " + price + " euros.", "Dialog",
                JOptionPane.INFORMATION_MESSAGE);
            i++;
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Error: Please insert valid options to add a customer", "Dialog",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed

    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
