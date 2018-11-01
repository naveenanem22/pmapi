package com.pmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
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
import com.pmt.model.Businessunit;
import com.pmt.model.EmpAddress;
import com.pmt.model.EmpEducation;
import com.pmt.model.EmpPassport;
import com.pmt.model.EmpPrevEmployment;
import com.pmt.model.EmpSkill;
import com.pmt.model.Employee;
import com.pmt.model.Visa;
import com.pmt.service.BusinessunitService;
import com.pmt.service.EmpAddressService;
import com.pmt.service.EmpEducationService;
import com.pmt.service.EmpPassportService;
import com.pmt.service.EmpPrevEmploymentService;
import com.pmt.service.EmpSkillService;
import com.pmt.service.EmployeeService;
import com.pmt.service.VisaService;
import com.pmt.util.response.ResultWithData;
import static com.pmt.common.PMAPIConstants.*;

/**
 * This is the main REST-Controller handling all the requests and responses for
 * various APIs across the application.
 * 
 * The role is to receive and process requests from Dispatcher Servlet -
 * com.sun.jersey.spi.spring.container.servlet.SpringServlet - declared as part
 * of web.xml.
 * 
 * @author Naveen Anem
 * @version 1.0
 * @since 2017-01-01
 */
@Controller
@Path("/projmgmt/V1/")
public class RestController {

	private static final Logger logger = LogManager.getLogger(RestController.class);

	@Autowired
	@Qualifier("businessunitServiceImpl")
	private BusinessunitService businessunitService;

	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;

	@Autowired
	@Qualifier("empEducationServiceImpl")
	private EmpEducationService empEducationService;

	@Autowired
	@Qualifier("visaServiceImpl")
	private VisaService visaService;

	@Autowired
	@Qualifier("empSkillServiceImpl")
	private EmpSkillService empSkillService;

	@Autowired
	@Qualifier(value = "empPrevEmploymentServiceImpl")
	private EmpPrevEmploymentService empPrevEmploymentService;

	@Autowired
	@Qualifier(value = "empPassportServiceImpl")
	private EmpPassportService empPassportService;

	@Autowired
	@Qualifier(value = "empAddressServiceImpl")
	private EmpAddressService empAddressService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/healthcheck")
	public Response healthCheck() {

		ResultWithData result = new ResultWithData();
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	/********** BusinessUnit APIs start ***********/

	@GET
	@Path("/businessunits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBusinessunits() {
		ResultWithData result = new ResultWithData();
		List<Businessunit> businessunits = businessunitService.listBusinessunits();
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(businessunits);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/businessunits")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBusinessunit(Businessunit businessunit) {
		ResultWithData result = new ResultWithData();
		businessunitService.addBusinessunit(businessunit);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/businessunits")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBusinessunit(Businessunit businessunit) {
		ResultWithData result = new ResultWithData();
		businessunitService.updateBusinessunit(businessunit);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/businessunits/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeBusinessunit(@PathParam("id") int id) {
		ResultWithData result = new ResultWithData();
		businessunitService.removeBusinessunit(id);
		result.setStatus(REST_STATUS_SUCCESS);
		return Response.status(Status.OK).entity(new GenericEntity<ResultWithData>(result) {
		}).build();
	}

	/********** BusinessUnit APIs end ***********/

	/********** Location APIs Start ***********/

	/********** Location APIs End ***********/

	/********** Employee APIs Start ***********/
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployees() {
		ResultWithData result = new ResultWithData();
		List<Employee> employees = employeeService.listEmployees();
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(employees);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/employees")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(@Valid Employee employee) {
		ResultWithData result = new ResultWithData();
		employeeService.addEmployee(employee);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/employees/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@Valid Employee employee, @PathParam("id") int employeeId) {
		ResultWithData result = new ResultWithData();
		employeeService.updateEmployee(employee, employeeId);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/employees/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeEmployee(@PathParam("id") int employeeId) {
		ResultWithData result = new ResultWithData();
		employeeService.removeEmployee(employeeId);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	/********** Employee APIs End ***********/

	/********** EmpEducation APIs Start ***********/
	@GET
	@Path("/employees/{id}/qualifications")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmpEducations(@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		// EmpEducation empEducation = empEducationService.getEmpEducationById(id);
		List<EmpEducation> empEducations = empEducationService.listEmpEducationsByEmployeeId(employeeId);
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(empEducations);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/employees/{id}/qualifications")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmpEducations(@Valid List<EmpEducation> empEducations, @PathParam("id") String empId) {
		ResultWithData result = new ResultWithData();
		empEducations.forEach(empEducation -> {
			empEducationService.addEmpEducation(empEducation, empId);
		});
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/employees/{id}/qualifications")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmpEducations(@Valid List<EmpEducation> empEducations, @PathParam("id") String empId) {
		ResultWithData result = new ResultWithData();
		empEducationService.updateEmpEducationsByEmployeeId(empEducations, empId);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/employees/{empId}/qualifications/{qualId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeEmpEducation(@PathParam("empId") String empId, @PathParam("qualId") String educationId) {
		ResultWithData result = new ResultWithData();
		if (empEducationService.removeEmpEducation(empId, educationId) == 1) {
			result.setStatus(REST_STATUS_SUCCESS);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.OK).entity(entity).build();

		}

		else {
			result.setStatus(REST_STATUS_FAILURE);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();
		}

	}

	@DELETE
	@Path("/employees/{empId}/qualifications")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeEmpEducations(Set<String> educationIds, @PathParam("empId") String empId) {
		ResultWithData result = new ResultWithData();

		if (empEducationService.removeEmpEducations(empId, educationIds) == educationIds.size()) {
			result.setStatus(REST_STATUS_SUCCESS);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.OK).entity(entity).build();
		} else {
			result.setStatus(REST_STATUS_FAILURE);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();
		}

	}

	/********** EmpEducation APIs End ***********/

	/********** Visa APIs Start ***********/
	@GET
	@Path("/employees/{id}/visas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisas(@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		Map<String, List<Visa>> empVisas = new HashMap<String, List<Visa>>();
		empVisas.put(employeeId, visaService.listVisasByEmployeeId(employeeId));
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(empVisas);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/employees/{id}/visas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addVisas(@Valid List<Visa> visas, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		visas.forEach(visa -> {
			visaService.addVisa(visa, employeeId);
		});
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/employees/{id}/visas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateVisas(@Valid List<Visa> visas, @PathParam("id") String empId) {
		ResultWithData result = new ResultWithData();
		visaService.updateVisasByEmployeeId(visas, empId);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/employees/{empId}/visas/{visaId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeVisa(@PathParam("empId") String empId, @PathParam("visaId") String visaId) {
		ResultWithData result = new ResultWithData();
		if (visaService.removeVisa(empId, visaId) == 1) {
			result.setStatus(REST_STATUS_SUCCESS);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.OK).entity(entity).build();

		}

		else {
			result.setStatus(REST_STATUS_FAILURE);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();
		}

	}

	@DELETE
	@Path("/employees/{empId}/visas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeVisas(Set<String> visaIds, @PathParam("empId") String empId) {
		ResultWithData result = new ResultWithData();

		if (visaService.removeVisas(empId, visaIds) == visaIds.size()) {
			result.setStatus(REST_STATUS_SUCCESS);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.OK).entity(entity).build();
		} else {
			result.setStatus(REST_STATUS_FAILURE);
			GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
			};
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(entity).build();
		}

	}

	/********** Visa APIs End ***********/

	/********** Employee-Skill APIs Start ***********/
	@GET
	@Path("/employees/{id}/skills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSkills(@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		Map<String, List<EmpSkill>> empSkills = new HashMap<String, List<EmpSkill>>();
		empSkills.put(employeeId, empSkillService.listSkillsById(employeeId));
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(empSkills);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/employees/{id}/skills")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSkills(@Valid Set<EmpSkill> empSkills, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empSkillService.addSkills(employeeId, empSkills);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/employees/{id}/skills")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSkills(@Valid Set<EmpSkill> empSkills, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empSkillService.updateSkillsByEmployeeId(employeeId, empSkills);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/employees/{empId}/skills")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSkills(Set<String> skillIds, @PathParam("empId") String employeeId) {
		ResultWithData result = new ResultWithData();
		empSkillService.removeSkills(employeeId, skillIds);

		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();

	}

	/********** Employee-Skill APIs End ***********/

	/********** Employee-Previous Employment History APIs Start ***********/
	@GET
	@Path("/employees/{id}/prevEmployers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrevEmploymentRecords(@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		Map<String, List<EmpPrevEmployment>> empPrevEmployments = new HashMap<String, List<EmpPrevEmployment>>();
		empPrevEmployments.put(employeeId, empPrevEmploymentService.listPrevEmploymentsByEmployeeId(employeeId));
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(empPrevEmployments);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/employees/{id}/prevEmployers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPrevEmploymentRecords(@Valid Set<EmpPrevEmployment> empPrevEmployments,
			@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empPrevEmploymentService.addPrevEmployments(employeeId, empPrevEmployments);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/employees/{id}/prevEmployers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePrevEmploymentRecords(@Valid Set<EmpPrevEmployment> empPrevEmployments,
			@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empPrevEmploymentService.updatePrevEmployments(employeeId, empPrevEmployments);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/employees/{id}/prevEmployers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removePrevEmploymentRecords(@Valid Set<EmpPrevEmployment> empPrevEmployments,
			@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empPrevEmploymentService.removePrevEmployments(employeeId, empPrevEmployments);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();

	}

	/********** Employee-Previous Employment History APIs End ***********/

	/********** Employee-Passport APIs Start ***********/
	@GET
	@Path("/employees/{id}/passport")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPassport(@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		Map<String, EmpPassport> empPassport = new HashMap<String, EmpPassport>();
		empPassport.put(employeeId, empPassportService.getPassport(employeeId));
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(empPassport);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/employees/{id}/passport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPassport(@Valid EmpPassport empPassport, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empPassportService.addPassport(empPassport, employeeId);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/employees/{id}/passport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePassport(@Valid EmpPassport empPassport, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empPassportService.updatePassport(empPassport, employeeId);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/employees/{id}/passport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removePassport(@Valid EmpPassport empPassport, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empPassportService.removePassport(employeeId, empPassport.getPassportNumber());
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();

	}

	/********** Employee-Passport APIs End ***********/

	/********** Employee-Address APIs Start ***********/
	@GET
	@Path("/employees/{id}/empAddresses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmpAddresses(@PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		Map<String, List<EmpAddress>> empAddresses = new HashMap<String, List<EmpAddress>>();
		empAddresses.put(employeeId, empAddressService.listEmpAddresses(employeeId));
		result.setStatus(REST_STATUS_SUCCESS);
		result.setData(empAddresses);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@POST
	@Path("/employees/{id}/empAddresses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmpAddresses(@Valid Set<EmpAddress> empAddresses, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empAddressService.addEmpAddresses(employeeId, empAddresses);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@PUT
	@Path("/employees/{id}/empAddresses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmpAddresses(@Valid Set<EmpAddress> empAddresses, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empAddressService.updateEmpAddresses(employeeId, empAddresses);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("/employees/{id}/empAddresses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeEmpAddresses(@Valid Set<EmpAddress> empAddresses, @PathParam("id") String employeeId) {
		ResultWithData result = new ResultWithData();
		empAddressService.removeEmpAddresses(employeeId, empAddresses);
		result.setStatus(REST_STATUS_SUCCESS);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();

	}

	/********** Employee-Address APIs End ***********/

	/* This for developer testing that need to be deleted if no more necessary */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/testrespbld")
	public Response testResponseBuilder() {
		String[] forex = { "first", "second" };
		ResultWithData result = new ResultWithData();
		result.setStatus(forex[5]);
		GenericEntity<ResultWithData> entity = new GenericEntity<ResultWithData>(result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

}
