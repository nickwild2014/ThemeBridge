package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.LookupSwiftTypes;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LookupSwiftTypesAdapter extends ThemeBridgeEntityManager {

	public LookupSwiftTypesAdapter() {
		super();
	}

	/**
	 * To get all service log data values
	 * 
	 * @return List<LookupSwiftTypes>
	 */
	public List<LookupSwiftTypes> getAllProperties() {
		List<LookupSwiftTypes> lookupAccountTypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupSwiftTypes.findAll");
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

}
