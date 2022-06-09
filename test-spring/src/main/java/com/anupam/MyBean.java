package com.anupam;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements ApplicationContextAware {
	
	private String name;
	private ApplicationContext context;
	
	public MyBean() {
		super();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		Object flow=this.context.getBean("testFlow1");
		System.out.println("########## FLOW ########## "+flow);
		
		Object listener_config=this.context.getBean("listener_8081");
		System.out.println("########## Listener Config ########## "+listener_config);
		
//		System.out.println("Closing the Application context.");
//		ConfigurableApplicationContext ctx=(ConfigurableApplicationContext)this.context;
//		ctx.close();
	}


	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;
		System.out.println();
	}

}
