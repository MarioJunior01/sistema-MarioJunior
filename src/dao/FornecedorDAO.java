/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MpjTbFornecedor;
import bean.MpjTbUsuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u04584043221
 */
public class FornecedorDAO extends AbstractDAO {

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
    public Object list(int cnpj) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbFornecedor.class);
        criteria.add(Restrictions.eq("CnpjF Fornecedor",cnpj));
        List lista = criteria.list();
        session.getTransaction().commit();


        return lista;

    }
        public Object listNomeFantasia(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbFornecedor.class);
        criteria.add(Restrictions.like("mpjNomeFantasiaFornecedor", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

     public Object listSegmento(String segmento) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbFornecedor.class);
        criteria.add(Restrictions.like("mpjSegmentoFornecedor", "%" + segmento + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

       
       public Object listSegementoENomeFantasia(String nome, String segmento) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbFornecedor.class);
        criteria.add(Restrictions.like("mpjNomeFantasiaFornecedor", "%" + nome + "%"));
        criteria.add(Restrictions.eq("mpjSegmentoFornecedor", segmento));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    
    @Override
    public Object  listAll() {
        session.beginTransaction();
        Criteria criteia = session.createCriteria(MpjTbFornecedor.class);
        List lista = criteia.list();
        session.getTransaction().commit();

        return lista;
    }
    public static void main(String[] args) {
        FornecedorDAO fornecedorDAO = new  FornecedorDAO();
        fornecedorDAO.listAll();
        System.out.println("Deu certo");
    }

}