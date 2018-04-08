package cmr.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import crm.dao.CustomerDAO;
import crm.entity.customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<customer> getCustomers() {
	
	return customerDAO.getCustomers();
		
	}

	@Override
	@Transactional 
	public void saveCustomer(customer thecustomer) {
		//adding customer to database 
		
		customerDAO.saveCustomer(thecustomer);
		
	}

	@Override
	@Transactional
	public customer getCustomers(int theId) {
		
		
		
		return customerDAO.getCustomers(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(customer thecustomer) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(thecustomer);
	}

	@Override
	@Transactional
	public List<customer> seaarchcustomer(String name) {
		// TODO Auto-generated method stub
		
		return customerDAO.searchCustomer(name);
		
	}

}
