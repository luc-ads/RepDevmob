package com.devmob.apijava;

import com.devmob.apijava.gateway.database.DataSource;
import com.devmob.apijava.gateway.repository.ComputerLogRowMapper;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import org.springframework.jdbc.core.JdbcTemplate;

public class ApiJavaApplication {

    public void runLooca(String fkE) {
        DataSource devmobDataSource = new DataSource();
        JdbcTemplate configDB = new JdbcTemplate(devmobDataSource.getDevmobDataSource());
        ComputerLogRowMapper computerLog = new ComputerLogRowMapper();
        computerLog.runLog(fkE);
    }

    //Sistema sistema = new Sistema();
    //Memoria memoria = new Memoria();
    //Processador processador = new Processador();
    //Temperatura temperatura = new Temperatura();
    //DiscosGroup grupoDeDiscos = new DiscosGroup();
    //ServicosGroup grupoDeServicos = new ServicosGroup();
    //ProcessosGroup grupoDeProcessos = new ProcessosGroup();
}
