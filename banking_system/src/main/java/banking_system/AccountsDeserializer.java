package banking_system;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AccountsDeserializer  extends JsonDeserializer<ArrayList<Account>>{

	@Override
	public ArrayList<Account> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		System.out.println("it came here1");
		ArrayList<Account> accounts = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		CheckingAccount[] myObjects = mapper.readValue(p, CheckingAccount[].class);
		for(CheckingAccount account:myObjects) {
			accounts.add(account);
		}
		System.out.println("it came here");
		return accounts;
	}

}
