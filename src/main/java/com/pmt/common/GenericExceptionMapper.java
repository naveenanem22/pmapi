package com.pmt.common;

import static com.pmt.common.PMAPIConstants.REST_STATUS_FAILURE;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pmt.controller.RestController;
import com.pmt.util.response.ResultWithData;

/** This is to catch all unchecked exceptions. This is registered
 * with Jersey using the @Provider annotation  
 *
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	
	private static final Logger logger = LogManager.getLogger(GenericExceptionMapper.class); 

	@Override
	public Response toResponse(Throwable ex) {
		logger.debug(ex);
		ResultWithData result = new ResultWithData();		
		result.setStatus(REST_STATUS_FAILURE);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();
	}

}
