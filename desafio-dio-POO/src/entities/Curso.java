package entities;

public class Curso extends Conteudo {

	private int cargaHoraria;

	
	
	public Curso(String titulo, String descricao, int cargaHoraria) {
		getTitulo();
		getDescricao();
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public double calcularXp() {
		return XP_PADRAO * cargaHoraria;
	}

	public Curso() {
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "\n\n--------------Curso------------------" 
	+ "\nTitulo = " + getTitulo() 
	+ "\nDescricao = " + getDescricao() 
	+ "\nCargaHorari = " + cargaHoraria;}
}
