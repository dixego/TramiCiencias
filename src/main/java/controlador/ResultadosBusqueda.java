/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author vicaris
 */
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import modelo.*;
import lombok.*;

@SessionScoped
@ManagedBean
public class ResultadosBusqueda {
    
    @Getter @Setter private String busqueda;
    @Getter @Setter private List<Pregunta> preguntas;
    @Getter @Setter private Pregunta preguntaEncontrada;
       
    public String visitar(int id){
        PreguntaDAO pdao = new PreguntaDAO();
        preguntaEncontrada = pdao.buscarPregunta(id);
        return "pregunta?id="+preguntaEncontrada;
    }
    
    public String buscarPregunta() {
        PreguntaDAO pdao = new PreguntaDAO();
        preguntas = pdao.buscarTitulo(busqueda);
        return "resultados?faces-redirect=true";
    }
    
}