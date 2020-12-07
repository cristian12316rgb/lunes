package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestAutoPista {
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista nueva=new Autopista();
		Vehiculo auto=new Automovil("abc",120);
		Vehiculo camion=new Camion("afg",70,3);
		
		nueva.registrarTelepase(1, auto);
		nueva.registrarTelepase(2, camion);
		
		assertEquals(((Integer)2),nueva.getTelapase());
		
	}
    @Test(expected=VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista nueva=new Autopista();
		Vehiculo auto=new Automovil("abc",120);
		Vehiculo camion=new Camion("afg",70,3);
		
		nueva.registrarTelepase(1, auto);
		nueva.registrarTelepase(2, camion);
		
		nueva.salirAutpista(auto);
		assertEquals(((Integer)1),nueva.cantidadDeVehiculosENCirculacion());
		
	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista nueva=new Autopista();
		
		Vehiculo auto=new Automovil("abc",130);
		Vehiculo auto2=new Automovil("ter",120);
		Vehiculo camion2=new Camion("ert",70,3);
		Vehiculo camion=new Camion("afg",80,3);
		
		nueva.registrarTelepase(1, auto);
		nueva.registrarTelepase(2, camion);
		nueva.registrarTelepase(3, auto2);
		nueva.registrarTelepase(4, camion2);
		
		nueva.ingresarAutopista(1);
		nueva.ingresarAutopista(2);
		nueva.ingresarAutopista(3);
		nueva.ingresarAutopista(4);
		
		
		Integer contador =0;
		Vehiculo prueba=null;
		
		for(Vehiculo j:nueva.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente()) {
			if(contador==0) {
				prueba=j;
			}else {
				assertTrue(prueba.getPatente().compareTo(j.getPatente())<0);
			}
			prueba=j;
			contador++;
		}
		for(Vehiculo nuevo:nueva.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente()) {
			System.out.println(nuevo.toString());
		}
		
		
		assertTrue(nueva.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(auto));
		assertTrue(nueva.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(camion));
		assertFalse(nueva.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(camion2));
		
	}
    @Test
	public void queNoSePuedanIngresarVehiculosConLaMismaPatenteEnLaAutopista() throws VehiculoNotFounException {
		Autopista nueva=new Autopista();
		Vehiculo auto1=new Automovil("asi",120);
		Vehiculo auto2=new Automovil("asd",120);
		Vehiculo auto3=new Automovil("asdf",120);
		Vehiculo auto4=new Automovil("ter",120);
		Vehiculo camion1=new Camion("fds",70,3);
		Vehiculo camion2=new Camion("erd",70,3);
		Vehiculo camion3=new Camion("aer",70,3);
		Vehiculo camion4=new Camion("hgd",70,3);
		
		Vehiculo auto5=new Automovil("asd",120);
		Vehiculo camion5=new Camion("hgd",70,3);
		
		
		nueva.registrarTelepase(1, auto1);
		nueva.registrarTelepase(2, auto2);
		nueva.registrarTelepase(3, auto3);
		nueva.registrarTelepase(4, auto4);
		nueva.registrarTelepase(5, auto5);
		nueva.registrarTelepase(6, camion1);
		nueva.registrarTelepase(7, camion2);
		nueva.registrarTelepase(8, camion3);
		nueva.registrarTelepase(9, camion4);
		nueva.registrarTelepase(10, camion5);
		
		
		nueva.ingresarAutopista(1);
		nueva.ingresarAutopista(2);
		nueva.ingresarAutopista(3);
		nueva.ingresarAutopista(4);
		nueva.ingresarAutopista(5);
		nueva.ingresarAutopista(6);
		nueva.ingresarAutopista(7);
		nueva.ingresarAutopista(8);
		nueva.ingresarAutopista(9);
		nueva.ingresarAutopista(10);
		
		
		assertEquals(((Integer)8),nueva.cantidadDeVehiculosENCirculacion());
		
		
		
	}
	@Test
	public void queSePuedaModificarLaVelocidad() throws VehiculoNotFounException {
		Autopista nueva=new Autopista();
		Vehiculo auto1=new Automovil("asi",120);
		Vehiculo camion1=new Camion("fds",70,3);
		
		nueva.registrarTelepase(1, auto1);
		nueva.registrarTelepase(2, camion1);
		
		nueva.ingresarAutopista(1);
		nueva.ingresarAutopista(2);
		
		assertTrue(nueva.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().isEmpty());
		
		auto1.incrmentarVelocidad(10);
		camion1.incrmentarVelocidad(10);
		
		assertEquals(((Integer)2), ((Integer)nueva.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().size()));
		
		
	}
	
}