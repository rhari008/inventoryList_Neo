package com.sap.cloud.sample.inventory.api;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import javax.ws.rs.core.Context;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class DataConnectionService {

//	private javax.naming.Context mContext;
//	
//	public DataConnectionService(javax.naming.Context context){
//		mContext = context;
//	}
//	
	 protected EntityManagerFactory getEMF(){
			EntityManagerFactory emf = null;		
			Map<String, DataSource> properties = new HashMap<String, DataSource>();
			DataSource ds = this.getDataSource();
			properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, ds);
			emf = Persistence.createEntityManagerFactory("inventoryList", properties); //Taken from web.xml
			return emf;
		}
	    
	    protected DataSource getDataSource() {
			DataSource retVal = null;

			try {
				InitialContext ctx = new InitialContext();
				retVal = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
			} catch (NamingException ex) {
				ex.printStackTrace();
			}
			return retVal;
		}
	
}
