package com.sample.postgress.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.google.cloud.vision.v1.*;
import com.sample.postgress.entity.VisitorDetails;
//import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.sample.postgress.service.VisitorDetailsService;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/google")
public class VisionController {
	
	    @Autowired
	    private ResourceLoader resourceLoader;

	    @Autowired
	    private CloudVisionTemplate cloudVisionTemplate;
	   
	    @Autowired
		VisitorDetailsService visitorDetailsService;
	
   
	 @PostMapping("/vision") 
	    public String singleFileUpload(@RequestParam("filename") MultipartFile file, HttpServletRequest request) throws IOException {
		 
				   String ipAddress=request.getRemoteAddr();
				   VisitorDetails visitorDetails=new VisitorDetails(ipAddress);
				   visitorDetailsService.insertVisitorDetails(visitorDetails);
				   List<VisitorDetails> visitorDetailsList=visitorDetailsService.findAll();
				   
				   int count=visitorDetailsList.size();
				   if(count>=450) {
					   return "Google Vision Free Service has been fully utilized: Kindly upgrade your account to enjoy the service";
				   }
		 
	        if (file.isEmpty()) {
	            return "Please select a file";
	        }

	        Path path = null;
	       
	        try {

	          byte[] bytes = file.getBytes();
	          path = Paths.get("src/main/resources/GoogleVision/" + file.getOriginalFilename());
	          Files.write(path, bytes);
			
			
			  Resource imageResource = this.resourceLoader.getResource("file:"+path);
			  AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(
			  imageResource, Feature.Type.DOCUMENT_TEXT_DETECTION);
			  
			  String responseToReturn= response.getFullTextAnnotation().getText();
			 
			  imageResource=null;
			  response=null;
			  System.gc();
			  
			  return responseToReturn;

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
	        return "some error occurred";
	    }

}