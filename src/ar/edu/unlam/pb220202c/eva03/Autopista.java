package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telapase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	
	
	public Autopista() {
		this.telapase=new HashMap<>();
		this.vehiculosEnCirculacion=new HashSet<>();
	}
	public void registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		this.telapase.put(numeroTelpase, vehiculo);
	}
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista
	if(this.telapase.get(numeroTelepase) instanceof Vehiculo) {
		this.vehiculosEnCirculacion.add(this.telapase.get(numeroTelepase));
		return true;
	}
		
		throw new VehiculoNotFounException("Telepase no registrado");
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		if(this.vehiculosEnCirculacion.contains(vehiculo)) {
			this.vehiculosEnCirculacion.remove(vehiculo);
			
		}
		throw new VehiculoNotFounException("No esta en circulacion");
		
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
	TreeSet<Vehiculo> nuevo=new TreeSet<>(new nuevoOrden());
	
	for(Vehiculo prueba:this.vehiculosEnCirculacion) {
		if(prueba instanceof Automovil) {
			if(prueba.getVelocidadActual()>=130) {
				nuevo.add(prueba);
			}
		}else {
			if(prueba.getVelocidadActual()>=80) {
				nuevo.add(prueba);
			}
			
		}
	}
	
	return nuevo;
	
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return this.vehiculosEnCirculacion.size();
}
	
	
	
	
	
	public Integer getTelapase() {
		return telapase.size();
	}
	public void setTelapase(HashMap<Integer, Vehiculo> telapase) {
		this.telapase = telapase;
	}
	
	public void setVehiculosEnCirculacion(HashSet<Vehiculo> vehiculosEnCirculacion) {
		this.vehiculosEnCirculacion = vehiculosEnCirculacion;
	}
	public HashSet<Vehiculo> getVehiculosEnCirculacion() {
		return vehiculosEnCirculacion;
	}
	
	
	
	
	}
