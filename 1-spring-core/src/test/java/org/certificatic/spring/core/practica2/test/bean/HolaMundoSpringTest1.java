package org.certificatic.spring.core.practica2.test.bean;

import org.certificatic.spring.core.practica2.bean.HolaMundo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolaMundoSpringTest1 {

	@Test
	public void holaMundoNoSpringTest() {
		log.info("holaMundoNoSpringTest -------------------------");

		String ruta = "spring/practica2/beans.xml";

		// Implementar IoC con BeanFactory
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(ruta));
		
		HolaMundo hola = (HolaMundo)factory.getBean("holaMundoBean");
		
		Assert.assertNotNull(hola);
		Assert.assertNotNull(hola.getMensaje());
		
		Assert.assertEquals("Hola Mundo con Spring !", hola.getMensaje());
		
		log.info("hola: {}",hola);

	}
}
