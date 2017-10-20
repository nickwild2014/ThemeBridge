package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Limitexposure;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LimitexposureAdapter extends ThemeBridgeEntityManager {

	public LimitexposureAdapter() {
		super();
	}

	/**
	 * To add a liendetails log data object
	 * 
	 * @param Limitexposurelog
	 */
	public boolean addProperty(Limitexposure Limitexposurelog) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitexposurelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(Limitexposurelog);
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
			addPropertyAgain(Limitexposurelog);
		}
		return result;
	}

	/**
	 * 
	 * @param Limitexposurelog
	 */
	public void addPropertyAgain(Limitexposure Limitexposurelog) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitexposurelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(Limitexposurelog);
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
	 * @return List<Limitexposure>
	 */
	public List<Limitexposure> getAllProperties() {
		List<Limitexposure> liendetailsLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitexposure.findAll");
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
	public Limitexposure getKeyProperty(String id) {
		Limitexposure liendetailsLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					liendetailsLog = entityManager.find(Limitexposure.class, new BigDecimal(id));
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
	 * @param Limitexposurelog
	 */
	public void updateProperty(Limitexposure Limitexposurelog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitexposurelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(Limitexposurelog);
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
	 * @param Limitexposurelog
	 */
	public void removeProperty(Limitexposure Limitexposurelog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(Limitexposurelog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(Limitexposurelog);
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
	 * @return List<Limitexposure>
	 */
	public List<Limitexposure> getLimitCountProperties() {
		List<Limitexposure> liendetailsList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitexposure.findAll");
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
	 * @return {@link Limitexposure}
	 */
	public Limitexposure getLimitexposureByMasterEventReference(String masterReference, String eventReference) {
		logger.debug(masterReference + eventReference);
		Limitexposure liendetailsLog = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(masterReference) && ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("Limitexposure.findByMasterEventId");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						logger.debug("TEST");
						liendetailsLog = (Limitexposure) query.getResultList().get(0);
					}
				} else {
					logger.error("Limitexposure log missing mandatory field(s)");
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
	 * To get logging page liendetails log data values
	 * 
	 * @return List<Limitexposure>
	 */
	public List<Limitexposure> getLoggingListTransactionProperties() {
		List<Limitexposure> liendetailslogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Limitexposure.findByLogList");
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
