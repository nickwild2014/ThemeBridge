package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.Bridgeproperties;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class BridgepropertiesAdapter extends ThemeBridgeEntityManager {

	public BridgepropertiesAdapter() {
		super();
	}

	/**
	 * To add a property object
	 * 
	 * @param bridgeProperties
	 */
	public void addProperty(Bridgeproperties bridgeProperties) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(bridgeProperties)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(bridgeProperties);
				entityManager.getTransaction().commit();
				// logger.debug("Bridge property added successfully");
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
	 * To get all property values
	 * 
	 * @return List<Bridgeproperties>
	 */
	public List<Bridgeproperties> getAllProperties() {

		List<Bridgeproperties> bridgePropertyList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Bridgeproperties.findAll");
				bridgePropertyList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return bridgePropertyList;
	}

	/**
	 * To get property value by id
	 * 
	 * @param id
	 * @return {@link Bridgeproperties}
	 */
	public Bridgeproperties getPropertyById(String id) {
		// logger.debug("Bridge Property get property by id--" + id);
		Bridgeproperties bridgeProperty = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				entityManager.getTransaction().begin();
				bridgeProperty = entityManager.find(Bridgeproperties.class, new BigDecimal(id));
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return bridgeProperty;
	}

	/**
	 * To get key property value
	 * 
	 * @param key
	 * @return List <{@link Bridgeproperties}>
	 */
	public List<Bridgeproperties> getPropertyByKey(String key) {
		List<Bridgeproperties> bridgePropertyList = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(key)) {
			try {
				entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Bridgeproperties.findByKey");
				query.setParameter("key", key);
				bridgePropertyList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return bridgePropertyList;
	}

	/**
	 * To get key property value
	 * 
	 * @param zone
	 * @return List<{@link Bridgeproperties}>
	 */
	public List<Bridgeproperties> getPropertyByZone(String zone) {
		List<Bridgeproperties> bridgeProperty = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(zone)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Bridgeproperties.findByZone");
				query.setParameter("zone", zone);
				bridgeProperty = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return bridgeProperty;
	}

	/**
	 * To get property value by key and zone
	 * 
	 * @param keyName
	 *            {@code allows } {@link String}
	 * @param zone
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Bridgeproperties}
	 */
	public Bridgeproperties getPropertyByKeyAndZone(String key, String zone) {
		Bridgeproperties bridgeProperty = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(key)
				&& ValidationsUtil.isValidString(zone)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Bridgeproperties.findByZoneAndKey");
				query.setParameter("zone", zone);
				query.setParameter("key", key);
				List<Bridgeproperties> bpList = query.getResultList();
				if (ValidationsUtil.isValidList(bpList)) {
					bridgeProperty = bpList.get(0);
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return bridgeProperty;
	}

	/**
	 * To get property value by key and zone
	 * 
	 * @param keyName
	 *            {@code allows } {@link String}
	 * @param branch
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Bridgeproperties}
	 */
	public Bridgeproperties getPropertyByKeyAndBranch(String key, String branch) {
		Bridgeproperties bridgeProperty = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(key)
				&& ValidationsUtil.isValidString(branch)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Bridgeproperties.findByBranchAndKey");
				query.setParameter("branch", branch);
				query.setParameter("key", key);
				List<Bridgeproperties> bpList = query.getResultList();
				if (ValidationsUtil.isValidList(bpList)) {
					bridgeProperty = bpList.get(0);
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return bridgeProperty;
	}

	/**
	 * To get property value by key, branch and zone
	 * 
	 * @param key
	 *            {@code allows } {@link String}
	 * @param branch
	 *            {@code allows } {@link String}
	 * @param zone
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Bridgeproperties}
	 */
	public Bridgeproperties getPropertyByKeyAndZoneAndBranch(String key, String branch, String zone) {
		Bridgeproperties bridgeProperty = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(key)
				&& ValidationsUtil.isValidString(branch) && ValidationsUtil.isValidString(zone)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Bridgeproperties.findByZoneBranchAndKey");
				query.setParameter("zone", zone);
				query.setParameter("branch", branch);
				query.setParameter("key", key);
				List<Bridgeproperties> bpList = query.getResultList();
				if (ValidationsUtil.isValidList(bpList)) {
					bridgeProperty = bpList.get(0);
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return bridgeProperty;
	}

	/**
	 * To update a property value
	 * 
	 * @param property
	 */
	public void updateProperty(Bridgeproperties bridgeProperty) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(bridgeProperty)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(bridgeProperty);
				entityManager.getTransaction().commit();
				logger.debug("Bridge property modified successfully");
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
	 * To remove a property value
	 * 
	 * @param property
	 */
	public void removeProperty(Bridgeproperties bridgeProperty) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(bridgeProperty)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(bridgeProperty);
				entityManager.getTransaction().commit();
				logger.debug("Bridge property removed successfully");
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
	 * To get limited count of property values
	 * <p>
	 * {@code Default limit count is 200}
	 * </p>
	 * 
	 * @return List<Bridgeproperties>
	 */
	public List<Bridgeproperties> getLimitCountProperties() {
		List<Bridgeproperties> bridgePropertyList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("Bridgeproperties.findAll");
				query.setMaxResults(200);
				bridgePropertyList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return bridgePropertyList;
	}

	/**
	 * To get limited count of property values
	 * <p>
	 * {@code Default limit count is 200}
	 * </p>
	 * 
	 * @return List<Bridgeproperties>
	 */
	public void saveProperties(HashMap valuesToBeSave) {
		Iterator it = valuesToBeSave.keySet().iterator();
		while (it.hasNext()) {
			String keyName = (String) it.next();
			String value = (String) valuesToBeSave.get(keyName);
			if (ValidationsUtil.isValidString(keyName) && ValidationsUtil.isValidString(value)) {
				Bridgeproperties bridgeProperty = new Bridgeproperties();
				bridgeProperty.setId(new BigDecimal(keyName));
				bridgeProperty.setValue(value);
				updateProperty(bridgeProperty);
			} else {
				logger.debug("CountryList is empty");
			}
		}
	}

}
