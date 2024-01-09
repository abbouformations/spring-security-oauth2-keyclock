package ma.formations.service;

import ma.formations.dtos.CustomerDto;

import java.util.List;

public interface IService {
    void save(CustomerDto dto);

    List<CustomerDto> getAllCustomers();
}
