package ar.edu.unlam.pb1.finalAgosto;

public class Contacto {
	
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * •	Nombre y Apellido: No se aceptan números.
	 * •	Celular: Compuesto del código de país + código de área + número de celular.
	 * •	E-Mail: Debe contener al menos el símbolo ‘@’ y el caracter ‘.’.
	 * •	Dirección: Valor alfanumérico.
	 * •	Código Postal: Valor numérico.
	 * •	Localidad: Valor alfanumérico.
	 * •	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * •	Es cliente (Si o No): Inicialmente se carga en “No”.
	 * •	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en “Si”.
	 */
	
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private int codigoPostal;
	private String localidad;
	private Provincia provincia;
	private Celular celular;
	private boolean esCliente;
	private String deseaSerLlamado;
	private Llamada llamadas[];
	
	
	
	public Contacto(String nombre, String apellido,Celular celular, String email, String direccion, int codigoPostal,
			String localidad, Provincia provincia) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.deseaSerLlamado = "si";
		this.esCliente = false;
	}
	

	public boolean esEmailValido(String eMail) {
		/*
		 * Evalúa si un String determinado puede ser almacenado como E-MAIL.
		 */
		
		int size = eMail.length() - 1;
		boolean arroba = false;
		boolean punto = false;
		
		char[] aCaracteres = eMail.toCharArray();
		
		for (int i = 0; i < aCaracteres.length; i++) {
			
		   if(aCaracteres[i] == 64) {
			   arroba = true;
		   }
		   if(aCaracteres[i] == 46) {
			   punto = true;
		   }
		}
		
		if(punto == true && arroba == true) {
			return true;
		}
	
		return false;
	}
	
	public boolean esCliente() {
		return this.esCliente;
	}
	

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}


	public String getDeseaSerLlamado() {
		return deseaSerLlamado;
	}


	public void setDeseaSerLlamado(String deseaSerLlamado) {
		this.deseaSerLlamado = deseaSerLlamado;
	}
	


	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public boolean nombreYApellidoEsValido(String nombre, String apellido) {
		
		char[] aNombre = nombre.toCharArray();
		char[] aApellido = apellido.toCharArray();
		
		for (int i = 0; i < aNombre.length; i++) {
			
		}
		
		
		return false;
	}
	
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		
		for (int i = 0; i < llamadas.length; i++) {
			if(llamadas[i] == null) {
				llamadas[i] = nueva;
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
		 */
		
		if(llamadas != null) {
			return "Nombre: " + this.nombre+ " " + this.apellido+ " Tel: " + this.celular.toString() + " Email: " + this.email + " Nro. de llamadas realizadas: " + this.llamadas.length;
		}
		
		else {
			return "Nombre: " + this.nombre+ " " + this.apellido+ " Tel: " + this.celular.toString() + " Email: " + this.email + " Nro. de llamadas realizadas: " + 0;
		}
		
		
	}
	
	
	
}
