package com.tb.controller;

import com.tb.dao.IBookDao;
import com.tb.dao.IBorrowDao;
import com.tb.domain.Book;
import com.tb.domain.Borrow;
import com.tb.domain.BorrowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("borrowDaoImpl")
    IBorrowDao borrowDao;

    @Autowired
    @Qualifier("bookDaoImpl")
    IBookDao bookDao;

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public String BookListPage(Model model) {
        List<Book> bookList = bookDao.findAll();
        model.addAttribute("libraryPageCount", bookList);

        return "/user/user_bookList";
    }

    @RequestMapping("/return.action")
    public String returnBook(String stu_id, String book_id,Model model) throws Exception {
        Borrow borrow = new Borrow();
        borrow.setStu_id(stu_id);
        borrow.setBook_id(book_id);
        borrow.setSreturn_date(new Date());
        borrowDao.insertReturn(borrow);

        return personalLoanList(stu_id,model);
    }

    @RequestMapping("/renew.action")
    public String renewAction(String stu_id, String book_id,Model model)  {
        Borrow borrow = new Borrow();
        borrow.setStu_id(stu_id);
        borrow.setBook_id(book_id);
        borrow.setBorrow_date(new Date());
        borrowDao.updateRenew(borrow);
        model.addAttribute("successMsg","续借成功！");
        return "errorMsg";
    }

    @RequestMapping("/outStanding.action")
    public String outStanding(String id,Model model){
        List<BorrowView> borrowViews = borrowDao.notReturn(id);
        model.addAttribute("loanRecordList",borrowViews);
        return "/user/user_loanList";
    }

    //借阅列表显示
    @RequestMapping("TarantulasBookstore/PersonalBorrowRecord.action")
    public String personalLoanList(String id, Model model) throws Exception {

        List<BorrowView> borrows = borrowDao.findBorrowByStuId(id);
     

        model.addAttribute("loanRecordList", borrows);
        return "/user/user_loanList";
    }

    @RequestMapping("/TarantulasBookstore/toBorrow.action")
    public String jieyue_book2(String id,Model model) {
        model.addAttribute("id",id);
        return "user/jieshu_book";
    }

    @RequestMapping("/TarantulasBookstore/toOrderBorrow.action")
    public String yuyue_book1(String id,Model model) {
        model.addAttribute("id",id);
        return "user/yuyue_book";
    }
}
