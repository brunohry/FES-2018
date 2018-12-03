import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reserva {
	public List<Reserva_DAO> reservas = new ArrayList<Reserva_DAO>();
	
	public void make(Reserva_DAO reserva) {
		for (Iterator<Reserva_DAO> iterator = reservas.iterator(); iterator.hasNext();) {
			Reserva_DAO reserva2 = iterator.next();
			if( reserva.getSala().equals(reserva2.getSala()) && reserva.getData().equals( reserva2.getData())) {
				System.out.println(" Sala Já esta reservada neste dia.");
				return;
			}
			else if ( reserva.getSala() == null ||  reserva.getData() == null || reserva.getSolicitante() == null ||  reserva.getAvaliador() == null ){
				System.out.println(" Falta informaçao para a reserva");
				return;
			}
			
		}
		this.reservas.add(reserva);
	}
	
	public String toString() {
		String ret =  new String();
		for (Iterator<Reserva_DAO> iterator = reservas.iterator(); iterator.hasNext();) {
			ret = ret  + iterator.next() + "\n" ;
			
		}
		return ret;
	}
	
	public List<Reserva_DAO> get(Reserva_DAO reserva ) {
		List<Reserva_DAO> reservas_exit = new ArrayList<Reserva_DAO>();
		for (Iterator<Reserva_DAO> iterator = reservas.iterator(); iterator.hasNext();) {
			Reserva_DAO reserva2 = iterator.next();
			if( ( reserva.getSala() == null || reserva.getSala().equals( reserva2.getSala())) &&
					( reserva.getData() == null || reserva.getData().equals( reserva2.getData())) &&
					( reserva.getSolicitante() == null || reserva.getSolicitante().equals( reserva2.getSolicitante())) &&
					( reserva.getAvaliador() == null || reserva.getAvaliador().equals( reserva2.getAvaliador())) ) {
					
				reservas_exit.add(reserva2);
			}
		}
		return reservas_exit;
		
	}

}
