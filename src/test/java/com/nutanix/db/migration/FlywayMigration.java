package com.nutanix.db.migration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

public class FlywayMigration    {

    private void migrateDataBase(){
        FluentConfiguration fluentConfiguration=new FluentConfiguration();
        fluentConfiguration.dataSource("dbUrl","dbUser","dbPassword");
        Flyway flyway=new Flyway(fluentConfiguration);
        flyway.migrate();
    }

}
