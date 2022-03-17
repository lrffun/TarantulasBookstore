package com.tb.dao;

import com.tb.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 图书持久层接口
 */

public interface IBookDao {
    /**
     * 查询所有book
     * @return
     */
    @Select("select * from books")
    List<Book> findAll();

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    @Select("select * from books where id=#{id}")
    Book findBooksById(String id);

    /**
     * 根据图书名称模糊查询
     * @param name
     * @return
     */
    @Select("select * from books where name like #{name}")
    List<Book> findBooksByName(String name);

    /**
     * 添加图书
     * @param book
     */
    @Insert("insert into books values(#{id},#{name},#{tag},#{img},#{author},#{press},#{date},#{price},#{Introduction},#{num},#{place})")
    void addBook(Book book);

    /**
     * 删除图书
     * @param id
     */
    @Delete("delete from books where id = #{id}")
    void deleteBook(String id);

    /**
     * 修改图书
     * @param book
     */
    @Update("update books set id=#{book.id},name=#{book.name},tag=#{book.tag},img=#{book.img},author=#{book.author},press=#{book.press},date=#{book.date},price=#{book.price},Introduction=#{book.Introduction},num=#{book.num},place=#{book.place} where id=#{book.id}")
    void update( @Param("book") Book book);

}
