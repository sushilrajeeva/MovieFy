# BookMyMovie


API's 
1. http://localhost:8082/api/v1.0/getAllMovies

2. http://localhost:8082/call/consumer/authenticate/

{
"userName": "sushilrajeeva",
"userPassword" : "pas123"
}

3. http://localhost:8082/api/v1.0/admin/addMovie

{
    "movieName": "Asur 2",
    "theatreName": "Bharat Cinemas"
}

4. http://localhost:8082/api/v1.0/admin/delete/Pathan/Inox

5. http://localhost:8082/api/v1.0/getAllMovies

6. http://localhost:8082/api/v1.0/admin/updateMovie/3

{
    "movieName": "RRR"
}

7. http://localhost:8082/api/v1.0/ticket/admin/getAllTickets

8. http://localhost:8082/api/v1.0/ticket/add/6/35

9. http://localhost:9091/registerNewUser

{
"userName": "sushilrajeev",
"fullName": "Sushil Rajeeva Bhandary",
"email": "sushil@gmail.com",
"userPassword": "sush@123",
"secretQuestion": "What is your favourite athelete name",
"secretAnswer": "Virat Kohli",
"role": [
{
"roleName":"user",
"roleDesc":"For users"
}
]
}

10. http://localhost:9091/authenticate

{
"userName": "vishalsb",
"userPassword" : "vis1234"
}

11. http://localhost:9091/user/forgetpassword

{
    "secretQuestion": "What is your nickname",
    "secretAnswer": "Vishu",
    "newPassword": "vishalbhandary@123",
    "userName": "vishalsb1"
}

12. http://localhost:9091/username/forget/{email}/{password}
