import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.account.Account;
import com.revature.customer.Customer;

public class CustomerTest {
	
	//declare customer for testing
	Customer customer;
	
	@BeforeEach
	void setUp() throws Exception{
		//initialize customer here
		this.customer = new Customer();
	}
	

	
	  @Test
	    public void testSetCustomer_id() {
	        Customer cust = new Customer();
	        cust.setFirstName("hello");
	        assertTrue(cust.getFirstName() == "hello");
	    }

}//end test customer
