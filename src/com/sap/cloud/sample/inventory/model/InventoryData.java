package com.sap.cloud.sample.inventory.model;

import java.io.Serializable;
import java.lang.Number;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: InventoryModel
 *
 */
@Entity
@Table(name="T_InventoryData")
@NamedQueries({
@NamedQuery(name = "AllInventories", query = "select i from InventoryData i"),
@NamedQuery(name = "InitializeDB", query = "delete from InventoryData")
})
public class InventoryData implements Serializable {

	   
	@Id
	private String code;
	private String vendor_code;
	private String vendor_name;
	private String item_description;
	private Number net_price;
	private String warehouse;
	private Number stock;
	private static final long serialVersionUID = 1L;

	//The newly added fields - category and bin_id
	private String category;
	private String bin_id;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBin_id() {
		return bin_id;
	}
	public void setBin_id(String bin_id) {
		this.bin_id = bin_id;
	}

	public InventoryData() {
		super();
	}   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}   
	public String getVendor_code() {
		return this.vendor_code;
	}

	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}   
	public String getVendor_name() {
		return this.vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}   
	public String getItem_description() {
		return this.item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}   
	public Number getNet_price() {
		return this.net_price;
	}

	public void setNet_price(Number net_price) {
		this.net_price = net_price;
	}   
	public String getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}   
	public Number getStock() {
		return this.stock;
	}

	public void setStock(Number stock) {
		this.stock = stock;
	}
   
}
