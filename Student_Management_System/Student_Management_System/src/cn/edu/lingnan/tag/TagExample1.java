package cn.edu.lingnan.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagExample1 extends TagSupport {
    public int doStartTag() throws JspException {
    	try {
			pageContext.getOut().println("Hello Tag");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return SKIP_BODY;//�Թ���ǩ�壬ֱ��ȥ��doend
    }
    
    public int doEndTag() throws JspException {
    	return EVAL_PAGE;//����ִ������Ķ���
    }
}

