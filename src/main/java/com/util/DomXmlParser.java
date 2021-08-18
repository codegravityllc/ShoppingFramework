package com.util;
import java.io.File;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class DomXmlParser {
	public static void main(String args[]) throws Exception
	{
		 File inputFile = new File("C:\\Users\\raghav\\desktop\\test.xml");
		 Document doc=new SAXBuilder().build( inputFile);
		 Element rootEle=doc.getRootElement();
		 System.out.println(rootEle.setAttribute("",""));
		 Element addressesEle=rootEle.getChild("addresses");
		 String idVal=addressesEle.getAttribute("id").getValue();
		 List<Element> addressList=addressesEle.getChildren();
		 for(Element e:addressList)
		 {
			 Element cityEle=e.getChild("city");
			 System.out.println(cityEle.getValue());
		 }
	}
}
