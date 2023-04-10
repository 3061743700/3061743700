package controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UpdateCourseService;
import service.impl.UpdateCourseServiceImpl;
import stl.AopUtils;

public class aa {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        Object oUpdateCourseService = context.getBean("aopUtils");
//        AopUtils aopUtil = (AopUtils)oUpdateCourseService;
//        System.out.println(aopUtil);

        Object oUpdateCourseService = context.getBean("updateCourseServiceImpl");
        UpdateCourseService updateCourseService = (UpdateCourseService) oUpdateCourseService;

        System.out.println(updateCourseService);
        updateCourseService.a();


//        UpdateCourseServiceImpl updateCourseService = new UpdateCourseServiceImpl();
//        updateCourseService.a();
    }
}
