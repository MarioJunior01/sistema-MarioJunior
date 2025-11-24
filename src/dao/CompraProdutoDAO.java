/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MpjTbCompra;
import bean.MpjTbCompraProduto;
import bean.MpjTbFornecedor;
import bean.MpjTbProduto;
import bean.MpjTbUsuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u04584043221
 */
public class CompraProdutoDAO extends AbstractDAO {

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
    public Object list(int idCompraProduto) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbCompraProduto.class);
        criteria.add(Restrictions.eq("IdCompraProduto",idCompraProduto));
        List lista = criteria.list();
        session.getTransaction().commit();


        return lista;

    }
      public Object listProdutos(MpjTbCompra compra) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbCompraProduto.class);
        criteria.add(Restrictions.eq("Compra",compra));
        List lista = criteria.list();
        session.getTransaction().commit();


        return lista;

    }
    
    

    
    @Override
    public Object  listAll() {
        session.beginTransaction();
        Criteria criteia = session.createCriteria(MpjTbCompraProduto.class);
        List lista = criteia.list();
        session.getTransaction().commit();

        return lista;
    }
    public static void main(String[] args) {
        CompraProdutoDAO compraProdutoDAO = new  CompraProdutoDAO();
        compraProdutoDAO.listAll();
        System.out.println("Deu certo");
    }

}