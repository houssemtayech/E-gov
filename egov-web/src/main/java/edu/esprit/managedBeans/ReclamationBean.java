package edu.esprit.managedBeans;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.domain.Reclamation;
import tn.esprit.services.ClaimGestionLocal;


@ManagedBean
@ViewScoped
public class ReclamationBean  implements Serializable {
	 private Reclamation reclamation ;
	 
	 
		private List<Reclamation> reclamations;
		private String ResultRecheche;
		
		@EJB
		ClaimGestionLocal claimGestionLocal; 
		

		@PostConstruct
		public void init() {
			setReclamation(new Reclamation());
			setReclamations(claimGestionLocal.chercherReclamation());
		
		}
		
		
		
		public Reclamation getReclamation() {
		return reclamation;
		}




	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}





		
		
		public  String DoAddClaim(){
			
			FacesMessage message =new FacesMessage("ERROR:","validation error. You must enter a value.");
			FacesContext.getCurrentInstance().addMessage("nom", message);
	
				
			claimGestionLocal.addClaim(reclamation);
			init();
	
			return null;
		}

		public List<Reclamation> getReclamations() {
			return reclamations;
		}


		public void setReclamations(List<Reclamation> reclamations) {
			this.reclamations = reclamations;
		}

		public  String  doDelete( Reclamation reclamation){
			claimGestionLocal.deleteClaim( reclamation);
		
			init();
			return null ;
		}


		public String getResultRecheche() {
			return ResultRecheche;
		}


		public void setResultRecheche(String resultRecheche) {
			ResultRecheche = resultRecheche;
		}

	}
