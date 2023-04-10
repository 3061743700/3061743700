package Utils;

import java.lang.reflect.Proxy;

public class Factory {
    public static Object factory(Class c){
        Object obj = null;
        try {
            obj = c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Handler handler = new Handler(obj);
        /**
         * 第一个参数是指定代理类的ClassLoader，也就是生成代理类的类加载器。通常情况下可以使用被代理对象的类加载器。
         * 第二个参数是指定代理类要实现的接口列表，也就是生成的代理类需要实现哪些接口。注意，这里必须以数组形式传入接口列表。
         * 第三个参数是InvocationHandler类型的对象，它是用来处理代理类所有方法调用的重要对象，每次代理对象调用方法时都会委托给该对象来进行处理。
         */
        Object o = Proxy.newProxyInstance(Handler.class.getClassLoader(),obj.getClass().getInterfaces(), handler);
        return o;
    }
}
