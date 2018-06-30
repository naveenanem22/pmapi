package com.pmt.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component(value="validationError")
public class ValidationError {
	
	private String propertyPath;    
    private String errCode;
    private String userMsg;
    private String developerMsg;
    private String moreInfo;
    
    public ValidationError(){
    	
    }

	public String getPropertyPath() {
		return propertyPath;
	}

	public void setPropertyPath(String propertyPath) {
		this.propertyPath = propertyPath;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getUserMsg() {
		return userMsg;
	}

	public void setUserMsg(String userMsg) {
		this.userMsg = userMsg;
	}

	public String getDeveloperMsg() {
		return developerMsg;
	}

	public void setDeveloperMsg(String developerMsg) {
		this.developerMsg = developerMsg;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
    
    
}
