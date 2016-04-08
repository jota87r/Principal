/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sophos.xml;

import com.sophos.Client;
import lombok.extern.java.Log;

/**
 *
 * @author carlos ignacio restrepo
 */
@Log
class XMLTypeABuilder {
    
    static void build(Client client) {
        log.info(client.toString());
    }
}
