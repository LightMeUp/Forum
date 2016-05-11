package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Data.Files;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public class SchoolAssignmentService implements ISchoolAsignment {
    @Override
    public Boolean addService(SchoolAssignment assignment) {
        return null;
    }

    @Override
    public Boolean deleteService(Serializable id) {
        return null;
    }

    @Override
    public Boolean updateServcie(SchoolAssignment assignment) {
        return null;
    }

    @Override
    public SchoolAssignment findService(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public List<SchoolAssignment> listAllService(String tableName) {
        return null;
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
