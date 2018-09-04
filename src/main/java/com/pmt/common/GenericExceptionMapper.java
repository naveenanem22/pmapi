package com.pmt.common;

import static com.pmt.common.PMAPIConstants.REST_STATUS_FAILURE;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.ApplicationContext;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.pmt.util.propertyfilehandlers.AppErrorProperties;
import com.pmt.util.response.ResultWithData;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * Global exception-mapper to catch unchecked exceptions across all the REST
 * APIs part of pmapi. This is registered with Jersey using the @Provider
 * annotation.
 * 
 * Eg: If add or update skill operation fails at Service/DAO/Controller layer
 * for unknown reasons, a default response - 500 equivalent Internal Server
 * Error - is built and posted back to client.
 * 
 * 
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	private static final Logger logger = LogManager.getLogger(GenericExceptionMapper.class);

	/**
	 * @return {"data": null, "status": "Success"}
	 */
	@Override
	public Response toResponse(Throwable ex) {
		ResultWithData result = new ResultWithData();
		
		AppErrorProperties aep = new ApplicationContextProvider().getApplicationContext().getBean("appErrorProp",
				AppErrorProperties.class);
		if (ExceptionUtils.indexOfType(ex, MySQLIntegrityConstraintViolationException.class) != -1) {
			ExceptionUtils.getThrowableList(ex).forEach(exception -> {
				if (exception instanceof MySQLIntegrityConstraintViolationException) {
					Stream<String> fkStream = Arrays
							.stream(aep.getProperty("db.fk_on_employeeId").split(aep.getProperty("global.delimiter")));
					if (fkStream.anyMatch(fkName -> {
						return exception.getMessage().contains(fkName);
					})) {
						result.setData(aep.getProperty("db.fk_on_employeeId.msg"));
						result.setStatus(REST_STATUS_FAILURE);

					}
				}

			});
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.BAD_REQUEST).entity(entity).build();
		}
		else {
			result.setData("Failed for unknown reasons");
			result.setStatus(REST_STATUS_FAILURE);
		}

		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();

	}

}
