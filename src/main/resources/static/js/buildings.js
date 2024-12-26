
$(document).ready(function() {
    loadBuildings();

    // Load Buildings
    function loadBuildings() {
        $.ajax({
            url: '/api/buildings',
            method: 'GET',
            success: function(data) {
                $('#buildingTableBody').empty();
                data.forEach(function(building) {
                    $('#buildingTableBody').append(`
                        <tr>
                            <td>${building.id}</td>
                            <td>${building.name}</td>
                            <td>${building.location}</td>
                            <td>${building.details}</td>
                            <td>
                                <button class="btn btn-sm btn-info edit-btn" data-id="${building.id}">Edit</button>
                                <button class="btn btn-sm btn-danger delete-btn" data-id="${building.id}">Delete</button>
                            </td>
                        </tr>
                    `);
                });
            }
        });
    }

    // Add Building
    $('#addBuildingForm').submit(function(e) {
        e.preventDefault();
        const newBuilding = {
            name: $('#addName').val(),
            location: $('#addLocation').val()
        };
        $.ajax({
            url: '/api/buildings',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(newBuilding),
            success: function() {
                $('#addBuildingModal').modal('hide');
                loadBuildings();
                $('#addBuildingForm')[0].reset();
            }
        });
    });

    // Edit Building - Show Modal
    $(document).on('click', '.edit-btn', function() {
        const buildingId = $(this).data('id');
        $.ajax({
            url: `/api/buildings/${buildingId}`,
            method: 'GET',
            success: function(building) {
                $('#editBuildingId').val(building.id);
                $('#editName').val(building.name);
                $('#editLocation').val(building.location);
                $('#editBuildingModal').modal('show');
            }
        });
    });

    // Update Building
    $('#editBuildingForm').submit(function(e) {
        e.preventDefault();
        const buildingId = $('#editBuildingId').val();
        const updatedBuilding = {
            name: $('#editName').val(),
            location: $('#editLocation').val()
        };
        $.ajax({
            url: `/api/buildings/${buildingId}`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(updatedBuilding),
            success: function() {
                $('#editBuildingModal').modal('hide');
                loadBuildings();
            }
        });
    });

    // Delete Building
    $(document).on('click', '.delete-btn', function() {
        const buildingId = $(this).data('id');
        if (confirm('Are you sure you want to delete this building?')) {
            $.ajax({
                url: `/api/buildings/${buildingId}`,
                method: 'DELETE',
                success: function() {
                    loadBuildings();
                }
            });
        }
    });

    // Show Analytics
    $('#analyticsBtn').click(function() {
        $.ajax({
            url: '/api/buildings/analytics',
            method: 'GET',
            success: function(data) {
                $('#analyticsContent').html(`
                    <p>Total Buildings: ${data.totalBuildings}</p>
                    <p>Average Apartments per Building: ${data.averageApartments}</p>
                    <!-- Add more analytics as needed -->
                `);
                $('#analyticsModal').modal('show');
            }
        });
    });
});