package com.sophos;

import com.sophos.log.LoggerConfig;
import javax.swing.SwingUtilities;
import java.io.IOException;

public class Principal {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        LoggerConfig.setup();
        SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
        		new Window();
    		}
		});
    }
}
