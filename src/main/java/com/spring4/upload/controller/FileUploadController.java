package com.spring4.upload.controller;

import com.spring4.upload.model.FileBucket;
import com.spring4.upload.validation.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by thangnguyen-imac on 10/23/16.
 */
@Controller
public class FileUploadController {

    @Autowired
    private FileValidator fileValidator;

    @InitBinder("fileBucket")
    protected void initBinderFileBucket(WebDataBinder binder){
        binder.setValidator(fileValidator);
    }


    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(){
        return "upload/welcome";
    }

    @RequestMapping(value = "/uploadSinglePage", method = RequestMethod.GET)
    public String uploadSinglePage(ModelMap modelMap){
        FileBucket fileBucket = new FileBucket();
        modelMap.addAttribute("fileBucket", fileBucket);
        return "upload/singleFileUploader";

    }

    @RequestMapping(value = "/singleUploadFile", method = RequestMethod.POST)
    public @ResponseBody String singleUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap modelMap){

        if(result.hasErrors()){
            return "upload/singleFileUploader";
        }else {

            MultipartFile file = fileBucket.getFile();

            if(!file.isEmpty()){

                try {
                    byte[] bytes = file.getBytes();
                    // Creating the directory to store file

                    File dir = new File(System.getProperty("catalina.home") + File.separator + "tempFiles");
                    String name =  (fileBucket.getName() == null ? file.getOriginalFilename() : fileBucket.getName());

                    if(!dir.exists()){
                        dir.mkdirs();

                        // Creating file on server

                        File fileServer = new File(dir.getAbsolutePath() + File.separator + name);

                        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileServer));
                        stream.write(bytes);
                        stream.close();
                    }
                    modelMap.addAttribute("fileName", name);

                    return "upload/success";
                }catch (Exception e){

                }
            }else {
                return "upload/failure";
            }
        }

        return "upload/failure";
    }
}
