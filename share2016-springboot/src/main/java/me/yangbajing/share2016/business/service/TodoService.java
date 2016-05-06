package me.yangbajing.share2016.business.service;

import me.yangbajing.share2016.data.domain.TodoStatus;
import me.yangbajing.share2016.data.model.Todo;

import java.util.List;
import java.util.Optional;

/**
 * Created by Yang Jing (yangbajing@gmail.com) on 2016-05-06.
 */
public interface TodoService {
    List<Todo> findAll(Optional<TodoStatus> status);

    Todo create(Todo todo);

    Optional<Todo> findOne(String id);

    Todo updateOne(Todo todo);

    void removeOne(String id);

    Optional<Todo> updateOneToCompleted(String id);
}
