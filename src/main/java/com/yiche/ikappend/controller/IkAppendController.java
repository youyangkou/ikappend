package com.yiche.ikappend.controller;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * @author kouyy
 */
@RestController
public class IkAppendController {

    private static final Logger logService = LogManager.getLogger(IkAppendController.class);

    private static String filePath="/root/softwer/apache-tomcat-7.0.68/webapps/ROOT/hot.dic";

    @GetMapping(value = "ikAppend/{word}")
    public String appendIkWord(@PathVariable("word")  String word){
        File file= null;
        try {
            file = new File(filePath);
            List<String> words = FileUtils.readLines(file, "utf-8");
            for (String str : words) {
                if(word.equals(str)){
                    return "要添加的新词在ik文件中已存在，请不要重复添加！";
                }
            }
            FileUtils.writeStringToFile(file,word+"\r\n","utf-8",true);
            logService.info("ik远程词库添加新词成功："+word);
            return "ik远程词库添加新词成功："+word;
        } catch (Exception e) {
            logService.error("ik远程词库添加新词失败"+e);
            return "ik远程词库添加新词失败";
        }
    }
}
