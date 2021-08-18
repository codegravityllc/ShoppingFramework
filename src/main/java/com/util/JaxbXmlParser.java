package com.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbXmlParser {

	public static void main(String args[]) {
		/*
		Person p=new Person();
		p.setAge(10);
		p.setName("jeeuser");
		p.setPassword("jeepwd");
		Address a=new Address();
		a.city="ny123";
		a.state="ny123";
		a.zip=12345;
		Address b=new Address();
		b.city="washington12";
		b.state="was12";
		b.zip=12346;
		Addresses addresses=new Addresses();
		addresses.address.add(a);
		addresses.address.add(b);
		p.setAddresses(addresses);
		object2Xml(p);
		*/
		xml2Obj("C:\\Users\\raghav\\desktop\\test.xml");
	}

	public static void object2Xml(Person person) {
		try {

			File file = new File("C:\\Users\\raghav\\desktop\\test.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(person, file);
			jaxbMarshaller.marshal(person, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void xml2Obj(String filePath) {
		try {

			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Person customer = (Person) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
}
