package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	public Model() {
		corsoDao= new CorsoDAO();
	}
	
	public List<Corso> getCorsibyPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	public Map<Corso,Integer> getIscrittiByPeriodo(Integer pd){
		return corsoDao.getIscrittiByPeriodo(pd);
	}
	public List<Studente> getStudentiByCorso(String codice){
		return corsoDao.getStudentiByCorso(new Corso(codice,null,null,null));
	}
	//SOLUZIONE 1
	/*public Map<String,Integer>  getDivisioneCDS(String codice) {
		//dato il corso con codice ABC io mi apsetto GEST--> 50   Info--> 40   MECC---> 30
	Map<String ,Integer> divisione= new HashMap<String,Integer>();
    List<Studente> studenti= this.getStudentiByCorso(codice);
    for(Studente s : studenti) {
    	if(s.getCDS()!=null && !s.getCDS().equals("")) {
    	if(divisione.get(s.getCDS())==null) {
    		divisione.put(s.getCDS(), 1);
    	}
    	else {
    		divisione.put(s.getCDS(),divisione.get(s.getCDS())+1);
    	}
    }
    }
    return divisione;
	
	}*/
	
	public Map<String,Integer> getDivisioneCDS(String codice){
		return corsoDao.getDivisioneStudenti(new Corso(codice,null,null,null));
	}

	public boolean esisteCorso(String codice) {
		
		return corsoDao.esisteCorso(new Corso(codice,null,null,null));
	}
}
