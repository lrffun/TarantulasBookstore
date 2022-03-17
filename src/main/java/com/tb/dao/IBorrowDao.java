package com.tb.dao;

import com.tb.domain.Borrow;
import com.tb.domain.BorrowView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 借阅记录持久层接口
 */

public interface IBorrowDao {

    /**
     * 查询所有借阅记录（此处采用allBorrow视图查询）
     * @return
     */
    @Select("select * from borrowView")
    List<BorrowView> findAll();

    /**
     * 根据学生学号查询所有借阅记录
     * @param stu_id
     * @return
     */
    @Select("select * from borrowView where stu_id=#{stu_id}")
    List<BorrowView> findBorrowByStuId(String stu_id);

    /**
     * 根据图书id查询所有借阅记录
     * @param book_id
     * @return
     */
    @Select("select * from borrowView where book_id=#{book_id}")
    List<BorrowView> findBorrowByBookId(String book_id);

    /**
     * 根据图书id和学号查询所有借阅记录
     * @param book_id
     * @return
     */
    @Select("select * from borrowView where book_id=#{book_id} and stu_id=#{stu_id}")
    List<BorrowView> findBorrowByBookIdAndStuId(String stu_id,String book_id);

    /**
     * 插入借阅记录
     * @param borrow
     */
    @Insert("insert into borrow(stu_id,book_id,borrow_date) values(#{stu_id},#{book_id},#{borrow_date})")
    void insertBorrow(Borrow borrow);

    /**
     * 更新一条归还记录
     * @param borrow
     */
    @Update("update borrow set Sreturn_date = #{Sreturn_date} where stu_id=#{stu_id} and book_id=#{book_id}")
    void insertReturn(Borrow borrow);

    /**
     * 续借
     * @param borrow
     */
    @Update("update borrow set borrow_date = #{borrow_date} where stu_id=#{stu_id} and book_id=#{book_id}")
    void updateRenew(Borrow borrow);

    /**
     * 查询学生未还信息
     * @return
     */
    @Select("select * from borrowView where  Sreturn_date is null")
    List<BorrowView> allNotReturn();

    /**
     * 查询学生未还信息
     * @param stu_id
     * @return
     */
    @Select("select * from borrowView where stu_id=#{stu_id} and Sreturn_date is null")
    List<BorrowView> notReturn(String stu_id);

}
