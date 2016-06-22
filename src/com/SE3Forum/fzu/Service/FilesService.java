package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
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
    public Boolean addService(uploadFile file) {
        try {
            filesDao.add(file);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteService(Serializable id) {
        uploadFile f=(uploadFile) filesDao.find(uploadFile.class,id);
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
    public Boolean updateServcie(uploadFile file) {
        try {
            uploadFile f= (uploadFile) filesDao.find(uploadFile.class,file.getId());
            f.setFilepath(file.getFilepath());
            f.setUploadDate(file.getUploadDate());
            f.setUser(file.getUser());
            filesDao.update(f);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public uploadFile findService(Serializable id) {
        return (uploadFile) filesDao.find(uploadFile.class,id);
    }

    @Override
    public List<uploadFile> listAllService() {
        return filesDao.getFiles();
    }

    @Override
    public int getRowsService(String tableName) {
        return 0;
    }

    @Override
    public uploadFile findFileByName(String name) {
        return null;
    }

    @Override
    public List<uploadFile> findFileByuploadDate(Date uploadDate) {
        return null;
    }

    @Override
    public List<uploadFile> findFilesByValidateDate(Date validateDate) {
        return null;
    }

    @Override
    public List<uploadFile> findFileWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
