package tn.esprit.spring.services;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratService implements IContratService{
	
	@Autowired
	ContratRepository contratRepository;
	
	private static final Logger L = LogManager.getLogger(ContratService.class);
	@Override
	public List<Contrat>retrieveAllContrats() {
		L.info("In retrieveAllContrats : ");
		List<Contrat> contrats = (List<Contrat>)contratRepository.findAll();
		for (Contrat contrat : contrats){
			L.debug("contrat +++ : " +contrat);
		}
		L.info("Out of retrieveAllContrats."); 
		return contrats;
	}
			
	@Override
	public Contrat addContrat(Contrat c) {
		L.info("In  addContrat : " + c); 
		Contrat contratSaved = contratRepository.save(c);
		L.info("Out of  addContrat. "); 
		return contratSaved; 
	}
	
	@Override 
	public Contrat updateContrat(Contrat c) {
		return contratRepository.save(c);
	}
		
		public void deleteContrat(String id){
		contratRepository.deleteById(Integer.parseInt(id));
		}
		@Override
		public Contrat retrieveContrat(String id) {
			L.info("in  retrieveContrat id = " + id);
			Contrat c =  contratRepository.findById(Integer.parseInt(id)).orElse(null);
			L.info("user returned : " + c);
			return c; 
		}
	}




