package code.pro.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDemo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("code.pro");
        context.refresh();
        context.close();
	}

}
