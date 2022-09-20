package com.nutanix.db.migration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.info.MigrationInfoDumper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FlywayMigration    {

    private static Properties properties=new Properties();
    static {
        String filePath = System.getProperty("configFileName","src/test/resources/conf/flyway.conf");
        System.out.println("Reading config from : " + filePath);
        File file = new File(filePath);
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    private void migrateDataBase(){
        System.out.println("Connecting to : " + properties.getProperty("url"));
        Flyway flyway=Flyway.configure()
                .licenseKey(properties.getProperty("licenseKey"))
                .dataSource(properties.getProperty("url"),
                        properties.getProperty("user"),
                        properties.getProperty("password"))
                .defaultSchema(properties.getProperty("schema"))
                .load();

        System.out.println(MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
        flyway.undo();
        System.out.println(MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
    }

}
