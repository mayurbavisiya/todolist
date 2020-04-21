<template>
  <div v-if="currentUser" class="edit-form">
    <h4>User</h4>
    <form>
      <div class="form-group">
        <label for="username">User Name</label>
        <input
          type="text"
          class="form-control"
          id="username" required
          v-model="currentUser.username"
          name="username"
        />
      </div>

      <div class="form-group">
        <label for="fullName">Full Name</label>
        <input
          class="form-control"
          id="fullName" required
          v-model="currentUser.fullName"
          name="fullName"
        />
      </div>
       <div class="form-group">
        <label for="email">Email</label>
        <input
          class="form-control"
          id="email" required
          v-model="currentUser.email"
          name="email"
        />
      </div>
       <div class="form-group">
        <label for="phone">Phone</label>
        <input
          class="form-control"
          id="phone" required
          v-model="currentUser.phone"
          name="phone"
        />
      </div>
       <div class="form-group">
        <label for="address">Address</label>
        <input
          class="form-control"
          id="address" required
          v-model="currentUser.address"
          name="address"
        />
      </div>

      
    </form>

    
    
    <button class="badge badge-danger mr-2"
      @click="deleteUser"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateUser"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a User...</p>
  </div>
</template>

<script>
import UserService from "../services/UserService";

export default {
  name: "user",
  data() {
    return {
      currentUser: null,
      message: ''
    };
  },
  methods: {
    getUser(id) {
      UserService.get(id)
        .then(response => {
          this.currentUser = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

   

    updateUser() {
      UserService.update(this.currentUser)
        .then(response => {
          console.log(response.data);
          this.message = 'The Task was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteUser() {
      UserService.delete(this.currentUser.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "user" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getUser(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>