import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reserva {
	public List<Reserva_DAO> reservas = new ArrayList<Reserva_DAO>();
	
	public void make(Reserva_DAO reserva) {
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
			if( ( reserva.getSala() == null || reserva.getSala() == iterator.next().getSala()) &&
					( reserva.getData() == null || reserva.getData() == iterator.next().getData()) &&
					( reserva.getSolicitante() == null || reserva.getSolicitante() == iterator.next().getSolicitante()) &&
					( reserva.getAvaliador() == null || reserva.getAvaliador() == iterator.next().getAvaliador()) ) {
					
				reservas_exit.add(iterator.next());
			}
		}
		return reservas_exit;
		
	}

}
