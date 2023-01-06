package com.example.twodatabases.routing.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.twodatabases.routing.enumerated.ClientDatabase;
import com.example.twodatabases.routing.model.ClientADetails;
import com.example.twodatabases.routing.model.ClientBDetails;
import com.example.twodatabases.routing.router.ClientDataSourceRouter;

@Configuration
public class RoutingTestConfiguration {
    
    @Autowired
    private ClientADetails clientADetails;

    @Autowired
    private ClientBDetails clientBDetails;

    private DataSource clientADatasource() {
        DriverManagerDataSource dmds = new DriverManagerDataSource(clientADetails.getUrl(), clientADetails.getUsername(), clientADetails.getPassword());
        dmds.setDriverClassName("org.postgresql.Driver");
        return dmds;
    }

    private DataSource clientBDatasource() {
        DriverManagerDataSource dmds = new DriverManagerDataSource(clientBDetails.getUrl(), clientBDetails.getUsername(), clientBDetails.getPassword());
        dmds.setDriverClassName("org.postgresql.Driver");
        return dmds;
    }

    @Bean
    public DataSource clienDataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        DataSource clientADatasource = clientADatasource();
        DataSource clientBDatasource = clientBDatasource();
        targetDataSources.put(ClientDatabase.CLIENT_A, 
          clientADatasource);
        targetDataSources.put(ClientDatabase.CLIENT_B, 
          clientBDatasource);

        ClientDataSourceRouter clientRoutingDatasource = new ClientDataSourceRouter();
        clientRoutingDatasource.setTargetDataSources(targetDataSources);
        clientRoutingDatasource.setDefaultTargetDataSource(clientADatasource);
        return clientRoutingDatasource;
    }

}
