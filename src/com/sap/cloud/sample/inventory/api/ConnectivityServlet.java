package com.sap.cloud.sample.inventory.api;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sap.cloud.sample.inventory.model.InventoryData;

/**
 * Servlet implementation class ConnectivityServlet
 */
public class ConnectivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /** {@inheritDoc} */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	init();
    	response.getWriter().println("Connection established successfully!");
    
     }

    //Added category and bin id as part of data initialization (last two parameters)
    
    public void init(){    	 	    	   
		fillInventoryData("OS12004", "5401", "ABC", "Trim Brush", 23, "Palo Alto", 20, "Painting Supplies", "pa_pb_12");
		fillInventoryData("OS28001a", "330", "XYZ", "Painters Ladder", 32, "Palo Alto", 5, "Ladders", "pa_pl_01");		
		fillInventoryData("OS28057a", "330", "XYZ", "16 Penny Nails", 15, "Palo Alto", 90, "Hardware", "pa_hd_11");
		fillInventoryData("OS28057b", "330", "XYZ", "8 Penny Nails", 13, "Palo Alto", 80, "Hardware", "pa_hd_21");
		fillInventoryData("OS28066", "5401", "ABC", "Mechanics Wrench set", 20, "Palo Alto", 40, "Hand Tools", "pa_ht_61");
		fillInventoryData("OS28062", "5401", "ABC", "Electricians Plier Set", 25, "Palo Alto", 100, "Hand Tools", "pa_ht_31");
		fillInventoryData("OS28022", "5401", "ABC", "Mechanics Pliers", 19, "Palo Alto", 33, "Hand Tools", "pa_ht_22");
		fillInventoryData("OS28011", "5401", "ABC", "Brush Set", 10, "Palo Alto", 77, "Painting Supplies", "pa_pb_13");
		fillInventoryData("OS28057c", "330", "XYZ", "10 Penny Nails", 14, "Palo Alto", 110, "Hardware", "pa_hd_31");
		fillInventoryData("OS28004", "143", "GCG", "Ergo Roller", 22, "Palo Alto", 2, "Painting Supplies", "pa_pb_41");
		fillInventoryData("OS28099", "5401", "ABC", "Big L Carpenters Square", 15, "Palo Alto", 200, "Measuring Tools", "pa_mt_82");
		fillInventoryData("OS28114", "5401", "ABC", "Painters Brush set", 30, "Palo Alto", 93, "Painting Supplies", "pa_pb_92");
		fillInventoryData("OS28115", "5401", "ABC", "Disposable Brush set", 15, "Palo Alto", 180, "Painting Supplies", "pa_pb_82");
		fillInventoryData("OS28222", "143", "GCG", "Spackling Knife", 15, "Palo Alto", 82, "Painting Supplies", "pa_pb_02");
		fillInventoryData("OS28021", "143", "GCG", "Framing Hammer", 22, "Palo Alto", 14, "Hand Tools", "pa_ht_31");
		
	}
    
//    public void init(){    	 	    	   
//		fillInventoryData("OS12004", "5401", "ABC", "Trim Brush", 23, "Palo Alto", 20);
//		fillInventoryData("OS28001a", "330", "XYZ", "Painters Ladder", 32, "Palo Alto", 5);		
//		fillInventoryData("OS28057a", "330", "XYZ", "16 Penny Nails", 15, "Palo Alto", 90);
//		fillInventoryData("OS28057b", "330", "XYZ", "8 Penny Nails", 13, "Palo Alto", 80);
//		fillInventoryData("OS28066", "5401", "ABC", "Mechanics Wrench set", 20, "Palo Alto", 40);
//		fillInventoryData("OS28062", "5401", "ABC", "Electricians Plier Set", 25, "Palo Alto", 100);
//		fillInventoryData("OS28022", "5401", "ABC", "Mechanics Pliers", 19, "Palo Alto", 33);
//		fillInventoryData("OS28011", "5401", "ABC", "Brush Set", 10, "Palo Alto", 77);
//		fillInventoryData("OS28057c", "330", "XYZ", "10 Penny Nails", 14, "Palo Alto", 110);
//		fillInventoryData("OS28004", "143", "GCG", "Ergo Roller", 22, "Palo Alto", 2);
//		fillInventoryData("OS28099", "5401", "ABC", "Big L Carpenters Square", 15, "Palo Alto", 200);
//		fillInventoryData("OS28114", "5401", "ABC", "Painters Brush set", 30, "Palo Alto", 93);
//		fillInventoryData("OS28115", "5401", "ABC", "Disposable Brush set", 15, "Palo Alto", 180);
//		fillInventoryData("OS28222", "143", "GCG", "Spackling Knife", 15, "Palo Alto", 82);
//		fillInventoryData("OS28021", "143", "GCG", "Framing Hammer", 22, "Palo Alto", 14);
//		
//	}
    
    //private void fillInventoryData(String code, String vendor_code, String vendor_name, String item_description, Integer net_price, String warehouse, Integer stock)
    private void fillInventoryData(String code, String vendor_code, String vendor_name, String item_description, Integer net_price, String warehouse, Integer stock, String category, String bin_id)
	{
		InventoryData inventoryData = new InventoryData();
		inventoryData.setCode(code);
		inventoryData.setVendor_code(vendor_code);
		inventoryData.setVendor_name(vendor_name);
		inventoryData.setItem_description(item_description);
		inventoryData.setNet_price(net_price);
		inventoryData.setWarehouse(warehouse);
		inventoryData.setStock(stock);
		
		//Newly added fields
		inventoryData.setCategory(category);
		inventoryData.setBin_id(bin_id);
		
		try{
			DataConnectionService dataService = new DataConnectionService();
			EntityManager em = dataService.getEMF().createEntityManager();
			em.getTransaction().begin();
			em.persist(inventoryData);
			em.getTransaction().commit();
			em.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

 }