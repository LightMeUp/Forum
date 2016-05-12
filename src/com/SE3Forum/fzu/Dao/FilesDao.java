package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.User;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/4/16.
 */
public class FilesDao  extends BaseDao implements IFileDao{


    @Override
    public uploadFile getFileByName(String name) {
        return null;
    }

    @Override
    public List<uploadFile> getFileByUser(User user) {
        return null;
    }

    @Override
    public List<uploadFile> getFileByUploadDate(Date date) {
        return null;
    }

    @Override
    public List<uploadFile> getFileByEvalidateDate(Date date) {
        return null;
    }
}
