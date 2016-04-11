/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.log;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author jonatan
 */
public class LoggerConfig {
    static private FileHandler fileTxt;

    static public void setup() throws IOException {

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        
        if (handlers[0] instanceof ConsoleHandler)
            rootLogger.removeHandler(handlers[0]);

        rootLogger.setLevel(Level.INFO);
        fileTxt = new FileHandler("principal.log");
        fileTxt.setFormatter(new SimpleFormatter());
        rootLogger.addHandler(fileTxt);
    }

}
