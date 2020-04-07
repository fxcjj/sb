package com.vic.sb08.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("upload")
@RestController
public class UploadController {
    /**
     * 单个文件上传
     * @param type
     * @param file
     * @return
     */
    @PostMapping(value ="/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestParam(value = "type", required = false) String type,
                           @RequestPart(value="file", required = false) MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "成功！";
    }

    /**
     * 多个文件上传
     * @return
     */
    @PostMapping("saveImg")
    public String saveImg(@RequestParam("files") MultipartFile[] files, int bizType) {
        System.out.println("bizType: " + bizType);
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
        }
        return "成功！";
    }

    @PostMapping("test1")
    public String test1(@RequestParam("bizType") int bizType) {
        System.out.println("bizType: " + bizType);
        return "连通成功！";
    }
}
