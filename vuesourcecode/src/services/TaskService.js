import http from "../http-common";

class TaskService{

    getAll(){
        return http.get(`/task`);
    }
    create(data) {
        return http.post(`/task`, data);
    }
    get(id) {
        return http.get(`/task/${id}`);
    }
    delete(id) {
        return http.delete(`/task/${id}`);
    }
    update(data) {
        return http.put(`/task`, data);
    }
    assignTask(data){
        return http.post(`/task/assign`, data);
    }
    taskAssigned(){
        return http.get(`/task/assign`);
    }
    complete(id){
        return http.get(`/task/complete/${id}`);
    }
   
    
}

export default new TaskService();