import java.util.ArrayList;
import java.util.List;


public class Espaço {
	private String nome = new String();
	private String tipo = new String();
	private int capacidade;
	public List<Itens> itens = new ArrayList<Itens>();
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public void addItem (Itens item) {
		this.itens.add(item);
	}
	
	public void rmItem (Itens item) {
		this.itens.remove(item);
	}
	
	

}


