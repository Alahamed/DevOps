package tn.esprit.rh.achat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FounisseurServiceImplTest {
	
	@InjectMocks
	 FournisseurServiceImpl fSer ;
	@Mock
	FournisseurRepository fRep ;
	
	@Test
	public void retrieveAllFounisseurs()
	{
		List<Fournisseur> list = new ArrayList<Fournisseur>();
		
		// remplire la liste par des founisseurs statiquement 
		Fournisseur F1 = new Fournisseur((long) 1, "05xx64","Delice", CategorieFournisseur.ORDINAIRE, null, null, null);
		Fournisseur F2 = new Fournisseur((long) 1, "2csd8g", "Maestro", CategorieFournisseur.ORDINAIRE, null, null, null);
		Fournisseur F3 = new Fournisseur((long) 1, "555fzf", "Coca", CategorieFournisseur.ORDINAIRE, null, null, null);
		
		list.add(F1);
		list.add(F2);
		list.add(F3);
		
		// retourner la liste 
		when(fRep.findAll()).thenReturn(list);
		
		//Test
	    List<Fournisseur> Fous = fSer.retrieveAllFournisseurs();
	    Assertions.assertEquals(3, Fous.size());
	    verify(fRep, times(1)).findAll();
	    
	}
	
	@Test
	public void AjouterFounisseur()
	{
		Fournisseur F4 = new Fournisseur((long) 4, "555555", "momento", CategorieFournisseur.CONVENTIONNE, null, null, null);
		fSer.addFournisseur(F4);
		verify(fRep , times(1)).save(F4);
	}
	
	;
	@Test 
	public void getFounisseurById()
	{
		Fournisseur f1 = new Fournisseur((long) 1, "555555", "momento", CategorieFournisseur.CONVENTIONNE, null, null, null) ;
	    when(fRep.findById((long) 1)).thenReturn(Optional.of(f1));
	   Fournisseur Four = fSer.retrieveFournisseur((long) 1);
	   Assertions.assertEquals("555555", Four.getCode());
	   Assertions.assertEquals("momento", Four.getLibelle());
	}
	
	/*@Test
	public void supprimerFournisseur()
	{
		Fournisseur ff = fSer.retrieveFournisseur((long) 1);
		when(fRep.findById((long) 1)).thenReturn(Optional.of(ff));
		fSer.deleteFournisseur((long) 1);
		verify(fRep).save(ff);
	}*/
	
	

}
