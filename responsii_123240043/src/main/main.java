/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import view.loginView;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lab Informatika
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            
        }
        SwingUtilities.invokeLater(() -> new loginView().setVisible(true));
    }
    
}
