/**
 * 
 */
package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Transactionlog;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * @author Prasath Ravichandran
 * 
 */
public class TransactionlogAdapter extends ThemeBridgeEntityManager {

	public TransactionlogAdapter() {
		super();
	}

	public boolean addProperty(Transactionlog transactionData) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(transactionData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(transactionData);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("Transaction data added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return result;
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
			addPropertyAgain(transactionData);
		}
		return result;
	}

	/**
	 * 
	 * @param transactionData
	 */
	public void addPropertyAgain(Transactionlog transactionData) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(transactionData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(transactionData);
				entityManager.getTransaction().commit();
				// logger.debug("Transaction data added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("addPropertyAgain method Entity manager is null");
		}
	}

	/**
	 * To get all Transaction log data values
	 * 
	 * @return List<Transactionlog>
	 */
	public List<Transactionlog> getAllProperties() {
		List<Transactionlog> transactionList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findAll");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transactionList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transactionList;
	}

	/**
	 * To get Transaction log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public Transactionlog getKeyProperty(String id) {
		Transactionlog trn = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					trn = entityManager.find(Transactionlog.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return trn;
	}

	/**
	 * To update a Transaction log data value
	 * 
	 * @param transaction
	 */
	public void updateProperty(Transactionlog transaction) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(transaction)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(transaction);
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log data modified successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
	}

	/**
	 * To remove a Transaction log data value
	 * 
	 * @param transaction
	 */
	public void removeProperty(Transactionlog transaction) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(transaction)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(transaction);
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log data removed successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
	}

	/**
	 * To get a transaction data by master reference
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @return {@link Transactionlog}
	 */
	public Transactionlog getTransactionByMasterReference(String masterReference) {
		Transactionlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findByMasterreference");
				query.setParameter("masterreference", masterReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Transactionlog) query.getResultList().get(0);
				}
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log get successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transaction;
	}

	/**
	 * To get a transaction data by event reference
	 * 
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @return {@link Transactionlog}
	 */
	public Transactionlog getTransactionByEventReference(String eventReference) {
		Transactionlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findByMasterreference");
				query.setParameter("eventreference", eventReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Transactionlog) query.getResultList().get(0);
				}
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log get successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transaction;
	}

	/**
	 * To get a transaction data by master reference
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @return {@link Transactionlog}
	 */
	@SuppressWarnings("unchecked")
	public List<Transactionlog> getTransactionByMasterAndEventReference(String masterReference, String eventReference) {
		List<Transactionlog> transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)
				&& ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findByMasterAndEventreference");
				query.setParameter("masterreference", masterReference);
				query.setParameter("eventreference", eventReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = query.getResultList();
				}
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log get successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transaction;
	}

	/**
	 * To get a transaction data by event reference
	 * 
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @return {@link Transactionlog}
	 */
	public Transactionlog getTransactionByOperationAndMasterEventReference(String operation, String masterReference,
			String eventReference) {
		Transactionlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(operation)
				&& ValidationsUtil.isValidString(masterReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findByOperationAndMasterEventReference");
				query.setParameter("operation", operation);
				query.setParameter("masterreference", masterReference);
				query.setParameter("eventreference", eventReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Transactionlog) query.getResultList().get(0);
				}
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log get successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transaction;
	}

	/**
	 * To get a transaction data by service, operation, masterreference,
	 * eventreference
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Transactionlog}
	 */
	public Transactionlog getTransactionByServiceOperationMasterEventReference(String service, String operation,
			String masterReference, String eventReference) {
		Transactionlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)
				&& ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findBySOMRER");
				query.setParameter("service", service);
				query.setParameter("operation", operation);
				query.setParameter("masterreference", masterReference);
				query.setParameter("eventreference", eventReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Transactionlog) query.getResultList().get(0);
				}
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log get successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transaction;
	}

	/**
	 * To get a transactionlog data by operation and masterreference
	 * 
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Transactionlog}
	 */
	public Transactionlog getTransactionByOperationAndMasterReference(String operation, String masterReference) {
		Transactionlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(operation)
				&& ValidationsUtil.isValidString(masterReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findByMasterAndOperation");
				query.setParameter("operation", operation);
				query.setParameter("masterreference", masterReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Transactionlog) query.getResultList().get(0);
				}
				entityManager.getTransaction().commit();
				// logger.debug("Transaction log get successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transaction;
	}

	/**
	 * To get logging page transaction log data values
	 * 
	 * @return List<Transactionlog>
	 */
	@SuppressWarnings("unchecked")
	public List<Transactionlog> getLoggingListTransactionProperties() {
		List<Transactionlog> transactionList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Transactionlog.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transactionList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return transactionList;
	}

	/**
	 * 
	 * @param id
	 * @param updateMap
	 */
	public static void updateTrasactionLogData(String id, Map<String, String> updateMap) {

		String service = updateMap.get("Service");
		String operation = updateMap.get("Operation");
		String tiRequest = updateMap.get("TIRequest");
		String tiResponse = updateMap.get("TIResponse");
		String status = updateMap.get("Status");
		String masterReference = updateMap.get("MasterReference");
		String eventReference = "";
		String bankRequest = "";
		String bankResponse = "";
		String source = "";
		String sourceSystem = "";
		String targetSystem = "";

		if (operation.equals("Batch") || operation.equals("SARIE")) {
			eventReference = updateMap.get("EventReference");
			bankRequest = updateMap.get("BankRequest");
			bankResponse = updateMap.get("BankResponse");
			source = updateMap.get("Source");
			sourceSystem = updateMap.get("SourceSystem");
			targetSystem = updateMap.get("targetSystem");
		}
		// TransactionLogging.updateTransactionLogData(id, service, operation,
		// "","", tiRequest, tiResponse, bankRequest, bankResponse, status,
		// masterReference, eventReference, source, sourceSystem,
		// targetSystem,"","","");
	}

}
