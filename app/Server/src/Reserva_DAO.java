import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva_DAO {
	private Date data;
	private String solicitante; 
	private String sala;
	private boolean aprovação;
	private String avaliador;
	SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date date) {
		this.data = date;
	}
	
	public String getSolicitante() {
		return solicitante;
	}
	
	public void setSolicitante(String string) {
		this.solicitante = string;
	}
	
	public String getSala() {
		return sala;
	}
	
	public void setSala(String string) {
		this.sala = string;
	}
	
	public boolean isAprovação() {
		return aprovação;
	}
	
	public void setAprovação(boolean aprovação) {
		this.aprovação = aprovação;
	}
	
	public String getAvaliador() {
		return avaliador;
	}
	
	public void setAvaliador(String string) {
		this.avaliador = string;
	}
	
	public String toString() {
		return ( "Sala " + sala + " foi solicitada por "+ solicitante + " para o dia " + sdf1.format(data) + " com status de " + aprovação + " dado por " + avaliador);
	}
	
	

}
