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
        userService.findUserById(selectedUserID).then(renderUser);
    }

    function deleteUser(event) {
        deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr('id');
        console.log(id);
        userService.deleteUser(id).then(findAllUsers);
    }

    function selectUser() {}
    function updateUser() {
        var updateBtn = $(event.currentTarget);
        userID = updateBtn.attr("value");
        updateBtn.attr('value', "0");

        console.log('Update User');
        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const role = $roleFld.val();
        console.log(username, password, firstName, lastName, role);

        const userNew = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        }

        userService.updateUser(userNew,userID).then(findAllUsers);
    }

    function appendUserToDom(user) {
        const row = userRowTemplate.clone();
        row.removeClass('wbdv-hidden');
        const usernameCol = row.find('.wbdv-username');
        const firstNameCol = row.find('.wbdv-first-name');
        const lastNameCol = row.find('.wbdv-last-name');
        const roleCol = row.find('.wbdv-role');
        const removeBtn = row.find('.removeBtn');
        const editBtn = row.find('.editBtn');

        removeBtn.click(deleteUser);
        editBtn.click(findUserById);
        removeBtn.attr('id', user.id);
        editBtn.attr('id', user.id);

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

    function renderUser(user) {
        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $roleFld.val(user.role);
        const updateBtn = $('#updateBtn');
        updateBtn.attr('value', user.id);
    }


    function renderUsers(users) {
        $("tbody").empty()
        for(i in users) {
            console.log(i);
            appendUserToDom(users[i]);
        }
    }
})();
