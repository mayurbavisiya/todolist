
  <template>
  <div id="app">
    
    <nav class="navbar navbar-expand navbar-light bg-light">
      <a href="#" class="navbar-brand mr-auto">ToDo Application</a>
      <div class="navbar-nav mr-auto">
        <!-- <li class="nav-item">
          <a href="/task" class="nav-link">Tasks</a>
        </li>
        <li class="nav-item">
          <a href="/addTask" class="nav-link">Add New Task</a>
        </li> -->
         <!-- <li class="nav-item">
          <a href="/user" class="nav-link">Users</a>
        </li> -->
        <!-- <li class="nav-item">
          <a href="/AssignTask" class="nav-link">Assign Task</a>
        </li> -->
        <!-- <li class="nav-item">
          <a href="/addUser" class="nav-link">Add User</a>
        </li> -->
        <!-- Dropdown -->
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
          User
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="/user">All Users</a>
          <a class="dropdown-item" href="/addUser">Add User</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
          Task
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="/task">All Tasks</a>
          <a class="dropdown-item" href="/addTask">Add Task</a>
          <a class="dropdown-item" href="/assignTask">Assign Task</a>
          <a class="dropdown-item" href="/assignedTask">Assigned Task</a>
        </div>
      </li>
        <!-- <li class="nav-item">
          <a href="/assignedTasks" class="nav-link">Assigned Tasks</a>
        </li> -->
      </div>
      <form class="form-inline my-2 my-lg-0" action="/action_page.php">
    <input class="form-control mr-sm-2" type="text" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>




<script>
export default {
  name: 'app'
}
</script>
