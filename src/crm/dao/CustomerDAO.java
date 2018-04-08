package crm.dao;

import java.util.List;

import crm.entity.customer;


public interface CustomerDAO {

	public List<customer> getCustomers();

	public void saveCustomer(customer thecustomer);

	public customer getCustomers(int theId);

	public void deleteCustomer(customer thecustomer);

	public List<customer> searchCustomer(String name);
}
