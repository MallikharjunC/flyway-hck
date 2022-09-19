package com.nutanix.db.migration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.info.MigrationInfoDumper;
import org.testng.annotations.Test;

public class FlywayMigration    {


    @Test
    private void migrateDataBase(){
        Flyway flyway=Flyway.configure()
                .licenseKey("")
                .dataSource("url",
                        "user",
                        "pass")
                .defaultSchema("")
                .load();

        System.out.println(MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
        flyway.undo();
        System.out.println(MigrationInfoDumper.dumpToAsciiTable(flyway.info().all()));
    }

}
