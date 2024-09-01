package com.willy.utils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlParserUtils {
	public static<T> List<T> parse(String file , Class<T> targetClass) throws DocumentException {
		ArrayList<T> list = new ArrayList<T>();
		//獲取解析器對象
		SAXReader saxReader = new SAXReader();
		//讀到記憶體中 回傳文檔對象
		Document document = saxReader.read(new File(file));
		//選取root標籤
		Element rootElement = document.getRootElement();
		//選取user標籤
		List<Element> elements = rootElement.elements("emp");
		
		try {
		for (Element element : elements) {
			String name = element.element("name").getText();
			String age = element.element("age").getText();
			String image = element.element("image").getText();
			String gender = element.element("gender").getText();
			String job = element.element("job").getText();
			
			Constructor<T> constructor = targetClass.getDeclaredConstructor(String.class, Integer.class, String.class, String.class, String.class); constructor.setAccessible(true);
			T object = constructor.newInstance(name, Integer.parseInt(age), image, gender, job);
			
			list.add(object);
		}} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		}
	}