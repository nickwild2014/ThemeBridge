package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.LookupCustomerType;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LookupCustomerTypeAdapter extends ThemeBridgeEntityManager {

	public LookupCustomerTypeAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param lookupcustomertype
	 */
	public void addProperty(LookupCustomerType lookupcustomertype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupcustomertype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(lookupcustomertype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupCustomerType log added successfully");
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
	 * To get all service log data values
	 * 
	 * @return List<LookupCustomerType>
	 */
	public List<LookupCustomerType> getAllProperties() {
		List<LookupCustomerType> lookupCustomerTypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupCustomerType.findAll");
				lookupCustomerTypeList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return lookupCustomerTypeList;
	}

	/**
	 * To get service log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public LookupCustomerType getKeyProperty(String id) {
		LookupCustomerType lookupCustomerType = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					lookupCustomerType = entityManager.find(LookupCustomerType.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return lookupCustomerType;
	}

	/**
	 * To update a service log data value
	 * 
	 * @param lookupcustomertype
	 */
	public void updateProperty(LookupCustomerType lookupcustomertype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupcustomertype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(lookupcustomertype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupCustomerType log data modified
				// successfully");
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
	 * @param lookupcustomertype
	 */
	public void removeProperty(LookupCustomerType lookupcustomertype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupcustomertype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(lookupcustomertype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupCustomerType log data removed
				// successfully");
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
	 * @return List<LookupCustomerType>
	 */
	public List<LookupCustomerType> getLimitCountProperties() {
		List<LookupCustomerType> serviceList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupCustomerType.findAll");
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
	 * @return {@link LookupCustomerType}
	 */
	public LookupCustomerType getLookupAccountTypeByMasterEventReferenceOperation(String masterReference,
			String eventReference, String operation) {
		LookupCustomerType lookupCustomerType = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("LookupCustomerType.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						lookupCustomerType = (LookupCustomerType) query.getResultList().get(0);
					}
				} else {
					logger.error("LookupCustomerType log missing mandatory field(s)");
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return lookupCustomerType;
	}

	/**
	 * To get logging page service log data values
	 * 
	 * @return List<LookupCustomerType>
	 */
	public List<LookupCustomerType> getLoggingListTransactionProperties() {
		List<LookupCustomerType> lookupaccounttypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupCustomerType.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					lookupaccounttypeList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return lookupaccounttypeList;
	}

}
