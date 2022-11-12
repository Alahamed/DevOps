package tn.esprit.rh.achat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
 class ProduitTest {

	@InjectMocks
	ProduitServiceImpl Service;
	
	@Mock
	ProduitRepository Repo;
	
	Produit prod= Produit.builder().codeProduit("123").libelleProduit("lait").build();
	List<Produit> listProduit = new ArrayList<Produit>() {
	        {
	        	  add(Produit.builder().codeProduit("123").libelleProduit("lait").build());
	              add(Produit.builder().codeProduit("123").libelleProduit("lait").build());
	        }
	    };

	@Test
    void testAddProduit() {
       Mockito.when(Repo.save(prod)).thenReturn(prod);
       Produit s1 = Service.addProduit(prod);
       Assertions.assertNotNull(s1);

   }
	
	 @Test
     void testDeleteProduit() {
    	Service.deleteProduit(prod.getIdProduit());
        Mockito.verify(Repo, Mockito.times(1)).deleteById(prod.getIdProduit());
    }
	 
	 @Test
     void testUpdatestock() {
    	prod.setLibelleProduit("Chocolat");
        Mockito.when(Repo.save(prod)).thenReturn(prod);
        Produit s1 = Service.updateProduit(prod);
        Assertions.assertEquals(prod,s1);
    }
	 
	 @Test
     void testAllRetrieveProduits() {
        Mockito.when(Repo.findAll()).thenReturn(listProduit);
        List<Produit> lProds = Service.retrieveAllProduits();
        Assertions.assertNotNull(lProds);
    }
	 
	 @Test
	 void testRetrieveProduit() {
	    Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(prod));
	    @SuppressWarnings("removal")
	    Produit s1 = Service.retrieveProduit(new Long(2));
	    Assertions.assertNotNull(s1);
	  }
}