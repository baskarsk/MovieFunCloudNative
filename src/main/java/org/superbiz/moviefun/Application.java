package org.superbiz.moviefun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean(ActionServlet actSrv){

		System.out.println("===== In actionServletRegistration =====");
		return new ServletRegistrationBean(actSrv,"/moviefun/*");
	}

}
