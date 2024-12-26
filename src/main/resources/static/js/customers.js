
$(document).ready(function() {
    loadCustomers();

    // Load Customers
    function loadCustomers() {
        $.ajax({
            url: '/api/customers',
            method: 'GET',
            success: function(data) {
                $('#customerTableBody').empty();
                data.forEach(function(customer) {
                    $('#customerTableBody').append(`
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.name}</td>
                            <td>${customer.email}</td>
                            <td>${customer.phone}</td>
                            <td>
                                <button class="btn btn-sm btn-info edit-btn" data-id="${customer.id}">Edit</button>
                                <button class="btn btn-sm btn-danger delete-btn" data-id="${customer.id}">Delete</button>
                            </td>
                        </tr>
                    `);
                });
            }
        });
    }

    // Add Customer
    $('#addCustomerForm').submit(function(e) {
        e.preventDefault();
        const newCustomer = {
            name: $('#addName').val(),
            email: $('#addEmail').val(),
            phone: $('#addPhone').val()
        };
        $.ajax({
            url: '/api/customers',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(newCustomer),
            success: function() {
                $('#addCustomerModal').modal('hide');
                loadCustomers();
                $('#addCustomerForm')[0].reset();
            }
        });
    });

    // Edit Customer - Show Modal
    $(document).on('click', '.edit-btn', function() {
        const customerId = $(this).data('id');
        $.ajax({
            url: `/api/customers/${customerId}`,
            method: 'GET',
            success: function(customer) {
                $('#editCustomerId').val(customer.id);
                $('#editName').val(customer.name);
                $('#editEmail').val(customer.email);
                $('#editPhone').val(customer.phone);
                $('#editCustomerModal').modal('show');
            }
        });
    });

    // Update Customer
    $('#editCustomerForm').submit(function(e) {
        e.preventDefault();
        const customerId = $('#editCustomerId').val();
        const updatedCustomer = {
            name: $('#editName').val(),
            email: $('#editEmail').val(),
            phone: $('#editPhone').val()
        };
        $.ajax({
            url: `/api/customers/${customerId}`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(updatedCustomer),
            success: function() {
                $('#editCustomerModal').modal('hide');
                loadCustomers();
            }
        });
    });

    // Delete Customer
    $(document).on('click', '.delete-btn', function() {
        const customerId = $(this).data('id');
        if (confirm('Are you sure you want to delete this customer?')) {
            $.ajax({
                url: `/api/customers/${customerId}`,
                method: 'DELETE',
                success: function() {
                    loadCustomers();
                }
            });
        }
    });
});