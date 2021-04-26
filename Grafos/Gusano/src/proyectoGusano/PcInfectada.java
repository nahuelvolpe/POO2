package proyectoGusano;

public class PcInfectada {
	public int pc;
	public int hora;
	
	public PcInfectada(int compu, int tiempo){
		this.pc=compu;
		this.hora=tiempo;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	
}
