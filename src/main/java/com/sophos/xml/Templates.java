/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.xml;

import com.sophos.Client;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.app.VelocityEngine;

/**
 *
 * @author jonatan
 */
class Templates {
    
    private Map<Integer, XMLTemplate> templates = new HashMap<>(2);
    private VelocityEngine engine;
    
    private static Templates instance;
    
    static synchronized Templates instance() {
        return instance == null ? instance = new Templates() : instance;
    }
    
    private Templates() {
        
        Properties props = new Properties();
        try {
            props.load(ClassLoader.getSystemResourceAsStream("props.properties"));
        } catch (IOException ex) {
            Logger.getLogger(XMLTypeABuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        engine = new VelocityEngine(props);
        engine.init();
    }
    
    XMLTemplate get(int type) {
        XMLTemplate template = templates.get(type);
        if (template == null) template = buildTemplate(type);
        return template;
    }
    
    private XMLTemplate buildTemplate(int type) {
        XMLTemplate template = new XMLTemplate(engine.getTemplate(templateFile(type)));
        templates.put(type, template);
        return template;
    }
    
    private String templateFile(int type) {
        switch(type) {
            case Client.TYPE_A : return "templates/RetCustAdd.xml";
            case Client.TYPE_B : return "templates/CorpCustAdd.xml";
            default : throw new RuntimeException("Tipo de cliente inválido");
        }
    }
}
