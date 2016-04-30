package Controller;

import Bean.Post_Comments.CommentEntity;
import Bean.Post_Comments.PostEntity;
import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import Dao.BaseDao;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Feng on 4/15/16.
 */
@WebServlet(name = "delete")
public class delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 删除用户使用get 通过将用户的ID拼接到url后面  http://localhost:8080/Controller/adminOP/deleteuser?deleteid=XXXX
        * 删除 ID 头四位表示   2213  学生    2201 教师    2220 帖子  2212   消息
        *
        *
        *
        * /*/
        // 获取查询字符串
        String str = request.getQueryString();

        String[] QueryStr = str.split("=");
        int deleteid = Integer.parseInt(QueryStr[1]);
        if(QueryStr[0].equals("stuentid")){
            //删除学生

            BaseDao<StudentEntity> baseDao = new BaseDao<StudentEntity>();
            StudentEntity student = (StudentEntity) baseDao.findEntity(StudentEntity.class,deleteid);
            if(student == null){
                System.out.printf("controller:AdminController:delete: no student match");
            }
            else {
                    baseDao.deleteEntity(student);
            }
        }
        else if(QueryStr[0].equals("teacherid")){
            //删除教师
            BaseDao<TeacherEntity> baseDao = new BaseDao<TeacherEntity>();
            TeacherEntity teacher =  baseDao.findEntity(TeacherEntity.class,deleteid);
            if(teacher == null){
                System.out.printf("controller:AdminController:delete: no teacher match");
            }
            else {
                baseDao.deleteEntity(teacher);
            }
        }
        else if(QueryStr[0].equals("postid")){
            //删除帖子
            BaseDao<PostEntity> baseDao = new BaseDao<PostEntity>();
            PostEntity post = (PostEntity) baseDao.findEntity(PostEntity.class,deleteid);
            if(post == null){
                System.out.printf("controller:AdminController:delete: no post match");
            }
            else {
                baseDao.deleteEntity(post);
            }
        }
        else if(QueryStr[0].equals("commentid")) {
            //删除消息
            BaseDao<CommentEntity> baseDao = new BaseDao<CommentEntity>();
            CommentEntity comment = (CommentEntity) baseDao.findEntity(CommentEntity.class, deleteid);
            if (comment == null) {
                System.out.printf("controller:AdminController:delete: no post match");
            } else {
                baseDao.deleteEntity(comment);
            }
        }
    }
}
