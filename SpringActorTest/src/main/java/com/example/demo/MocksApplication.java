

package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MocksApplication {
    public static void main(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(MocksApplication.class, args);
    	
    	BeansPrinter beansPrinter = ctx.getBean(BeansPrinter.class);
    	beansPrinter.printBeans();
    }
}
