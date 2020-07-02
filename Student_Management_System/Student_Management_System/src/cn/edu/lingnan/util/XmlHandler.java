package cn.edu.lingnan.util;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//�¼�������


public class XmlHandler extends DefaultHandler
//DefaultHandler�����������Ķ����ΪSAX���������¼�������
{
    private StringBuffer sb=new StringBuffer();//�ɱ��ַ���
    private HashMap<String,String> hm=new HashMap<String, String>();
    //��ϣ���������������ķ�ʽ����
	public HashMap<String,String> getHashMap()
	{//���ع�ϣӳ���е����԰���JSON����
		return hm;
	}
	
	/*-----------------��һ�������StringBuffer---------------------------*/
    public void startElement (String uri, String localName,
    /*�ڶ���ִ�з�������ʾ��ǵĿ�ʼ*/String qName, Attributes attributes)
    throws SAXException
    {
       sb.delete(0, sb.length());
    }
    /*----------------�ڶ�������xml������д��StringBuffer-----------------------*/
    public void characters (char ch[], int start, int length)  //����Ǽ�startElement�������ִ�з�����
     /*�÷����е�ch����������xml���������ݶ���������� 
        start��һ���ڵ�">"��λ�á�length����">"����һ��"<"�ĳ��ȡ� */
        throws SAXException
    {
       sb.append(ch, start, length);
       //append() �����ڱ�ѡԪ�صĽ�β����Ȼ���ڲ�������ָ������
      
    }
    /*-----------------�������������ݴ����ϣ����--------------------------*/
    public void endElement (String uri, String localName, String qName)
    //��ʾ��ǵĽ�������һ���ڵ㣬����<name>michael</name>,��ִ����characters���ִ�и÷�����
        throws SAXException
    {
        hm.put(qName.toLowerCase(), sb.toString().trim());
        //qname������ǰ׺��hashmap put�����������ݣ�key�ظ������ؾ�ֵ
    }


}
