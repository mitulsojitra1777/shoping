package com.srinathji.shoping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "D:\\myproject\\Galaxy-shoping\\shoping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	private static Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		//get real parh
		 REAL_PATH=request.getServletContext().getRealPath("/assets/images/");
		 logger.info("REAL_PATH :"+REAL_PATH);
		 if(!new File(ABS_PATH).exists()){
			 new File(ABS_PATH).mkdirs();
		 }
		 if(!new File(REAL_PATH).exists()){
			 new File(REAL_PATH).mkdirs();
		 }
		 try{
			 //project directoryupload
			 file.transferTo(new File(ABS_PATH+code+".jpg"));
			 //server Upload
			 file.transferTo(new File(REAL_PATH+code+".jpg"));
		 }catch(IOException EX){

		 }
		
	}
}
