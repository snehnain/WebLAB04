package isep.web.sakila;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SakilaBusinessDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaBusinessDaoApplication.class, args);
	}
}*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import isep.web.sakila.dao.business.IBusiness;
import isep.web.sakila.jpa.config.PersistenceConfig;
import isep.web.sakila.jpa.entities.Actor;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.Staff;;

@SpringBootApplication
public class SakilaBusinessDaoApplication
{

	public static void main(String[] args)
	{
		// We prepare the Spring Configuration
		SpringApplication app = new SpringApplication(PersistenceConfig.class);
		app.setLogStartupInfo(false);

		// We launch the Application Context
		ConfigurableApplicationContext context = app.run(args);
		// Business Layer
		IBusiness business = context.getBean(IBusiness.class);

		/*-----------------------------------------------------
		 * Actor Function
		 */
		try
		{
			for (Actor actor : business.getAllActors())
			{
				System.out.println(actor);
			}

			Actor guiness = business.getByID(1);
			System.out.printf("Who is ID 1? %s %s %n", guiness.getLastName(), guiness.getFirstName());

		} catch (Exception ex)
		{
			System.out.println("Exception : " + ex.getCause());
		}
		/*
		 * End of Actor Function
		 */
		
		/*-------------------------------------------------------
		 * Customer Function
		 */
		try
		{
			for (Customer customer : business.getAllCustomers())
			{
				System.out.println(customer);
			}

			Customer smith = business.getById(1);
			System.out.printf("Show firstname and lastname of CustomerID 1? %s %s %n", smith.getFirstName(), smith.getLastName());

		} catch (Exception ex)
		{
			System.out.println("Exception : " + ex.getCause());
		}
		/*
		 * End of Customer Function
		 */

		/*--------------------------------------------------------
		 * Staff Function
		 */
		try
		{
			for (Staff staff : business.getAllStaffs())
			{
				System.out.println(staff);
			}

			Staff stephens = business.getByStaffId((byte) 3);
			System.out.printf("Show username and password of StaffID 3? %s %s %n", stephens.getUsername(), stephens.getPassword());

			Staff checkname = business.getByUsername("Mike");
			System.out.println("FIRST NAME :"+checkname.getFirstName());
			
		} catch (Exception ex)
		{
			System.out.println("Exception : " + ex.getCause());
		}
		/*
		 * End of Staff Function
		 */
		
		/*--------------------------------------------------------
		 * Film Function
		 */
		try
		{
			for (Film film : business.getAllFilms())
			{
				System.out.println(film);
			}

			Film stephens = business.getByFilmId(1);
			System.out.printf("Show title of FilmID 1? %s %n", stephens.getTitle());
			
		} catch (Exception ex)
		{
			System.out.println("Exception : " + ex.getCause());
		}
		/*
		 * End of Film Function
		 */
		
		
		// Closing Spring Context
		context.close();

	}
}

