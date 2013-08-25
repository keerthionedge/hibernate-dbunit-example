package com.hib.dbunit.example;

import com.hib.dbunit.example.domain.TUserImpl;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.Transaction;
import org.junit.Test;

public class UsersDbUnitTestCase extends HibernateDbUnitTestCase {


    /** {@inheritDoc} */
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(this.getClass().getResourceAsStream("/test/integration/data/users.xml"));
    }

    /**
     * Demo test to see that the number of user records in the database corresponds the flat file inserts.
     */
    @Test
    public void testDemo1() {
        Transaction trans = session.beginTransaction();
        assertEquals(4, session.createCriteria(TUserImpl.class).list().size());
        trans.commit();
    }

    /**
     * Demo test to see that the number of user records in the database corresponds the flat file inserts.
     */
    @Test
    public void testDemo2() {
        Transaction trans = session.beginTransaction();
        assertEquals("bob", ((TUserImpl) session.get(TUserImpl.class, 2L)).getUsername());
        trans.commit();
    }

}
