package tn.esprit.rh.achat ;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.ReglementServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ReglementTest {
	    @Mock
	    ReglementRepository Repo;

	    @InjectMocks
	    ReglementServiceImpl Service;

	    
	    
	    

	    
	    
	    
//		Facture retrieveFacture(Long id);
	    @Test
	     void testRetrieveReglement() {
	    	Reglement reg= new Reglement() ;
	        Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(reg));
	        @SuppressWarnings("removal")
	        Reglement r1 = Service.retrieveReglement((long) 1);
	        Assertions.assertNotNull(r1);
	    	int a=1 ;
	    	int b=2 ;
	    	int c= a+b ;
	    	
	    		
	    }
	    
	
	    
	    
	    //	List<Facture> retrieveAllFactures();
	    /*
	    @Test
	     void testAllRetrieveReglement() {
	    	 List<Reglement> lreg = Service.retrieveAllReglements();
	        Mockito.when(Repo.findAll()).thenReturn(lreg);
	       
	        Assertions.assertNotNull(lreg);
	    }

	    */
	    
	    
	    //	Facture addFacture(Facture f);
	    @Test
	     void testAddReglement() {
	    	Reglement reg= new Reglement() ;
	        Mockito.when(Repo.save(reg)).thenReturn(reg);
	        Reglement s1 = Service.addReglement(reg);
	        Assertions.assertNotNull(s1);
	    	

	    }
	    

		
	    
	    
	    
	    

}
