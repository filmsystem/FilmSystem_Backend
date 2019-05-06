package shu.ces.filmsystem.BO;

import shu.ces.filmsystem.Model.Customer;

public class CustomerBO {
    public boolean insertCustomer(Customer customer){
        // add to database
        return true;
    }

    public boolean updateCustomer(Customer customer){
        // add to database
        return true;
    }

    public boolean deleteCustomer(int id){
        //delete in database
        return true;
    }

    public Customer findCustomerById(int id){
        // find in database
        return null;
    }

    public Customer findCustomerByName(String name){
        // find in database
        return null;
    }

    public int checkCustomer(String username, String password){
        // check
        Customer customer = findCustomerByName(username);
        if(customer != null){
            if(password.equals(customer.getPassword())){
                return customer.getId();
            }
            else{   // password error
                return 0;
            }
        }
        else{   // customer not found
            return -1;
        }
    }
}
