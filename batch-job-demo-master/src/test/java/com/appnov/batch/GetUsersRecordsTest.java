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
public class GetUsersRecordsTest extends FunctionalMunitSuite {
	
	private static final String GET_USERS_RECORDS_FLOW_NAME = "get-users-records";

	@Override
    protected String getConfigResources()
    {
		return "batch-job-demo.xml, global-config.xml";
	}
	
    @Before
    public void setupMocks() throws Exception
    {
        whenMessageProcessor("flow").withAttributes(
                Collections.singletonMap("name", (Object)GET_USERS_RECORDS_FLOW_NAME)).thenReturn(
                muleMessageWithPayload(usersCollection()));        
    }
    
    
    private Collection<Map<String, Object>> usersCollection(){
    	Collection<Map<String, Object>> users = new ArrayList<Map<String, Object>>();
    	Map<String, Object> user1 = createUser(100, "test1", "test1", "test1", 10);
    	users.add(user1);
    	Map<String, Object> user2 = createUser(101, "test2", "test2", "test2", 10);
    	users.add(user2);
    	Map<String, Object> user3 = createUser(103, "test3", "test3", "test3", 10);
    	users.add(user3);
    	return users;
    }
    
    private Map<String, Object> createUser(Integer id, String userName, String lastName, String firstName, Integer status){
    	Map<String, Object> user = new HashMap<String, Object>();
    	user.put("id", id);
    	user.put("user_name", userName);
    	user.put("last_name", lastName);
    	user.put("first_name", firstName);
    	user.put("status", 10);
    	return user;
    }
	

	@Test
	public void getUsersRecordsFlowTest() throws Exception {
		MuleEvent requestEvent = testEvent(muleMessageWithPayload(null));
		MuleEvent resultEvent = runFlow(GET_USERS_RECORDS_FLOW_NAME, requestEvent);		
		assertEquals(usersCollection(), (Collection<Map<String, Object>>)resultEvent.getMessage().getPayload());
	}
	
	
	
}
