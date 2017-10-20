package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.DatabaseUtility;

public class Skeleton {

	private final static Logger logger = Logger.getLogger(Skeleton.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String getForceDebit(String masterReference, String eventReference) {

		String forceDrNo = "";
		ResultSet aResultset = null;
		Connection aConnection = null;
		PreparedStatement aPreparedStatement = null;
		try {
			aConnection = DatabaseUtility.getTizoneConnection();
			aPreparedStatement = aConnection.prepareStatement(
					"SELECT TRIM(EXT.FORCDEBT) AS FORCDEBIT FROM EXTEVENT EXT JOIN BASEEVENT BEV ON BEV.KEY97 = EXT.EVENT "
							+ " JOIN MASTER MAS ON MAS.KEY97=BEV.MASTER_KEY WHERE trim(MAS.MASTER_REF) = ? AND trim((BEV.REFNO_PFIX || LPAD(BEV.REFNO_SERL, 3, 0)) ) = ? ");
			aPreparedStatement.setString(1, masterReference);
			aPreparedStatement.setString(2, eventReference);
			aResultset = aPreparedStatement.executeQuery();
			while (aResultset.next()) {
				forceDrNo = aResultset.getString("FORCDEBIT");
			}

		} catch (Exception e) {
			logger.debug("Force Debit Credit Exceptions! " + e.getMessage());
			e.printStackTrace();

		} finally {
			DatabaseUtility.surrenderPrepdConnection(aConnection, aPreparedStatement, aResultset);

		}
		return forceDrNo;
	}

}
