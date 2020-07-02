package cn.edu.lingnan.util;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

//½âÎöÆ÷
public class XmlParser {
   public static HashMap<String,String> perser(String xmlPath){
	   HashMap<String,String> hm=new HashMap<String,String>();
	   String base=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	   xmlPath=base+xmlPath;
	   try { 
		SAXParserFactory spf=SAXParserFactory.newInstance();//1
		SAXParser sp=spf.newSAXParser();//2
		File f=new File(xmlPath);
		XmlHandler xh=new XmlHandler();
		sp.parse(f, xh);//3
		hm=xh.getHashMap();
	} catch (ParserConfigurationException | SAXException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   
	   return hm;
	   
   }
}
