package com.sophos;

import java.awt.EventQueue;

public class Principal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> { new Window(); });
    }
}
