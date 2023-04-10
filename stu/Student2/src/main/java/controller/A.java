package controller;

import Utils.Handler;
import service.AddCourseService;
import service.impl.AddCourseServiceImpl;

import java.lang.reflect.Proxy;

public class A {
    public static void main(String[] args) {
        Object obj = null;
        try {
            obj = AddCourseServiceImpl.class.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Handler handler = new Handler(obj);
        Object o = Proxy.newProxyInstance(Handler.class.getClassLoader(),obj.getClass().getInterfaces(), handler);
        AddCourseService addCourseService = (AddCourseService) o;
        addCourseService.a();
//        System.out.println(addCourseService);
//        System.out.println(o);
    }
}
