package yt.bean.bus.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author yunteng
 */
@Order(1)
@Aspect
@Slf4j
@Component
public class ControllerLogCustomerAspect {

	ThreadLocal<Long> startTime = new ThreadLocal<>();

	/**
	 * Controller切点
	 */
	@Pointcut(
			"@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
					"@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
					"@annotation(org.springframework.web.bind.annotation.PostMapping)"
	)
	public void pointcut() {

	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		MDC.put("request-id", UUID.randomUUID().toString());
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (null != requestAttributes) {
			startTime.set(System.currentTimeMillis());
			HttpServletRequest request = requestAttributes.getRequest();
			log.info("REQUEST==URL:{},args:{}", request.getRequestURL(), joinPoint.getArgs());
		}
	}

	@AfterReturning(value = "pointcut()" , returning = "result")
	public void after(Object result) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (null != requestAttributes) {
			startTime.set(System.currentTimeMillis());
			HttpServletRequest request = requestAttributes.getRequest();
			log.info("REQUEST==URL:{},cost:{}ms,args:{}", request.getRequestURL(),System.currentTimeMillis() - startTime.get(), result);
		}
		MDC.remove("request-id");
		startTime.remove();
	}

	@AfterThrowing(value = "pointcut()", throwing = "e")
	public void afterThrowing(Exception e) {
		startTime.remove();
	}
}
