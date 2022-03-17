package com.tb.controller;

import com.tb.dao.IBookDao;
import com.tb.dao.IBorrowDao;
import com.tb.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @description: 列表页面显示
 */

@Controller
@RequestMapping("/admin/ch")
public class BookController {
    // 注入
    @Autowired
    @Qualifier("bookDaoImpl")
    private IBookDao bookDao;

    @Autowired
    @Qualifier("borrowDaoImpl")
    private IBorrowDao borrowDao;
    /**
     * 查询图书列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public String showBookListPage(Model model) {

        List<Book> bookList = bookDao.findAll();
        model.addAttribute("libraryPageCount", bookList);
        return "/admin/loan_bookList";
    }

    /**
     * 图书编辑页面跳转
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/toEditPage.action", method = RequestMethod.GET)
    public String toBookEditPage(Model model, String id) {
        // 查询的 图书
        Book book = bookDao.findBooksById(id);
        System.out.println("准备修改图书"+book.toString());
        // 向域中 添加 属性library
        model.addAttribute("book", book);

        return "/admin/loan_editBook";
    }

    @RequestMapping(value = "/updateBook.action", method = RequestMethod.POST)
    public String updateBook(Book book, HttpServletRequest request) {
        bookDao.update(book);
        System.out.println(book);
        System.out.println("修改成功");
        System.out.println(book);
        return "redirect:/admin/ch/bookList";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(MultipartFile uploadFile, Book book, HttpSession session, HttpServletRequest request) {
        bookDao.addBook(book);
        return "redirect:/admin/ch/bookList";
    }

    /**
     * 根据 图书id  删除 图书
     *
     * @param id 图书id
     * @return
     */
    @RequestMapping("/delBookById")
    public String delBook(String id,Model model) {

        try {
            bookDao.deleteBook(id);
            return "redirect:/admin/ch/bookList";
        }catch (Exception e){
            model.addAttribute("errorMsg", "此书被借阅中，无法删除！");
            return "errorMsg";
        }

    }

    @RequestMapping(value = "/selectBookByName.action",method = RequestMethod.POST)
    public String selectByName(String name,Model model){
        List<Book> books = bookDao.findBooksByName("%"+name+"%");
        for(Book book:books){
            System.out.println(book);
        }
        model.addAttribute("libraryPageCount", books);
        return "/admin/loan_bookList";
    }
//

}
