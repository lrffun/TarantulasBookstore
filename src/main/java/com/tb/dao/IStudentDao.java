package com.tb.dao;

import com.tb.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 学生持久层接口
 */

public interface IStudentDao {
    /**
     * 查询所有学生
     * @return
     */
    @Select("select * from students")
    List<Student> findAll();

    /**
     * 登录
     * @param student
     * @return
     */
    @Select("select * from students where id=#{id} and password=#{password}")
    Student login(Student student);

    /**
     * 根据学号查询学生信息。
     * @return
     */
    @Select("select * from students where id=#{id}")
    Student findStudentsById(String id);

    /**
     * 根据学生姓名模糊查询学生信息
     * @return
     */
    @Select("select * from students where name like #{name}")
    List<Student> findStudentsByName(String name);

    /**
     * 插入学生信息
     * @param student
     */
    @Insert("insert into students values(#{id},#{password},#{name},#{sex},#{age},#{college},#{sclass},0)")
    void insertStudent(Student student);

    /**
     * 更改学生信息
     * @param student
     */
    @Update("update students set id=#{id},password=#{password},name=#{name},sex=#{sex},age=#{age},college=#{college},sclass=#{sclass}, where id=#{id}")
    void updateStudent(Student student);

    /**
     * 删除学生
     * @param id
     */
    @Delete("delete from students where id=#{id}")
    void deleteStudent(String id);

    /**
     * 学生加入黑名单
     */
    @Update("update students set blackList=1 where id = #{id}")
    void addBlackList(String id);

    @Update("update students set password=#{password} where id = #{id}")
    void changePassword(@Param("password")String password, @Param("id")String id);

    /**
     * 学生移出黑名单
     */
    @Update("update students set blackList=0 where id = #{id}")
    void outBlackList(String id);

    /**
     * 查询所有黑名单同学
     * @return
     */
    @Select("select * from students where blackList=1")
    List<Student> findAllBlackList();
}
