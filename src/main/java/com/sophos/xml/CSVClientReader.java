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
 * Clase que permite leer el archivo CSV proporcionado por el cliente
 * @author Rc
 */
class CSVClientReader implements AutoCloseable {
    
    private CsvReader reader;
    private boolean canRead;
    private boolean pendingRecord;
    
    /**
     * Constructor de la clase
     * @param path
     * @throws FileNotFoundException
     * @throws IOException 
     */
    CSVClientReader(String path) throws FileNotFoundException, IOException {
        reader = new CsvReader(path);  
        reader.readHeaders();
    }
    
    /**
     * Se identifica si hay registros por leer y retorna false si no hay.
     * @return
     * @throws IOException 
     */
    boolean hasNext() throws IOException {
        if (pendingRecord) return true;
        else return pendingRecord = canRead = reader.readRecord();
    }
    
    /**
     * Se El objeto con los datos del CSV (cuatro columnas del archivo)
     * @return
     * @throws IOException 
     */
    Client next() throws IOException {
        if (!canRead) throw new RuntimeException("No hay mas clientes por leer");
        pendingRecord = false;
        return new Client(reader.get(0), reader.get(1), reader.get(2), reader.get(3));
    }
    
    
    /**
     * Cierra la lectura de datos
     */
    @Override public void close() {
        reader.close();
    }
}