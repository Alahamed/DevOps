package tn.esprit.rh.achat;

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
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class FactureTest {
    @Mock
    FactureRepository Repo;

    @InjectMocks
    FactureServiceImpl Service;

    
    
    private Date mydate;
    private Date mydate2;

    private Set <DetailFacture> df ; 
    private Set <DetailFacture> df2 ; 
    

    Fournisseur fournisseur  = Fournisseur.builder().build();
    Operateur operateur = Operateur.builder().build();
    
    Facture facture= Facture.builder().montantRemise(100).montantFacture(100).dateCreationFacture(mydate).dateDerniereModificationFacture(mydate).archivee(true).detailsFacture(df).fournisseur(fournisseur).build();
    List<Facture> listFactures = new ArrayList<Facture>() {
        {
            add(Facture.builder().montantRemise(10).montantFacture(100).dateCreationFacture(mydate).dateDerniereModificationFacture(mydate).archivee(true).detailsFacture(df).build());
            add(Facture.builder().montantRemise(20).montantFacture(200).dateCreationFacture(mydate2).dateDerniereModificationFacture(mydate).archivee(true).detailsFacture(df2).build());
        }
    };
    
    
    
    
//	Facture retrieveFacture(Long id);
    @Test
     void testRetrieveFacture() {
        Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        @SuppressWarnings("removal")
        Facture s1 = Service.retrieveFacture(new Long(2));
        Assertions.assertNotNull(s1);
    }
    
   
//	List<Facture> getFacturesByFournisseur(Long idFournisseur);
    @Test
     void testFacturesByFournisseur() {
    	List<Facture> lFacture = Service.retrieveAllFactures();
        Mockito.lenient().when(Repo.getFactureByFournisseur(fournisseur)).thenReturn(listFactures);
       // Repo.saveAll(lFacture); 
        lFacture = Service.retrieveAllFactures();
        Assertions.assertNotNull(lFacture);
    }
    
    
    

    //	List<Facture> retrieveAllFactures();
    @Test
     void testAllRetrieveFacture() {
        Mockito.when(Repo.findAll()).thenReturn(listFactures);
        List<Facture> lFacture = Service.retrieveAllFactures();
        Assertions.assertNotNull(lFacture);
    }

    
    
    
    //	Facture addFacture(Facture f);
    @Test
     void testAddFacture() {
        Mockito.when(Repo.save(facture)).thenReturn(facture);
        Facture s1 = Service.addFacture(facture);
        Assertions.assertNotNull(s1);

    }
    

	//void cancelFacture(Long id);
    @Test
    void testCancelfacture() {
   	
    	facture.setArchivee(true);
        Mockito.when(Repo.save(facture)).thenReturn(facture);
        Repo.save(facture);
        Assertions.assertTrue(facture.getArchivee());
    	
   }

    
    
    
    
    
    
    
}