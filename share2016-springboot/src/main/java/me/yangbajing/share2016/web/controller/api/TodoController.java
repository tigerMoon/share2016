package me.yangbajing.share2016.web.controller.api;

import me.yangbajing.share2016.business.service.TodoService;
import me.yangbajing.share2016.common.Consts;
import me.yangbajing.share2016.common.exception.SNotFoundException;
import me.yangbajing.share2016.data.domain.ErrResponse;
import me.yangbajing.share2016.data.domain.TodoStatus;
import me.yangbajing.share2016.data.model.Todo;
import me.yangbajing.share2016.web.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Todo Rest Controller
 * Created by Yang Jing (yangbajing@gmail.com) on 2016-05-06.
 */
@RestController
@RequestMapping(path = Consts.API_PATH + "/todo")
public class TodoController {
    /**
     * @apiDefine TodoSuccessListResponse
     * @apiSuccessExample {Json} Success-Json-Example:
     * [{
     *   "id": "String: ID",
     *   "text": "String: Todo内容",
     *   "status": "Enum String: Todo状态，Active: 活动，Completed: 已完成",
     *   "createdTime": "LocalDateTime: 创建时间",
     *   "lastModifiedTime": "LocalDateTime: 最后更新时间"
     * }]
     */

    /**
     * @apiDefine TodoSuccessResponse
     * @apiSuccessExample {Json} Success-Json-Example:
     * {
     *   "id": "String: ID",
     *   "text": "String: Todo内容",
     *   "status": "Enum String: Todo状态，Active: 活动，Completed: 已完成",
     *   "createdTime": "LocalDateTime: 创建时间",
     *   "lastModifiedTime": "LocalDateTime: 最后更新时间"
     * }
     */

    /**
     * @apiDefine TodoSuccessErrResponse
     * @apiSuccessExample {Json} Success-Json-Example:
     * {
     *   "errcode": 0,
     *   "errmsg": "String: 未0时返回错消息"
     * }
     */

    /**
     * @apiDefine TodoUpdateExample
     * @apiParamExample {Json} Request-Json-Example:
     * {
     *   "id": "String: ID",
     *   "text": "String: Todo内容",
     *   "status": "Enum String: Todo状态，Active: 活动，Completed: 已完成",
     *   "createdTime": "LocalDateTime: 创建时间",
     *   "lastModifiedTime": "LocalDateTime: 最后更新时间"
     * }
     */

    /**
     * @apiDefine TodoCreateExample
     * @apiParamExample {Json} Request-Json-Example:
     * {
     *   "text": "String: Todo内容",
     *   "status": "Enum String: Todo状态，Active: 活动，Completed: 已完成"
     * }
     */

    @Autowired
    private TodoService todoService;

    /**
     * @api {get} /api/todo 获取所有Todo
     * @apiVersion 0.0.1
     * @apiGroup Todo
     * @apiName GetTodoList
     * @apiUse TodoSuccessListResponse
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getTodoList(@RequestParam Optional<TodoStatus> status) {
        return todoService.findAll(status);
    }

    /**
     * @api {post} /api/todo 创建Todo
     * @apiVersion 0.0.1
     * @apiGroup Todo
     * @apiName CreateTodo
     * @apiUse TodoCreateExample
     * @apiUse TodoSuccessResponse
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo result = todoService.create(todo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * @api {get} /api/todo/:id 获取Todo
     * @apiVersion 0.0.1
     * @apiGroup Todo
     * @apiName GetTodo
     * @apiParam {String} id Todo id
     * @apiUse TodoSuccessResponse
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Todo> findOne(@PathVariable String id) {
        return WebUtils.responseOptional(todoService.findOne(id));
    }

    /**
     * @api {put} /api/todo/:id 更新Todo
     * @apiVersion 0.0.1
     * @apiGroup Todo
     * @apiName UpdateTodo
     * @apiParam {String} id Todo id
     * @apiUse TodoUpdateExample
     * @apiUse TodoSuccessResponse
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Todo updateOne(@PathVariable String id, @RequestBody Todo todo) {
        if (!id.equals(todo.getId())) {
            throw new SNotFoundException(String.format("request id is %s, but todo.id is %s", id, todo.getId()));
        }
        return todoService.updateOne(todo);
    }

    /**
     * @api {put} /api/todo/:id/completed 设置Todo已完成
     * @apiVersion 0.0.1
     * @apiGroup Todo
     * @apiName GetTodoList
     * @apiParam {String} id Todo id
     * @apiUse TodoUpdateExample
     * @apiUse TodoSuccessResponse
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}/completed")
    public ResponseEntity<Todo> updateOneToCompleted(@PathVariable String id) {
        return WebUtils.responseOptional(todoService.updateOneToCompleted(id),
                () -> new ErrResponse(500, String.format("set id: %s to completed failure", id)));
    }

    /**
     * @api {delete} /api/todo/:id 删除Todo
     * @apiVersion 0.0.1
     * @apiGroup Todo
     * @apiName DeleteTodo
     * @apiParam {String} id Todo id
     * @apiUse TodoSuccessErrResponse
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<ErrResponse> removeOne(@PathVariable String id) {
        todoService.removeOne(id);
        return ResponseEntity.ok(new ErrResponse(0, ""));
    }

}
