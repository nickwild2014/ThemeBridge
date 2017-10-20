package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Liendetails;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LiendetailsAdapter extends ThemeBridgeEntityManager {

	public LiendetailsAdapter() {
		super();
	}

	/**
	 * To add a liendetails log data object
	 * 
	 * @param liendetailslog
	 */
	public boolean addProperty(Liendetails liendetailslog) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(liendetailslog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(liendetailslog);
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
			addPropertyAgain(liendetailslog);
		}
		return result;
	}

	/**
	 * 
	 * @param liendetailslog
	 */
	public void addPropertyAgain(Liendetails liendetailslog) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(liendetailslog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(liendetailslog);
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
	 * @return List<Liendetails>
	 */
	public List<Liendetails> getAllProperties() {
		List<Liendetails> liendetailsLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Liendetails.findAll");
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
	public Liendetails getKeyProperty(String id) {
		Liendetails liendetailsLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					liendetailsLog = entityManager.find(Liendetails.class, new BigDecimal(id));
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
	 * @param liendetailslog
	 */
	public void updateProperty(Liendetails liendetailslog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(liendetailslog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(liendetailslog);
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
	 * @param liendetailslog
	 */
	public void removeProperty(Liendetails liendetailslog) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(liendetailslog)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(liendetailslog);
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
	 * @return List<Liendetails>
	 */
	public List<Liendetails> getLimitCountProperties() {
		List<Liendetails> liendetailsList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Liendetails.findAll");
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
	 * @return {@link Liendetails}
	 */
	public Liendetails getLiendetailsByMasterEventReference(String masterReference, String eventReference) {
		logger.debug(masterReference + eventReference);
		Liendetails liendetailsLog = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(masterReference) && ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("Liendetails.findByMasterEventId");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						logger.debug("TEST");
						liendetailsLog = (Liendetails) query.getResultList().get(0);
					}
				} else {
					logger.error("Liendetails log missing mandatory field(s)");
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
	 * @return List<Liendetails>
	 */
	public List<Liendetails> getLoggingListTransactionProperties() {
		List<Liendetails> liendetailslogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Liendetails.findByLogList");
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
