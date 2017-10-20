package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Limitsoftblock;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LimitsoftblockAdapter extends ThemeBridgeEntityManager {

	public LimitsoftblockAdapter() {
		super();
	}

	/**
	 * To add a liendetails log data object
	 * 
	 * @param Limitsoftblock
	 */
	public boolean addProperty(Limitsoftblock Limitsoftblock) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitsoftblock)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(Limitsoftblock);
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
			addPropertyAgain(Limitsoftblock);
		}
		return result;
	}

	/**
	 * 
	 * @param Limitsoftblock
	 */
	public void addPropertyAgain(Limitsoftblock Limitsoftblock) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitsoftblock)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(Limitsoftblock);
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
	 * To get all liendetails log data values
	 * 
	 * @return List<Limitsoftblock>
	 */
	public List<Limitsoftblock> getAllProperties() {
		List<Limitsoftblock> liendetailsLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitsoftblock.findAll");
				liendetailsLogList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return liendetailsLogList;
	}

	/**
	 * To get liendetails log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public Limitsoftblock getKeyProperty(String id) {
		Limitsoftblock liendetailsLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					liendetailsLog = entityManager.find(Limitsoftblock.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return liendetailsLog;
	}

	/**
	 * To get Customer limit object by Facility ID
	 * 
	 * @param id
	 * @return {@link Customer limit}
	 */
	public List<Limitsoftblock> getCustomerLimitDetailsById(String reservationId) {
		logger.debug("Customer limit get by id--" + reservationId);
		List<Limitsoftblock> customerLimit = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(reservationId)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitsoftblock.findByReservationid");
				query.setParameter("reservationid", reservationId);
				customerLimit = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return customerLimit;
	}

	/**
	 * 
	 * @param masterReference
	 *            {@code allows }{@link String}
	 * @param eventReference
	 *            {@code allows }{@link String}
	 * @param flag
	 *            {@code allows }{@link String}
	 * @return
	 */
	public List<Limitsoftblock> getLimitDetailsByMasterEventLimitFlag(String masterReference, String eventReference,
			String limitFlag) {
		// logger.debug("Customer limit get by id--" + masterReference);
		logger.debug("Customer limit get by id--" + eventReference);
		List<Limitsoftblock> customerLimit = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)
				&& ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitsoftblock.findByMasterEventLimitFlag");
				query.setParameter("masterreference", masterReference);
				query.setParameter("eventreference", eventReference);
				query.setParameter("limitumlflag", limitFlag);
				customerLimit = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return customerLimit;
	}

	/**
	 * To get Customer limit object by Facility ID
	 * 
	 * @param id
	 * @return {@link Customer limit}
	 */
	public List<Limitsoftblock> getCustomerLimitDetailsByMasterEvent(String masterReference, String eventReference) {
		logger.debug("Customer limit get by id--" + masterReference);
		logger.debug("Customer limit get by id--" + eventReference);
		List<Limitsoftblock> customerLimit = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(masterReference)
				&& ValidationsUtil.isValidString(eventReference)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitsoftblock.findByMasterEventId");
				query.setParameter("masterreference", masterReference);
				query.setParameter("eventreference", eventReference);
				customerLimit = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return customerLimit;
	}

	/**
	 * To get liendetails log data values with masterReference, eventReference,
	 * operation
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Limitsoftblock}
	 */
	public Limitsoftblock getLimitexposureByMasterEventReference(String masterReference, String eventReference) {
		logger.debug(masterReference + eventReference);
		Limitsoftblock liendetailsLog = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(masterReference) && ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("Limitsoftblock.findByMasterEventId");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						logger.debug("TEST");
						liendetailsLog = (Limitsoftblock) query.getResultList().get(0);
					}
				} else {
					logger.error("Limitsoftblock log missing mandatory field(s)");
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return liendetailsLog;
	}

	/**
	 * To update a liendetails log data value
	 * 
	 * @param Limitsoftblock
	 */
	public void updateProperty(Limitsoftblock Limitsoftblock) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitsoftblock)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(Limitsoftblock);
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
	 * To remove a liendetails log data value
	 * 
	 * @param Limitsoftblock
	 */
	public void removeProperty(Limitsoftblock Limitsoftblock) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitsoftblock)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(Limitsoftblock);
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
	 * To get limited count of liendetails values
	 * <p>
	 * {@code Default limit count is 200}
	 * </p>
	 * 
	 * @return List<Limitsoftblock>
	 */
	public List<Limitsoftblock> getLimitCountProperties() {
		List<Limitsoftblock> liendetailsList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitsoftblock.findAll");
				query.setMaxResults(200);
				liendetailsList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return liendetailsList;
	}

	/**
	 * To get logging page liendetails log data values
	 * 
	 * @return List<Limitsoftblock>
	 */
	public List<Limitsoftblock> getLoggingListTransactionProperties() {
		List<Limitsoftblock> liendetailslogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitsoftblock.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					liendetailslogList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return liendetailslogList;
	}

}
