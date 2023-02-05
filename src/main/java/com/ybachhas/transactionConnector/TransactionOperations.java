package com.ybachhas.transactionConnector;

import static org.mule.runtime.extension.api.annotation.param.MediaType.TEXT_PLAIN;

import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;

public class TransactionOperations {
	@Parameter
	@DisplayName("Transaction Properties")
	@Placement(order = 1)
	private String transactionProperties;
	
	@Parameter
	@DisplayName("Stage")
	@Placement(order = 2)
	private String stage;
	
	@Parameter
	@DisplayName("Status")
	@Placement(order = 3)
	private String status;
	
	@Parameter
	@DisplayName("JSON Record")
	@Placement(order = 4)
	private String jsonRecord;
	
	@Parameter
	@DisplayName("Detail Text")
	@Placement(order = 5)
	private String detailText;
	
	@DisplayName("Save Transaction")
	@MediaType(value = TEXT_PLAIN, strict = false)
	public String SaveTransaction(@Config TransactionConfiguration config) {
		return "SaveTransaction() executed successfully";
	}
}
