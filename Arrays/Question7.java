/**
 * 
 */
package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 *  Create a program with multi-dimensional List to store customer details (customerId, 
    customerName, customerCity).
	This program to search the customer based on the customerName from a given array.
 		Note: use Binary search and Insertion sort algorithm.
		 *Create a constructor to initialize size of customer details for five customers.
		 *Create customer method which takes the array of customer elements (sorted as a
		  customerName).
		 *Create a method to getCustomer(customerId) method which will return the customer
		  details as a List.
		 *Create a method to sortCustomer() method which will return the array in a sorted
		  order based on customer city.
 */

class Customer {
    private int customerId;
    private String customerName;
    private String customerCity;

    public Customer(int customerId, String customerName, String customerCity) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerCity = customerCity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

	@Override
	public String toString() {
		return "Customer Details [customerId=" + customerId + ", customerName=" + customerName + ", customerCity="
				+ customerCity + "]";
	}
}


class CustomerDetails{
	
	private List<Customer> customerDetails;

    public CustomerDetails() {
    	customerDetails = new ArrayList<>(); 
    }
    
    public void addCustomer(Customer customer) {
    	customerDetails.add(customer);
    }
	
	public void sortCustomersByName(){
		// Insertion Sort
		for (int i = 1; i < customerDetails.size(); i++) {
			Customer key = customerDetails.get(i);
            int j = i - 1;

            while (j > -1 && this.customerDetails.get(j).getCustomerName().compareTo(key.getCustomerName()) > 0) {
                this.customerDetails.set(j+1, this.customerDetails.get(j+1));
                j = j - 1;
            }
            this.customerDetails.set(j+1,key);
		}
	}
	
	private int BinarySearch(int customerId) {
		// Binary Search
		int left = 0;
		int right = this.customerDetails.size()-1;
		
		
		
		while(left<=right) {
			int mid = left + (right - left) / 2;
			if(this.customerDetails.get(mid).getCustomerId() == customerId) {
				return mid;
			}else if(this.customerDetails.get(mid).getCustomerId()>customerId){
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		return -1;
	}
	
	public List<Customer> getCustomer(int id){
		List<Customer> result = new ArrayList<>();
		
		int match = BinarySearch(id);
		
		if(match != -1){
			result.add(this.customerDetails.get(match));
		}
		
		return result;
	}
	
	public void printDetils() {
		for (Customer i : this.customerDetails) {
			System.out.print("ID: "+i.getCustomerId());
			System.out.print(" | Name: "+i.getCustomerName());
			System.out.print(" | City: "+i.getCustomerCity());
			System.out.println();
		}
		
	}
	
}

public class Question7 {

	/**
	 * @param 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDetails customerDetails = new CustomerDetails();

		// Adding sample customers
		customerDetails.addCustomer(new Customer(101, "John", "New York"));
		customerDetails.addCustomer(new Customer(102, "Alice", "London"));
		customerDetails.addCustomer(new Customer(103, "Bob", "Paris"));
		customerDetails.addCustomer(new Customer(104, "Eve", "Tokyo"));
		customerDetails.addCustomer(new Customer(105, "Grace", "Sydney"));
		 
		int id = 110;
		List<Customer> l =  customerDetails.getCustomer(id);
		System.out.println(l);
	        
		customerDetails.printDetils();
		System.out.println();
		System.out.println("After sorting the Elements are :");
		customerDetails.sortCustomersByName();
		customerDetails.printDetils();
	}

}
