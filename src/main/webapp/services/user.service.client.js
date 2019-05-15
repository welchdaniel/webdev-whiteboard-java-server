function AdminUserServiceClient() {
    this.findAllUsersUrl = 'http://localhost:8080/users/find';
    this.deleteUserUrl = 'http://localhost:8080/users/USER_ID';
    this.createUserUrl = 'http://localhost:8080/users/create';
    this.getUserUrl = 'http://localhost:8080/users/find/USER_ID';
    this.putUserURL = 'http://localhost:8080/users/put/USER_ID';

    this.createUser = function(user){
        user.id = (new Date()).getTime();
        console.log(user);
        return fetch(this.createUserUrl, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json();
        })
    };


    this.findAllUsers = function(){
        return fetch(this.findAllUsersUrl, {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json();
        })
    };

    this.findUserById = function(getID) {
        const findURL = this.getUserUrl.replace('USER_ID', getID);
        return fetch(findURL, {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json();
        })
    };

    this.deleteUser = function(deleteID){
        const deleteURL = this.deleteUserUrl.replace('USER_ID', deleteID);
        return fetch(deleteURL, {
            method: 'DELETE'
        }).then(function(response) {
            return response.json();
        })
    };

    this.updateUser = function(user,putID) {
        const putURL = this.putUserURL.replace('USER_ID', putID);
        return fetch(putURL, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json();
        })
    };
}
