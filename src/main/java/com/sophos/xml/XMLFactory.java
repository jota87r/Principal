/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.xml;

import com.sophos.Client;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import lombok.extern.java.Log;

/**
 *
 * @author carlos ignacio restrepo
 */
@Log
public class XMLFactory {
    
    public static void build(String path) throws FileNotFoundException, IOException {
        try (CSVClientReader reader = new CSVClientReader(path)) {
            while (reader.hasNext()) {
                Client client = reader.next();

                switch (client.type()) {
                    case Client.TYPE_A : XMLTypeABuilder.build(client); break;
                    case Client.TYPE_B : XMLTypeBBuilder.build(client); break;
                }
                
                log.log(Level.WARNING, "Generado archivo para el cliente con tipo id {0} y numero de documento {1}", new Object[]{client.getCIF_ID(), client.getNUMDOC()});
            }
        }
    }
}
