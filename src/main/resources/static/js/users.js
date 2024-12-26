
$(document).ready(function() {
    loadUsers();

    // Load Users
    function loadUsers() {
        $.ajax({
            url: '/api/users',
            method: 'GET',
            success: function(data) {
                $('#userTableBody').empty();
                data.forEach(function(user) {
                    $('#userTableBody').append(`
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>
                                <button class="btn btn-sm btn-info edit-btn" data-id="${user.id}">Edit</button>
                                <button class="btn btn-sm btn-danger delete-btn" data-id="${user.id}">Delete</button>
                            </td>
                        </tr>
                    `);
                });
            }
        });
    }

    // Add User
    $('#addUserForm').submit(function(e) {
        e.preventDefault();
        const newUser = {
            username: $('#addUsername').val(),
            email: $('#addEmail').val()
        };
        $.ajax({
            url: '/api/users',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(newUser),
            success: function() {
                $('#addUserModal').modal('hide');
                loadUsers();
                $('#addUserForm')[0].reset();
            }
        });
    });

    // Edit User - Show Modal
    $(document).on('click', '.edit-btn', function() {
        const userId = $(this).data('id');
        $.ajax({
            url: `/api/users/${userId}`,
            method: 'GET',
            success: function(user) {
                $('#editUserId').val(user.id);
                $('#editUsername').val(user.username);
                $('#editEmail').val(user.email);
                $('#editUserModal').modal('show');
            }
        });
    });

    // Update User
    $('#editUserForm').submit(function(e) {
        e.preventDefault();
        const userId = $('#editUserId').val();
        const updatedUser = {
            username: $('#editUsername').val(),
            email: $('#editEmail').val()
        };
        $.ajax({
            url: `/api/users/${userId}`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(updatedUser),
            success: function() {
                $('#editUserModal').modal('hide');
                loadUsers();
            }
        });
    });

    // Delete User
    $(document).on('click', '.delete-btn', function() {
        const userId = $(this).data('id');
        if (confirm('Are you sure you want to delete this user?')) {
            $.ajax({
                url: `/api/users/${userId}`,
                method: 'DELETE',
                success: function() {
                    loadUsers();
                }
            });
        }
    });
});