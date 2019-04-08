package com.example.demo.controller;

import com.example.demo.test.MD5AndAES;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * Created by zhang_xubin on 2019/3/29.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(Model model,String param){
//        String param = request.getParameter("param");
//        File file = new File("/WEB-INF/views/hello.jsp");
//        System.out.println(file.getAbsolutePath());
        MD5AndAES mm = new MD5AndAES();
        System.out.println("有请求进入"+param);
        model.addAttribute("res",param);
        model.addAttribute("code",mm.MAndA(mm.md5(param),mm.aes(param)));
        model.addAttribute("code2",mm.MAndA("********************************",mm.aes(param)));
        return "hello";
    }

    @RequestMapping("exit")
    public String exit(){
        System.exit(0);
        return null;
    }

}
