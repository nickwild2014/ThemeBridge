package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.model.Postingstaging;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Raghu M
 * 
 */
public class PostingStagingAdapter extends ThemeBridgeEntityManager {

	private final static Logger logger = Logger.getLogger(PostingStagingAdapter.class);

	public PostingStagingAdapter() {
		super();
	}

	/**
	 * To add a Posting Staging log data object
	 * 
	 * @param Posting
	 *            Staging
	 */
	public boolean addProperty(Postingstaging postingStaging) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(postingStaging)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(postingStaging);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("Posting Staging added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return false;
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
		}
		return result;
	}

	/**
	 * To get all Posting Staging log data values
	 * 
	 * @return List<Postingstaging>
	 */
	@SuppressWarnings("unchecked")
	public List<Postingstaging> getAllProperties() {
		List<Postingstaging> postingStagingList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Postingstaging.findAll");
				postingStagingList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return postingStagingList;
	}

	/**
	 * To get Posting Staging log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public Postingstaging getKeyProperty(String id) {
		Postingstaging postingStagingLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					postingStagingLog = entityManager.find(Postingstaging.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return postingStagingLog;
	}

	/**
	 * To update a Posting Staging log data value
	 * 
	 * @param Posting
	 *            Staging
	 */
	public boolean updateProperty(Postingstaging postingStaging) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(postingStaging)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(postingStaging);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("Posting Staging data modified successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return result;
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return result;
	}

	/**
	 * To remove a postingStaging log data value
	 * 
	 * @param ftrtdetails
	 */
	public boolean removeProperty(Postingstaging postingStaging) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(postingStaging)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(postingStaging);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("Service log data removed successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return result;
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return result;
	}

}
