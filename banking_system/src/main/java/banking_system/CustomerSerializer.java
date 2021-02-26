package banking_system;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomerSerializer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String saveLocation;
	
	public CustomerSerializer(String savedLocation) {
		this.saveLocation = savedLocation;
	}
	public void serialize(Customer customer) {
		File file = new File(this.saveLocation);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			mapper.writeValue(file,  customer);
		}catch(JsonGenerationException e) {
			e.printStackTrace();
		} catch(JsonMappingException e ) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Customer deserialize() {
		Customer loadedCustomer = null;
		
		File file = new File(saveLocation);
		ObjectMapper mapper = new ObjectMapper();
		try {
			loadedCustomer = mapper.readValue(file,Customer.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return loadedCustomer;
	}

}
