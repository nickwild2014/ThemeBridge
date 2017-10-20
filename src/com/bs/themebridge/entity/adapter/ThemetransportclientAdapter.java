/**
 * 
 */
package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Themetransportclientlog;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * @author Prasath Ravichandran
 * 
 */
public class ThemetransportclientAdapter extends ThemeBridgeEntityManager {

	public ThemetransportclientAdapter() {
		super();
	}

	public boolean addProperty(Themetransportclientlog ThemetransportclientData) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(ThemetransportclientData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(ThemetransportclientData);
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
			addPropertyAgain(ThemetransportclientData);
		}
		return result;
	}

	/**
	 * 
	 * @param ThemetransportclientData
	 */
	public void addPropertyAgain(Themetransportclientlog ThemetransportclientData) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(ThemetransportclientData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(ThemetransportclientData);
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
	 * @return List<Themetransportclientlog>
	 */
	public List<Themetransportclientlog> getAllProperties() {
		List<Themetransportclientlog> transactionList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Themetransportclientlog.findAll");
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
	public Themetransportclientlog getKeyProperty(String id) {
		Themetransportclientlog trn = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					trn = entityManager.find(Themetransportclientlog.class, new BigDecimal(id));
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
	public void updateProperty(Themetransportclientlog transaction) {
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
	public void removeProperty(Themetransportclientlog transaction) {
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
	 * @return {@link Themetransportclientlog}
	 */
	public Themetransportclientlog getTransactionByMasterReference(String masterReference) {
		Themetransportclientlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Themetransportclientlog.findByMasterreference");
				query.setParameter("masterreference", masterReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Themetransportclientlog) query.getResultList().get(0);
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
	 * @return {@link Themetransportclientlog}
	 */
	public Themetransportclientlog getTransactionByEventReference(String eventReference) {
		Themetransportclientlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Themetransportclientlog.findByMasterreference");
				query.setParameter("eventreference", eventReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Themetransportclientlog) query.getResultList().get(0);
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
	 * @return {@link Themetransportclientlog}
	 */
	@SuppressWarnings("unchecked")
	public List<Themetransportclientlog> getTransactionByMasterAndEventReference(String masterReference,
			String eventReference) {
		List<Themetransportclientlog> transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)
				&& ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Themetransportclientlog.findByMasterAndEventreference");
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
	 * @return {@link Themetransportclientlog}
	 */
	public Themetransportclientlog getTransactionByOperationAndMasterEventReference(String operation,
			String masterReference, String eventReference) {
		Themetransportclientlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(operation)
				&& ValidationsUtil.isValidString(masterReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager
						.createNamedQuery("Themetransportclientlog.findByOperationAndMasterEventReference");
				query.setParameter("operation", operation);
				query.setParameter("masterreference", masterReference);
				query.setParameter("eventreference", eventReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Themetransportclientlog) query.getResultList().get(0);
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
	 * @return {@link Themetransportclientlog}
	 */
	public Themetransportclientlog getTransactionByServiceOperationMasterEventReference(String service,
			String operation, String masterReference, String eventReference) {
		Themetransportclientlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)
				&& ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Themetransportclientlog.findBySOMRER");
				query.setParameter("service", service);
				query.setParameter("operation", operation);
				query.setParameter("masterreference", masterReference);
				query.setParameter("eventreference", eventReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Themetransportclientlog) query.getResultList().get(0);
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
	 * @return {@link Themetransportclientlog}
	 */
	public Themetransportclientlog getTransactionByOperationAndMasterReference(String operation,
			String masterReference) {
		Themetransportclientlog transaction = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(operation)
				&& ValidationsUtil.isValidString(masterReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Themetransportclientlog.findByMasterAndOperation");
				query.setParameter("operation", operation);
				query.setParameter("masterreference", masterReference);
				if (ValidationsUtil.isValidList(query.getResultList())) {
					transaction = (Themetransportclientlog) query.getResultList().get(0);
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
	 * @return List<Themetransportclientlog>
	 */
	@SuppressWarnings("unchecked")
	public List<Themetransportclientlog> getLoggingListTransactionProperties() {
		List<Themetransportclientlog> transactionList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Themetransportclientlog.findByLogList");
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
