package com.pmt.controller;

import java.util.ArrayList;
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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.RequestHeaderMapMethodArgumentResolver;
import org.springframework.web.servlet.ModelAndView;










import com.pmt.model.Skill;
import com.pmt.service.SkillService;
import com.pmt.util.response.SimpleResult;

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
	public Response healthCheck(){		
		SimpleResult result = new SimpleResult();
		result.setStatus("Success");
		GenericEntity<SimpleResult> entity = new GenericEntity<SimpleResult>(result){};
		return Response.status(Status.OK).entity(entity).build();
	}

	@GET
	@Path("/skills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSkills() {
		logger.info("Getting skills...");
		//Skill skill = new Skill();
		//skill.setId(23);
		//skill.setCategory("domain");
		//skill.setDescription("Payments");
		//skill.setName("CuscalApi");
		//skillService.addSkill(skill);		
		List<Skill> skills =  skillService.listSkills();
		GenericEntity<List<Skill>> entity = new GenericEntity<List<Skill>>(skills){};		
		return Response.ok(entity).build();
	}
	
	@POST
	@Path("/skills/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSkill(Skill skill){		
		SimpleResult result = new SimpleResult();
		
		try{
		skillService.addSkill(skill);
		result.setStatus("Success");
		}catch(Exception ex){
			result.setStatus("Failure");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(result).build();
		}
				
		GenericEntity<SimpleResult> entity = new GenericEntity<SimpleResult>(result){};
		return Response.ok(entity).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/testrespbld")
	public Response testResponseBuilder(){
		SimpleResult result = new SimpleResult();
		result.setStatus("Failure at server");
		GenericEntity<SimpleResult> entity = new GenericEntity<SimpleResult>(result){};
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(result).build();
	}
	

}
