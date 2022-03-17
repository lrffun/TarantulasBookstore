package com.tb;

import com.tb.dao.IBookDao;
import com.tb.dao.IBorrowDao;
import com.tb.dao.IStudentDao;
import com.tb.dao.impl.BookDaoImpl;
import com.tb.dao.impl.BorrowDaoImpl;
import com.tb.dao.impl.StudentDaoImpl;
import com.tb.domain.Book;
import com.tb.domain.Borrow;
import com.tb.domain.BorrowView;
import com.tb.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class MyBatisTest {
//    InputStream in;
//    SqlSession session;
//
//
//    @Before
//    public void init() throws Exception{
//        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        session =  factory.openSession();
//    }
//
//    @After
//    public void destroy() throws Exception{
//        session.close();
//        in.close();
//    }


    IBookDao bookDao;

    IStudentDao studentDao;

    IBorrowDao borrowDao;

    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
        studentDao = context.getBean("studentDaoImpl", StudentDaoImpl.class);
        bookDao = context.getBean("bookDaoImpl", BookDaoImpl.class);
        borrowDao = context.getBean("borrowDaoImpl", BorrowDaoImpl.class);
    }


    @Test
    public void testFindAllStudent(){

        List<Student> students = studentDao.findAll();
        for(Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void testFindAllBook(){
        List<Book> books = bookDao.findAll();
        for (Book book:books){
            System.out.println(book);
        }
    }

    @Test
    public void testUpdateBook(){
        Book book = bookDao.findBooksById("1");
        book.setName("<<Test>>");
        bookDao.update(book);
    }

    @Test
    public void testInsertStudent(){
//        IStudentDao studentDao = session.getMapper(IStudentDao.class);
        Student student = new Student();
        student.setId("201803386");
        student.setPassword("803386");
        student.setAge(21);
        student.setName("郎瑞峰");
        student.setSex("男");
        student.setCollege("计算机科学学院");
        student.setSclass("大数据11801班");
        studentDao.insertStudent(student);
//        session.commit();
    }
    @Test
    public void testInsertBook(){
        Book book = new Book();
        book.setId("1");
        book.setName("《Test》");
        book.setTag("小说");
        book.setImg("www.baidu.com");
        book.setAuthor("郎瑞峰");
        book.setPress("中国人民出版社");
        book.setDate("2020");
        book.setPrice(12.5);
        book.setIntroduction("贼6的一本书");
        book.setNum(1);
        book.setPlace("长江大学东校区");
        bookDao.addBook(book);
    }

    @Test
    public void testFindAllBorrow(){
        for(BorrowView borrow:borrowDao.findAll()){
            System.out.println(borrow);
        }
    }

    @Test
    public void testInsertBorrow(){
        Borrow borrow = new Borrow();
        borrow.setStu_id("201805320");
        borrow.setBook_id("26755503");
        borrow.setSreturn_date(new Date());
        borrowDao.insertReturn(borrow);
    }

}
