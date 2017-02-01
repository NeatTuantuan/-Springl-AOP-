package SpringAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * ģ��SpringAOP����̬����
 * @author XUYIMING
 *
 */
public class LogInterceptor implements InvocationHandler{
	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	//���������
	private Object target;
	
	public void beforeMethord(){
		System.out.println("save start");
	}

	@Override
	/**
	 * ���÷���֮ǰ�����Լ����߼�(befordMethord)�����������ñ��������(target)��invoke����
	 * @param proxy
	 * @param m
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		beforeMethord();
		m.invoke(target, args);
		return null;
	}
}
