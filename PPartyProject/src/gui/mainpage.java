/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Objects.*;
/*
Author:  Brian Ha - 190376250
         
Repository:
         https://github.com/PPartyImplementation

 -------------------------------------
 File:    mainpage.java
 Description: Main home page layout, panels, tables and functions
 Version  4/5/2022
 -------------------------------------
 */
public class mainpage extends javax.swing.JFrame {

    /**
     * Creates new form mainpage
     */
    public mainpage(Objects.Database db) {
    	database=db;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_from_homepage = new javax.swing.JButton();
        login_from_homepage = new javax.swing.JButton();
        edit_profile_btn = new javax.swing.JButton();
        create_event_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        event_preview_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        delete_event_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        register_from_homepage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        register_from_homepage.setText("Register");

        login_from_homepage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        login_from_homepage.setText("Login");

        edit_profile_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        edit_profile_btn.setText("Edit Profile");

        create_event_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        create_event_btn.setText("Create New Event");
        create_event_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_event_btnActionPerformed(evt);
            }
        });
        
        event_preview_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            	{"party time", "Fortnite", "Anytime", 2},
                {"help", "Call of Duty: Warzone", "7:30pm", 3},
                {"MyPark", "NBA 2K22", "7:00pm", 1},
                {"Heist letsgooo", "Grand Theft Auto V", "8:00pm", 3},
                {":))))", "Minecraft", "9:00pm", 7},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
         
            },
            new String [] {
                "Event", "Game", "Start Time", "Participants"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }   
        });
        
        try {
			File eventsFile = new File("./events.txt");
			Scanner eventsScan = new Scanner(eventsFile);
			int nextEvent = eventsScan.nextInt();
			eventsScan.nextLine(); // Clear the newline
			while(eventsScan.hasNextLine()) {
				String line = eventsScan.nextLine();
				Scanner lineScan = new Scanner(line).useDelimiter("\\t");
				int eventID = lineScan.nextInt();
				String eventName = lineScan.next();
				String eventDescription = lineScan.next();
				String eventGame = lineScan.next();
				String eventSkill = lineScan.next();
				int eventMax = lineScan.nextInt();
				String eventHost = lineScan.next();
				String eventStart = lineScan.next();
				LocalDateTime startTime = LocalDateTime.parse(eventStart);
				lineScan.close();
				event_preview_table.getModel().setValueAt(eventName, this.eventID, 0);
				event_preview_table.getModel().setValueAt(eventGame, this.eventID, 1);
				event_preview_table.getModel().setValueAt(eventStart, this.eventID, 2);
				event_preview_table.getModel().setValueAt(eventMax, this.eventID, 3);
				}
			eventsScan.close();
		} catch(NoSuchElementException e) {
			System.err.println("Error loading events");
		} catch(FileNotFoundException e) {
			// If the event's file doesn't exist we assume there were no events
		}
        
        event_preview_table.setColumnSelectionAllowed(true);
        event_preview_table.setCellSelectionEnabled(false);
        event_preview_table.setRowSelectionAllowed(true);
        event_preview_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(event_preview_table);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        delete_event_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        delete_event_btn.setText("Delete Event");
        delete_event_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_event_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(delete_event_btn)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addComponent(delete_event_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("Player Party");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(register_from_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(login_from_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_profile_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(create_event_btn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_from_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_from_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_profile_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(create_event_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void create_event_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_event_btnActionPerformed
        javax.swing.JFrame eC= event_creation.start(database, this);
        
        //eC.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//GEN-LAST:event_create_event_btnActionPerformed

    private void delete_event_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_event_btnActionPerformed
    	/* Author: Mark Luong - 170995900
		 * Deleting the event item from the main page after pressing on the Delete Event button.
		 * 
		*/
    	int event_ID = event_preview_table.getSelectedRows()[0];
    	Event e = new Event("", "", "", "", -1, new User(-1, "", "", ""), event_ID, "");
    	Event event = database.fetchEvent(e);
    	
    	if(event == null || database.getCurrUser().getUserID() != event.getHost().getUserID()) {
    		JOptionPane.showMessageDialog(null, "You are not the host.", "Error", JOptionPane.INFORMATION_MESSAGE);
    		return;
    	}
    	database.deleteEvent(event_ID);
        ((DefaultTableModel)event_preview_table.getModel()).removeRow(event_ID);
    }//GEN-LAST:event_delete_event_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static javax.swing.JFrame start(Objects.Database db) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        javax.swing.JFrame current= new mainpage(db);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	current.setVisible(true);
            }
        });
       return current;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create_event_btn;
    private javax.swing.JButton edit_profile_btn;
    public javax.swing.JTable event_preview_table;
    public int eventID = 5;
    public int counter = 0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton delete_event_btn;
    private javax.swing.JButton login_from_homepage;
    private javax.swing.JButton register_from_homepage;
    private Objects.Database database; 
    // End of variables declaration//GEN-END:variables
}