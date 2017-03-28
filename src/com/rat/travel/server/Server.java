package com.rat.travel.server;

import javax.inject.Inject;

import com.rat.travel.server.db.DBInterface;


public class Server {
    @Inject
    private static Server server;
    
    @Inject
    private DBInterface db;
    
    public Server() {
    }
    
    public static DBInterface getDb() {
        return server.db;
    }
}
