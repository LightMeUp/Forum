package com.SE3Forum.fzu.Controller;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Service.FilesService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Feng on 6/18/16.
 */
@WebServlet(name = "showFilesServlet")
public class showFilesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilesService filesService = new FilesService();
        List<uploadFile> files =filesService.listAllService();
        request.setAttribute("files",files);
        request.getRequestDispatcher("/database/all.jsp").forward(request,response);
    }
}
