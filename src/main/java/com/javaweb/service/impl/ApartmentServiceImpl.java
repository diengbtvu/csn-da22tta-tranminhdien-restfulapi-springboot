import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    // ...existing code...

    @Override
    public List<ApartmentDTO> searchApartments(String name, Integer numberOfBedrooms, String status) {
        List<ApartmentEntity> apartments = apartmentRepository.findAll();
        return apartments.stream()
                .filter(apartment -> (name == null || apartment.getName().contains(name)) &&
                        (numberOfBedrooms == null || apartment.getNumberOfBedrooms().equals(numberOfBedrooms)) &&
                        (status == null || (status.equals("Còn trống") && !apartment.isRented()) || (status.equals("Đã thuê") && apartment.isRented())))
                .map(apartment -> modelMapper.map(apartment, ApartmentDTO.class))
                .collect(Collectors.toList());
    }

    // ...existing code...
}
