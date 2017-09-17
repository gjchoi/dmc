package com.wsoul.dmc;

import java.lang.reflect.Field;
import java.security.InvalidParameterException;

import com.wsoul.dmc.anno.DMC_TO;

public class Dmc{

	public <T> T convertTo(Object fromObj, Class<T> toClass) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		T toObj = toClass.newInstance();
	
		Field[] fields = fromObj.getClass().getDeclaredFields();
		for(Field f : fields) {
			DMC_TO anno = f.getDeclaredAnnotation(DMC_TO.class);
			if(toClass.equals(anno.to())){
				f.setAccessible(true);
				searchAndSet(f.get(fromObj), toObj, anno.path());
			}			
		}
		
		return toObj;
	}
	
	public <T> T convertFrom(Object fromObj, Class<T> toClass) throws Exception{
		throw new Exception("Not Yet");
		
	}
	
	public void searchAndSet(Object fromData, Object toModel, String toPath) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field targetField = null;
		Object parentFieldObj = null;
		Object targetFieldObj = toModel;
		
		for(String path : parseToPath(toPath)){
			parentFieldObj = targetFieldObj;
			targetField = targetFieldObj.getClass().getDeclaredField(path);
			targetField.setAccessible(true);
			targetFieldObj = targetField.get(targetFieldObj);
		}
		
		setField(targetField, fromData, parentFieldObj);
	}
	
	private void setField(Field toField, Object data, Object toParent) throws IllegalArgumentException, IllegalAccessException{
		toField.setAccessible(true);
		toField.set(toParent, data);
	}
	
	private String[] parseToPath(String toPath){
		if(toPath == null) throw new InvalidParameterException("Tager Filed Path Name Required");
		return toPath.split("\\.");
	}
}
