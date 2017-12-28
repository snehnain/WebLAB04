package isep.web.sakila.dao.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import isep.web.sakila.jpa.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	List<Customer> findByLastName(String lastName);
}

