package isep.web.sakila.dao.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import isep.web.sakila.dao.repositories.ActorRepository;
import isep.web.sakila.jpa.entities.Actor;
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Staff;

import isep.web.sakila.dao.repositories.StaffRepository;

@Service("business")
public class Business implements IBusiness
{
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private FilmRepository filmRepository;

	/*-----------------------------------------------------
	 * Actor Function
	 */
	
	@Override
	public List<Actor> getAllActors()
	{
		return Lists.newArrayList(actorRepository.findAll());
	}

	public Actor getByID(int actorId)
	{
		return actorRepository.findOne(actorId);
	}
	/*
	 * End of Actor Function
	 */
	
	/*-------------------------------------------------------
	 * Customer Function
	 */
	@Override
	public List<Customer> getAllCustomers()
	{
		return Lists.newArrayList(customerRepository.findAll());
	}
	
	public Customer getById(int customerId)
	{
		return customerRepository.findOne(customerId);
	}
	/*
	 * End of Customer Function
	 */

	/*--------------------------------------------------------
	 * Staff Function
	 */
	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(staffRepository.findAll());
	}

	@Override
	public Staff getByStaffId(byte staffId) {
		// TODO Auto-generated method stub
		return staffRepository.findOne(staffId);
	}
	
	public Staff getByUsername(String userame)
	{
		return staffRepository.findByUsername(userame);
	}
	/*
	 * End of Staff Function
	 */

	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(filmRepository.findAll());
	}

	@Override
	public Film getByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return filmRepository.findOne(filmId);
	}
	
}

