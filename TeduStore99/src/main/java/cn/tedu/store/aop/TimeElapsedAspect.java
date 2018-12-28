package cn.tedu.store.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeElapsedAspect {
	private long startTime;
	
@Around("execution(* cn.tedu.store.service.impl.*.*(..))")	
public Object around(ProceedingJoinPoint pjp) throws Throwable {
		//执行前序任务
		doBefore();
		//调用原本执行的方法
		Object result=pjp.proceed();
		//执行后续任务
		doAfter();
		//返回原本执行的方法的返回结果
		return result;
	}
	
	public void doBefore() {
		System.out.println("TimeElapsedAspect开始");
		startTime=System.currentTimeMillis();
	}
	public void doAfter() {
		long endTime=System.currentTimeMillis();
		long elapsed=endTime-startTime;
		System.out.println("TimeElapsedAspect结束时间："+elapsed);
	}

}
