package com.example.administrator.mianshitest.view;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User:Lazy_xu
 * Data:2019/10/09
 * Description:
 * FIXME
 */
public class DynamicProxy {
    interface Bird {
        void fly();
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Bird bird = factory.create(Bird.class);
        bird.fly();
    }

    static class Factory implements InvocationHandler {

        public <T> T create(Class<T> target) {
            return (T) Proxy.newProxyInstance(target.getClassLoader(),
                    new Class[]{target},
                    this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("flying...");
            return null;
        }
    }
}
