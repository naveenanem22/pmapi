package com.pmt.common;

import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;





//import com.owlike.genson.Genson;
//import com.owlike.genson.GensonBuilder;

/**
* This is a supporting class for issues with Date Deserialization/Serialization 
* between JSON and java.util.Date
* 
* @author  Naveen Anem
* @version 1.0
* @since   2017-01-01 
*/
@Provider
public class GensonProvider {/*implements ContextResolver<ObjectMapper>{
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	public GensonProvider() {
    	
    }

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}*/

}


/*@Provider
public class GensonProvider implements ContextResolver<Genson>{
	private final Genson genson = new GensonBuilder()
    .useDateAsTimestamp(false)
    .useDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
    .create();

	@Override
	public Genson getContext(Class<?> type) {
		return genson;	

}*/


