package com.liwj.keep.controller;

import com.liwj.keep.annotation.JwtIgnore;
import com.liwj.keep.entity.Help;
import com.liwj.keep.entity.RetMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HelpController {
    @JwtIgnore
    @PostMapping("/help/getHelpDetail")
    public RetMessage getHelpDetail(@RequestBody Help help) {
        RetMessage retMessage = new RetMessage();
        retMessage.setData("data------------------"+help.getId());
        retMessage.setResult(true);
        return retMessage;
    }
    @PostMapping("/help/upload")
    public RetMessage upload(@RequestParam("file") MultipartFile[] files){
        RetMessage retMessage = new RetMessage();
        retMessage.setData("data------------------"+files.length);
        retMessage.setResult(true);
        return retMessage;
    }
}
