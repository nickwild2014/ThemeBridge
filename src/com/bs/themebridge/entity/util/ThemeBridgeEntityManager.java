package com.bs.themebridge.entity.util;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * It is used to get Persistence connection
 * 
 * @author Prasath Ravichandran
 *
 */
public class ThemeBridgeEntityManager {

	public static Logger logger = Logger.getLogger("ThemeBridgeEntityManager");
	private final String PERSISTENCE_UNIT_NAME = "ThemeBridgePU";

	@PersistenceUnit(name = "", unitName = "")
	public EntityManagerFactory entityManagerFactory;

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	public EntityManager entityManager;

	public ThemeBridgeEntityManager() {
		try {
			// logger.debug(" Initializing TBE ");
			// logger.debug(" Initializing TBE ...");
			if (EntityFactoryStatus.isFirstTime()) {
				// logger.debug(" creating entity manager now ...");
				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityFactoryStatus.setFirstTime(false);
				EntityFactoryStatus.setEntityManagerFactory(entityManagerFactory);
			} else {
				entityManagerFactory = EntityFactoryStatus.getEntityManagerFactory();
				// logger.debug(" Entity manager already available .");
			}
			entityManager = entityManagerFactory.createEntityManager();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
		}
	}

	public ThemeBridgeEntityManager(EntityManager persistenceManager) {
		// this is not used.
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			persistenceManager = entityManagerFactory.createEntityManager();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			persistenceManager.close();
		}
	}

}
