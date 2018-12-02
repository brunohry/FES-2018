import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
	public Reserva reservas = new Reserva();
	public List<Usuario> usuarios = new ArrayList<Usuario>();
	public List<Espaço> espaços = new ArrayList<Espaço>();
	
	public Controller() {
		loadReservas();
		

	}
		
	
	void loadReservas() {
		String teste = new String ();
		Path path = Paths.get("", "reservas.xml");
		boolean flag = false;
		Charset charset = Charset.forName("UTF-8");
		Map<String, String> map = new TreeMap<String, String>();;  
	    try {

		List<String> lines = Files.readAllLines(path, charset);
			
	      for (String line : lines) {
	    	  
	        if(line.substring(line.indexOf("<")+ 1, line.indexOf(">")).equals("reserva")) {
	        	map = new TreeMap<String, String>();
	        	flag = true;
	        	continue;
	        }
	        else if(line.substring(line.indexOf("<")+ 1, line.indexOf(">")).equals("/reserva"))
				try {
					{
						Reserva_DAO reserva = new Reserva_DAO();
						SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
						reserva.setSala(map.get("sala"));
						reserva.setData(sdf1.parse(map.get("data")));
						reserva.setAprovação(Boolean.valueOf(map.get("aprovação")));
						reserva.setSolicitante(map.get("solicitante"));
						reserva.setAvaliador(map.get("avaliador"));
						
						reservas.make(reserva);
						
						flag = false;
						continue;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        if ( flag ) {
	        	String atrb = line.substring(line.indexOf("<")+1, line.indexOf(">"));
	        	String val = line.substring(line.indexOf(">")+1, line.indexOf("</"));
	        	map.put(atrb, val);
	        	
	        	
	        	
	        }
	      }
	    } catch (IOException e) {
	      System.out.println(e);
	    }

	 
		
	}
	

	}
	
	
	


