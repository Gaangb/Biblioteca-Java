/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudanteTemLivro.controler;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import estudanteTemLivro.model.EstudanteTemLivro;
import estudanteTemLivro.dao.EstudanteTemLivroDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author angelo
 */
public class EstudanteTemLivroControler {
    EstudanteTemLivroDao dao = new EstudanteTemLivroDao();
    
    public void emprestar(EstudanteTemLivro estudanteTemLivro){
        try {
            dao.salvar(estudanteTemLivro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudanteTemLivroControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteTemLivroControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void devolver(EstudanteTemLivro estudanteTemLivro){
        try {
            dao.atualizar(estudanteTemLivro);
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteTemLivroControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudanteTemLivroControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void obterTodosEmprestimos() {
        EstudanteTemLivroDao emprestimoDAO = new EstudanteTemLivroDao();
    
        try {
            List<EstudanteTemLivro> emprestimos;
            emprestimos = emprestimoDAO.obterTodosEmprestimos();
            if (!emprestimos.isEmpty()) {
                System.out.println("Emprestimos cadastrados na Biblioteca");
                for (EstudanteTemLivro emprestimo : emprestimos) {
                    System.out.println("ID: " + emprestimo.getId());
                    System.out.println("ID LIVRO: " + emprestimo.getIdLivro());
                    System.out.println("ID USUARIO: " + emprestimo.getIdUsuario());
                    System.out.println("DATA EMPRESTIMO: " + emprestimo.getDataEmprestimo());
                    System.out.println("DATA DEVOLUCAO: " + emprestimo.getDataDevolucao());
                    System.out.println("--------------------------------------");
                }
            } else {
                System.out.println("Nenhum emprestimo encontrado.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudanteTemLivroControler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteTemLivroControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
           public static void main(String args[]) {
        EstudanteTemLivroControler emprestimo = new EstudanteTemLivroControler();

//        EstudanteTemLivro emprestimo1 = new EstudanteTemLivro(1, 0);
//        emprestimo.emprestar(emprestimo1);
//        EstudanteTemLivro devolver1 = new EstudanteTemLivro(1);
//        emprestimo.devolver(devolver1);
        emprestimo.obterTodosEmprestimos();
    }
}

