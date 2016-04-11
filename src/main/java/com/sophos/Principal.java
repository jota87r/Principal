package com.sophos;

import com.sophos.log.LoggerConfig;
import java.awt.EventQueue;
import java.io.IOException;

public class Principal {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        LoggerConfig.setup();
        EventQueue.invokeLater(() -> { new Window(); });
    }
}
