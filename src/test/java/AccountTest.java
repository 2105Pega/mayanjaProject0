import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.account.Account;


public class AccountTest {
	
	private Account Account;

	@BeforeEach
	void setUp() throws Exception{
		//initialize customer here
		this.Account = new Account(0, 0, 0);
	}
	
	
	  @Test
	    public void testSetCustomer_id() {
	        Account account = new Account(2,3.0, 1);
	        account.setCustomer_id(1);
	        assertTrue(account.getCustomer_id() == 1);
	    }

}
