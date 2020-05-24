package json;

import java.io.FileOutputStream;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class demo1 {
	public static void main(String[] args) throws Exception {
		ObjectMapper a=new ObjectMapper();//创建json的核心对象
		person per=new person();
		per.setAge(23);
		per.setGender("男");
		per.setName("jack");
		per.setBirthday(new Date());
		String j=a.writeValueAsString(per);		
		System.out.println(j);
		//a.writeValue(new FileOutputStream("d://json.txt"), per);
		
		
	}

}
