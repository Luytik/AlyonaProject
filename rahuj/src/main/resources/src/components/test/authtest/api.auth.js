import { instance } from "./api.config";

export default class AuthService {

    login (login, password) {
        return instance.post("http://localhost:8080/auth/login", {login, password})
    }
    
    refreshToken() {
        return instance.get("/api/refresh");
    }
    
    logout() {
        return instance.post("/api/logout")
    }
}