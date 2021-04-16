package tn.esprit.spring;


import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceTest {
	
	@Autowired 
	IContratService us; 
	
	@Test
	public <us> void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat(d, null, 0);
		Contrat contratAdded = us.addContrat(c);
		assertEquals(c.getTypeContrat(), contratAdded.getTypeContrat());
	}

	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-04-15");
		Contrat c = new Contrat(null, null, 000); 
		Contrat contratUpdated  = us.updateContrat(c); 
		assertEquals(c.getTypeContrat(), contratUpdated.getTypeContrat());
	}
	

	@Test
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = us.retrieveAllContrats(); 
		// if there are 5 users in DB : 
				assertEquals(5, listContrats.size());
			}
	
	@Test
	public void testRetrieveContrat() {
		Contrat contratRetrieved = us.retrieveContrat("1"); 
		assertEquals(1L, contratRetrieved.getReference());
	}

}


	



