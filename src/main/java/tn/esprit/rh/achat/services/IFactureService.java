package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Facture;

import java.util.Date;
import java.util.List;

public interface IFactureService {
	//cbon
	List<Facture> retrieveAllFactures();
	
	//pas encore 
	List<Facture> getFacturesByFournisseur(Long idFournisseur);

	//cbon
	Facture addFacture(Facture f);

	//cbon
	void cancelFacture(Long id);

	//cbon
	Facture retrieveFacture(Long id);
	
	//pas a moi 
	void assignOperateurToFacture(Long idOperateur, Long idFacture);

	//c bon
	float pourcentageRecouvrement(Date startDate, Date endDate);

}
