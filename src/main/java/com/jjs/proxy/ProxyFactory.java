package com.jjs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory  {
    private Object target;
    public ProxyFactory(Object target){

        this.target=target;
    }
    //
    public Object getProxy(){
        ClassLoader classLoader = this.getClass().getClassLoader();//为能够动态生成这个代理类，指定一个classLoader
        Class<?>[] interfaces = target.getClass().getInterfaces();//目标类实现的接口数组
        InvocationHandler invocationHandler = new InvocationHandler() {   //代理方法如何执行
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前: 方法名"+method.getName()+"参数"+ Arrays.toString(args));
                Object result = method.invoke(target, args);
                System.out.println("方法执行后: 方法名"+method.getName()+"结果"+result);
                return result;
            }
        };


        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }

}
