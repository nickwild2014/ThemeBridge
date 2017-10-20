package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.bs.themebridge.entity.model.Staticdatalog;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * .
 * 
 * @author Prasath Ravichandran
 *
 */
public class StaticdatalogAdapter extends ThemeBridgeEntityManager {

	public StaticdatalogAdapter() {
		super();
	}

	/**
	 * To add a static data object
	 * 
	 * @param staticData
	 */
	public boolean addProperty(Staticdatalog staticData) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(staticData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(staticData);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("Static data added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return result;
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
			addPropertyAgain(staticData);
		}
		return result;
	}

	/**
	 * 
	 * @param staticData
	 */
	public void addPropertyAgain(Staticdatalog staticData) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(staticData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(staticData);
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
	 * To get all static data values
	 * 
	 * @return List<Staticdatalog>
	 */
	@SuppressWarnings("unchecked")
	public List<Staticdatalog> getAllProperties() {
		List<Staticdatalog> staticDataList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Staticdatalog.findAll");
				staticDataList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return staticDataList;
	}

	/**
	 * To get static data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public Staticdatalog getKeyProperty(String id) {
		Staticdatalog staticData = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					staticData = entityManager.find(Staticdatalog.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return staticData;
	}

	/**
	 * To update a static data value
	 * 
	 * @param staticData
	 */
	public void updateProperty(Staticdatalog staticData) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(staticData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(staticData);
				entityManager.getTransaction().commit();
				// logger.debug("Static data modified successfully");
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
	 * To remove a static data value
	 * 
	 * @param staticData
	 */
	public void removeProperty(Staticdatalog staticData) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(staticData)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(staticData);
				entityManager.getTransaction().commit();
				// logger.debug("Static data removed successfully");
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
	 * <p>
	 * To get static data message from staging database filtered by EntityType
	 * </p>
	 * 
	 * @param entityType
	 *            {@code allows }{@link String}
	 * 
	 * @return {@link List}<{@link Staticdatalog}>
	 */
	@SuppressWarnings("unchecked")
	public List<Staticdatalog> getAllProperties(String entityType) {
		List<Staticdatalog> staticDataList = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(entityType)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Staticdatalog.findByEntitytype");
				query.setParameter("entitytype", entityType);
				staticDataList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return staticDataList;
	}

	/**
	 * <p>
	 * To get static data message from staging database filtered by EntityType
	 * </p>
	 * 
	 * @param entityType
	 *            {@code allows }{@link String}
	 * @param status
	 *            {@code allows }{@link String}
	 * 
	 * @return {@link List}<{@link Staticdatalog}>
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Staticdatalog> getAllProperties(String entityType, String status) {
		List<Staticdatalog> staticDataList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Staticdatalog.findByEntitytypeAndStatus");
				query.setParameter("entitytype", entityType);
				query.setParameter("status", status);
				staticDataList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return staticDataList;
	}

	/**
	 * <p>
	 * To get static data message from staging database filtered by EntityType
	 * </p>
	 * 
	 * @param entityType
	 *            {@code allows }{@link String}
	 * @param status
	 *            {@code allows }{@link String}
	 * @param processedTime
	 *            {@code allows }{@link String}
	 * 
	 * @return {@link List}<{@link Staticdatalog}>
	 */
	@SuppressWarnings("unchecked")
	public List<Staticdatalog> getAllProperties(String entityType, String status, Date processedTime) {
		List<Staticdatalog> staticDataList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Staticdatalog.findByEntitytypeStatusAndProcessedtime");
				query.setParameter("entitytype", entityType);
				query.setParameter("status", status);
				query.setParameter("processedtime", processedTime, TemporalType.DATE);
				staticDataList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return staticDataList;
	}

}
