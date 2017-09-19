package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;

public class BeansPrinterTest {
	
	@InjectMocks
	BeansPrinter beansPrinter = new BeansPrinter();
	
	@Mock
	private ApplicationContext appContext;
	
	@Mock
	BeansPrinter1 beansPrinter1;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test	
	public void test() {
		//beansPrinter = new BeansPrinter();
		when(appContext.getBean(BeansPrinter1.class)).thenReturn(beansPrinter1);
		//beansPrinter1.printBeans();
		//verify(beansPrinter1).printBeans();
		//beansPrinter.setAppContext(appContext);
		beansPrinter.printBeans();
		verify(beansPrinter1, times(1)).printBeans();
		
	}

}
