/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jonatan
 */
public class Window extends JFrame {
    
    private String path;
    
    public Window() {
        super("Principal");
        setVisible(true);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        
        JButton chooseFile = new JButton("Seleccionar archivo");
        chooseFile.addActionListener(this::selectFile);
        getContentPane().add(chooseFile);
        
        JButton createXML = new JButton("Generar");
        createXML.addActionListener(this::generateXML);
        getContentPane().add(createXML);
    }
    
    public void selectFile(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + File.separatorChar + "My Documents");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Coma separated value", "csv"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getPath();
        }
    }
    
    public void generateXML(ActionEvent e) {
    }
}
