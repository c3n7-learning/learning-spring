package tech.c3n7.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.c3n7.springdemo.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // Need to inject the hibernate session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // get the list of customers from the query (by executing it)
        List<Customer> customers = theQuery.getResultList();

        // return the list of retrieved customers
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        // get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve from the database using the primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }
}
