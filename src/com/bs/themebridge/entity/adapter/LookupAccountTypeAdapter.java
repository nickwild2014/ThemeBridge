package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.LookupAccountType;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LookupAccountTypeAdapter extends ThemeBridgeEntityManager {

	public LookupAccountTypeAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param lookupaccounttype
	 */
	public void addProperty(LookupAccountType lookupaccounttype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupaccounttype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(lookupaccounttype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupAccountType log added successfully");
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
	 * @return List<LookupAccountType>
	 */
	public List<LookupAccountType> getAllProperties() {
		List<LookupAccountType> lookupAccountTypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupAccountType.findAll");
				lookupAccountTypeList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return lookupAccountTypeList;
	}

	/**
	 * To get service log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public LookupAccountType getKeyProperty(String id) {
		LookupAccountType lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					lookupAccountType = entityManager.find(LookupAccountType.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return lookupAccountType;
	}

	/**
	 * To update a service log data value
	 * 
	 * @param lookupaccounttype
	 */
	public void updateProperty(LookupAccountType lookupaccounttype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupaccounttype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(lookupaccounttype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupAccountType log data modified
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
	 * @param lookupaccounttype
	 */
	public void removeProperty(LookupAccountType lookupaccounttype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupaccounttype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(lookupaccounttype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupAccountType log data removed
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
	 * @return List<LookupAccountType>
	 */
	public List<LookupAccountType> getLimitCountProperties() {
		List<LookupAccountType> serviceList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupAccountType.findAll");
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
	 * @return {@link LookupAccountType}
	 */
	public LookupAccountType getLookupAccountTypeByMasterEventReferenceOperation(String masterReference,
			String eventReference, String operation) {
		LookupAccountType lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("LookupAccountType.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						lookupAccountType = (LookupAccountType) query.getResultList().get(0);
					}
				} else {
					logger.error("LookupAccountType log missing mandatory field(s)");
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return lookupAccountType;
	}

	/**
	 * To get logging page service log data values
	 * 
	 * @return List<LookupAccountType>
	 */
	public List<LookupAccountType> getLoggingListTransactionProperties() {
		List<LookupAccountType> lookupaccounttypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupAccountType.findByLogList");
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
