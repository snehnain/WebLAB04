package isep.web.sakila.webapi.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

import isep.web.sakila.SakilaBusinessWebapiApplication;
import isep.web.sakila.webapi.model.ActorWO;
import isep.web.sakila.webapi.model.CustomerWO;
import isep.web.sakila.webapi.service.ActorService;
import isep.web.sakila.webapi.service.CustomerService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaBusinessWebapiApplication.class)
@WebAppConfiguration

public class WebapiApplicationTest {

    @Autowired
    private ActorService actorService;
    
    ActorWO mockactorWO=new ActorWO(201,"Sneh","Nain");
    
    @Autowired
    private CustomerService customerService;
    
    CustomerWO mockcustomerWO=new CustomerWO();

	@Test
	public void testCreateActor(){
		actorService.saveActor(mockactorWO);
		assertEquals("Nain", mockactorWO.getFirstName());		
	}
	

}
