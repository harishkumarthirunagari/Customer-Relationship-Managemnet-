package crm.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import crm.entity.customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		
		@Override
		public List<customer> getCustomers() {
			
			// hibernate session 
			Session currentsession = sessionFactory.getCurrentSession();
			
			// query to get list of customers 
			Query<customer> thequery = currentsession.createQuery("from customer order by last_name ",customer.class);
			
			
			// return list of customers 
			
			List<customer> customers = thequery.getResultList();
			
			return customers;
		}


		@Override
		public void saveCustomer(customer thecustomer) {
			//hibernate session 
			Session currentsession = sessionFactory.getCurrentSession();
			
			//querrying to save the customer 
			
			currentsession.saveOrUpdate(thecustomer);
		}


		@Override
		public customer getCustomers(int theId) {
			Session currentsession = sessionFactory.getCurrentSession();
			
			customer thecustomer = currentsession.get(customer.class, theId);
			return thecustomer;
		}


		@Override
		public void deleteCustomer(customer thecustomer) {
			// TODO Auto-generated method stub
			Session currentsession = sessionFactory.getCurrentSession();
			currentsession.delete(thecustomer);
			
		}



		 @Override
		    public List<customer> searchCustomer(String theSearchName) {

		        // get the current hibernate session
		        Session currentSession = sessionFactory.getCurrentSession();
		        
		        Query theQuery = null;
		        
		        //
		        // only search by name if theSearchName is not empty
		        //
		        if (theSearchName != null && theSearchName.trim().length() > 0) {

		            // search for firstName or lastName ... case insensitive
		            theQuery =currentSession.createQuery("from customer where lower(first_Name) like :theName or lower(last_Name) like :theName", customer.class);
		            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		        }
		        else {
		            // theSearchName is empty ... so just get all customers
		            theQuery =currentSession.createQuery("from Customer", customer.class);            
		        }
		        
		        // execute query and get result list
		        List<customer> customers = theQuery.getResultList();
		                
		        // return the results        
		        return customers;
		        
		    }

	}


