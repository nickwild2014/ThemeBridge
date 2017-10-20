package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.LookupFundedLiabilities;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LookupFundedeLiabAdapter extends ThemeBridgeEntityManager {

	public LookupFundedeLiabAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param lookupfundedliab
	 */
	public void addProperty(LookupFundedLiabilities lookupfundedliab) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupfundedliab)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(lookupfundedliab);
				entityManager.getTransaction().commit();
				// logger.debug("LookupFundedLiabilities log added
				// successfully");
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
	 * @return List<LookupFundedLiabilities>
	 */
	public List<LookupFundedLiabilities> getAllProperties() {
		List<LookupFundedLiabilities> lookupAccountTypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupFundedLiabilities.findAll");
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
	public LookupFundedLiabilities getKeyProperty(String id) {
		LookupFundedLiabilities lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					lookupAccountType = entityManager.find(LookupFundedLiabilities.class, new BigDecimal(id));
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
	 * @param lookupfundedliab
	 */
	public void updateProperty(LookupFundedLiabilities lookupfundedliab) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupfundedliab)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(lookupfundedliab);
				entityManager.getTransaction().commit();
				// logger.debug("LookupFundedLiabilities log data modified
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
	 * @param lookupfundedliab
	 */
	public void removeProperty(LookupFundedLiabilities lookupfundedliab) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupfundedliab)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(lookupfundedliab);
				entityManager.getTransaction().commit();
				// logger.debug("LookupFundedLiabilities log data removed
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
	 * @return List<LookupFundedLiabilities>
	 */
	public List<LookupFundedLiabilities> getLimitCountProperties() {
		List<LookupFundedLiabilities> serviceList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupFundedLiabilities.findAll");
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
	 * @return {@link LookupFundedLiabilities}
	 */
	public LookupFundedLiabilities getLookupAccountTypeByMasterEventReferenceOperation(String masterReference,
			String eventReference, String operation) {
		LookupFundedLiabilities lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager
							.createNamedQuery("LookupFundedLiabilities.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						lookupAccountType = (LookupFundedLiabilities) query.getResultList().get(0);
					}
				} else {
					logger.error("LookupFundedLiabilities log missing mandatory field(s)");
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
	 * @return List<LookupFundedLiabilities>
	 */
	public List<LookupFundedLiabilities> getLoggingListTransactionProperties() {
		List<LookupFundedLiabilities> lookupaccounttypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupFundedLiabilities.findByLogList");
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
