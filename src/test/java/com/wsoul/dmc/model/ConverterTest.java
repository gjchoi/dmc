package com.wsoul.dmc.model;

import org.junit.Test;

import com.wsoul.dmc.Dmc;

import static org.junit.Assert.*;

public class ConverterTest{
	
	@Test
	public void searchAndSetTest1() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Dmc dmc = new Dmc();
		
		FromModel fromModel = new FromModel();
		fromModel.name = "cyrano";
		fromModel.id = "123";
		fromModel.address = new Address();
		fromModel.address.city = "seoul";
		fromModel.address.detail = "barabra";
		
		ToModel toModel = new ToModel();
		
		dmc.searchAndSet(fromModel.name, toModel, "b");
		dmc.searchAndSet(fromModel.id, toModel, "a");
		dmc.searchAndSet(fromModel.address, toModel, "add");
	
		assertEquals(fromModel.name, toModel.b);
		assertEquals(fromModel.id, toModel.a);
		assertEquals(fromModel.address, toModel.add);
	}
	
	@Test 
	public void covertTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Dmc dmc = new Dmc();
		FromModel fromModel = new FromModel();
		fromModel.name = "cyrano";
		fromModel.id = "123";
		fromModel.address = new Address();
		fromModel.address.city = "seoul";
		fromModel.address.detail = "barabra";

		ToModel result = dmc.convertTo(fromModel, ToModel.class);
		
		assertEquals("cyrano", result.b);
		assertEquals("123", result.a);
		assertEquals(fromModel.address, result.add);
		
	}	

	//TODO
	@Test 
	public void 다른depth모델_컨버팅() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
	}

	//TODO
	@Test 
	public void 형변환_컨버팅() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
	}

	//TODO
	@Test 
	public void 데이터가공excuter사용_컨버팅() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
	}

	//TODO
	@Test 
	public void fromMDC형태_컨버팅() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
	}

}
