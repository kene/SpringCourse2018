package org.certificatic.practica1.interfaces.livingbeing.test;

import org.certificatic.practica1.interfaces.livingbeing.api.IBugEater;
import org.certificatic.practica1.interfaces.livingbeing.api.ILivingBeing;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Aardvark;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Animal;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.Plant;
import org.certificatic.practica1.interfaces.livingbeing.api.impl.VenusFlyTrap;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LivingBeingTest {

	@Test
	public void livingBeingTest() {
		log.info("livingBeingTest -------------------");

		// Implementar
		ILivingBeing livingBeing1 = getLivingBeing(true);
		ILivingBeing livingBeing2 = getLivingBeing(false);
		
		Assert.assertNotNull(livingBeing1);
		Assert.assertNotNull(livingBeing2);
		
		log.info("livingBeing1: {}", livingBeing1);
		log.info("livingBeing2: {}", livingBeing2);
		
		livingBeing1.born();
		livingBeing1.grow();
		livingBeing1.breed();
		livingBeing1.die();
		((IBugEater)livingBeing1).eatBug();
		
		System.out.println("---");
		
		livingBeing2.born();
		livingBeing2.grow();
		livingBeing2.breed();
		livingBeing2.die();
		((IBugEater)livingBeing2).eatBug();
		
		Assert.assertThat(VenusFlyTrap.class.getSimpleName(), 
				CoreMatchers.is(livingBeing1.getClass().getSimpleName()));
		
		Assert.assertTrue(livingBeing1 instanceof VenusFlyTrap);
		Assert.assertTrue(livingBeing1 instanceof Plant);
		Assert.assertTrue(livingBeing1 instanceof IBugEater);
		
		// ----
		
		Assert.assertThat(Aardvark.class.getSimpleName(), 
				CoreMatchers.is(livingBeing2.getClass().getSimpleName()));
		
		Assert.assertTrue(livingBeing2 instanceof Aardvark);
		Assert.assertTrue(livingBeing2 instanceof Animal);
		Assert.assertTrue(livingBeing2 instanceof IBugEater);
		
	}

	private ILivingBeing getLivingBeing(boolean isPlant) {
		 return isPlant ? 
				 	new VenusFlyTrap("planta carnivora") : 
				 	new Aardvark("oso hormiguero");			 
	}

}
