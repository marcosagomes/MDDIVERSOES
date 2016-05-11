/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacaoDAO;

import br.com.aplicacaoPOJO.Pessoa;
import br.com.aplicacaoUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Servidor
 */
public class pessoasDAO {

    private Session sessao;
    private Transaction trans;
    private List<Pessoa> list;

    public void addPessoa(Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(p.getNome());
            pessoa.setRua(p.getRua());
            pessoa.setTelefone(p.getTelefone());
            pessoa.setEmail(p.getEmail());

            sessao.save(pessoa);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessao.close();
        }
    }

    public List<Pessoa> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Pessoa.class);
        this.list = cri.list();
        return list;
    }

    public void remove(Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.delete(p);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessao.close();
        }

    }
     public void editar (Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            sessao.update(p);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessao.close();
        }

    }
}
