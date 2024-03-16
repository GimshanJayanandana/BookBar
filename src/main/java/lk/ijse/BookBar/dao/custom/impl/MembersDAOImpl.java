package lk.ijse.BookBar.dao.custom.impl;

import lk.ijse.BookBar.config.FactoryConfiguration;
import lk.ijse.BookBar.dao.custom.MembersDAO;
import lk.ijse.BookBar.entity.Members;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class MembersDAOImpl implements MembersDAO {
    @Override
    public boolean save(Members dto) throws SQLException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }
    @Override
    public boolean update(Members dto) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("DELETE FROM Members WHERE id ='"+id+"'", Members.class).executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Members search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Members> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        List<Members> list = session.createNativeQuery("SELECT * FROM Members", Members.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String generateNextID() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        Query<String> query = session.createQuery("SELECT id FROM Members ORDER BY id DESC LIMIT 1", String.class);
        query.setMaxResults(1);
        String currentMemberID = query.uniqueResult();

        transaction.commit();
        session.close();

        if (currentMemberID != null) {
            return splitMemberID(currentMemberID);
        } else {
            return splitMemberID(null);
        }
    }

    private String splitMemberID(String currentMemberID) {
        if (currentMemberID != null) {
            String[] split = currentMemberID.split("M");

            int id = Integer.parseInt(split[1]);
            id++;
            return String.format("M%03d", id);
        } else {
            return "M001";
        }
    }
}
