package com.bs.themebridge.entity.util;

import javax.persistence.EntityManagerFactory;

public class EntityFactoryStatus {

	public static boolean firstTime = true;

	public static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		EntityFactoryStatus.entityManagerFactory = entityManagerFactory;
	}

	public static boolean isFirstTime() {

		return firstTime;
	}

	public static void setFirstTime(boolean firstTime) {
		EntityFactoryStatus.firstTime = firstTime;
	}

}
