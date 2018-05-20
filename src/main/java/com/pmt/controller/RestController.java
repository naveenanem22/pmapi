package com.pmt.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pmt.model.Skill;
import com.pmt.service.SkillService;
import com.pmt.util.response.ResultWithData;
import com.pmt.util.response.ResultWithData;

import static com.pmt.common.PMAPIConstants.*;

/**
* This is the main controller handling all the request and response
* for various APIs across the application. 
* 
* @author  Naveen Anem
* @version 1.0
* @since   2017-01-01 
*/
@Controller
@Path("/projmgmt/V1/")
public class RestController {
	
	private static final Logger logger = LogManager.getLogger(RestController.class);
	
	@Autowired
	@Qualifier("skillServiceImpl")
	private SkillService skillService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/healthcheck")
	public Response healthCheck() {
		
		ResultWithData result = new ResultWithData();
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.OK).entity(entity).build();
	}

	@GET
	@Path("/skills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSkills() {		
		ResultWithData result = new ResultWithData();
		
		List<Skill> skills =  skillService.listSkills();
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(skills);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};		
		return Response.ok(entity).build();
	}
	
	@POST
	@Path("/skills/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSkill(Skill skill){		
		ResultWithData result = new ResultWithData();
		
		try{
		skillService.addSkill(skill);
		result.setStatus(REST_STATUS_SUCCESS);
		}catch(Exception ex){
			result.setStatus(REST_STATUS_FAILURE);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(result).build();
		}
				
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.ok(entity).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/testrespbld")
	public Response testResponseBuilder(){		
		ResultWithData result = new ResultWithData();		
		result.setStatus(REST_STATUS_FAILURE);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();
	}
	
	@ExceptionHandler(Exception.class)
	public Response localExceptionHandler(){
		ResultWithData result = new ResultWithData();		
		result.setStatus(REST_STATUS_FAILURE);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();
	}
	

}
