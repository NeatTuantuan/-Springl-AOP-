package SpringAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 模拟SpringAOP，动态代理
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

	//被代理对象
	private Object target;
	
	public void beforeMethord(){
		System.out.println("save start");
	}

	@Override
	/**
	 * 调用方法之前加入自己的逻辑(befordMethord)，接下来调用被代理对象(target)的invoke方法
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
