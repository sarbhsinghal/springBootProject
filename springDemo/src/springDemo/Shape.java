package springDemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Shape implements ApplicationContextAware,BeanNameAware{
	private Square s;
	private ApplicationContext context;

	public Square getS() {
		return s;
	}

	public void setS(Square s) {
		this.s = s;
	}
	
	public void draw() {
		System.out.println(this.s.getSize1());
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
	this.context = context;
	Square sq = (Square)this.context.getBean("square");
	System.out.println("from context" + sq.getSize1());
		
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println(arg0);
		
	}

	

}
