/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.MpjTbUsuario;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u04584043221
 */
public class UsuarioDAO extends AbstractDAO {

    private static final SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falha ao criar SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

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
        Criteria criteria = session.createCriteria(MpjTbUsuario.class);
        criteria.add(Restrictions.eq("idUsuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();

        return lista;

    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteia = session.createCriteria(MpjTbUsuario.class);
        List lista = criteia.list();
        session.getTransaction().commit();

        return lista;
    }

    public boolean login(String apelido, String senha) {
        Session session = factory.openSession();
        String hql = "FROM MpjTbUsuario u WHERE u.mpjApelidoUsuario = :apelido AND u.mpjSenhaUsuario = :senha";

        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("apelido", apelido);
        query.setParameter("senha", senha);

        MpjTbUsuario usuario = (MpjTbUsuario) query.uniqueResult();

        session.close();
        return usuario != null;
    }

    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbUsuario.class);
        criteria.add(Restrictions.like("mpjNomeUsuario", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listApelido(String apelido) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbUsuario.class);
        criteria.add(Restrictions.like("mpjApelidoUsuario", "%" + apelido + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeEApelido(String nome, String apelido) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MpjTbUsuario.class);
        criteria.add(Restrictions.like("mpjNomeUsuario", "%" + nome + "%"));
        criteria.add(Restrictions.eq("mpjApelidoUsuario", apelido));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        UsuarioDAO usuariosDAO = new UsuarioDAO();
        usuariosDAO.listAll();
        System.out.println("Deu certo");
    }

}
