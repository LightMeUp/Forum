package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Data.Files;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Dao.SchoolAssignmentDao;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public class SchoolAssignmentService implements ISchoolAsignment {
    private SchoolAssignmentDao schoolAssignmentDao;
    public SchoolAssignmentService(){schoolAssignmentDao=new SchoolAssignmentDao();}

    @Override
    public Boolean addService(SchoolAssignment assignment) {
       try {
           schoolAssignmentDao.add(assignment);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public Boolean deleteService(Serializable id) {
        SchoolAssignment schoolAssignment = (SchoolAssignment) schoolAssignmentDao.find(SchoolAssignment.class,id);

        if ( schoolAssignment == null)
        {
            return false;
        }
        else {
            try{
                schoolAssignmentDao.delete(schoolAssignment);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public Boolean updateServcie(SchoolAssignment assignment) {
        try {
            SchoolAssignment schoolAssignment = (SchoolAssignment) schoolAssignmentDao.find(SchoolAssignment.class,assignment.getId());
            schoolAssignment.setContent(assignment.getContent());
            schoolAssignment.setAssignmentNumbers(assignment.getAssignmentNumbers());
            schoolAssignment.setDeadLine(assignment.getDeadLine());
            schoolAssignment.setEvaluations(assignment.getEvaluations());
            schoolAssignment.setPublishDate(assignment.getPublishDate());
            schoolAssignment.setTeacher(assignment.getTeacher());
            schoolAssignmentDao.update(schoolAssignment);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public SchoolAssignment findService(Class clazz, Serializable id) {
        return (SchoolAssignment) schoolAssignmentDao.find(SchoolAssignment.class,id);
    }

    @Override
    public List<SchoolAssignment> listAllService(String tableName) {
        return schoolAssignmentDao.listAll(tableName) ;
    }

    @Override
    public int getRowsService(String tableName) {
        return 0;
    }

    @Override
    public Files findSchoolAssignmentByName(String name) {
        return null;
    }

    @Override
    public List<SchoolAssignment> findSchoolAssignmentBypublishDate(Date publishDate) {
        return null;
    }

    @Override
    public List<SchoolAssignment> findSchoolAssignmentByDeadLine(Date deadLine) {
        return null;
    }

    @Override
    public List<Files> findFileWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
