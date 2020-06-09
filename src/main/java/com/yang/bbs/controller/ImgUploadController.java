package com.yang.bbs.controller;

import com.yang.bbs.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/12 23:02
 */
@RestController
@RequestMapping("/v1")
public class ImgUploadController {

    @Autowired
    private ServerConfig serverConfig;

    @GetMapping("/upload/userList")
    public String userList(){
        return "hello world";
    }


    @PostMapping(value = "/fileUpload")
    public String upload(@RequestParam(value = "file") MultipartFile file){
        ModelAndView modelAndView = new ModelAndView();
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        // 上传后的路径
        String filePath = "E:/upload/";
        //fileName = UUID.randomUUID() + suffixName; // 存库的时候使用
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = "/path/"+fileName;
        modelAndView.addObject("filename",path);
        return serverConfig.getUrl()+path;
    }


}
