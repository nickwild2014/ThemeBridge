package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Servicelog;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class ServicelogAdapter extends ThemeBridgeEntityManager {

	public ServicelogAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param servicelog
	 */
	public boolean addProperty(Servicelog servicelog) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(servicelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(servicelog);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("Service log added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return result;
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
			addPropertyAgain(servicelog);
		}
		return result;
	}

	/**
	 * 
	 * @param servicelog
	 */
	public void addPropertyAgain(Servicelog servicelog) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(servicelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(servicelog);
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
	 * To get all service log data values
	 * 
	 * @return List<Servicelog>
	 */
	public List<Servicelog> getAllProperties() {
		List<Servicelog> serviceLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Servicelog.findAll");
				serviceLogList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return serviceLogList;
	}

	/**
	 * To get service log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public Servicelog getKeyProperty(String id) {
		Servicelog serviceLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					serviceLog = entityManager.find(Servicelog.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return serviceLog;
	}

	/**
	 * To update a service log data value
	 * 
	 * @param servicelog
	 */
	public void updateProperty(Servicelog servicelog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(servicelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(servicelog);
				entityManager.getTransaction().commit();
				// logger.debug("Service log data modified successfully");
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
	 * To remove a service log data value
	 * 
	 * @param servicelog
	 */
	public void removeProperty(Servicelog servicelog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(servicelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(servicelog);
				entityManager.getTransaction().commit();
				// logger.debug("Service log data removed successfully");
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
	 * To get limited count of service values
	 * <p>
	 * {@code Default limit count is 200}
	 * </p>
	 * 
	 * @return List<Servicelog>
	 */
	public List<Servicelog> getLimitCountProperties() {
		List<Servicelog> serviceList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Servicelog.findAll");
				query.setMaxResults(200);
				serviceList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return serviceList;
	}

	/**
	 * To get service log data values with masterReference, eventReference,
	 * operation
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Servicelog}
	 */
	public Servicelog getServicelogByMasterEventReferenceOperation(String masterReference, String eventReference,
			String operation) {
		Servicelog serviceLog = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("Servicelog.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						serviceLog = (Servicelog) query.getResultList().get(0);
					}
				} else {
					logger.error("Service log missing mandatory field(s)");
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return serviceLog;
	}

	/**
	 * To get logging page service log data values
	 * 
	 * @return List<Servicelog>
	 */
	public List<Servicelog> getLoggingListTransactionProperties() {
		List<Servicelog> servicelogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Servicelog.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					servicelogList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return servicelogList;
	}

}
