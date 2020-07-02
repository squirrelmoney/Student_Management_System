package cn.edu.lingnan.util;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//事件处理器


public class XmlHandler extends DefaultHandler
//DefaultHandler类或它的子类的对象称为SAX解析器的事件处理器
{
    private StringBuffer sb=new StringBuffer();//可变字符串
    private HashMap<String,String> hm=new HashMap<String, String>();
    //哈希函数，数组加链表的方式储存
	public HashMap<String,String> getHashMap()
	{//返回哈希映射中的属性包（JSON对象）
		return hm;
	}
	
	/*-----------------第一步：清空StringBuffer---------------------------*/
    public void startElement (String uri, String localName,
    /*第二个执行方法。表示标记的开始*/String qName, Attributes attributes)
    throws SAXException
    {
       sb.delete(0, sb.length());
    }
    /*----------------第二步：把xml的数据写入StringBuffer-----------------------*/
    public void characters (char ch[], int start, int length)  //这个是继startElement方法后的执行方法。
     /*该方法中的ch把所解析的xml的所有数据都保存进来。 
        start是一个节点">"的位置。length就是">"到下一个"<"的长度。 */
        throws SAXException
    {
       sb.append(ch, start, length);
       //append() 方法在被选元素的结尾（仍然在内部）插入指定内容
      
    }
    /*-----------------第三步：把数据存入哈希函数--------------------------*/
    public void endElement (String uri, String localName, String qName)
    //表示标记的结束。若一个节点，比如<name>michael</name>,在执行完characters后会执行该方法。
        throws SAXException
    {
        hm.put(qName.toLowerCase(), sb.toString().trim());
        //qname：带有前缀，hashmap put（）存入数据，key重复，返回旧值
    }


}
