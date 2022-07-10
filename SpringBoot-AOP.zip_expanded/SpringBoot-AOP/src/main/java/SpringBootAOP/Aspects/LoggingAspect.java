package SpringBootAOP.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* SpringBootAOP.ProductServiceImpl.multiply(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before Calling the Method");
	}
	
	@After("execution(* SpringBootAOP.ProductServiceImpl.multiply(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After Calling the Method");
	}
	
//	@Around("execution(* SpringBootAOP.ProductServiceImpl.multiply(..))")
//	public int logAround(JoinPoint joinPoint) {
//		System.out.println("Around Method Calling");
//		return 0;
//	}
	
}
