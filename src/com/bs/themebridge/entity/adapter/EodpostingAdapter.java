package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Eodposting;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class EodpostingAdapter extends ThemeBridgeEntityManager {

	public EodpostingAdapter() {
		super();
	}

	/**
	 * To add a Eodposting log data object
	 * 
	 * @param eodpostinglog
	 */
	public void addProperty(Eodposting eodpostinglog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(eodpostinglog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(eodpostinglog);
				entityManager.getTransaction().commit();
				// logger.debug("Eodposting log added successfully");
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
	 * To get all Eodposting log data values
	 * 
	 * @return List<Eodposting>
	 */
	public List<Eodposting> getAllProperties() {
		List<Eodposting> EodpostingLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Eodposting.findAll");
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
	 * To get Eodposting log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public Eodposting getKeyProperty(String id) {
		Eodposting EodpostingLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					EodpostingLog = entityManager.find(Eodposting.class, new BigDecimal(id));
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
	 * To update a Eodposting log data value
	 * 
	 * @param eodpostinglog
	 */
	public void updateProperty(Eodposting eodpostinglog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(eodpostinglog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(eodpostinglog);
				entityManager.getTransaction().commit();
				// logger.debug("Eodposting log data modified successfully");
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
	 * To remove a Eodposting log data value
	 * 
	 * @param eodpostinglog
	 */
	public void removeProperty(Eodposting eodpostinglog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(eodpostinglog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(eodpostinglog);
				entityManager.getTransaction().commit();
				// logger.debug("Eodposting log data removed successfully");
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
	 * To get limited count of Eodposting values
	 * <p>
	 * {@code Default limit count is 200}
	 * </p>
	 * 
	 * @return List<Eodposting>
	 */
	public List<Eodposting> getLimitCountProperties() {
		List<Eodposting> EodpostingList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Eodposting.findAll");
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
	 * To get Eodposting log data values with masterReference, eventReference,
	 * operation
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Eodposting}
	 */
	public Eodposting getEodpostingByMasterEventReferenceOperation(String masterReference, String eventReference,
			String operation) {
		Eodposting EodpostingLog = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("Eodposting.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						EodpostingLog = (Eodposting) query.getResultList().get(0);
					}
				} else {
					logger.error("Eodposting log missing mandatory field(s)");
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
	 * To get logging page Eodposting log data values
	 * 
	 * @return List<Eodposting>
	 */
	public List<Eodposting> getLoggingListTransactionProperties() {
		List<Eodposting> eodpostinglogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Eodposting.findByLogList");
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
