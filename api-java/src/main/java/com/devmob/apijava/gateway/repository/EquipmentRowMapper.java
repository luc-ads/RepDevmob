package com.devmob.apijava.gateway.repository;

import com.devmob.apijava.entities.Equipment;
import com.devmob.apijava.gateway.database.DataSource;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EquipmentRowMapper implements RowMapper<Equipment> {

    Sistema system = new Sistema();
    Memoria memory = new Memoria();
    Processador processor = new Processador();
    Temperatura temperature = new Temperatura();
    DiscosGroup diskGroup = new DiscosGroup();
    ServicosGroup serviceGroup = new ServicosGroup();
    ProcessosGroup processGroup = new ProcessosGroup();

    DataSource devmobDataSource = new DataSource();
    JdbcTemplate configDB = new JdbcTemplate(devmobDataSource.getDevmobDataSource());

    public List<Equipment> equipmentQuery() {
        List<Equipment> equipmentQuery = configDB.query("SELECT * FROM tb_equipment", new BeanPropertyRowMapper<>(Equipment.class));
        return equipmentQuery;
    }

    @Override
    public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Equipment equipment = new Equipment();
        equipment.setIdEquipment(rs.getString("id_equipment"));
        equipment.setFkUser(rs.getInt("fk_user"));
        return equipment;
    }

    public void includeEquipment(int fk) {
        configDB.update("insert into tb_equipment values (?,?,?,?,?,?,?,?,?,?)",
                processor.getId(),
                fk,
                system.getSistemaOperacional(),
                system.getFabricante(),
                system.getArquitetura(),
                Conversor.formatarBytes(memory.getTotal()),
                Conversor.formatarBytes(diskGroup.getTamanhoTotal()),
                processor.getNome(),
                processor.getNumeroCpusFisicas(),
                processor.getNumeroCpusLogicas());
    }
}
