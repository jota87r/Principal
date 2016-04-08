/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.xml;

import com.csvreader.CsvReader;
import com.sophos.Client;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author jonatan
 */
class CSVClientReader implements AutoCloseable {
    
    private CsvReader reader;
    private boolean canRead;
    
    CSVClientReader(String path) throws FileNotFoundException, IOException {
        reader = new CsvReader(path);
        reader.readHeaders();
    }
    
    boolean hasNext() throws IOException {
        return canRead = reader.readRecord();
    }
    
    Client next() throws IOException {
        if (!canRead) throw new RuntimeException("No hay mas clientes por leer");
        return new Client(reader.get(0), reader.get(1), reader.get(2), reader.get(3));
    }
    
    @Override public void close() {
        reader.close();
    }
}
