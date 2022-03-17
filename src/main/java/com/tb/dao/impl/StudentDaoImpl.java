package com.tb.dao.impl;

import com.tb.dao.IStudentDao;
import com.tb.domain.Student;

import java.util.List;


public class StudentDaoImpl implements IStudentDao {


    IStudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student login(Student student) {
        return studentDao.login(student);
    }

    @Override
    public Student findStudentsById(String id) {
        return studentDao.findStudentsById(id);
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentDao.findStudentsByName(name);
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        System.out.println(student);
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public void addBlackList(String id) {
        studentDao.addBlackList(id);
    }

    @Override
    public void changePassword(String password,String id ) {
        studentDao.changePassword(password,id);
    }

    @Override
    public void outBlackList(String id) {
        studentDao.outBlackList(id);
    }

    @Override
    public List<Student> findAllBlackList() {
        return studentDao.findAllBlackList();
    }

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public IStudentDao getStudentDao() {
        return studentDao;
    }
}
