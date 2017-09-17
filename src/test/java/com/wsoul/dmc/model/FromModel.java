package com.wsoul.dmc.model;

import com.wsoul.dmc.anno.DMC_TO;

import lombok.Data;

@Data
public class FromModel {

	@DMC_TO( to = ToModel.class, path = "b")
	String name;
	
	@DMC_TO( to = ToModel.class, path = "a")
	String id;
	
	@DMC_TO( to = ToModel.class, path = "add")	
	Address address;
	
}
