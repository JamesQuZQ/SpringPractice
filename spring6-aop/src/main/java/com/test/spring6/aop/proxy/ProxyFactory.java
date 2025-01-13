package com.test.spring6.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        /**
         * Three parameters of Proxy.newProxyInstance()
         * 1. ClassLoader loader: the class loader to define the proxy class
         * 2. Class[] interfaces: the list of interfaces for the proxy class to implement
         * 3. InvocationHandler h: the invocation handler to dispatch method invocations to
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {

            /**
             *
             * @param proxy the proxy instance that the method was invoked on
             *
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             *
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[Dynamic Proxy][Log] " + method.getName() + ", Parameters: " + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[Dynamic Proxy][Log] " + method.getName() + ", Result: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[Dynamic Proxy][Log] " + method.getName() + ", Exception: " + e.getMessage());
                } finally {
                    System.out.println("[Dynamic Proxy][Log] " + method.getName() + ", Method execution completed");
                }
                return result;

            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
