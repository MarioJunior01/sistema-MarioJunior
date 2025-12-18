/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MpjTbCompra;
import bean.MpjTbFornecedor;
import bean.MpjTbUsuario;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u04584043221
 */
public class CompraDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.update(object);
        session.flush();
        session.clear();
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbCompra.class);
        criteria.add(Restrictions.eq("IdCompra", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();

        return lista;

    }
      public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbCompra.class);
        criteria.add(Restrictions.like("", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listValor(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbCompra.class);
        criteria.add(Restrictions.ge("mpjValorCompra", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeEvalor(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbCompra.class);
        criteria.add(Restrictions.like("mpjNomeProduto", "%" + nome + "%"));
        criteria.add(Restrictions.ge("mpjPrecoProduto", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteia = session.createCriteria(MpjTbCompra.class);
        List lista = criteia.list();
        session.getTransaction().commit();

        return lista;
    }

    public void updateById(MpjTbCompra compra) {
        Transaction transaction = null;

        transaction = session.beginTransaction();
        session.merge(compra);

        transaction.commit();

        if (transaction != null) {
            transaction.rollback();
        }

    }

    public static void main(String[] args) {
        CompraDAO compraDAO = new CompraDAO();
        compraDAO.listAll();
        System.out.println("Deu certo");
    }

}
