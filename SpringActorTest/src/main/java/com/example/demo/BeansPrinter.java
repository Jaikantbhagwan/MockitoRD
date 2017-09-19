package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeansPrinter 
{
    @Autowired
    private ApplicationContext appContext;

    public void printBeans()
    {
        /*System.out.println("Number of beans:");
        System.out.println(appContext.getBeanDefinitionCount());

        String[] names = appContext.getBeanDefinitionNames();
        for(String name : names)
        {
            System.out.println("-----------------");
            System.out.println(name);
        }*/
    	
    	System.out.println("BeansPrinter printBeans method");
    	
    	BeansPrinter1 beansPrinter1 = appContext.getBean(BeansPrinter1.class);
    	beansPrinter1.printBeans();
    }

	public ApplicationContext getAppContext() {
		return appContext;
	}

	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}
    
    
}