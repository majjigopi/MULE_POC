package com.appnov.batch;


import java.util.Collection;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;


/**
 * 
 * @author Fattouh
 *
 */
public class AccountVerifier implements Callable {
	

	@Override
	public Object onCall(MuleEventContext eventContext) throws NoUserAccountExistException {
		Collection col = (Collection)eventContext.getMessage().getPayload();
		if(col==null || col.size() == 0){
			throw new NoUserAccountExistException("The user account does not exist");
		}
		return eventContext.getMessage().getPayload();
	}

}
