package isep.web.sakila.dao.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import isep.web.sakila.jpa.entities.Film;

public interface FilmRepository extends CrudRepository<Film, Integer>
{
	List<Film> findByTitle(String title);
}

