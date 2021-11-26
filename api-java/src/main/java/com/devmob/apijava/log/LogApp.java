package com.devmob.apijava.log;

import java.io.IOException;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class LogApp {

    //3. Criação do objeto logger
    private static Logger log = Logger.getLogger(LogApp.class);

    public static void main(String[] args) throws Exception {

        //1. Criação do layout (existem vários layouts possíveis para se obter os registros).
//        Layout layout = new HTMLLayout();
//        Layout layout = new SimpleLayout();
//        Layout layout = new XMLLayout();
        Layout layout = new PatternLayout("%p %d %C %M %m %n");
//            
        //2. Criação do appender (appender pode salvar as informações de logger em um arquivo, 
        //imprimir no console, enviar via e-mail, etc).
//        Appender app = new ConsoleAppender(layout);
        Appender app = new FileAppender(layout, "/home/luiz.ekstein@VALEMOBI.CORP/Downloads/my-logs/registro.log");

        //4. Link do appender com o log
        log.addAppender(app);

        //-----Print das Mensagens-----
        log.info("Informação dos registros!");
        log.debug("Informação dos bugs!");
        log.fatal("Informação dos erros fatais!");
        log.error("Informação dos erros gerais!");
        log.warn("Informação da sinalização de atenção!");
//
//        log.info("FROM INFO");
//        log.debug("FROM DEBUG");
//        log.fatal("FROM FATAL");
//        log.error("FROM ERROR");
//        log.warn("FROM WARN");

    }
}
