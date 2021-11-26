package com.devmob.apijava.gateway.database;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {

    private BasicDataSource devmobDataSource;

    public DataSource() {
        this.devmobDataSource = new BasicDataSource();

        devmobDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        devmobDataSource.setUrl("jdbc:sqlserver://devmobserver.database.windows.net:1433;database=devmob;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        devmobDataSource.setUsername("devmob");
        devmobDataSource.setPassword("Luiz@1010");
//        
//        devmobDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        devmobDataSource.setUrl("jdbc:mysql://localhost:3306/devmob");
//        devmobDataSource.setUsername("root");
//        devmobDataSource.setPassword("123456789");
    }

    public BasicDataSource getDevmobDataSource() {
        return devmobDataSource;
    }
}
