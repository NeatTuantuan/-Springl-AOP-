package SpringAop;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
/**
 * ģ��Spring AOP ��̬����
 * �ڶ������ǰ��У�ڹ�ͬ��ҵ���߼�
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
        //���������ļ�
        Resource r = new FileSystemResource("src/helloMessage.xml");
        //���������ļ�
        BeanFactory f = new XmlBeanFactory(r);
        //��ȡPersonʵ��
        Person person = (Person) f.getBean("person");
        String s = person.sayHello();
        System.out.println(s);
    */
    	
    	new Main().Proxy();
    } 
    
    public void Proxy(){
    	//���������
    	IHelloMessage helloChina = new HelloChina();
    	
    	LogInterceptor logInterceptor = new LogInterceptor();
    	//���������������ΪhelloChina
    	logInterceptor.setTarget(helloChina);
    	//���ݱ���������������
    	
    	//��һ�����������ĸ�ClassLoader�����������Ҫ�ͱ����������ͬһ��ClassLoader
    	//�ڶ��������������Ĵ������Ӧ��ʵ����Щ�ӿ�
    	//��������������������󣬵��ô������淽�����ĸ�Handler����
    	//newProxyInstance����ֵ���Ǵ������
    	 IHelloMessage helloChinaProxy = 
    			 (IHelloMessage)java.lang.reflect.Proxy.newProxyInstance(helloChina.getClass().getClassLoader(), new Class[]{IHelloMessage.class}, logInterceptor);
    	 helloChinaProxy.sayHello();
    	 
    }
}

