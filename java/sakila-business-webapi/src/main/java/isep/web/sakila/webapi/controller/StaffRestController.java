package isep.web.sakila.webapi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isep.web.sakila.webapi.model.StaffWO;
import isep.web.sakila.webapi.service.StaffService;

@RestController
public class StaffRestController
{

	@Autowired
	StaffService							staffService;

	private static final Log	log	= LogFactory.getLog(StaffRestController.class);

	@RequestMapping(value = "/staff/", method = RequestMethod.GET)
	public ResponseEntity<List<StaffWO>> listAllStaffs()
	{
		List<StaffWO> staffs = staffService.findAllStaffs();
		if (staffs.isEmpty())
		{
			return new ResponseEntity<List<StaffWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<StaffWO>>(staffs, HttpStatus.OK);
	}

	@RequestMapping(value = "/staff/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffWO> getStaff(@PathVariable("id") int id)
	{
		System.out.println("Fetching Actor with id " + id);
		StaffWO staffWO = staffService.findById((byte) id);
		if (staffWO == null)
		{
			System.out.println("Staff with id " + id + " not found");
			return new ResponseEntity<StaffWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StaffWO>(staffWO, HttpStatus.OK);
	}

	// -------------------Staff----------------------------------


	@RequestMapping(value = "/staffLogin/", method = RequestMethod.POST)
	public ResponseEntity<StaffWO> loginStaff(@RequestBody StaffWO staffWO, UriComponentsBuilder ucBuilder,HttpSession session,Model model)
	{
		log.error(String.format("Login Staff %s ", staffWO.getUsername(),"and password is %s ",staffWO.getPassword()));
		StaffWO currentStaff = staffService.loginStaff(staffWO.getUsername(),staffWO.getPassword());

		if (currentStaff == null)
		{
			System.out.println("Staff credentials are not correct or not found");
			model.addAttribute("login Error", "Error logging in please try again");
			return new ResponseEntity<StaffWO>(HttpStatus.NOT_FOUND);
		}

		session.setAttribute("loggedinUser", currentStaff);
		return new ResponseEntity<StaffWO>(currentStaff, HttpStatus.OK);
	}

}
