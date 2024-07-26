package com.washiner.todolist.service;

import com.washiner.todolist.entity.Todo;
import com.washiner.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    //1-
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;

    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);   //injetando essa dependencia
        return list();

    }
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
       return todoRepository.findAll(sort);

    }
    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();

    }
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();

    }

}


//1-para criar os metodos precisamos do repository
//2- criar uma injeçao com contrutores

//3-existem 3 formas de fazer injeçao de dependencia
/*
  3 formas de se fazer injeçao de dependencia no java
  1-> via atributo usando @Autowired
  1-> via metodo teria que criar getter e setter para todoRepository
  2-> e via contrutor que e a forma mais recomendada para usar springboot
  usando via contrutor nao preciso colocar o @Autowired por que o springboot
  ja inplicitamente esta sendo usando
*/

