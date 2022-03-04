 package practica3_segundaEVA;

public class Datos {

	private int id;
	private int traslados;
	private int circular;
	private int total;

	public Datos(int id, int traslados, int circular) {
		this.id = id;
		this.traslados = traslados;
		this.circular = circular;
		
	}
	
	public Datos(int id, int traslados, int circular, int total) {
		this.id = id;
		this.traslados = traslados;
		this.circular = circular;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTraslados() {
		return traslados;
	}

	public void setTraslados(int traslados) {
		this.traslados = traslados;
	}

	public int getCircular() {
		return circular;
	}

	public void setCircular(int circular) {
		this.circular = circular;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString(){
		return id + " " + traslados + " " + circular + " " + total;
	}
}
