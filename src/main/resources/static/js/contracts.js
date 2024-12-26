
$(document).ready(function() {
    loadContracts();
    loadCustomers('#addCustomer');
    loadCustomers('#editCustomer');

    // Load Contracts
    function loadContracts() {
        $.ajax({
            url: '/api/contracts',
            method: 'GET',
            success: function(data) {
                $('#contractTableBody').empty();
                data.forEach(function(contract) {
                    $('#contractTableBody').append(`
                        <tr>
                            <td>${contract.id}</td>
                            <td>${contract.contractNumber}</td>
                            <td>${contract.customerName}</td>
                            <td>${contract.details}</td>
                            <td>
                                <button class="btn btn-sm btn-info edit-btn" data-id="${contract.id}">Edit</button>
                                <button class="btn btn-sm btn-danger delete-btn" data-id="${contract.id}">Delete</button>
                            </td>
                        </tr>
                    `);
                });
            }
        });
    }

    // Load Customers for Dropdown
    function loadCustomers(selector) {
        $.ajax({
            url: '/api/customers',
            method: 'GET',
            success: function(data) {
                const dropdown = $(selector);
                dropdown.empty();
                data.forEach(function(customer) {
                    dropdown.append(`<option value="${customer.id}">${customer.name}</option>`);
                });
            }
        });
    }

    // Add Contract
    $('#addContractForm').submit(function(e) {
        e.preventDefault();
        const newContract = {
            contractNumber: $('#addContractNumber').val(),
            customerId: $('#addCustomer').val(),
            details: $('#addDetails').val()
        };
        $.ajax({
            url: '/api/contracts',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(newContract),
            success: function() {
                $('#addContractModal').modal('hide');
                loadContracts();
                $('#addContractForm')[0].reset();
            }
        });
    });

    // Edit Contract - Show Modal
    $(document).on('click', '.edit-btn', function() {
        const contractId = $(this).data('id');
        $.ajax({
            url: `/api/contracts/${contractId}`,
            method: 'GET',
            success: function(contract) {
                $('#editContractId').val(contract.id);
                $('#editContractNumber').val(contract.contractNumber);
                $('#editDetails').val(contract.details);
                $('#editCustomer').val(contract.customerId);
                $('#editContractModal').modal('show');
            }
        });
    });

    // Update Contract
    $('#editContractForm').submit(function(e) {
        e.preventDefault();
        const contractId = $('#editContractId').val();
        const updatedContract = {
            contractNumber: $('#editContractNumber').val(),
            customerId: $('#editCustomer').val(),
            details: $('#editDetails').val()
        };
        $.ajax({
            url: `/api/contracts/${contractId}`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(updatedContract),
            success: function() {
                $('#editContractModal').modal('hide');
                loadContracts();
            }
        });
    });

    // Delete Contract
    $(document).on('click', '.delete-btn', function() {
        const contractId = $(this).data('id');
        if (confirm('Are you sure you want to delete this contract?')) {
            $.ajax({
                url: `/api/contracts/${contractId}`,
                method: 'DELETE',
                success: function() {
                    loadContracts();
                }
            });
        }
    });
});