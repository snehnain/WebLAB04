package isep.web.sakila.webapi.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.StaffRepository;
import isep.web.sakila.jpa.entities.Staff;
import isep.web.sakila.webapi.model.StaffWO;;

@Service("staffService")
@Transactional
public class StaffServiceImplementation implements StaffService
{
	@Autowired
	private StaffRepository		staffRepository;

	private static final Log	log	= LogFactory.getLog(StaffServiceImplementation.class);

	public List<StaffWO> findAllStaffs()
	{
		List<StaffWO> staffs = new LinkedList<StaffWO>();

		for (Staff staff : staffRepository.findAll())
		{
			staffs.add(new StaffWO(staff));
			log.debug("Adding " + staff);
		}

		return staffs;
	}

	public StaffWO findById(Byte id)
	{
		log.debug(String.format("Looking for staff by Id %s", id));
		Staff staff = staffRepository.findOne(id);

		if (staff != null)
		{
			return new StaffWO(staff);
		}
		return null;
	}
	
	/*public void loggingStaff(StaffWO staffWO)
	{
		Staff staff2login = staffRepository.findOne(staffWO.getStaffId());
		if((staff2login.getUsername()==staffWO.getUsername())&&(staff2login.getPassword()==staffWO.getPassword())){
			System.out.println("Staff member "+staffWO+" exists");
		}
		else{
			System.out.println("Staff member doesn't exists");
		}
	}*/

	@Override
	public StaffWO loginStaff(String username, String password) {
		// TODO Auto-generated method stub
		Staff staff = staffRepository.findByUsername(username);
		if(staff!=null&&staff.getPassword().equals(password)){
			return new StaffWO(staff);
		}
		
		return null;
	}


}
