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
        System.getProperty("configFileName","src/test/resources/conf/flyway.conf");
        File file = new File("src/test/resources/conf/flyway.conf");
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    private void migrateDataBase(){
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
