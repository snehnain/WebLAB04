package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.StaffWO;

public interface StaffService
{
	StaffWO findById(Byte id);

	List<StaffWO> findAllStaffs();
	
	StaffWO loginStaff(String username,String password);

}
