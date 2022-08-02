import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class JavaRefection {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> studentInfo = Class.forName("Student");
//(or) Class<Student> studentInf = Student.class;
//(or)	Student student = new Student(null);
//		Class stu = student.getClass();
		
		Constructor<?>[] constructors = studentInfo.getConstructors();
		Method[] methods = studentInfo.getDeclaredMethods();
		
		for (Constructor constr : constructors) {
			System.out.println(constr);
		}
		
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}
