package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.User;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public interface IFileDao  extends IBaseDao{
    /* FilesDao  包含了对 files 表的操作
 * 1. 创建  删除   修改   由超类实现
 * 2. 按文件名查找
 * 3. 按上传用户查找
 * 4. 上传日期查找
 * 5. 失效日期查找*/

     uploadFile getFileByName(String name);
     List<uploadFile> getFileByUser(User user);
     List<uploadFile> getFileByUploadDate(Date date);
     List<uploadFile> getFileByEvalidateDate(Date date);

     List<uploadFile> getFiles();


}
