package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class demo2 {
	public static void main(String[] args) throws Exception {
		ObjectMapper a=new ObjectMapper();
	    person pp=a.readValue("{\"name\":\"jack\",\"age\":23,\"gender\":\"ÄÐ\",\"birthday\":\"20-2-2\"}", person.class);
	    System.out.println(pp);
		
	}

}
