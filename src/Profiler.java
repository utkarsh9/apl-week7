import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Profiler implements InvocationHandler {

	private Object object;

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new Profiler(obj));
	}

	private Profiler(Object obj) {
		this.object = obj;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result=null;
		try {
			long start = System.nanoTime();
			result = m.invoke(object, args);
			long end = System.nanoTime();
			String display = String.format("%s took %d ns", m.getName(), (end - start));
			System.out.println(display);
		} catch (InvocationTargetException e) {
			 e.printStackTrace();
		} 
		return result;
	}
}
