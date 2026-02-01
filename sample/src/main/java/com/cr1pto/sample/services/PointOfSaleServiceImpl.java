package com.cr1pto.sample.services;

import org.springframework.stereotype.Service;

import com.cr1pto.sample.interfaces.PointOfSaleService;
import com.cr1pto.sample.repositories.AssociateRepository;
import com.cr1pto.sample.repositories.DepartmentRepository;
import com.cr1pto.sample.repositories.ProductRepository;
import com.cr1pto.sample.repositories.StoreRepository;

@Service
public class PointOfSaleServiceImpl implements PointOfSaleService {
    private AssociateRepository associateRepository;
    private DepartmentRepository deparmentRepository;
    private ProductRepository productRepository;
    private StoreRepository storeRepository;

    public PointOfSaleServiceImpl(AssociateRepository associateRepository, DepartmentRepository deparmentRepository,
            ProductRepository productRepository, StoreRepository storeRepository) {
        super();
        this.associateRepository = associateRepository;
        this.deparmentRepository = deparmentRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }
}
