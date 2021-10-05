package ar.edu.unlam.pb1.finalAgosto;

import java.util.Scanner;

public class InterfazCallCenter {
	
	static Empresa miEmpresa = new Empresa("Amazon", 100);
	static Contacto contacto;
	public static void main(String args[]) {
		
		
		int opcion = 0;
		do {
			opcion = menu();
			
			switch(opcion) {
			
			case 1: incorporarZonaDeCobertura();
			        break;
			        
			case 2: darDeAltaNuevoContacto();
			        break;
			        
			case 3: realizarNuevaLlamada();
			        break;
			        
			case 4: verInformacionDelContacto();
			       break;
			        
			default:
				System.out.println("Opcion Invalida");
				break;
			}
			
			
		}while(opcion != 9);
               

        
        
        
        
       
			
	}
	
	private static void incorporarZonaDeCobertura() {
		/*
		 * Se registra un nuevo código postal dentro de la zona de cobertura de la empresa
		 */
		
		System.out.println("Ingrese el codigo posta");
		Scanner teclado = new Scanner(System.in);
		int cod = teclado.nextInt();
		
		boolean sePudo = miEmpresa.agregarNuevaZonaDeCobertura(cod);
		
		if(sePudo == true) {
			System.out.println("Zona de cobertura agregada correctamente");
		}else {
			System.out.println("El codigo posta ya existe");
		}
		
		
	}
	
	private static void darDeAltaNuevoContacto() {
		/*
		 * Registra un nuevo contacto en la empresa
		 */
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe el nombre");
		String nombre = teclado.nextLine();
		System.out.println("Escribe el apellido");
		String apellido = teclado.nextLine();
		
		System.out.println("Escribe el email");
		String email = teclado.nextLine();
		
		System.out.println("Crea tu celular");
		System.out.println("Codigo de pais");
		
		int pais = teclado.nextInt();
		System.out.println("Codigo de Area");
		int area = teclado.nextInt();
		System.out.println("Numero telefonico");
		int numero = teclado.nextInt();
		
		
		System.out.println("Escribe la direccion");
		String dire = teclado.nextLine();
		
		
		Celular celu = new Celular(numero, pais, area);
		contacto = new Contacto(nombre, apellido, celu, email, dire, 1754, "San justo", Provincia.BUENOS_AIRES);
		
		if(contacto.esEmailValido(email) == false) {
			
			contacto = null;
			System.out.println("El email no es valido");
		}else {
			
			miEmpresa.agregarNuevoContacto(contacto);
			System.out.println("Contacto agregado correctamente");
		}
				
		
	}
	
	private static void realizarNuevaLlamada() {
		/*
		 * Busca un candidato,  muestra los datos del mismo, y permite almacenar el resultado de la llamada.
		 * 
		 * a.	Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y no se lo debe volver a 
		 * llamar).
		 * b.	Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga 
		 * un nuevo intento en el futuro).
		 * c.	Observaciones: Texto libre donde el operador deja registro de lo conversado.
		 * 
		 * 
		 */
		
		Contacto candi = miEmpresa.buscarCandidato();
		
		if(candi != null) {
			
			candi.setEsCliente(true);
			candi.setDeseaSerLlamado("no");
			
			System.out.println("Se realizo la llamada correctamente");
			
		}else {
			System.out.println("No se puedo llamar");
		}
		
	}
	
	private static void verInformacionDelContacto() {
		/*
		 * Se visualiza la información del contacto, incluso el listado de las llamadas que se le hicieron
		 */
		if(contacto != null) { 
			System.out.println(contacto.toString());
		}
		
		
	}
	
   public static int menu() {
	   
	   Scanner teclado = new Scanner(System.in);
		int opcionSeleccionada=0;
	   
	   System.out.println("Bienvenido al callcenter");
		
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Incorporar zona de cobertura");
		System.out.println("2 - Dar de alta un nuevo contacto");
		System.out.println("3 - Realizar nueva llamada");
		System.out.println("4 - Ver información del contacto");
		System.out.println("9 - Salir");
		System.out.println("************************");
		
        opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
   }
	
}
