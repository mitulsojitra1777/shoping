package com.srinathji.shoping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.srinathji.shopngback.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product=(Product)target;
		//where file hah bin selecated or not
		if (product.getFile()==null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "plese select immage file to upload");
			return;
		}
		if(!(product.getFile().getContentType().equals("image/jpeg")||
			product.getFile().getContentType().equals("image/png")||
			product.getFile().getContentType().equals("image/gif"))
		){
			errors.rejectValue("file", null, "plese select only image file for upload");
			return;
			
		}

	}

}
