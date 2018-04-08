package cmr.service;

import java.util.List;

import crm.entity.customer;

public interface CustomerService {
	
	List<customer> getCustomers();

	void saveCustomer(customer thecustomer);

	customer getCustomers(int theId);

	void deleteCustomer(customer theCustomer);

	List<customer> seaarchcustomer(String name);

}
