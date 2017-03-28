package com.rat.travel.server;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.rat.travel.server.db.DB;
import com.rat.travel.server.db.DBInterface;

public class TravelModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DBInterface.class).to(DB.class).in(Singleton.class);
    }
}
