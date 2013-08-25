package com.hib.dbunit.example;

import com.hib.dbunit.example.domain.xUser;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

/**
 * This Class XUserDBUnitTestCase todo ramacke
 *
 * @author <a href="mailto:keerthi.ramachandran@navis.com">Keerthi Ramachandran</a>
 * @since 2.6. / 25-08-2013
 */
public class XUserDBUnitTestCase extends HibernateDbUnitTestCase {
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(this.getClass().getResourceAsStream("/test/integration/data/xUser.xml"));
    }

    @Test
    public void testXUser() {
        Transaction transaction = session.beginTransaction();
        assertEquals(2, session.createCriteria(xUser.class).list().size());
        assertNotNull(session.createCriteria(xUser.class).add(Restrictions.eq("userId","admin")));
        transaction.commit();
    }
}
