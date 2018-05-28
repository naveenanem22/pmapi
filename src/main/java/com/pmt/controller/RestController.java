package com.pmt.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

import com.pmt.model.Businessunit;
import com.pmt.model.Skill;
import com.pmt.service.BusinessunitService;
import com.pmt.service.SkillService;
import com.pmt.util.response.ResultWithData;
import com.pmt.util.response.ResultWithData;

import static com.pmt.common.PMAPIConstants.*;

/**
* This is the main REST-Controller handling all the requests and responses
* for various APIs across the application. 
* 
* The role is to receive and process requests from Dispatcher Servlet - 
* com.sun.jersey.spi.spring.container.servlet.SpringServlet - declared as part of
* web.xml. 
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
	
	@Autowired
	@Qualifier("businessunitServiceImpl")
	private BusinessunitService businessunitService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/healthcheck")
	public Response healthCheck(){
		
		ResultWithData result = new ResultWithData();
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	/**********Skill APIs start***********/

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
	@Path("/skills")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSkill(Skill skill){		
		ResultWithData result = new ResultWithData();		
		skillService.addSkill(skill);
		result.setStatus(REST_STATUS_SUCCESS);				
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.ok(entity).build();
	}
	
	@DELETE
	@Path("/skills/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSkill(@PathParam("id") int id){
		ResultWithData result = new ResultWithData();
		skillService.removeSkill(id);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.ok(entity).build();
	}
	
	@PUT
	@Path("/skills")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSkill(Skill skill){
		ResultWithData result= new ResultWithData();
		skillService.updateSkill(skill);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.ok(entity).build();
	}
	
	/**********Skill APIs end***********/
	
	/**********BusinessUnit APIs start***********/
	
	@GET
	@Path("/businessunits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBusinessunits(){
		ResultWithData result = new ResultWithData();
		List<Businessunit> businessunits = businessunitService.listBusinessunits();
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(businessunits);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@POST
	@Path("/businessunits")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBusinessunit(Businessunit businessunit){
		ResultWithData result = new ResultWithData();
		businessunitService.addBusinessunit(businessunit);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@PUT
	@Path("/businessunits")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBusinessunit(Businessunit businessunit){
		ResultWithData result = new ResultWithData();		
		businessunitService.updateBusinessunit(businessunit);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@DELETE
	@Path("/businessunits/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeBusinessunit(@PathParam("id") int id){
		ResultWithData result = new ResultWithData();
		businessunitService.removeBusinessunit(id);
		result.setStatus(REST_STATUS_SUCCESS);		
		return Response.status(Status.OK)
				.entity(new GenericEntity<ResultWithData>(result){})
				.build();
	}
	
	
	
	/**********BusinessUnit APIs end***********/
	
	/*This for developer testing that need to be deleted if no more necessary*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/testrespbld")
	public Response testResponseBuilder(){
		String[] forex = {"first","second"};
		
		ResultWithData result = new ResultWithData();		
		result.setStatus(forex[5]);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result){};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	
	
	
	

}
