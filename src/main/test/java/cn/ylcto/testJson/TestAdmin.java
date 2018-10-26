
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.ylcto.student.vo.Admin;
import cn.ylcto.util.ObjectToJson;



public class TestAdmin {
    public static void main(String[] args) {
    	
    	List<Admin> all = new ArrayList<Admin>();
    	for (int i = 0; i < 5; i++) {
			
		
    	Admin admin = new Admin();
    	admin.setEmail("ylcto@163.com");
    	admin.setPassword("1111111");
    	admin.setLastdate(new Date());
    	all.add(admin);
    	}
    	System.out.println(ObjectToJson.converterListObjectToJson("allAdmin",all));
    }
}
