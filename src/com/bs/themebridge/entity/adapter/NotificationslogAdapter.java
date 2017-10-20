package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Notificationslog;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class NotificationslogAdapter extends ThemeBridgeEntityManager {

	public NotificationslogAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param notifications
	 */
	public boolean addProperty(Notificationslog notifications) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(notifications)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(notifications);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("Notifications log added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return result;
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
			addPropertyAgain(notifications);
		}
		return result;
	}

	/**
	 * 
	 * @param transactionData
	 */
	public void addPropertyAgain(Notificationslog notifications) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(notifications)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(notifications);
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
	 * @return List<Notificationslog>
	 */
	public List<Notificationslog> getAllProperties() {
		List<Notificationslog> serviceLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Notificationslog.findAll");
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
	public Notificationslog getKeyProperty(String id) {
		Notificationslog serviceLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					serviceLog = entityManager.find(Notificationslog.class, new BigDecimal(id));
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
	 * @param notifications
	 */
	public void updateProperty(Notificationslog notifications) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(notifications)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(notifications);
				entityManager.getTransaction().commit();
				// logger.debug("Notifications log data modified successfully");
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
	 * @param notifications
	 */
	public void removeProperty(Notificationslog notifications) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(notifications)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(notifications);
				entityManager.getTransaction().commit();
				// logger.debug("Notifications log data removed successfully");
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
	 * @return List<Notificationslog>
	 */
	public List<Notificationslog> getLimitCountProperties() {
		List<Notificationslog> NotificationsList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Notificationslog.findAll");
				query.setMaxResults(200);
				NotificationsList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return NotificationsList;
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
	 * @return {@link Notificationslog}
	 */
	public Notificationslog getNotificationslogByMasterEventReferenceOperation(String masterReference,
			String eventReference, String operation) {
		Notificationslog serviceLog = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("Notificationslog.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						serviceLog = (Notificationslog) query.getResultList().get(0);
					}
				} else {
					logger.error("Notifications log missing mandatory field(s)");
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
	 * @return List<Notificationslog>
	 */
	public List<Notificationslog> getLoggingListTransactionProperties() {
		List<Notificationslog> notificationsList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Notificationslog.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					notificationsList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return notificationsList;
	}

}
