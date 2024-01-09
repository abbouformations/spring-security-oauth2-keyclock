package ma.formations.service;

import lombok.AllArgsConstructor;
import ma.formations.dao.CustomerRepository;
import ma.formations.dtos.CustomerDto;
import ma.formations.service.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class ServiceImpl implements IService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Override
    public void save(CustomerDto dto) {
        customerRepository.save(modelMapper.map(dto, Customer.class));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().
                map(bo -> modelMapper.map(bo, CustomerDto.class)).toList();
    }
}
