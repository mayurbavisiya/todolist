<template>
  <div class="list row">
    
    <div class="col-md-6">
      <h4>User List</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(t, index) in users"
          :key="index"
          @click="setActiveUser(t, index)"
        >
          {{ t.fullName }}
        </li>
      </ul>

     
    </div>
    <div class="col-md-6">
      <div v-if="currentUser">
        <h4>User</h4>
        <div>
          <label><strong>UserName:</strong></label> {{ currentUser.username }}
        </div>
        <div>
          <label><strong>Full Name:</strong></label> {{ currentUser.fullName }}
        </div>
         <div>
          <label><strong>Contact:</strong></label> {{ currentUser.phone }}
        </div>
         <div>
          <label><strong>Address:</strong></label> {{ currentUser.address }}
        </div>
         <div>
          <label><strong>Email:</strong></label> {{ currentUser.email }}
        </div>
       

        <a class="badge badge-warning"
          :href="'/user/' + currentUser.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br />
        <p>Please click on a User...</p>
      </div>
    </div>
  </div>
</template>

<script>
import UserService from "../services/UserService";
export default {
  name: "user-list",
  data() {
    return {
      users: [],
      currentUser: null,
      currentIndex: -1
    };
  },
  methods: {
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
      this.retrieveUser();
      this.currentUser = null;
      this.currentIndex = -1;
    },

    setActiveUser(user, index) {
      this.currentUser = user;
      this.currentIndex = index;
    },

  },
    
  mounted() {
    this.retrieveUser();
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