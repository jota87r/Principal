/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jonatan
 */
@Data
@AllArgsConstructor
public class Client {
    
    private String CIF_ID;
    private String PARTNER;
    private String TIPODOC;
    private String NUMDOC;

    public final static int TYPE_A = 1;
    public final static int TYPE_B = 2;
    
    public int type() {
        switch(TIPODOC) {
            case "FS001" : case "FS002" : case "FS004" : case "FS005" : case "FS006" : case "FS009" :
                return TYPE_A;
            case "FS003" : case "FS007" : case "FS008" :
                return TYPE_B;
            default :
                throw new RuntimeException("Tipo de documento no válido");
        }
    }
}
