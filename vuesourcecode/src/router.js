import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
      {
        path: "/",
        alias: "/task",
        name: "taskList",
        component: () => import("./components/TaskList")
      },
      {
        path: "/task/:id",
        name: "task",
        component: () => import("./components/Task")
      },
      {
        path: "/addTask",
        name: "addTask",
        component: () => import("./components/AddTask")
      },
      {
        path: "/assignTask",
        name: "assignTask",
        component: () => import("./components/AssignTask")
      },
      {
        path: "/assignedTask",
        name: "assignedTask",
        component: () => import("./components/AssignedTasks")
      },
      {
        path: "/user",
        name: "user",
        component: () => import("./components/UserList")
      },
      {
        path: "/user/:id",
        name: "user",
        component: () => import("./components/User")
      },
      {
        path: "/addUser",
        name: "addUser",
        component: () => import("./components/AddUser")
      }
    ]
  });