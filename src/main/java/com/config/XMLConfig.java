package com.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class XMLConfig {
	public XMLBean xmlObject = new XMLBean();
	public File configFile = new File("src/main/resources/config.xml");
	@Autowired
	public Marshaller marshaller;
	@Autowired
	public Unmarshaller unmarshaller;
	public void writeToXml( ) throws IOException {
		try (FileOutputStream os = new FileOutputStream(configFile);) {
			this.marshaller.marshal(xmlObject, new StreamResult(os));
		}
	}
	public void readFromXml( ) throws IOException {
		try (FileInputStream is = new FileInputStream(configFile);) {
			this.xmlObject = (XMLBean) this.unmarshaller.unmarshal(new StreamSource(is));
		}
	}
	public static void main(String[] args) throws Exception {
		XMLConfig x = new XMLConfig();
		XMLBean xb = new XMLBean();
		xb.setIp("2.2.2.2");
		xb.setPort("6666");
		x.writeToXml( );
	}
}
