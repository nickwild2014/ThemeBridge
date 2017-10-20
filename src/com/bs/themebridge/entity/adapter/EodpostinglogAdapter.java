package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Eodpostinglog;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class EodpostinglogAdapter extends ThemeBridgeEntityManager {

	public EodpostinglogAdapter() {
		super();
	}

	/**
	 * To add a Eodpostinglog log data object
	 * 
	 * @param eodpostinglog
	 */
	public void addProperty(Eodpostinglog eodpostinglog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(eodpostinglog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(eodpostinglog);
				entityManager.getTransaction().commit();
				// logger.debug("Eodpostinglog log added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
		}
	}

	/**
	 * To get all Eodpostinglog log data values
	 * 
	 * @return List<Eodpostinglog>
	 */
	public List<Eodpostinglog> getAllProperties() {
		List<Eodpostinglog> EodpostingLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Eodpostinglog.findAll");
				EodpostingLogList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return EodpostingLogList;
	}

	/**
	 * To get Eodpostinglog log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public Eodpostinglog getKeyProperty(String id) {
		Eodpostinglog EodpostingLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					EodpostingLog = entityManager.find(Eodpostinglog.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return EodpostingLog;
	}

	/**
	 * To update a Eodpostinglog log data value
	 * 
	 * @param eodpostinglog
	 */
	public void updateProperty(Eodpostinglog eodpostinglog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(eodpostinglog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(eodpostinglog);
				entityManager.getTransaction().commit();
				// logger.debug("Eodpostinglog log data modified successfully");
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
	 * To remove a Eodpostinglog log data value
	 * 
	 * @param eodpostinglog
	 */
	public void removeProperty(Eodpostinglog eodpostinglog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(eodpostinglog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(eodpostinglog);
				entityManager.getTransaction().commit();
				// logger.debug("Eodpostinglog log data removed successfully");
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
	 * To get limited count of Eodpostinglog values
	 * <p>
	 * {@code Default limit count is 200}
	 * </p>
	 * 
	 * @return List<Eodpostinglog>
	 */
	public List<Eodpostinglog> getLimitCountProperties() {
		List<Eodpostinglog> EodpostingList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Eodpostinglog.findAll");
				query.setMaxResults(200);
				EodpostingList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return EodpostingList;
	}

	/**
	 * To get Eodpostinglog log data values with masterReference,
	 * eventReference, operation
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Eodpostinglog}
	 */
	public Eodpostinglog getEodpostingByMasterEventReferenceOperation(String masterReference, String eventReference,
			String operation) {
		Eodpostinglog EodpostingLog = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("Eodpostinglog.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						EodpostingLog = (Eodpostinglog) query.getResultList().get(0);
					}
				} else {
					logger.error("Eodpostinglog log missing mandatory field(s)");
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return EodpostingLog;
	}

	/**
	 * To get logging page Eodpostinglog log data values
	 * 
	 * @return List<Eodpostinglog>
	 */
	public List<Eodpostinglog> getLoggingListTransactionProperties() {
		List<Eodpostinglog> eodpostinglogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Eodpostinglog.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					eodpostinglogList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return eodpostinglogList;
	}

}
