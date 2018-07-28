package com.pmt.common;

import static com.pmt.common.PMAPIConstants.REST_STATUS_FAILURE;

import java.util.Collections;
import java.util.List;

import javax.persistence.PersistenceException;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.spi.ResponseErrorMapper;
import org.hibernate.exception.ConstraintViolationException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.pmt.util.response.ResultWithData;

/** Global exception-mapper to catch unchecked exceptions across all the REST APIs part of pmapi.
 * This is registered with Jersey using the @Provider annotation.
 * 
 *  Eg: If add or update skill operation fails at Service/DAO/Controller layer for unknown reasons, a default
 *  response - 500 equivalent Internal Server Error - is built and posted back to
 *  client.
 * 
 * 
 */
@Provider
public class PersistenceExceptionMapper /*implements ResponseErrorMapper*/{/*
	
	private static final Logger logger = LogManager.getLogger(PersistenceExceptionMapper.class); 

	*//** 
	* @return {"data": null, "status": "Success"}
	*//*
	@Override
	public Response toResponse(Throwable ex) {
		logger.debug("Naveen caught...key violations...");
		return Response.status(Response.Status.BAD_REQUEST)
                .entity(Collections.singletonMap("errors",
                        Collections.singletonMap("message", getMessage((ConstraintViolationException) ex))))
                .build();		
		
	}	
	
	private List<String> getMessage(ConstraintViolationException e) {

		logger.error(e.getMessage(), e);

        // a hack to convert exception to friendly error message
        if ("fk_edu_empid_emp_id".equalsIgnoreCase(e.getConstraintName())) {
            return Collections.singletonList("Failed to delete category due to references to existing budget(s).");
        } else if ("fk_transactions_budgets".equalsIgnoreCase(e.getConstraintName())) {
            return Collections.singletonList("Failed to delete budget due to references to existing transaction(s).");
        }
        return Collections.singletonList(e.getMessage());
    }*/
	

}
