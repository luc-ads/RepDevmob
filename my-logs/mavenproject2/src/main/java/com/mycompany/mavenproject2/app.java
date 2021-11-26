/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;

/**
 *
 * @author phaap
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        Logs log = new Logs();
        log.pastaLog();
        log.escrevendoLog();
        log.sobreEscrver("pitada de escrita");
    }
    
    
}
