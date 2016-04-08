/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.xml;

import com.sophos.Client;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.java.Log;

/**
 *
 * @author carlos ignacio restrepo
 */
@Log
class XMLTypeBBuilder {
    
    static void build(Client client) throws IOException {
//        String fileName = System.getProperty("user.home") + File.separatorChar + "output" + File.separatorChar + UUID.randomUUID();
        UUID uuid = UUID.randomUUID();
        String fileName = System.getProperty("user.home") + File.separatorChar + "Desktop" +  File.separatorChar + uuid + ".xml";
        Templates.instance().get(client.type())
                .put("UUID", uuid.toString())
                .put("CIF_ID", client.getCIF_ID())
                .put("NUMDOC", client.getNUMDOC())
                .write(fileName);
    }
}
