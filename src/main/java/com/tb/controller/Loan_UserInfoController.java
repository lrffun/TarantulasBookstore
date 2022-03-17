package com.tb.controller;


import com.tb.dao.IStudentDao;
import com.tb.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户列表信息
 */

@Controller
@RequestMapping("/admin")
public class Loan_UserInfoController {
    @Autowired
    @Qualifier("studentDaoImpl")
    private IStudentDao studentDao;

    //查询用户信息列表
    @RequestMapping("/userList")
    public String userList(Model model) {
        List<Student> students = studentDao.findAll();
/*        for(TbUser t : userList) {
            System.out.println(t);
        }*/
        model.addAttribute("userList", students);
        return "admin/loan_userList";
    }


    @RequestMapping("/selectStudentByName.action")
    public String selectByName(String name,Model model){
        List<Student> students = studentDao.findStudentsByName("%"+name+"%");
        model.addAttribute("userList", students);
        return "admin/loan_userList";
    }

    //查询黑名单同学列表
    @RequestMapping("/blackList")
    public String blackList(Model model) {
        List<Student> students = studentDao.findAllBlackList();
/*        for(TbUser t : userList) {
            System.out.println(t);
        }*/
        model.addAttribute("userList", students);
        return "admin/loan_blackList";
    }

    //用户信息修改页面
    @RequestMapping("/loan_editUser")
    public String editUser(String id, Model model) {
        Student student = studentDao.findStudentsById(id);
        model.addAttribute("tbUser", student);
        return "admin/loan_editUser";
    }

    //用户信息修改提交
    @RequestMapping("/editUser.action")
    public String editUser(Student tbUser, Model model) {
        studentDao.updateStudent(tbUser);
        //进行数据回显

        return userList(model);
    }
//
//
    //用户删除
    @RequestMapping("/loan_deleteUser")
    public String loan_deleteUser(String id,Model model) {
        try{
            studentDao.deleteStudent(id);
            return userList(model);
        }catch (Exception e) {
            model.addAttribute("errorMsg", "用户有借阅未还，无法删除用户！");
            return "errorMsg";
        }

    }
    //用户加入黑名单
    @RequestMapping("/addBlackList")
    public String addBlackList(String id,Model model) {
        try{
            studentDao.addBlackList(id);
            model.addAttribute("successMsg", "已将该同学加入黑名单。");
            return "errorMsg";
        }catch (Exception e) {
            model.addAttribute("errorMsg", "无法加入黑名单！！");
            return "errorMsg";
        }

    }
    //用户加入黑名单
    @RequestMapping("/outBlackList")
    public String outBlackList(String id,Model model) {
        try{
            studentDao.outBlackList(id);
            model.addAttribute("successMsg", "已将该同学移出黑名单。");
            return "errorMsg";
        }catch (Exception e) {
            model.addAttribute("errorMsg", "无法移出黑名单！！");
            return "errorMsg";
        }

    }
//
    //用户添加
    @RequestMapping("/loan_addUser")
    public String addUser(Student student,Model model) {
        //注册时间
        try{
            studentDao.insertStudent(student);
        }catch (Exception e){
            model.addAttribute("errorMsg", "添加失败，用户已存在！");
            return "errorMsg";
        }

        //not online

        return userList(model);
    }
//
//    //用户列表模糊查询用户信息(用户名)
//    @RequestMapping("/selectLikeName.action")
//    public String Loan_selectLikeName(TbUser tbUser, Model model) {
//        Integer online = null;
//        TbUserQueryVo tbUserQueryVo = new TbUserQueryVo();
//        tbUserQueryVo.setTbUser(tbUser);
//        tbUserQueryVo.setOnline(online);
//        List<TbUser> userList = loan_userInfoList.selectLikeName(tbUserQueryVo);
//        model.addAttribute("userList", userList);
//        return "admin/loan_userList";
//    }
}
