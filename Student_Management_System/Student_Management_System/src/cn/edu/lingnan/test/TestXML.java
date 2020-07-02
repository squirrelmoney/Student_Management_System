package cn.edu.lingnan.test;

import java.util.HashMap;

import cn.edu.lingnan.util.XmlParser;
import cn.edu.lingnan.util.XmlValidator;

public class TestXML {
	   public static void main(String[] args) {
		   String xmlpath="database.conf.xml";
		   String xsdpath="database.conf.xsd";
		if(XmlValidator.validate(xmlpath, xsdpath)){
			HashMap<String,String> hm=XmlParser.perser(xmlpath);
			System.out.println(hm.get("driver"));
			System.out.println(hm.get("password"));
		}
	}
}
