package SpringAop;

import Spring.IHelloMessage;

public class HelloChina2 implements IHelloMessage{
	
	private HelloChina helloChina;
	
	public void sayHello() {
		new LogInterceptor().beforeMethord();
		helloChina.sayHello();
	}

}
