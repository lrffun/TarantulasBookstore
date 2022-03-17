package com.tb.controller;

import com.tb.dao.IBookDao;
import com.tb.dao.IBorrowDao;
import com.tb.dao.IStudentDao;
import com.tb.domain.Book;
import com.tb.domain.Borrow;
import com.tb.domain.BorrowView;
import com.tb.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 图书借阅管理Controller
 *
 **/
@Controller
@RequestMapping("/admin")
public class Loan_LoanListController {

    @Autowired
    @Qualifier("bookDaoImpl")
    private IBookDao bookDao;

    @Autowired
    @Qualifier("studentDaoImpl")
    private IStudentDao studentDao;

    @Autowired
    @Qualifier("borrowDaoImpl")
    private IBorrowDao borrowDao;

    @RequestMapping("/TarantulasBookstore/toBorrow.action")
    public String jieyue_book2(Model model) {
        return "admin/jieshu_book";
    }

    @RequestMapping("/TarantulasBookstore/Borrow.action")
    public String jieyue_book2(HttpSession session, String id, String barcode, Model model) {
        Book book = bookDao.findBooksById(barcode);
        if (null == book) {
            model.addAttribute("errorMsg", "图书码不存在");
            return "errorMsg";
        }
        Student student = studentDao.findStudentsById(id);
        if (null == student || student.getBlackList()==1) {
            model.addAttribute("errorMsg", "学生学号不存在或处于黑名单中");
            return "errorMsg";
        }


        Borrow borrow = new Borrow();
        // 获取 session 中的用户信息
        borrow.setStu_id(student.getId());
        borrow.setBook_id(book.getId());

        borrow.setBorrow_date(new Date()); //预约 借阅时间
        // 插入数据
        borrowDao.insertBorrow(borrow);
        model.addAttribute("successMsg", "借阅成功");
        return "errorMsg";
    }

    @RequestMapping("/TarantulasBookstore/toOrderBorrow.action")
    public String yuyue_book1(Model model) {
        return "admin/yuyue_book";
    }



    @RequestMapping("/TarantulasBookstore/OrderBorrow.action")
    public String yuyue_book2(HttpSession session, String id, String barcode,String mDate, Model model){
        Book book = bookDao.findBooksById(barcode);
        if (null == book) {
            model.addAttribute("errorMsg", "图书码不存在");
            return "errorMsg";
        }
        Student student = studentDao.findStudentsById(id);
        if (null == student || student.getBlackList()==1) {
            model.addAttribute("errorMsg", "学生学号不存在或处于黑名单中");
            return "errorMsg";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(mDate);
            Borrow borrow = new Borrow();
            // 获取 session 中的用户信息
            borrow.setStu_id(student.getId());
            borrow.setBook_id(book.getId());

            borrow.setBorrow_date(date); //预约 借阅时间
            // 插入数据
            borrowDao.insertBorrow(borrow);
            model.addAttribute("successMsg", "借阅成功");
            return "errorMsg";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errorMsg","借阅失败！");
            return "errorMsg";
        }
    }

    @RequestMapping("/TarantulasBookstore/outStanding.action")
    public String allNotReturn(Model model){
        List<BorrowView> borrows = borrowDao.allNotReturn();
        model.addAttribute("loanRecordList", borrows);
        return "admin/loan_loanList";
    }

    //借阅列表显示
    @RequestMapping("/TarantulasBookstore/BorrowRecord.action")
    public String loanList(Model model) throws Exception {

        List<BorrowView> borrows = borrowDao.findAll();


        model.addAttribute("loanRecordList", borrows);
        return "admin/loan_loanList";
    }


    //借阅列表搜素
    @RequestMapping("/loan/searchLoanList.action")
    public String searchLoanList(Model model, String searchSelect, String searchKeyWord) throws Exception {
        //实例化包装类（包装类中在原有类的基础上添加的column（列名称）和keyword（搜索关键字）两个字段）
//        TbRecordSearchL tbRecordSearchL = new TbRecordSearchL();
//        tbRecordSearchL.setColumn(searchSelect);
//        tbRecordSearchL.setKeyWord(searchKeyWord);
//        //将查询结果保存到list集合并通过model将对象集合放入request域中
//        pageL pageL = this.loan_management.getLoanRecord(tbRecordSearchL);
        if (searchKeyWord.equals("")){
            return loanList(model);
        }
        if(searchSelect.equals("stu_id")){
            List<BorrowView> borrows = borrowDao.findBorrowByStuId(searchKeyWord);
            model.addAttribute("loanRecordList", borrows);
            return "admin/loan_loanList";
        }else if(searchSelect.equals("book_id")){
            List<BorrowView> borrows1 = borrowDao.findBorrowByBookId(searchKeyWord);
            model.addAttribute("loanRecordList",borrows1);
            return "admin/loan_loanList";
        }else{
            return loanList(model);
        }
    }

    @RequestMapping("/TarantulasBookstore/outTime.action")
    public String outTime(Model model){
        List<BorrowView> borrowViews = borrowDao.allNotReturn();
        List<BorrowView> borrowViewList = new ArrayList<BorrowView>();
        for(BorrowView borrowView:borrowViews){
            if(subMonth(borrowView.getBorrow_date(),3).getTime() < new Date().getTime()){
                borrowViewList.add(borrowView);
            }
        }
        model.addAttribute("loanRecordList",borrowViewList);
        return "admin/loan_loanList";
    }

    private Date subMonth(Date date,int month) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, month);
        Date dt1 = rightNow.getTime();
        return dt1;
    }


//
//    //    借阅列表归还状态修改
//    @RequestMapping("/loan/changeLoanStatus")
//    public String changeLoanStatus(Model model, String recid, String status) throws Exception {
//        loanStatusL loanStatusL = new loanStatusL();
//        loanStatusL.setId(recid);
//        loanStatusL.setStatus(status);
//        this.loan_management.changLoanStatus(loanStatusL);
//        //返回借阅列表
//        return "redirect:/admin/loan/loanList.action";
//    }
}
