package ar.edu.unlam.pb1.finalAgosto;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	
	private Contacto[] contactos;
	private String nombreEmpresa;
	private String[] zonaDeCobertura; 
	
	
	public Empresa(String nombreEmpresa, int cantidadMaximaDeContactos) {
		
		this.nombreEmpresa = nombreEmpresa;
		this.contactos = new Contacto[cantidadMaximaDeContactos];
		this.zonaDeCobertura = new String[100];
	}

	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */
		
		return this.nombreEmpresa;
	}
	
	public boolean agregarNuevoContacto(Contacto nuevo) {
	
		/*
		 * Incorpora un nuevo contacto a la empresa
		 */
		
		for (int i = 0; i < this.contactos.length; i++) {
			
			if(contactos[i] == null) {
				contactos[i] = nuevo;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */
		
		
		for (int i = 0; i < zonaDeCobertura.length; i++) {
			
			if(zonaDeCobertura[i] != null) {	
				
                 if(zonaDeCobertura[i].equals(Integer.toString(codigoPostal))) {
                	 return true;
                 }
			}
			
			if(zonaDeCobertura[i] == null) {
				zonaDeCobertura[i] = Integer.toString(codigoPostal);
				return true;
			}
		}
		
		return false;
	}	
	
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un código postal está dentro de la zona de cobertura
		 */
         for (int i = 0; i < zonaDeCobertura.length; i++) {
			
			if(zonaDeCobertura[i] != null) {	
				
                 if(zonaDeCobertura[i].equals(Integer.toString(codigoPostal))) {
                	 return true;
                 }
			}
         }
		
		return false;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qué contacto el sistema debe mostrar, se debe realizar la siguiente búsqueda:
		 * 1.	El contacto NO debe ser cliente aún.
		 * 2.	El contacto desea ser llamado o al menos no informó lo contrario.
		 * 3.	El código postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el próximo llamado.
		 */
		
		Contacto[] contactosQuePuedenLlamarse = new Contacto[this.contactos.length];
		boolean hayContactos = false;
		
		int lengthPermitidos = 0;
		
		for (int i = 0; i < contactos.length; i++) {
			
			if(contactos[i] != null) { 
			Contacto actual = contactos[i];
			
			if(actual.esCliente() == false) {
				
				if(actual.getDeseaSerLlamado().equalsIgnoreCase("si")) {
					
					boolean existe = elCodigoPostalEstaDentroDeLaZonaDeCobertura(actual.getCodigoPostal());
					
					if(existe == true) {
						
						for(int j = 0; j < contactosQuePuedenLlamarse.length; j++) {
							if(contactosQuePuedenLlamarse[j] == null) {
								contactosQuePuedenLlamarse[j] = actual;
								lengthPermitidos++;
							}
						}
						
						hayContactos = true;
					}
				}	
			}
		}
		}
		
		if(hayContactos == true) {
			
			int rand = (int) Math.random()*lengthPermitidos;
			
			return contactosQuePuedenLlamarse[rand];
		}
			
		return null;
	}
	
	

	
	
	
	
}







