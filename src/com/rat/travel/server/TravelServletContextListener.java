package com.rat.travel.server;

import java.util.Properties;

import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.rat.travel.server.db.DB;
import com.rat.travel.server.db.DBInterface;

public class TravelServletContextListener extends GuiceServletContextListener{
        @Override
        protected Injector getInjector() {
            final Properties props = new Properties();
            props.setProperty("db.user", "postgres");
            props.setProperty("db.password", "123456");
            props.setProperty("jdbc.url", "jdbc:postgresql://localhost:5432/TRAVEL");

            Injector injector = Guice.createInjector(
                new XMLMyBatisModule() {

                    @Override
                    protected void initialize() {
                        setClassPathResource("mybatis-config.xml");
                        addProperties(props);
                        setEnvironmentId("development");
                    }

                },
                new AbstractModule() {
                    
                    @Override
                    protected void configure() {
                        requestStaticInjection(Server.class);
                        bind(DBInterface.class).to(DB.class).in(Singleton.class);
                    }
                }
            );
            
            return injector;
        }
}
