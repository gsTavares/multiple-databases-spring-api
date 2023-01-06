package com.example.twodatabases.routing;

import org.springframework.util.Assert;

import com.example.twodatabases.routing.enumerated.ClientDatabase;

public class ClientDatabaseContextHolder {
    
    private static ThreadLocal<ClientDatabase> CONTEXT 
    = new ThreadLocal<>();

    public static void set(ClientDatabase clientDatabase) {
        Assert.notNull(clientDatabase, "client database cannot be null");
        CONTEXT.set(clientDatabase);
    }

    public static ClientDatabase getClientDatabase() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }

}
