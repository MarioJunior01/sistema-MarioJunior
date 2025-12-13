/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MpjTbProduto;
import bean.MpjTbUsuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ProdutoDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(MpjTbProduto.class);
        criteria.add(Restrictions.eq("idProduto", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();

        return lista;

    }

    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbProduto.class);
        criteria.add(Restrictions.like("mpjNomeProduto", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listValor(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbProduto.class);
        criteria.add(Restrictions.ge("mpjPrecoProduto", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeEvalor(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbProduto.class);
        criteria.add(Restrictions.like("mpjNomeProduto", "%" + nome + "%"));
        criteria.add(Restrictions.ge("mpjPrecoProduto", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteia = session.createCriteria(MpjTbProduto.class);
        List lista = criteia.list();
        session.getTransaction().commit();

        return lista;
    }

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.listAll();
        System.out.println("Deu certo");
    }

}
