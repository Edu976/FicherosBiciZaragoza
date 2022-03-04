package practica3_segundaEVA;

public class UsoBizi {
	private int id;
	private String fechaRetirada;
	private int estacionRetirada;
	private String fechaDev;
	private int estacionDev;
	
	public UsoBizi(int id, String fechaRetirada, int estacionRetirada, String fechaDev, int estacionDev) {
		this.id = id;
		this.fechaRetirada = fechaRetirada;
		this.estacionRetirada = estacionRetirada;
		this.fechaDev = fechaDev;
		this.estacionDev = estacionDev;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFechaRetirada() {
		return fechaRetirada;
	}
	public void setFechaRetirada(String fechaRetirada) {
		this.fechaRetirada = fechaRetirada;
	}
	public int getEstacionRetirada() {
		return estacionRetirada;
	}
	public void setEstacionRetirada(int estacionRetirada) {
		this.estacionRetirada = estacionRetirada;
	}
	public String getFechaDev() {
		return fechaDev;
	}
	public void setFechaDev(String fechaDev) {
		this.fechaDev = fechaDev;
	}
	public int getEstacionDev() {
		return estacionDev;
	}
	public void setEstacionDev(int estacionDev) {
		this.estacionDev = estacionDev;
	}
	
	@Override
	public String toString(){
		return id + " " + fechaRetirada + " " + estacionRetirada + " " + fechaDev + " " + estacionDev;
	}
}
