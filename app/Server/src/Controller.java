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
	public List<Espaço> espaços = new ArrayList<Espaço>();
	SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
	
	public Controller() {

	}
	
	/* função auxiliar que substitui as entradas por interface web, usada no desenvolvimento */
	void imputByFile() {
		loadReservas("reservasImput.xml");
		saveReservas("reservas.xml");	
		
	}
	
	void fazRelatorio(String arquivo, String arquivo2) {
		Path path_exit = Paths.get("", arquivo2);
		String word = new String();
		Reserva_DAO filtros = new Reserva_DAO();
		Path path = Paths.get("", arquivo);
		boolean flag = false;
		Charset charset = Charset.forName("UTF-8");
		Map<String, String> map = new TreeMap<String, String>();;  
	    try {

		List<String> lines = Files.readAllLines(path, charset);
			
	      for (String line : lines) {
	        if(!line.equals("") && line.substring(line.indexOf("<")+ 1, line.indexOf(">")).equals("relatorio")) {
	        	map = new TreeMap<String, String>();
	        	flag = true;
	        	continue;
	        }
	        else if(!line.equals("") && line.substring(line.indexOf("<")+ 1, line.indexOf(">")).equals("/relatorio"))
				try {
					{
						SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
						filtros.setSala(map.get("sala"));
						if (map.get("sala") == null) {
							filtros.setData(null);
						}
						else {
							filtros.setData(sdf1.parse(map.get("data")));
						}
							
						filtros.setAprovação(Boolean.valueOf(map.get("aprovação")));
						filtros.setSolicitante(map.get("solicitante"));
						filtros.setAvaliador(map.get("avaliador"));

						
						flag = false;
						continue;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        if ( flag  && !line.equals("") ) {
	        	String atrb = line.substring(line.indexOf("<")+1, line.indexOf(">"));
	        	String val = line.substring(line.indexOf(">")+1, line.indexOf("</"));
	        	map.put(atrb, val);
	        }
	      }
	    } catch (IOException e) {
	      System.out.println(e);
	    }
		List<Reserva_DAO> resultado = reservas.get(filtros);
		for (Iterator<Reserva_DAO> iterator = resultado.iterator(); iterator.hasNext();) {
			Reserva_DAO reserva = iterator.next();
			word += reserva.toString() + "\n";
		}
		List<String> lines = Arrays.asList(word);
		try {
			Files.write(path_exit, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	void saveReservas(String fileName) {
		try {
			Path path = Paths.get("", fileName);
			
		
		String word = new String();
		word = "<Reservas>\r\n";
		for (Iterator<Reserva_DAO> iterator = reservas.reservas.iterator(); iterator.hasNext();) {
			Reserva_DAO reserva = iterator.next();
			word = word +  "	<reserva>\r\n" + 
					"		<data>" + sdf1.format(reserva.getData()) + "</data>\r\n" + 
					"		<solicitante>" + reserva.getSolicitante() + "</solicitante>\r\n" + 
					"		<sala>" + reserva.getSala() + "</sala>\r\n" + 
					"		<aprovação>" + reserva.getAprovação() +"</aprovação>\r\n" + 
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
	        if(!line.equals("") && line.substring(line.indexOf("<")+ 1, line.indexOf(">")).equals("reserva")) {
	        	map = new TreeMap<String, String>();
	        	flag = true;
	        	continue;
	        }
	        else if(!line.equals("") && line.substring(line.indexOf("<")+ 1, line.indexOf(">")).equals("/reserva"))
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
	        if ( flag  && !line.equals("") ) {
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
	
	
	


