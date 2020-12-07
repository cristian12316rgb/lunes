package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo{
	
	
	private Integer cantidadDeEjes;
	
	public Camion(String patente, Integer velocidadActual,Integer cantidadDeEjes) {
		super(patente, velocidadActual);
		super.setLimite(80);
		this.cantidadDeEjes=cantidadDeEjes;
	}

	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}

	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}
	
	

	
}
