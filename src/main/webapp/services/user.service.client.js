function AdminUserServiceClient() {
    this.findAllUsersUrl = 'http://localhost:8080/users';
    this.deleteUserUrl = 'http://localhost:8080/users/USER_ID';

    this.createUser = function(user){
        user.id
    };


    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/user';
    var self = this;
    function createUser(user, callback) { … }
    function findAllUsers(callback) { … }
    function findUserById(userId, callback) { … }
    function updateUser(userId, user, callback) { … }
    function deleteUser(userId, callback) { … }
}
