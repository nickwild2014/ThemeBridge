package com.bs.themebridge.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * @since 2016-JUN-15
 * @version 1.01
 * @author Prasath Ravicandran
 * @category BSIT
 *
 */
public class DatabaseUtility {

	private final static Logger logger = Logger.getLogger(DatabaseUtility.class);

	public static void main(String args[]) {
		logger.debug("Themebridge connection : " + getThemebridgeConnection());
		logger.debug("TIZONE connection : " + getTizoneConnection());
		// logger.debug(getIdbTiplusConnection());
		logger.debug(getIdbFcConnection());
	}

	/**
	 * Get <i><b>THEMEBRIDGE</b></i> connection using WAS-JNDI
	 *
	 * @return {@code Themebridge }{@link Connection}
	 */
	
	
//	public static Connection getThemebridgeConnection() {
//
//		Context ctx = null;
//		Connection conn = null;
//
//		Hashtable<String, String> ht = new Hashtable<String, String>();
//		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
//		ht.put(Context.PROVIDER_URL, "t3://172.16.251.202:7726");
//
//		try {
//			ctx = new InitialContext(ht);
//			javax.sql.DataSource ds = (javax.sql.DataSource) ctx
//					.lookup("jdbc/themebridge");
//			logger.info("Hashtable +>" + ht);
//			conn = ds.getConnection();
//		} catch (NamingException e) {
//			e.printStackTrace();
//			logger.error("Connection  NamingException !1!!!!", e);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			logger.error("Connection  SQLException !1!!!!", e);
//		}
//
//		return conn;
//	}
	
	public static Connection getTresuryConnection() {

		Context ctx = null;
		Connection conn = null;

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://172.16.251.202:7726");

		try {
			ctx = new InitialContext(ht);
			javax.sql.DataSource ds = (javax.sql.DataSource) ctx
					.lookup("jdbc/tresury");
			logger.info("Hashtable +>" + ht);
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			logger.error("Connection  NamingException !1!!!!", e);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Connection  SQLException !1!!!!", e);
		}

		return conn;
	}

	
	public static Connection getTizoneConnection() {

		Context ctx = null;
		Connection conn = null;

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://172.16.251.202:7726");

		try {
			ctx = new InitialContext(ht);
			javax.sql.DataSource ds = (javax.sql.DataSource) ctx
					.lookup("jdbc/zone");
			logger.info("Hashtable +>" + ht);
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			logger.error("Connection  NamingException !1!!!!", e);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Connection  SQLException !1!!!!", e);
		}

		return conn;
	}
	
//	public static Connection getTizoneConnection() {
//		Connection connection = null;
//		try {
//			Properties param = new Properties();
//			param.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
//			Context initialContext;
//			initialContext = new InitialContext(param);
//			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/zone");
//			connection = dataSource.getConnection();
//			if (connection == null) {
//				logger.debug("ThemeBridge connection failed!");
//			}
//
//		} catch (NamingException e) {
//			logger.error("ThemeBridge NamingException!" + e.getMessage(), e);
//			e.printStackTrace();
//
//		} catch (SQLException e) {
//			logger.error("ThemeBridge SQLException!" + e.getMessage(), e);
//			e.printStackTrace();
//		}
//		return connection;
//	}

	/**
	 * Get <b>TIZONE</b> connection using WAS-JNDI
	 *
	 * @return {@code TIZONE }{@link Connection} //
	 */
//	public static Connection getTizoneConnection() {
//		Connection connection = null;
//		try {
//			Properties param = new Properties();
//			param.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
//			Context initialContext = new InitialContext(param);
//			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/zone");
//			connection = dataSource.getConnection();
//			if (connection == null) {
//				logger.debug("TIZONE connection failed!");
//			}
//		} catch (NamingException e) {
//			logger.error("TIZONE NamingException!" + e.getMessage(), e);
//			e.printStackTrace();
//
//		} catch (SQLException e) {
//			logger.error("TIZONE SQLException!" + e.getMessage(), e);
//			e.printStackTrace();
//		}
//		return connection;
//	}

	/**
	 * Get <b>RPTZONE</b> connection using WAS-JNDI
	 *
	 * @return {@code RPTZONE }{@link Connection} //
	 */
	public static Connection getRptzoneConnection() {
		Connection connection = null;
		try {
			Properties param = new Properties();
			param.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context initialContext = new InitialContext(param);
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/rptzone");
			connection = dataSource.getConnection();
			if (connection == null) {
				logger.debug("TIZONE connection failed!");
			}
		} catch (NamingException e) {
			logger.error("TIZONE NamingException!" + e.getMessage(), e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("TIZONE SQLException!" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Get <b>TIGLOBAL</b> connection using WAS-JNDI
	 *
	 * @return {@code TIGLOBAL }{@link Connection}
	 */
	public static Connection getTiglobalConnection() {
		Connection connection = null;
		try {
			Properties param = new Properties();
			param.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context initialContext = new InitialContext(param);
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/global");
			connection = dataSource.getConnection();
			if (connection == null) {
				logger.debug("TIGLOBAL connection failed!");
			}
		} catch (NamingException e) {
			logger.error("TIGLOBAL NamingException!" + e.getMessage(), e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("TIGLOBAL SQLException!" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Get <i><b>IDB-RATE</b></i> connection using WAS-JNDI
	 *
	 * @return {@code IDB-RATE }{@link Connection}
	 */
	public static Connection getIdbFcConnection() {
		Connection connection = null;
		try {
			Properties param = new Properties();
			param.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context initialContext = new InitialContext(param);
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/idbfc");// jdbc/idb
			connection = dataSource.getConnection();
			if (connection == null) {
				logger.debug("IDB-FC connection failed!");
			}
		} catch (NamingException e) {
			logger.error("IDB-FC NamingException!" + e.getMessage(), e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("IDB-FC SQLException!" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * getIdbtiplusConnection
	 * 
	 * Get <b>IDB-STATICDATA</b> connection using WAS-JNDI
	 *
	 * @return {@code IDB-STATICDATA }{@link Connection}
	 */
	public static Connection getIdbTiplusConnection() {
		Connection connection = null;
		try {
			Properties param = new Properties();
			param.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context initialContext = new InitialContext(param);
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/idbtiplus");// jdbc/idbstatic
			connection = dataSource.getConnection();
			if (connection == null) {
				logger.debug("IDB-TIPLUS connection failed!");
			}
		} catch (NamingException e) {
			logger.error("IDB-TIPLUS NamingException!" + e.getMessage(), e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("IDB-TIPLUS SQLException!" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Get <b>PAYMENT-HUB</b> connection using WAS-JNDI
	 *
	 * @return {@code PAYMENT-HUB }{@link Connection}
	 */
	public static Connection getNeftRtgsConnection() {
		Connection connection = null;
		try {
			Properties param = new Properties();
			param.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context initialContext = new InitialContext(param);
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/neftrtgs");
			connection = dataSource.getConnection();
			if (connection == null) {
				logger.debug("PAYMENT-HUB connection failed!");
			}
		} catch (NamingException e) {
			logger.error("PAYMENT-HUB NamingException!" + e.getMessage(), e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("PAYMENT-HUB SQLException!" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Get <b>SMS-HUB</b> connection using WAS-JNDI
	 *
	 * @return {@code SMS-HUB }{@link Connection}
	 */
	public static Connection getSMSConnection() {
		Connection connection = null;
		try {
			Properties param = new Properties();
			param.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context initialContext = new InitialContext(param);
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/smsalert");
			connection = dataSource.getConnection();
			if (connection == null) {
				logger.debug("SMS-HUB connection failed!");
			}
		} catch (NamingException e) {
			logger.error("SMS-HUB NamingException!" + e.getMessage(), e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("SMS-HUB SQLException!" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Get <b>IDB-INTERNAL</b> connection using WAS-JNDI
	 *
	 * @return {@code IDB-TEST }{@link Connection}
	 */
	public static Connection getIdbinternalConnection() {
		Connection connection = null;
		try {
			Properties param = new Properties();
			param.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
			Context initialContext = new InitialContext(param);
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/idbinternal");
			connection = dataSource.getConnection();
			if (connection == null) {
				logger.debug("IDB-INTERNAL connection failed!");
			}
		} catch (NamingException e) {
			logger.error("IDB-INTERNAL NamingException!" + e.getMessage(), e);
			e.printStackTrace();

		} catch (SQLException e) {
			logger.error("IDB-INTERNAL SQLException!" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 
	 * @param aConnection
	 *            {@code allows }{@link Connection}
	 * @param aStatement
	 *            {@code allows }{@link Statement}
	 * @param aResultset
	 *            {@code allows }{@link ResultSet}
	 */
	public static void surrenderConnection(Connection aConnection, Statement aStatement, ResultSet aResultset) {
		/**
		 * Order to close => Resultset, Statement / PreparedStatement,
		 * Connection
		 */
		try {
			if (ValidationsUtil.isValidObject(aResultset))
				aResultset.close();
		} catch (SQLException e) {
			logger.error("Close Resultset Failed!" + e.getMessage());
			e.printStackTrace();
		}
		try {
			if (ValidationsUtil.isValidObject(aStatement))
				aStatement.close();
		} catch (SQLException e) {
			logger.error("Close Statement Failed!" + e.getMessage());
			e.printStackTrace();
		}
		try {
			if (ValidationsUtil.isValidObject(aConnection)) {
				aConnection.close();
			}
		} catch (SQLException e) {
			logger.error("Close Connection Failed!" + e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param aConnection
	 *            {@code allows }{@link Connection}
	 * @param sStatement
	 *            {@code allows }{@link PreparedStatement}
	 * @param aResultset
	 *            {@code allows }{@link ResultSet}
	 */
	public static void surrenderPrepdConnection(Connection aConnection, PreparedStatement aPreparedStatement,
			ResultSet aResultset) {
		/**
		 * Order to close => Resultset, Statement / PreparedStatement,
		 * Connection
		 */
		try {
			if (ValidationsUtil.isValidObject(aResultset))
				aResultset.close();
		} catch (SQLException e) {
			logger.error("Close Resultset Failed!" + e.getMessage(), e);
			e.printStackTrace();
		}
		try {
			if (ValidationsUtil.isValidObject(aPreparedStatement))
				aPreparedStatement.close();
		} catch (SQLException e) {
			logger.error("Close PreparedStatement Failed!" + e.getMessage(), e);
			e.printStackTrace();
		}
		try {
			if (ValidationsUtil.isValidObject(aConnection)) {
				aConnection.close();
			}
		} catch (SQLException e) {
			logger.error("Close Connection Failed!" + e.getMessage(), e);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param aConnection
	 *            {@code allows }{@link Connection}
	 * @param sStatement
	 *            {@code allows }{@link CallableStatement}
	 * @param aResultset
	 *            {@code allows }{@link ResultSet}
	 */
	public static void surrenderCallableConnection(Connection aConnection, CallableStatement aCallableStatement,
			ResultSet aResultset) {
		/**
		 * Order to close => Resultset, Statement / PreparedStatement,
		 * Connection
		 */
		try {
			if (ValidationsUtil.isValidObject(aResultset))
				aResultset.close();
		} catch (SQLException e) {
			logger.error("Close Resultset Failed!" + e.getMessage(), e);
			e.printStackTrace();
		}
		try {
			if (ValidationsUtil.isValidObject(aCallableStatement))
				aCallableStatement.close();
		} catch (SQLException e) {
			logger.error("Close CallableStatement Failed!" + e.getMessage(), e);
			e.printStackTrace();
		}
		try {
			if (ValidationsUtil.isValidObject(aConnection)) {
				aConnection.close();
			}
		} catch (SQLException e) {
			logger.error("Close Connection Failed!" + e.getMessage(), e);
			e.printStackTrace();
		}

	}

	/************* Below method are only for local testing *****************/

	 public static Connection getThemebridgeConnection() {
	
	 Connection connection = null;
	 try {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	
	 String SIT_JdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		
	 /** SIT **/
	 connection = DriverManager.getConnection(SIT_JdbcURL, "HR",
	 "test1234");
	 if (connection == null) {
	 logger.debug("Themebridge connection(DB) failed! >>-->> null");
	 }
	
	 } catch (ClassNotFoundException e) {
	 logger.debug("ThemeBridge ClassNotFoundException!" + e.getMessage());
	 e.printStackTrace();
	
	 } catch (SQLException e) {
	 logger.debug("ThemeBridge SQLException!" + e.getMessage());
	 e.printStackTrace();
	
	 } catch (Exception e) {
	 logger.debug("ThemeBridge Exception!" + e.getMessage());
	 e.printStackTrace();
	 }
	 return connection;
	 }

//	 public static Connection getTizoneConnection() {
//	
//	 Connection connection = null;
//	 try {
//	 Class.forName("oracle.jdbc.driver.OracleDriver");
//	
//	 String SIT_JdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
//	
//	
//	 /** SIT **/
//	 connection = DriverManager.getConnection(SIT_JdbcURL, "HR",
//	 "test1234");
//
//	
//	 if (connection == null) {
//	 logger.debug("Zone1 connection failed! >>-->> null");
//	 }
//	
//	 } catch (ClassNotFoundException e) {
//	 logger.debug("Zone1 ClassNotFoundException!" + e.getMessage());
//	 e.printStackTrace();
//	
//	 } catch (SQLException e) {
//	 logger.debug("Zone1 SQLException!" + e.getMessage());
//	 e.printStackTrace();
//	
//	 } catch (Exception e) {
//	 logger.debug("Zone1 Exception!" + e.getMessage());
//	 e.printStackTrace();
//	 }
//	 return connection;
//	 }

	// public static Connection getIdbFcConnection() {
	//
	// Connection connection = null;
	// try {
	// String idbDriver = FileProperties.getFileProperties("IdbDbDriverUrl");
	// String idbUserName = FileProperties.getFileProperties("IdbfcDbUsername");
	// String idbEncryptedPassword =
	// FileProperties.getFileProperties("IdbfcDbEncryptedPassword");
	// String dbDecryptedPassword =
	// EncryptDecrypt.decrypt(idbEncryptedPassword);
	// logger.debug("IdbfcDbEncryptedPassword " + dbDecryptedPassword);
	//
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// connection = DriverManager.getConnection(idbDriver, idbUserName,
	// dbDecryptedPassword);
	// if (connection == null) {
	// logger.debug("IDB-FC connection failed! >>-->> null");
	// }
	//
	// } catch (ClassNotFoundException e) {
	// logger.error("IDB-FC ClassNotFoundException!" + e.getMessage(), e);
	// e.printStackTrace();
	//
	// } catch (SQLException e) {
	// logger.error("IDB-FC SQLException!" + e.getMessage(), e);
	// e.printStackTrace();
	//
	// } catch (Exception e) {
	// logger.error("IDB-FC Exception!" + e.getMessage(), e);
	// e.printStackTrace();
	// }
	// return connection;
	// }

	// public static Connection getIdbTiplusConnection() {
	//
	// Connection connection = null;
	// try {
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// connection =
	// DriverManager.getConnection("jdbc:oracle:thin:@10.10.56.174:1530:IDB",
	// "TIPLUS", "tiplus");
	// if (connection == null) {
	// logger.debug("IDB-TIPLUS connection failed! >>-->> null");
	// }
	//
	// } catch (ClassNotFoundException e) {
	// logger.error("IDB-TIPLUS ClassNotFoundException!" + e.getMessage());
	// e.printStackTrace();
	//
	// } catch (SQLException e) {
	// logger.error("IDB-TIPLUS SQLException!" + e.getMessage());
	// e.printStackTrace();
	//
	// } catch (Exception e) {
	// logger.error("IDB-TIPLUS Exception!" + e.getMessage());
	// e.printStackTrace();
	// }
	// return connection;
	// }

	// /**
	// * Get <b>PAYMENT-HUB</b> connection using JDBC-Driver
	// *
	// * @return {@code PAYMENT-HUB }{@link Connection}
	// */
	// public static Connection getNeftRtgsConnection() {
	//
	// Connection connection = null;
	// try {
	// String neftRtgsDriverUrl =
	// FileProperties.getFileProperties("NeftRtgsDbDriverUrl");
	// String NeftRtgsDbUserName =
	// FileProperties.getFileProperties("NeftRtgsDbUsername");
	// String NeftRtgsDbEncryptedPassword =
	// FileProperties.getFileProperties("NeftRtgsDbEncryptedPassword");
	// String dbDecryptedPassword =
	// EncryptDecrypt.decrypt(NeftRtgsDbEncryptedPassword);
	// // logger.debug("dbEncryptedPassword " + dbEncryptedPassword);
	//
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// connection = DriverManager.getConnection(neftRtgsDriverUrl,
	// NeftRtgsDbUserName, dbDecryptedPassword);
	// if (connection == null) {
	// logger.debug("PAYMENT-HUB connection failed! >>-->> null");
	// }
	//
	// } catch (ClassNotFoundException e) {
	// logger.error("PAYMENT-HUB ClassNotFoundException!" + e.getMessage());
	// e.printStackTrace();
	//
	// } catch (SQLException e) {
	// logger.error("PAYMENT-HUB SQLException!" + e.getMessage());
	// e.printStackTrace();
	//
	// } catch (Exception e) {
	// logger.error("PAYMENT-HUB Exception!" + e.getMessage());
	// e.printStackTrace();
	// }
	// return connection;
	// }

	// /**
	// * Get <b>SMS-HUB</b> connection using JDBC-Driver
	// *
	// * @return {@code SMS-HUB }{@link Connection}
	// */
	// public static Connection getSMSConnection() {
	//
	// Connection connection = null;
	// try {
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// connection =
	// DriverManager.getConnection("jdbc:oracle:thin:@10.10.19.141:10002:finuatdb",
	// "alertuser",
	// "T06ZeBKbKCHebF");
	// if (connection == null) {
	// logger.debug("SMS-HUB connection failed! >>-->> null");
	// }
	//
	// } catch (ClassNotFoundException e) {
	// logger.error("SMS-HUB ClassNotFoundException!" + e.getMessage(), e);
	// e.printStackTrace();
	//
	// } catch (SQLException e) {
	// logger.error("SMS-HUB SQLException!" + e.getMessage(), e);
	// e.printStackTrace();
	//
	// } catch (Exception e) {
	// logger.error("SMS-HUB Exception!" + e.getMessage(), e);
	// e.printStackTrace();
	// }
	// return connection;
	// }
	//
	// /**
	// * Get <b>IDB-INTERNAL</b> connection using JDBC-Driver
	// *
	// * @return {@code IDB-TEST }{@link Connection}
	// */
	// public static Connection getIdbinternalConnection() {
	//
	// Connection connection = null;
	// try {
	// String idbinternalDriver =
	// FileProperties.getFileProperties("IdbinternalDbDriverUrl");
	// String idbinternalUserName =
	// FileProperties.getFileProperties("IdbinternalDbUsername");
	// String idbinternalEncryptedPassword =
	// FileProperties.getFileProperties("IdbinternalDbEncryptedPassword");
	// String dbDecryptedPassword =
	// EncryptDecrypt.decrypt(idbinternalEncryptedPassword);
	// // logger.debug("dbEncryptedPassword " + dbEncryptedPassword);
	//
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// connection = DriverManager.getConnection(idbinternalDriver,
	// idbinternalUserName, dbDecryptedPassword);
	// if (connection == null) {
	// logger.debug("SMS-HUB connection failed! >>-->> null");
	// }
	//
	// } catch (ClassNotFoundException e) {
	// logger.error("IDB-INTERNAL ClassNotFoundException!" + e.getMessage(), e);
	// e.printStackTrace();
	//
	// } catch (SQLException e) {
	// logger.error("IDB-INTERNAL SQLException!" + e.getMessage(), e);
	// e.printStackTrace();
	//
	// } catch (Exception e) {
	// logger.error("IDB-INTERNAL Exception!" + e.getMessage(), e);
	// e.printStackTrace();
	// }
	// return connection;
	// }
	//
}
