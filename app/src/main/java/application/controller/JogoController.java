package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.JogoRepository;
import application.model.Jogo;


@Controller
public class JogoController {

    @Autowired
    private JogoRepository jogoRepo;

    //LIST.JSP
    @RequestMapping("/jogo")
    public String list(Model model) {
        model.addAttribute("jogos", jogoRepo.findAll());
        return "WEB-INF/list.jsp";
    }

    //INSERT.JSP
    @RequestMapping("/insert")
    public String insert() {
        return "WEB-INF/insert.jsp";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo, @RequestParam("anoDeLancamento") int anoDeLancamento){
        Jogo jogo = new Jogo(); //criar objeto jogo do tipo jogo
        jogo.setTitulo(titulo); 
        jogo.setAnoDeLancamento(anoDeLancamento);

        jogoRepo.save(jogo); //fazer consulta no BD 
        return "redirect:/jogo"; //redirecionando para a listagem de jogo 
    }


    //UPDATE.JSP
    @RequestMapping("/update") 
    public String update(Model model, 
    @RequestParam("id") int id) {
        Optional<Jogo> jogo = jogoRepo.findById(id);

        if (!jogo.isPresent()){ //se não houver nenhum atributo de jogo
            return "redirect:/jogo"; 
        }

        model.addAttribute("jogo", jogo.get());
        return("WEB-INF/update.jsp");
    }

    //função de editar o jogo que foi retornado
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("titulo") String titulo,
        @RequestParam("id") int id,
        @RequestParam("anoDeLancamento") int anoDeLancamento

        
    ){
        Optional<Jogo> jogo = jogoRepo.findById(id);
        if (!jogo.isPresent()){ //se não houver nenhum atributo de jogo
            return "redirect:/jogo"; 
        }

        jogo.get().setTitulo(titulo);
        jogo.get().setAnoDeLancamento(anoDeLancamento);

        jogoRepo.save(jogo.get());
        return "redirect:/jogo";
    }
    
      //função de excluir o jogo que foi retornado
      @RequestMapping(value = "/delete", method = RequestMethod.GET)
      public String delete(Model model, @RequestParam("id") int id){
          Optional<Jogo> jogo = jogoRepo.findById(id);

          if (!jogo.isPresent()){ //se não houver nenhum atributo de jogo
              return "redirect:/jogo"; 
          }
  
          model.addAttribute("jogo", jogo.get());
          return("WEB-INF/delete.jsp");
        }


      @RequestMapping(value = "/delete", method = RequestMethod.POST)
      public String delete(@RequestParam("id") int id){
        jogoRepo.deleteById(id);
        return "redirect:/jogo";
      }
}
