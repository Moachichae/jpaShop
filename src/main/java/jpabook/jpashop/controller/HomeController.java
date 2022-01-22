package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Post;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j //Logger
public class HomeController {

//    Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping("/")
    public String home(){
        log.info("home controller");
        return "home"; //templates.home.html 로 찾아감
    }

    @GetMapping("/smarteditor")
    public String post(){
        return "smarteditor/post";
    }

    @ResponseBody
    @GetMapping("/smarteditor/savePost")
    public ResponseEntity<String> savePost(@RequestParam String content){
        System.out.println("post.getContent() = " + content);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
