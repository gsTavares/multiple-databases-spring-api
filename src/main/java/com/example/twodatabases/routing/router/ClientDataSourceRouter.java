package com.example.twodatabases.routing.router;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.example.twodatabases.routing.ClientDatabaseContextHolder;

public class ClientDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ClientDatabaseContextHolder.getClientDatabase();
    }
    
}
