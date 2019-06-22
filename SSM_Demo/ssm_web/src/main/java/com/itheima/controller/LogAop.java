package com.itheima.controller;


import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date startTime;
    private Class classType;
    private Method method;
    private String url;
    private String ip;
    private String username;

    @Pointcut("execution(* com.itheima.controller.*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(JoinPoint jp) throws Exception {
        classType = jp.getTarget().getClass();
        startTime = new Date();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if(args == null || args.length == 0){
            method = classType.getMethod(methodName);
        }else {
            Class[] argsClass = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argsClass[i] = args[i].getClass();
            }

            method = classType.getMethod(methodName,argsClass);
         }
    }


    @After("pt()")
    public void after(JoinPoint jp) throws Exception{
        long time = System.currentTimeMillis() - startTime.getTime();

        //获取url
        if(classType != null && method != null && classType != LogAop.class){
            RequestMapping ra = (RequestMapping) classType.getAnnotation(RequestMapping.class);
            if(ra != null){
                String classUrl = ra.value()[0];
                RequestMapping ma = method.getAnnotation(RequestMapping.class);
                if (ma != null) {
                    String methodUrl = ma.value()[0];
                    url = classUrl + methodUrl;
                }
            }

        }

        ip = request.getRemoteAddr();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = user.getUsername();
        if (classType != SysLogController.class) {
            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time);
            sysLog.setIp(ip);
            sysLog.setUrl(url);
            sysLog.setUsername(username);
            sysLog.setVisitTime(startTime);
            sysLog.setMethod("[类名]" + classType.getName() + "[方法名]" + method.getName());
            sysLogService.save(sysLog);
        }

    }

}
