package com.ybachhas.transactionConnector;

import static org.mule.runtime.extension.api.annotation.param.MediaType.TEXT_PLAIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	private static String URL = null;
	private static String USERNAME = null;
	private static String PASSWORD = null;
//	private static String SELECT_QUERY = "select * from public.\"Transactions\"";
	private static String INSERT_QUERY = "INSERT INTO public.\"Transactions\""
			+ " (TransactionProperties,Stage,Status,JSONRecord,DetailText) VALUES " + " (?,?,?,?,?);";

	@DisplayName("Save Transaction")
	@MediaType(value = TEXT_PLAIN, strict = false)
	public String SaveTransaction(@Config TransactionConfiguration config) {
		URL = config.getHost();
		USERNAME = config.getUsername();
		PASSWORD = config.getPassword();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Error while loading Driver!!!");
			return "false";
		}
//		Below commented code will be used in validate method for Test Connection button
//		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) {
//			ResultSet rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				System.out.println("resultSet");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);) {
			preparedStatement.setString(1, transactionProperties);
			preparedStatement.setString(2, stage);
			preparedStatement.setString(3, status);
			preparedStatement.setString(4, jsonRecord);
			preparedStatement.setString(5, detailText);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error while query execution!!!");
			return "false";
		}

		return "true";
	}
}
