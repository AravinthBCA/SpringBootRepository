import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaRefectionAccessMethods {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> studentClass = Class.forName("Student");
		Student studentObj = (Student) studentClass.newInstance();
		
		Class[] methodArgs = new Class[] {Integer.class};
		Method method = studentClass.getDeclaredMethod("attendSession",methodArgs);
		method.invoke(studentObj,101);
		
		Method method1 = studentClass.getDeclaredMethod("attendSession");
		method1.invoke(studentObj);
	}
}
