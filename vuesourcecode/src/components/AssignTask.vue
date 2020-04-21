<template>
<div class="submit-form">
  <div class="list row">
    <div class="col-md-6">
        <label for="email">Select Task</label>
        <select id="taskList" v-model="assignTask.taskId" required name="taskList" class="form-control" @change="changeAssignTask($event)">
            <option value="" selected disabled>Select Task</option>
            <option v-for="(t, index) in tasks" :key="index" :value="t.id" name = "taskId">
          {{ t.title }}
          </option>
        </select>
    </div>
    <div class="col-md-6">
        <label for="email">Select User</label>
        <select id="userList" v-model="assignTask.userId" name="userList" required class="form-control" @change="changeAssignUser($event)">
            <option value="" selected disabled>Select User</option>
            <option v-for="(t, index1) in users" :key="index1" :value="t.id" name = "userId" >
          {{ t.username }}
          </option>
        </select>
    </div>
    <div class="col-md-6">
        <label for="startDate">Start Date</label>
        <input type="date"  v-model="assignTask.startDate" class="form-control" name="startDate"/>
    </div>
    <div class="col-md-6">
        <label for="email">End Date</label>
        <input type="date"  v-model="assignTask.endDate" class="form-control" name="endDate"/>
    </div>

    <div class="col-md-12 text-right" style="margin-top:10px;">
        <button class="btn pull-right btn-success" @click="createAssignTask">Assign Task</button>
    </div>
    
  </div>
</div>
</template>

<script>
import TaskService from "../services/TaskService";
import UserService from "../services/UserService";

export default {
  name: "task-list",
  data() {
    return {
      tasks: [],
      users:[],
      
    
      assignTask: {
        id: null,
        userId:"",
        taskId:"",
        startDate:"",
        endDate:"",
        
      },
      submitted: false,
    

      currentTask: null,
      currentUser : null,
      currentIndex: -1
    };
  },
  
  methods: {
      changeAssignTask(event) {
              console.log(event.target.value);
        },
        changeAssignUser(event) {
              console.log(event.target.value);
        },
      
     createAssignTask() {
       //alert("clicked");
      var assign = {
        userId: this.assignTask.userId,
        taskId: this.assignTask.taskId,
        startDate: this.assignTask.startDate,
        endDate : this.assignTask.endDate,
        };

      TaskService.assignTask(assign)
        .then(response => {
          alert("Assigned successfully");
          this.assign.id = response.assign.id;
          console.log(response.assign);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    

    retrieveTask() {
      TaskService.getAll()
        .then(response => {
          this.tasks = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    retrieveUser() {
      UserService.getAll()
        .then(response => {
          this.users = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    

    refreshList() {
      this.retrieveTask();
      this.retrieveUser();
      this.currentTask = null;
      this.currentIndex = -1;
    },

    setActiveTask(task, index) {
      this.currentTask = task;
      this.currentIndex = index;
    },
    setActiveUser(user, index1) {
      this.currentUser = user;
      this.currentIndex = index1;
    },

  },
    
  mounted() {
    this.retrieveTask();
    this.retrieveUser();
  }
};



// 


</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>