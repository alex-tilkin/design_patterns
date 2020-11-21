package unit_12_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

interface IHuman{
	void walk();
	void talk();
}

class Person implements IHuman{

	@Override
	public void walk() {
		System.out.println("I'm walking");
	}

	@Override
	public void talk() {
		System.out.println("I'm talking");
	}
}

class LoggingHandler<T> implements InvocationHandler{
	private T target;
	private HashMap<String, Integer> calls = new HashMap<String, Integer>();
	
	public LoggingHandler(T target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String name = method.getName();
		
		if(name.equals("toString")) {
			return calls.toString();
		}
		
		calls.merge(name, 1, Integer::sum);
		
		return method.invoke(target, args);
	}
}

public class DynamicLoggingProxyExample {
	@SuppressWarnings("unchecked")
	public static <T> T withLogging(T target, Class<T> interfaceType, InvocationHandler invocationHandler) {
		return (T)Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				new Class<?>[] { interfaceType},
				invocationHandler);
	}
	
	public static void main(String[] args) {
		IHuman person = new Person();
		
		IHuman personWithLogging = withLogging(person, IHuman.class, new LoggingHandler<IHuman>(person));
		
		personWithLogging.walk();
		personWithLogging.talk();
		personWithLogging.talk();
		System.out.println(personWithLogging);
	}
}