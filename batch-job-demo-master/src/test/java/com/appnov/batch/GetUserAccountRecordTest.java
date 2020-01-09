package com.appnov.batch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.munit.runner.functional.FunctionalMunitSuite;


/**
 * 
 * @author Fattouh
 *
 */
public class GetUserAccountRecordTest extends FunctionalMunitSuite {
	
	private static final String GET_USER_ACCOUNT_RECORD_FLOW_NAME = "get-account-record";

	@Override
    protected String getConfigResources()
    {
		return "batch-job-demo.xml, global-config.xml";
	}
	
    @Before
    public void setupMocks() throws Exception
    {
        whenMessageProcessor("flow").withAttributes(
                Collections.singletonMap("name", (Object)GET_USER_ACCOUNT_RECORD_FLOW_NAME)).thenReturn(
                muleMessageWithPayload(accountsCollection()));        
    }
    
    
    private Collection<Map<String, Object>> accountsCollection(){
    	Collection<Map<String, Object>> accounts = new ArrayList<Map<String, Object>>();
    	Map<String, Object> account1 = createAccount(1001, 100, "Y", 1000.10, "2014-12-11", "fattouh");
    	accounts.add(account1);
    	Map<String, Object> account2 = createAccount(1002, 101, "Y", 1000.30, "2014-12-11", "fattouh");
    	accounts.add(account2);
    	Map<String, Object> account3 = createAccount(1003, 102, "Y", 4000.10, "2014-12-11", "fattouh");
    	accounts.add(account3);
    	return accounts;
    }

    
    private Map<String, Object> createAccount(Integer id, Integer userId, String active, Double creditLimit, String createdDate, String createdBy){
    	Map<String, Object> account = new HashMap<String, Object>();
    	account.put("id", id);
    	account.put("user_id", userId);
    	account.put("active", active);
    	account.put("credit_limit", creditLimit);
    	account.put("created_date", createdDate);
    	account.put("created_by", createdBy);
    	return account;
    }
	

	@Test
	public void getUsersRecordsFlowTest() throws Exception {
		MuleEvent requestEvent = testEvent(muleMessageWithPayload(null));
		MuleEvent resultEvent = runFlow(GET_USER_ACCOUNT_RECORD_FLOW_NAME, requestEvent);		
		assertEquals(accountsCollection(), (Collection<Map<String, Object>>)resultEvent.getMessage().getPayload());
	}
	
	
	
}
