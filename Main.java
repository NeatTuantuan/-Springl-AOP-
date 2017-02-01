package SpringAop;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
/**
 * 模拟Spring AOP 动态代理
 * 在多个方法前加校内共同的业务逻辑
 * @author XUYIMING
 *
 */
public class Main {

    public static void main(String[] args) {
 /*   	BeanFactory factory = new ClassPathXmlApplicationContext("helloMessage.xml");
    	Person person = (Person)factory.getBean("person");
    	person.sayHello();
 */   	
   /* 	
        //引入配置文件
        Resource r = new FileSystemResource("src/helloMessage.xml");
        //加载配置文件
        BeanFactory f = new XmlBeanFactory(r);
        //获取Person实例
        Person person = (Person) f.getBean("person");
        String s = person.sayHello();
        System.out.println(s);
    */
    	
    	new Main().Proxy();
    } 
    
    public void Proxy(){
    	//被代理对象
    	IHelloMessage helloChina = new HelloChina();
    	
    	LogInterceptor logInterceptor = new LogInterceptor();
    	//将被代理对象设置为helloChina
    	logInterceptor.setTarget(helloChina);
    	//根据被代理对象产生代理
    	
    	//第一个参数：用哪个ClassLoader产生代理对象，要和被代理对象用同一个ClassLoader
    	//第二个参数：产生的代理对象应该实现那些接口
    	//第三个参数：产生代理后，调用代理里面方法用哪个Handler处理
    	//newProxyInstance返回值就是代理对象
    	 IHelloMessage helloChinaProxy = 
    			 (IHelloMessage)java.lang.reflect.Proxy.newProxyInstance(helloChina.getClass().getClassLoader(), new Class[]{IHelloMessage.class}, logInterceptor);
    	 helloChinaProxy.sayHello();
    	 
    }
}

