define({ "api": [
  {
    "type": "get",
    "url": "/api/todo/:id",
    "title": "获取Todo",
    "version": "0.0.1",
    "group": "Todo",
    "name": "CreateTodo",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>Todo id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Json-Example:",
          "content": "{\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\"\n}",
          "type": "Json"
        }
      ]
    },
    "filename": "../src/main/java/me/yangbajing/share2016/web/controller/api/TodoController.java",
    "groupTitle": "Todo",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/api/todo/:id"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Json-Example:",
          "content": "{\n  \"id\": \"String: ID\",\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\",\n  \"createdTime\": \"LocalDateTime: 创建时间\",\n  \"lastModifiedTime\": \"LocalDateTime: 最后更新时间\"\n}",
          "type": "Json"
        }
      ]
    }
  },
  {
    "type": "delete",
    "url": "/api/todo/:id",
    "title": "删除Todo",
    "version": "0.0.1",
    "group": "Todo",
    "name": "DeleteTodo",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>Todo id</p>"
          }
        ]
      }
    },
    "filename": "../src/main/java/me/yangbajing/share2016/web/controller/api/TodoController.java",
    "groupTitle": "Todo",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/api/todo/:id"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Json-Example:",
          "content": "{\n  \"errcode\": 0,\n  \"errmsg\": \"String: 未0时返回错消息\"\n}",
          "type": "Json"
        }
      ]
    }
  },
  {
    "type": "post",
    "url": "/api/todo",
    "title": "创建Todo",
    "version": "0.0.1",
    "group": "Todo",
    "name": "GetTodo",
    "filename": "../src/main/java/me/yangbajing/share2016/web/controller/api/TodoController.java",
    "groupTitle": "Todo",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/api/todo"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Json-Example:",
          "content": "{\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\"\n}",
          "type": "Json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Json-Example:",
          "content": "{\n  \"id\": \"String: ID\",\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\",\n  \"createdTime\": \"LocalDateTime: 创建时间\",\n  \"lastModifiedTime\": \"LocalDateTime: 最后更新时间\"\n}",
          "type": "Json"
        }
      ]
    }
  },
  {
    "type": "get",
    "url": "/api/todo",
    "title": "获取所有Todo",
    "version": "0.0.1",
    "group": "Todo",
    "name": "GetTodoList",
    "filename": "../src/main/java/me/yangbajing/share2016/web/controller/api/TodoController.java",
    "groupTitle": "Todo",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/api/todo"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Json-Example:",
          "content": "[{\n  \"id\": \"String: ID\",\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\",\n  \"createdTime\": \"LocalDateTime: 创建时间\",\n  \"lastModifiedTime\": \"LocalDateTime: 最后更新时间\"\n}]",
          "type": "Json"
        }
      ]
    }
  },
  {
    "type": "put",
    "url": "/api/todo/:id/completed",
    "title": "设置Todo已完成",
    "version": "0.0.1",
    "group": "Todo",
    "name": "GetTodoList",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>Todo id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Json-Example:",
          "content": "{\n  \"id\": \"String: ID\",\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\",\n  \"createdTime\": \"LocalDateTime: 创建时间\",\n  \"lastModifiedTime\": \"LocalDateTime: 最后更新时间\"\n}",
          "type": "Json"
        }
      ]
    },
    "filename": "../src/main/java/me/yangbajing/share2016/web/controller/api/TodoController.java",
    "groupTitle": "Todo",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/api/todo/:id/completed"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Json-Example:",
          "content": "{\n  \"id\": \"String: ID\",\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\",\n  \"createdTime\": \"LocalDateTime: 创建时间\",\n  \"lastModifiedTime\": \"LocalDateTime: 最后更新时间\"\n}",
          "type": "Json"
        }
      ]
    }
  },
  {
    "type": "put",
    "url": "/api/todo/:id",
    "title": "更新Todo",
    "version": "0.0.1",
    "group": "Todo",
    "name": "UpdateTodo",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>Todo id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Json-Example:",
          "content": "{\n  \"id\": \"String: ID\",\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\",\n  \"createdTime\": \"LocalDateTime: 创建时间\",\n  \"lastModifiedTime\": \"LocalDateTime: 最后更新时间\"\n}",
          "type": "Json"
        }
      ]
    },
    "filename": "../src/main/java/me/yangbajing/share2016/web/controller/api/TodoController.java",
    "groupTitle": "Todo",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/api/todo/:id"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Json-Example:",
          "content": "{\n  \"id\": \"String: ID\",\n  \"text\": \"String: Todo内容\",\n  \"status\": \"Enum String: Todo状态，Active: 活动，Completed: 已完成\",\n  \"createdTime\": \"LocalDateTime: 创建时间\",\n  \"lastModifiedTime\": \"LocalDateTime: 最后更新时间\"\n}",
          "type": "Json"
        }
      ]
    }
  }
] });
