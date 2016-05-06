package me.yangbajing.share2016.business.service;

import me.yangbajing.share2016.data.domain.TodoStatus;
import me.yangbajing.share2016.data.model.Todo;
import me.yangbajing.share2016.data.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Yang Jing (yangbajing@gmail.com) on 2016-05-06.
 */
@Service
public class TodServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAll(Optional<TodoStatus> status) {
        return status.map(todoRepository::findByStatus).orElseGet(() -> todoRepository.findAll());
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.insert(todo);
    }

    @Override
    public Optional<Todo> findOne(String id) {
        return Optional.ofNullable(todoRepository.findOne(id));
    }

    @Override
    public Todo updateOne(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void removeOne(String id) {
        todoRepository.delete(id);
    }

    @Override
    public Optional<Todo> updateOneToCompleted(String id) {
        return findOne(id)
                .map(todo -> {
                    todo.setStatus(TodoStatus.Completed);
                    return todoRepository.save(todo);
                });
    }

}
