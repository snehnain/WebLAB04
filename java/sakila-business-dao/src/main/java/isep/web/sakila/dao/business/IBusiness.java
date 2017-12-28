package isep.web.sakila.dao.business;

import java.util.List;
import isep.web.sakila.jpa.entities.Actor;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Staff;

public interface IBusiness {
	/*
	 * Actor Function
	 */
	public List<Actor> getAllActors();

	public Actor getByID(int actorId);
	
	/*
	 * Customer Function
	 */
	
	public List<Customer> getAllCustomers();

	public Customer getById(int customerId);
	
	/*
	 * Staff Function 
	 */
	public List<Staff> getAllStaffs();

	public Staff getByStaffId(byte staffId);
	public Staff getByUsername(String userame);
	
	/*
	 * Film Function
	 */
	
	public List<Film> getAllFilms();

	public Film getByFilmId(int filmId);

}
