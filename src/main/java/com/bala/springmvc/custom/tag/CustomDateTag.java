package com.bala.springmvc.custom.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomDateTag extends SimpleTagSupport {
	
    private final String DEFAULT_PATTERN = "dd/MM/yyyy H:m:s";


	private String pattern; 

    
    @Override
    public void doTag() throws JspException, IOException {
        final JspWriter writer = getJspContext().getOut();

        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_PATTERN);
        if (pattern != null) {
        	format= new SimpleDateFormat(pattern);
        }
        writer.print(format.format(new Date()));
    }
    
	
    public String getPattern() {
		return pattern;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}