package com.pmt.util.propertyfilehandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@PropertySource("classpath:applicationerrors.properties")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component(value="appErrorProp")
public class AppErrorProperties {
	
	@Autowired
	private Environment environment;
	
	public String getProperty(String key){
		return environment.getProperty(key);
	}

}
