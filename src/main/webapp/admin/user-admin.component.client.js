(function () {
    const $createBtn = $('#createBtn');
    const $usernameFld = $('#usernameFld');
    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const $lastNameFld = $('#lastNameFld');
    const $roleFld = $('#roleFld');
    const userRowTemplate = $('.wbdv-template');
    const tbody = $('tbody');
    const $searchBtn = $('.searchBtn');
    const $updateBtn = $('.updateBtn');
    const $createBtn = $('.createBtn');
    const $removeBtn = $('.removeBtn');
    const $editBtn = $('.editBtn');
    const findAllUsersUrl = 'http://localhost:8080/users';
    const deleteUserUrl = 'http://localhost:8080/users/USER_ID';
    const userService = new AdminUserServiceClient();

    $.ajax(findAllUsersUrl, {
        'success': handleUsers
    })

    $(main);

    function main() {
        $createBtn.click(createUser);
        $removeBtn.click(deleteUser);
    }

    function createUser() { … }
    function findAllUsers() { … }
    function findUserById() { … }
    function deleteUser() { … }
    function selectUser() { … }
    function updateUser() { … }
    function renderUser(user) { … }
    function renderUsers(users) { … }
})();
