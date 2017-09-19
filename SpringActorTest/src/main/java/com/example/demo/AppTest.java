

package com.example.demo;


import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;


public class AppTest {

    @Mock
    ApplicationContext applicationContext;

    HelloWorldImpl helloWorldImpl = new HelloWorldImpl();

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void test() {
        // helloWorldImpl = new HelloWorldImpl();// applicationContext.getBean(HelloWorldImpl.class);
        when(applicationContext.getBean("helloWorldImpl")).thenReturn(helloWorldImpl);
        helloWorldImpl.printHelloWorld("Spring3 Java Config");

    }

}
