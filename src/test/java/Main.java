/*import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.karya.dao.IUserRoleDAO;
import com.karya.model.UserRole001mb;
import com.karya.service.IUserManagerService;

public class Main {
	
	@Autowired
	private static IUserManagerService uegistrationservice;
	
	public static void main(String[] args) {
		
		List<UserRole001mb> list = uegistrationservice.findAllUsers();

		UserRole001mb user = new UserRole001mb();
		user.setUsername("johndoe");
		//user.setName("John Doe");
		uegistrationservice.insertUser(user);

		list = uegistrationservice.findAllUsers();

	}
}
*/