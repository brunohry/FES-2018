import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
	public Reserva reservas = new Reserva();
	public List<Usuario> usuarios = new ArrayList<Usuario>();
	public List<Espa�o> espa�os = new ArrayList<Espa�o>();
	SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
	
	public Controller() {
		loadReservas("reservas.xml");
	}
	
	/* fun��o auxiliar que substitui as entradas por interface web, usada no desenvolvimento */
	void imputByFile() {
		loadReservas("reservasImput.xml");
		saveReservas();
		
		
	}
		
	
	void saveReservas() {
		try {
			Path path = Paths.get("", "reservas2.xml");
			
		
		String word = new String();
		word = "<Reservas>\r\n";
		for (Iterator<Reserva_DAO> iterator = reservas.reservas.iterator(); iterator.hasNext();) {
			Reserva_DAO reserva = iterator.next();
			word = word +  "	<reserva>\r\n" + 
					"		<data>" + sdf1.format(reserva.getData()) + "</data>\r\n" + 
					"		<solicitante>" + reserva.getSolicitante() + "</solicitante>\r\n" + 
					"		<sala>" + reserva.getSala() + "</sala>\r\n" + 
					"		<aprova��o>" + reserva.getAprova��o() +"</aprova��o>\r\n" + 
					"		<avaliador>" + reserva.getAvaliador() + "</avaliador>\r\n" +
					"	</reserva>\r\n";
			
		}
		word += "</Reservas>\r\n";
		List<String> lines = Arrays.asList(word);
		Files.write(path, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void loadReservas(String filename) {
		Path path = Paths.get("", filename);
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
						reserva.setAprova��o(Boolean.valueOf(map.get("aprova��o")));
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
	
	
	


