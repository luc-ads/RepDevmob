package com.devmob.apijava.gateway.repository;

import com.devmob.apijava.gateway.database.DataSource;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import org.springframework.jdbc.core.JdbcTemplate;

public class ComputerLogRowMapper {
    DataSource devmobDataSource = new DataSource();
    JdbcTemplate configDB = new JdbcTemplate(devmobDataSource.getDevmobDataSource());

    Memoria memoria = new Memoria();
    Processador processador = new Processador();
    DiscosGroup disk = new DiscosGroup();
    
    private void includeLog(String fkE, Double cpuPercentage, Long ramPercentage, Long hdPercentage) {
        configDB.update("insert into tb_computer_log (fk_equipment, cpu_percentage, ram_percentage, hd_percentage, log_time) values (?,?,?,?,Sysdatetime())", fkE, cpuPercentage, ramPercentage, hdPercentage);
    }

    public void runLog(String fkE) {
        //while (isActive == true) {
        //for (int i = 0; i < 3; i++) {
        long memoriaP = (100 * memoria.getEmUso()) / memoria.getTotal();
        long hdP = diskP();
        includeLog(fkE, processador.getUso(), memoriaP, hdP);
        pause(1000);
        //}
        //}
    }
    
    private long diskP(){
        Volume mainDisk = disk.getVolumes().get(0);
        long avaibleDisk =  ((100 * ( mainDisk.getTotal() - mainDisk.getDisponivel())) / mainDisk.getTotal());
        return avaibleDisk;
    }

    private static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
