

package com.example.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {



    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // HelloWorld obj = (HelloWorld)context.getBean("helloBean");
        HelloWorld obj = (HelloWorld)context.getBean("helloWorldImpl");
        obj.printHelloWorld("Spring3 Java Config");

        PropertyComponent pc = (PropertyComponent)context.getBean("propertyComponent");
        pc.foo();
        pc.propertyTest();

        // System.out.println("stringProp1 in App: " + stringProp1);

    }
}
