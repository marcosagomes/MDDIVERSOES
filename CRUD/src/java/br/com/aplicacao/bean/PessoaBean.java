/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplicacao.bean;

import br.com.aplicacaoDAO.pessoasDAO;
import br.com.aplicacaoPOJO.Pessoa;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Servidor
 */
@ManagedBean
@SessionScoped
public class PessoaBean {

    /**
     * Creates a new instance of PessoaBean
     */
    private Pessoa pessoa = new Pessoa();
    private pessoasDAO pessoaDao = new pessoasDAO();
    private List<Pessoa> listarPessoas;
    public PessoaBean() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public String adicionarPessoa(){
        pessoaDao.addPessoa(pessoa);
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setRua(null);
        pessoa.setTelefone(null);
        return "index";
    }
    
    public String removerPessoa(Pessoa p){
        this.pessoa = p;
        pessoaDao.remove(this.pessoa);
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setRua(null);
        pessoa.setTelefone(null);
        return "index";
    }
    public String carregarPessoa(Pessoa p){
        pessoa = p;
        return "editar";
    }
    public String atualizarPessoa(){
        pessoaDao.editar(pessoa);
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setRua(null);
        pessoa.setTelefone(null);
        return "index";
    }
    public List listaPessoas(){
       listarPessoas = pessoaDao.getList();
       return listarPessoas;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaBean other = (PessoaBean) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }
    
}
