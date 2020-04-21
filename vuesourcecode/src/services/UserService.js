import http from "../http-common";

class UserService{

    getAll(){
        return http.get(`/user`);
    }
   
    create(data){
        return http.post(`/user`, data);
    }

    get(id) {
        return http.get(`/user/${id}`);
    }

    delete(id){
        return http.delete(`/user/${id}`);
    }

    update(data) {
        return http.put(`/user`, data);
     }

}
export default new UserService();