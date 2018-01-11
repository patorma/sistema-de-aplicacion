package com.patriciocontreras.sistemausuarios.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




//captura el tiempo de las peticiones desde que entra a la request 
//hasta que se devuelve una response , se calcula con esta clase
//se calcula el tiempo de las peticiones http
//esto hace que por cada peticion que nos hagan entre por esta CLASE	
//
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	//Se ejecuta primero
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
		//hace que antes se ejecute el controlador guardar en esta peticion el tiempo
		//en milisegundo
	}
	//Se ejecuta segundo
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//una vez que se ha ejecutado el controlador y ver la vista
		//se obtiene el tiempo actual
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("Url to:  '"+ request.getRequestURL().toString() +"' in:'" + (System.currentTimeMillis() - startTime) + "ms'" );
	}


	
	
}
