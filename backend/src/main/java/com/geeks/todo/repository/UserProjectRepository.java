package com.geeks.todo.repository;


import com.geeks.todo.beans.Task;
import com.geeks.todo.beans.User;
import com.geeks.todo.beans.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProjectRepository extends JpaRepository<UserTask, Integer> {

    public UserTask findByTaskAndUsers(Task task, User user);

    public List<UserTask> findByUsers(User user);

}
