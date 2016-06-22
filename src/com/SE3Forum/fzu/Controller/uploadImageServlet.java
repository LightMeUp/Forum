package com.SE3Forum.fzu.Controller;
        import java.io.File;
        import java.io.IOException;
        import java.util.List;

        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

        import com.SE3Forum.fzu.Util.Utils;
        import org.apache.commons.fileupload.FileItem;
        import org.apache.commons.fileupload.FileUploadException;
        import org.apache.commons.fileupload.disk.DiskFileItemFactory;
        import org.apache.commons.fileupload.servlet.ServletFileUpload;

        import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class uploadImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("ppppppppppppppppppp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //需要返回的fileName
        String fileName = null;

        //参考资料  http://commons.apache.org/proper/commons-fileupload/using.html
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        try {
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item : items) {
                //其他参数
                String type = item.getContentType();
                if(type == null) {
//					System.out.println(item.getString(item.getFieldName()));
                    continue;
                }

                //文件参数
                fileName = item.getName();

                //设置保存文件路径
                String realPath = Utils.getImageUploadFolder();
                File dir = new File(realPath);
                File f = new File(dir, fileName);

                if(!f.exists()) {
                    f.createNewFile();
                }
                //保存
                item.write(f);

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回结果
        JSONObject obj = new JSONObject();
        obj.put("fileName", fileName);
        response.getWriter().print(obj.toJSONString());
    }

}


