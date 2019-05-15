(function () {
    const $usernameFld = $('#usernameFld');
    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const $lastNameFld = $('#lastNameFld');
    const $roleFld = $('#roleFld');
    const userRowTemplate = $('.wbdv-template');
    const tbody = $('tbody');
    const $searchBtn = $('#searchBtn');
    const $updateBtn = $('#updateBtn');
    const $createBtn = $('#createBtn');
    var $removeBtn = $('.removeBtn');
    var $editBtn = $('.editBtn');
    const findAllUsersUrl = 'http://localhost:8080/users';
    const deleteUserUrl = 'http://localhost:8080/users/USER_ID';
    var selectedUserID;
    var userService = new AdminUserServiceClient();

    $(main);

    function main() {
        $updateBtn.click(updateUser);
        $createBtn.click(createUser);
        $removeBtn.click(deleteUser);
        $editBtn.click(findUserById);
    }

    function createUser() {
        console.log('Create User');
        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const role = $roleFld.val();
        console.log(username, password, firstName, lastName, role);

        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        }
        userService.createUser(user).then(findAllUsers);
    }

    function findAllUsers() {
        userService.findAllUsers().then(renderUsers);
    }

    function findUserById() {
        var editBtn = $(event.currentTarget);
        selectedUserID = editBtn.attr("id");
        const foundUser = userService.findUserById();
        renderUser(foundUser);
    }

    function deleteUser(event) {
        deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr('id');
        console.log(id);
        const url = deleteUserUrl.replace('USER_ID', id);
        console.log(url);
        userService.deleteUser(url).then(findAllUsers);
    }

    function selectUser() {}
    function updateUser() {}

    function appendUserToDom(user) {
        const row = userRowTemplate.clone();
        row.removeClass('wbdv-hidden');
        const usernameCol = row.find('.wbdv-username');
        const firstNameCol = row.find('.wbdv-first-name');
        const lastNameCol = row.find('.wbdv-last-name');
        const roleCol = row.find('.wbdv-role');
        const removeBtn = row.find('.removeBtn');

        removeBtn.click(deleteUser);
        removeBtn.attr('id', user.id);

        usernameCol.html(user.username);
        firstNameCol.html(user.firstName);
        lastNameCol.html(user.lastName);
        roleCol.html(user.role);

        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");

        tbody.append(row);
    }

    function renderUser(user) {}


    function renderUsers(users) {
        $("tbody").empty()
        for(i in users) {
            console.log(i);
            appendUserToDom(users[i]);
        }
    }
})();
