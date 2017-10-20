package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.FtrtDetailsUtilizeBean;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class FtrtdetailsUtilizeAdapter extends ThemeBridgeEntityManager {

	public FtrtdetailsUtilizeAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param ftrtdetails
	 */
	public boolean addProperty(FtrtDetailsUtilizeBean ftrtdetails) {

		boolean result = false;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(ftrtdetails)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(ftrtdetails);
				entityManager.getTransaction().commit();
				result = true;
				// logger.debug("FtrtDetailsUtilizeBean log added
				// successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				// return result;
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
			addPropertyAgain(ftrtdetails);
		}
		return result;
	}

	/**
	 * 
	 * @param ftrtdetails
	 */
	public void addPropertyAgain(FtrtDetailsUtilizeBean ftrtdetails) {

		logger.info("Enter into addPropertyAgain method...!");
		ThemeBridgeEntityManager anTBEntity = new ThemeBridgeEntityManager();
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(ftrtdetails)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(ftrtdetails);
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
	 * @return List<FtrtDetailsUtilizeBean>
	 */
	public List<FtrtDetailsUtilizeBean> getAllProperties() {
		List<FtrtDetailsUtilizeBean> serviceLogList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("FtrtDetailsUtilizeBean.findAll");
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
	public FtrtDetailsUtilizeBean getKeyProperty(String id) {
		FtrtDetailsUtilizeBean serviceLog = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					serviceLog = entityManager.find(FtrtDetailsUtilizeBean.class, new BigDecimal(id));
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
	 * @param ftrtdetails
	 */
	public void updateProperty(FtrtDetailsUtilizeBean ftrtdetails) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(ftrtdetails)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(ftrtdetails);
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
	 * @param ftrtdetails
	 */
	public void removeProperty(FtrtDetailsUtilizeBean ftrtdetails) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(ftrtdetails)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(ftrtdetails);
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

}
