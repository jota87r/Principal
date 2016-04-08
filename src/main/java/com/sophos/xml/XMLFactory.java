/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.xml;

import com.sophos.Client;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author carlos ignacio restrepo
 */
public class XMLFactory {
    
    public static void build(String path) throws FileNotFoundException, IOException {
        try (CSVClientReader reader = new CSVClientReader(path)) {
            while (reader.hasNext()) {
                Client client = reader.next();

                switch (client.type()) {
                    case Client.TYPE_A : XMLTypeABuilder.build(client); break;
                    case Client.TYPE_B : XMLTypeBBuilder.build(client); break;
                }
            }
        }
    }
}
