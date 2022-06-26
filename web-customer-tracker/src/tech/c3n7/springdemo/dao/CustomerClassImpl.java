package tech.c3n7.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.c3n7.springdemo.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerClassImpl implements CustomerDAO {

    // Need to inject the hibernate session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

        // get the list of customers from the query (by executing it)
        List<Customer> customers = theQuery.getResultList();

        // return the list of retrieved customers
        return customers;
    }
}