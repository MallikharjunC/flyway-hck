package com.nutanix.db.migration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.info.MigrationInfoDumper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FlywayMigration {

    private static Properties properties = new Properties();
    private String activity;
    private Flyway flyway;

    static {
        String filePath = System.getProperty("configFileName", "src/test/resources/conf/flyway.conf");
        System.out.println("Reading config from : " + filePath);
        File file = new File(filePath);
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void configure() {
        System.out.println("Connecting to : " + properties.getProperty("url"));
        activity = System.getProperty("activity", "migrate");
        flyway = Flyway.configure()
                .licenseKey(properties.getProperty("licenseKey"))
                .dataSource(properties.getProperty("url"),
                        properties.getProperty("user"),
                        properties.getProperty("password"))
                .defaultSchema(properties.getProperty("schema"))
                .load();
        System.out.println("Version history before " + activity + " :\n" +
                MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
    }

    @Test
    private void migrateDataBase() {
        System.out.println("Starting activity : " + activity);

        if (activity.equalsIgnoreCase("migrate")) {
            flyway.migrate();
        } else if (activity.equalsIgnoreCase("undo")) {
            flyway.undo();
        } else {
            System.err.println("Invalid activity : " + activity);
            System.err.println("Please use valid activity name [migrate, undo]");
        }
    }

    @AfterSuite
    public void validate(){
        System.out.println("Version history after " + activity + " :\n" +
                MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
    }

}
