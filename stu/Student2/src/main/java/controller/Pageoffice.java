package controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Pageoffice")
public class Pageoffice extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        PageOfficeCtrl pageOfficeCtrl = new PageOfficeCtrl(request);
        request.setAttribute("pageOfficeCtrl",pageOfficeCtrl);
        pageOfficeCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
        pageOfficeCtrl.setSaveFilePage("SaveFile.jsp");
        pageOfficeCtrl.webOpen("C:\\测试结果\\中国核工业二三建设有限公司-时间继电器-5fe84720-1eaa-4399-95c3-e8842033f78b.docx", OpenModeType.docNormalEdit,"123");
        request.getRequestDispatcher("/aword.jsp").forward(request, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



}
