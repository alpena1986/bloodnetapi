package com.bloodnet.bloodnetapi.com.appconfig;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStop implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {
    	Enumeration<Driver> drivers = DriverManager.getDrivers();
    	while( drivers.hasMoreElements() ){
    	    Driver driver = drivers.nextElement();
    	    try {
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}