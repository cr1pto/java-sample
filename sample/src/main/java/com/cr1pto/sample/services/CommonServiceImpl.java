package com.cr1pto.sample.services;

import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.cr1pto.sample.entities.Associate;
import com.cr1pto.sample.interfaces.CommonService;
import com.cr1pto.sample.repositories.AssociateRepository;
import com.cr1pto.sample.repositories.CustomerRepository;
import com.cr1pto.sample.repositories.DepartmentRepository;
import com.cr1pto.sample.repositories.ManagerRepository;
import com.cr1pto.sample.repositories.ProductRepository;
import com.cr1pto.sample.repositories.StoreRepository;
import com.cr1pto.sample.requests.AssociateRequest;
import com.cr1pto.sample.responses.AssociateResponse;
import com.cr1pto.sample.responses.CustomersResponse;
import com.cr1pto.sample.responses.StoreResponse;

@Service
public class CommonServiceImpl implements CommonService {

    private AssociateRepository associateRepository;
    private ManagerRepository managerRepository;
    private CustomerRepository customerRepository;
    private DepartmentRepository departmentRepository;
    private ProductRepository productRepository;
    private StoreRepository storeRepository;

    public CommonServiceImpl(AssociateRepository associateRepository, ManagerRepository managerRepository,
            CustomerRepository customerRepository, DepartmentRepository departmentRepository,
            ProductRepository productRepository, StoreRepository storeRepository) {
        super();
        this.associateRepository = associateRepository;
        this.managerRepository = managerRepository;
        this.customerRepository = customerRepository;
        this.departmentRepository = departmentRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public List<AssociateResponse> getAllAssociates() {

        var associatesEntities = this.associateRepository.findAll();

        var associates = Streamable.of(associatesEntities)
                .toList()
                .stream()
                .map(item -> {
                    var response = new AssociateResponse();
                    response.setFirstName(item.getFirstName());
                    response.setMiddleName(item.getMiddleName());
                    response.setLastName(item.getLastName());
                    return response;
                }).toList();

        return associates;
    }

    @Override
    public List<CustomersResponse> getAllCustomers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCustomers'");
    }

    @Override
    public List<StoreResponse> getAllStores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllStores'");
    }

    @Override
    public AssociateResponse addNewAssociate(AssociateRequest associateRequest) {
        var newAssociateEntity = new Associate();

        newAssociateEntity.setFirstName(associateRequest.getFirstName());
        newAssociateEntity.setMiddleName(associateRequest.getMiddleName());
        newAssociateEntity.setLastName(associateRequest.getLastName());
        newAssociateEntity.setBirthDate(associateRequest.getBirthDate());

        this.associateRepository.save(newAssociateEntity);

        var response = new AssociateResponse();

        response.setFirstName(newAssociateEntity.getFirstName());
        response.setMiddleName(newAssociateEntity.getMiddleName());
        response.setLastName(newAssociateEntity.getLastName());

        return response;
    }

    @Override
    public AssociateResponse getAssociate(String lastName) {

        var entity = this.associateRepository.findByLastName(lastName);
        var response = new AssociateResponse();

        response.setFirstName(entity.getFirstName());
        response.setMiddleName(entity.getMiddleName());
        response.setLastName(entity.getLastName());

        return response;
    }
}
