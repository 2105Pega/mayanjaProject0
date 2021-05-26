import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.account.Account;
import com.revature.customer.Customer;
import com.revature.employee.Employee;

public class EmployeeTest {
	
	private Employee Employee;

	@BeforeEach
	void setUp() throws Exception{
		//initialize customer here
		this.Employee = new Employee(0, null, null, 0, null, null);
	}
	

	  @Test
	    public void testSetCustomer_id() {
		  Employee emp = new Employee(2, "hello", "hello1", 2);
	          emp.setId(2);
	        assertTrue(emp.getId() == 2);
	    }
	  @Test
	    public void testSetUserName() {
		  Employee emp = new Employee(2, "hello", "hello1", 2);
	          emp.setUserName("name");
	        assertTrue(emp.getUserName() == "name");
	    }
	  @Test
	    public void testsetPassword() {
		  Employee emp = new Employee(2, "hello", "hello1", 2);
	          emp.setPassword("hello");
	        assertTrue(emp.getPassword() == "hello");
	    }
}
