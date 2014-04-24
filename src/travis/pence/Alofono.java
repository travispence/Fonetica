package travis.pence;

public class Alofono {
	private String alofono;
	private String modo;
	private String punto;
	private String sonoridad;
	
	public Alofono(String a, String m, String p, String s){
		this.alofono = a;
		this.modo = m;
		this.punto = p;
		this.sonoridad = s;
	}
	
	
	
	public String getAlofono(){
		return this.alofono;
		
	}
	public String getModo(){
		return this.modo;
	}
	public String getPunto(){
		return this.punto;
	}
	
	public Boolean isSonoro(){
		if (this.sonoridad.equals("sonoro")){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	

}
