package banking_system;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AccountsDeserializer extends JsonDeserializer<List<CheckingAccount>>{

	@Override
	public List<CheckingAccount> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		CheckingAccount[] myObjects = mapper.readValue(p, CheckingAccount[].class);
		ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
		for(CheckingAccount acc: myObjects ) {
			checkingAccounts.add(acc);
		}
		
		return checkingAccounts;
	}

}
