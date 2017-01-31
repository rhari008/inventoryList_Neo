package com.sap.cloud.sample.inventory.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.net.ssl.HttpsURLConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import com.sap.cloud.sample.inventory.model.InventoryData;

@Path("/inventorydata")
@Produces({ MediaType.APPLICATION_JSON })
public class InventoryDataService {
	@SuppressWarnings("unchecked")
	@GET
	@Path("/")
	public List<InventoryData> getInventoryData(@Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception{
		
		List<InventoryData> inventoryList = null;
		DataConnectionService dataService = new DataConnectionService();
		EntityManager em = dataService.getEMF().createEntityManager();
		
		//Get the data
		inventoryList = em.createNamedQuery("AllInventories").getResultList();		
		if (inventoryList.isEmpty())
			return null;
		return inventoryList;
		
	}
}
