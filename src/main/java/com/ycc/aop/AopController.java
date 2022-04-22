package com.ycc.aop;

import com.ycc.annotion.MyAnnotion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;


/**
 * @author ycc
 */
public class AopController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public void beforeT(JoinPoint joinPoint){
//        System.out.println("前置通知。。。。。。。");
        logger.info("配置的日志进入了方法"+joinPoint.getSignature().getName());
    }

    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕通知。。。。。。。");
        System.out.println(jp.getSignature().getClass().getName());
        MyAnnotion annotation = ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(MyAnnotion.class);
        System.out.println(annotation.value());
        System.out.println(jp.getSignature().getName());
        /*try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }*/
        return jp.proceed();
    }
}
