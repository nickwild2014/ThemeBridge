package com.bs.themebridge.entity.servlet.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.model.SchemaAnalysisModel;
import com.bs.themebridge.util.DatabaseUtility;

public class SchemaAnalysisImpl {

	private final static Logger logger = Logger.getLogger(SchemaAnalysisImpl.class);

	public static List<SchemaAnalysisModel> getSchemaTableSize(String schemaName) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		List<SchemaAnalysisModel> tableSizeList = new ArrayList<SchemaAnalysisModel>();
		String query = "select owner as schema_name, table_name, num_rows, round((num_rows*avg_row_len)/(1024*1024)) MB from all_tables where owner like '"
				+ schemaName + "' order by MB desc";
		logger.debug("Query : " + query);
		try {
			if (schemaName.equals("THEMEBRIDGE")) {
				con = DatabaseUtility.getThemebridgeConnection();
			} else {
				con = DatabaseUtility.getTizoneConnection();
				// con = DBConnection.getTizoneConnection(schemaName);
			}
			stmt = con.createStatement();
			res = stmt.executeQuery(query);
			while (res.next()) {
				SchemaAnalysisModel tableSize = new SchemaAnalysisModel();
				tableSize.setSchema_name(res.getString("SCHEMA_NAME"));
				tableSize.setTable_name(res.getString("TABLE_NAME"));
				tableSize.setNum_rows(res.getString("NUM_ROWS"));
				tableSize.setMb(res.getString("MB"));
				tableSizeList.add(tableSize);
			}

		} catch (SQLException e) {
			logger.error("Exception while get table size!", e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
			}
		} finally {
			DatabaseUtility.surrenderConnection(con, stmt, res);
		}
		return tableSizeList;
	}

	public static void main(String[] args) {

		List<SchemaAnalysisModel> tableSizeList = getSchemaTableSize("THEMEBRIDGE");

		for (int i = 0; i < tableSizeList.size(); i++) {
			logger.debug(tableSizeList.get(i).getSchema_name());
			logger.debug(tableSizeList.get(i).getTable_name());
			logger.debug(tableSizeList.get(i).getNum_rows());
			logger.debug(tableSizeList.get(i).getMb());
		}
	}

}
