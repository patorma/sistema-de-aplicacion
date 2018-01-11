package com.patriciocontreras.sistemausuarios.configuration;
//las clases de configuracion 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.patriciocontreras.sistemausuarios.component.RequestTimeInterceptor;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	//inyectamos nuestro interceptor
	@Autowired
	@Qualifier("requestTimeInterceptor")//damos un calificador
	private RequestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(requestTimeInterceptor);
	}
	
	//ahora se da de alta el inteceptor
	

}
