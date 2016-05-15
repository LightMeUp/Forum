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
        try {
            filesDao.add(file);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteService(Serializable id) {
        Files f=(Files)filesDao.find(Files.class,id);
        if (f==null){
            return false;
        }else {
            try {
                filesDao.delete(f);
                return true;
            }catch (Exception e){
                return false;
            }
        }
    }

    @Override
    public Boolean updateServcie(Files file) {
        try {
            Files f= (Files) filesDao.find(Files.class,file.getId());
            f.setDesc(file.getDesc());
            f.setFileName(file.getFileName());
            f.setUploadingDate(file.getUploadingDate());
            f.setUser(file.getUser());
            f.setUuid(file.getUuid());
            f.setValidateDate(file.getValidateDate());
            filesDao.update(f);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public Files findService(Class clazz, Serializable id) {
        return (Files) filesDao.find(Files.class,id);
    }

    @Override
    public List<Teacher> listAllService(String tableName) {
        return filesDao.listAll(tableName);
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
