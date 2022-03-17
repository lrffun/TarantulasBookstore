package com.tb.dao.impl;

import com.tb.dao.IBorrowDao;
import com.tb.domain.Borrow;
import com.tb.domain.BorrowView;

import java.util.List;

public class BorrowDaoImpl implements IBorrowDao {

    IBorrowDao borrowDao;

    @Override
    public List<BorrowView> findAll() {
        return borrowDao.findAll();
    }

    @Override
    public List<BorrowView> findBorrowByStuId(String stu_id) {
        return borrowDao.findBorrowByStuId(stu_id);
    }

    @Override
    public List<BorrowView> findBorrowByBookId(String book_id) {
        return borrowDao.findBorrowByBookId(book_id);
    }

    @Override
    public List<BorrowView> findBorrowByBookIdAndStuId(String stu_id, String book_id) {
        return borrowDao.findBorrowByBookIdAndStuId(stu_id,book_id);
    }

    @Override
    public void insertBorrow(Borrow borrow) {
        borrowDao.insertBorrow(borrow);
    }

    @Override
    public void insertReturn(Borrow borrow) {
        borrowDao.insertReturn(borrow);
    }

    @Override
    public void updateRenew(Borrow borrow) {
        borrowDao.updateRenew(borrow);
    }

    @Override
    public List<BorrowView> allNotReturn() {
        return borrowDao.allNotReturn();
    }

    @Override
    public List<BorrowView> notReturn(String stu_id) {
        return borrowDao.notReturn(stu_id);
    }

    public void setBorrowDao(IBorrowDao borrowDao) {
        this.borrowDao = borrowDao;
    }

    public IBorrowDao getBorrowDao() {
        return borrowDao;
    }
}
