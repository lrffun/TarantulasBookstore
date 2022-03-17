package com.tb.controller;

import com.tb.dao.IAdministratorDao;
import com.tb.dao.IStudentDao;
import com.tb.domain.Administrator;
import com.tb.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("studentDaoImpl")
    public IStudentDao studentDaoImpl;

    @Autowired
    @Qualifier("administratorDaoImpl")
    public IAdministratorDao administratorDao;

//    @RequestMapping("/checkLogin")
//    public String checkLogin(Student student, Model model){
//        //调用service方法
//        Student student1 = studentDaoImpl.login(student);
//        //若有user则添加到model里并且跳转到成功页面
//        if(student1.getName() != null){
//            model.addAttribute("student",student1);
//            System.out.println("登陆成功！！"+student1.toString());
//            return "admin/admin";
//        }else{
//            return "fail";
//        }
//
//    }

    @RequestMapping("/checkLogin")
    public String checkLogin(String id, String password, HttpSession session, Model model){
        //调用service方法
        Administrator administrator = new Administrator();
        administrator.setId(id);
        administrator.setPassword(password);
        administrator = administratorDao.login(administrator);
        Student student = new Student();
        student.setId(id);
        student.setPassword(password);
        student = studentDaoImpl.login(student);

        try{
            if (administrator != null){
                model.addAttribute("student",administrator);
                System.out.println("登陆成功！！"+administrator.toString());
                return "admin/admin";
            }else if(student.getName() != null){
                model.addAttribute("student",student);
                System.out.println("登陆成功！！"+student.toString());
                return "user/user";
            }else{
                model.addAttribute("errorMsg","用户不存在或密码错误，请重新登录！");
                return "errorMsg";
            }
        }catch (Exception e){
            model.addAttribute("errorMsg","用户不存在或密码错误，请重新登录！");
            return "errorMsg";
        }

    }



    @RequestMapping("/loginOut.action")
    public String loginOut(Model model){
        return "../../index";
    }

    @RequestMapping("/toChangePassword")
    public String toChangePassword(String id,Model model){
        model.addAttribute("id",id);
        return "user/changePassword";
    }
    @RequestMapping("/changePassword")
    public String changePassword(String password,String id,Model model){
        studentDaoImpl.changePassword(password,id);
        System.out.println(id+"@"+password);
        model.addAttribute("successMsg","密码修改成功！");
        return "errorMsg";
    }
}