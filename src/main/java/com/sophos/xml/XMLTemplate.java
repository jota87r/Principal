/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

/**
 *
 * @author jonatan
 */
public class XMLTemplate {
    
    private Template template;
    private VelocityContext context;
    
    XMLTemplate(Template template) {
        this.template = template;
        this.context = new VelocityContext();
    }
    
    public XMLTemplate put(String key, String value) {
        context.put(key, value);
        return this;
    }
    
    public XMLTemplate write(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {
            template.merge(context, writer);
            writer.flush();
        }
        return this;
    }
}
