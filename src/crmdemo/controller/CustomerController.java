package crmdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cmr.service.CustomerService;
import crm.entity.customer;
// Creating controller class and Adding request mapping 

@Controller 
@RequestMapping("/customers")
@ComponentScan("cmr.service")
@ComponentScan("crm.dao")
public class CustomerController {

	
	// injection DAO into the customer controller class 
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/showFromForAdd")
	public String showFormForAdd(Model theModel)
	{
		
		customer newcustomer = new customer();
		
		theModel.addAttribute("customers",newcustomer);
		return "customer-form";
	}
	@PostMapping("/searchCustomer")
    public String searchCustomers(@RequestParam("first_name") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<customer> theCustomers = customerService.seaarchcustomer(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
	
	@RequestMapping("/list")
	public String listCustomers(Model themodel)
	{
		

		//get customers from DAO 
		List<customer> thecustomers = customerService.getCustomers();
		
		//add customers to model 
		themodel.addAttribute("customers",thecustomers);
		return "list-customers";
		
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customers") customer thecustomer )
	{
		
		customerService.saveCustomer(thecustomer);
		return "redirect:/customers/list";
		
	}
	
	@RequestMapping("/showFromForUpdate")
	public String showFromForUpdate(@RequestParam("customerId") int theId,Model theModel)
{
		customer theCustomer = customerService.getCustomers(theId);
		theModel.addAttribute("customers",theCustomer);
	return "customer-form";
	
}
	
	@RequestMapping("/showFromForDelete")
	public String showFromForDelete(@RequestParam("customerId") int theId,Model theModel)
{
		customer theCustomer = customerService.getCustomers(theId);
		customerService.deleteCustomer(theCustomer);
		
	return "redirect:/customers/list";
	
}
}
