<template>
  <div class="list row">
    
    <div class="col-md-6">
      <h4>Task List</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(t, index) in tasks"
          :key="index"
          @click="setActiveTask(t, index)"
        >
          {{ t.title }}
        </li>
       
      </ul>

     
    </div>
    <div class="col-md-6">
      <div v-if="currentTask">
        <h4>Task</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentTask.title }}
        </div>
        <div>
          <label><strong>Description:</strong></label> {{ currentTask.description }}
        </div>
        <div>
          <label><strong>Status:</strong></label> {{ currentTask.status }}
        </div>
       

        <a class="badge badge-warning"
          :href="'/task/' + currentTask.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br />
        <p>Please click on a Task...</p>
      </div>
    </div>
  </div>
</template>

<script>
import TaskService from "../services/TaskService";

export default {
  name: "task-list",
  data() {
    return {
      tasks: [],
      currentTask: null,
      currentIndex: -1
    };
  },
  methods: {
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
    

    refreshList() {
      this.retrieveTask();
      this.currentTask = null;
      this.currentIndex = -1;
    },

    setActiveTask(task, index) {
      this.currentTask = task;
      this.currentIndex = index;
    },

  },
    
  mounted() {
    this.retrieveTask();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>