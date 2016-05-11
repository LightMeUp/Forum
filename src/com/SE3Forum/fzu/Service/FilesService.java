package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Data.Files;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Dao.FilesDao;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class FilesService implements IFilesService {
        private FilesDao  filesDao;
    public FilesService(){
        filesDao = new FilesDao();
    }

    @Override
    public Boolean addService(Files file) {
        return null;
    }

    @Override
    public Boolean deleteService(Serializable id) {
        return null;
    }

    @Override
    public Boolean updateServcie(Files file) {
        return null;
    }

    @Override
    public Files findService(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public List<Teacher> listAllService(String tableName) {
        return null;
    }

    @Override
    public int getRowsService(String tableName) {
        return 0;
    }

    @Override
    public List<Files> listAllFiles(Serializable id) {
        return null;
    }

    @Override
    public Files findFileByName(String name) {
        return null;
    }

    @Override
    public List<Files> findFileByuploadDate(Date uploadDate) {
        return null;
    }

    @Override
    public List<Files> findFilesByValidateDate(Date validateDate) {
        return null;
    }

    @Override
    public List<Files> findFileWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
