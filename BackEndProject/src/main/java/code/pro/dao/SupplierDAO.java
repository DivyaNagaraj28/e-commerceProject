package code.pro.dao;

import java.util.List;

import code.pro.model.Product;
import code.pro.model.Supplier;


public interface SupplierDAO {
	public boolean registerSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> listSuppliers();
	
	public Supplier getSupplier(int supplierId);

}

