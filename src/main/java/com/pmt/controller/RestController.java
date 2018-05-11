package com.pmt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

@Controller
@Path("/projmgmt")
public class RestController {
	
	@Autowired
	@Qualifier("skillServiceImpl")
	public SkillService skillService;

	@GET
	@Path("/skills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment() {		
		List<Skill> skills =  skillService.listSkills();
		GenericEntity entity = new GenericEntity<List<Skill>>(skills){};
		return Response.ok(entity).build();

	}
	
	
	
	

}
