import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva_DAO {
	private Date data;
	private String solicitante; 
	private String sala;
	private boolean aprova��o;
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
	
	public boolean isAprova��o() {
		return aprova��o;
	}
	
	public void setAprova��o(boolean aprova��o) {
		this.aprova��o = aprova��o;
	}
	
	public String getAvaliador() {
		return avaliador;
	}
	
	public void setAvaliador(String string) {
		this.avaliador = string;
	}
	
	public String toString() {
		return ( "Sala " + sala + " foi solicitada por "+ solicitante + " para o dia " + sdf1.format(data) + " com status de " + aprova��o + " dado por " + avaliador);
	}
	
	

}
