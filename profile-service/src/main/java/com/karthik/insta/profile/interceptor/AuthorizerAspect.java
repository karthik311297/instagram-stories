package com.karthik.insta.profile.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizerAspect {

    @Before("@annotation(Authorized)")
    public void authorize(JoinPoint joinPoint) throws AuthException
    {
        System.out.println("Authorizer Invoked");
        throw new AuthException();
    }
}
