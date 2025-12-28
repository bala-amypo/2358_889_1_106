package com.example.demo.dto;

public class AuthRequest {
    private String email;
    private String password;
    
    public AuthRequest() {}
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}


//ApiResponse.java
// package com.example.demo.dto;

// public class ApiResponse {
//     private boolean success;
//     private String message;
//     private Object data;

//     public ApiResponse() {}

//     public ApiResponse(boolean success, String message, Object data) {
//         this.success = success;
//         this.message = message;
//         this.data = data;
//     }

//     public boolean isSuccess() {
//         return success;
//     }

//     public void setSuccess(boolean success) {
//         this.success = success;
//     }

//     public String getMessage() {
//         return message;
//     }

//     public void setMessage(String message) {
//         this.message = message;
//     }

//     public Object getData() {
//         return data;
//     }

//     public void setData(Object data) {
//         this.data = data;
//     }
// }