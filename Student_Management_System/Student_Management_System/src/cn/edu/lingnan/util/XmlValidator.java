package cn.edu.lingnan.util;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;


public class XmlValidator {
//��֤xml�ļ�����Ч��
	public static boolean validate(String xmlPath,String xsdPath){
		boolean flag=false;
		String base=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath=base+xmlPath;
		xsdPath=base+xsdPath;
		try {
			//1.����ģʽ����Schemafactory
			SchemaFactory sf=SchemaFactory.newInstance
					("http://www.w3.org/2001/XMLSchema");
		    //2.ͨ��XSD�ļ�����ģʽSchema
			File f=new File(xsdPath);
			Schema s = sf.newSchema(f);
			 //3.��ģʽ������֤��validator����
			Validator v=s.newValidator();
			//4.ʹ����֤����֤xml�ļ�
			Source so= new StreamSource(xmlPath);
			v.validate(so);
			flag=true;
			
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("xml�ļ���֤ʧ��");
			e.printStackTrace();
		}
      
		return flag;
	}
}