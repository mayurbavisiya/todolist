<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="username">User Name</label>
        <input
          type="text"
          class="form-control"
          id="username4" required
          v-model="user.username"
          name="usernanme"
        />
      </div>

      <div class="form-group">
        <label for="fullName">Full Name</label>
        <input
          class="form-control"
          id="fullName" required
          v-model="user.fullName"
          name="fulName"
        />
      </div>
       <div class="form-group">
        <label for="email">Email</label>
        <input
          class="form-control"
          id="email" required
          v-model="user.email"
          name="email"
        />
      </div>
       <div class="form-group">
        <label for="phone">Phone</label>
        <input
          class="form-control"
          id="phone" required
          v-model="user.phone"
          name="phone"
        />
      </div>
       <div class="form-group">
        <label for="address">Address</label>
        <input
          class="form-control"
          id="description" required
          v-model="user.address"
          name="address"
        />
      </div>

      <button @click="saveUser" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newUser">Add</button>
    </div>
  </div>
</template>

<script>
import UserService from '../services/UserService';

export default {
  name: "add-user",
  data() {
    return {
      user: {
        id: null,
        username:"",
        fullName:"",
        phone:"",
        email:"",
        address:""
      },
      submitted: false
    };
  },
  methods: {
    saveUser() {
      var data = {
        username: this.user.username,
        email:this.user.email,
        fullName :this.user.fullName,
        address:this.user.address,
        phone:this.user.phone,

        };

      UserService.create(data)
        .then(response => {
          this.user.id = response.data.id;
         
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newUser() {
      this.submitted = false;
      this.user = {};
    }
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>