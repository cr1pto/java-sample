package com.cr1pto.sample.interfaces;

import java.util.List;

import com.cr1pto.sample.requests.AssociateRequest;
import com.cr1pto.sample.responses.AssociateResponse;
import com.cr1pto.sample.responses.CustomersResponse;
import com.cr1pto.sample.responses.StoreResponse;

public interface CommonService {
    List<AssociateResponse> getAllAssociates();

    AssociateResponse getAssociate(String name);

    AssociateResponse addNewAssociate(AssociateRequest associateRequest);

    List<CustomersResponse> getAllCustomers();

    List<StoreResponse> getAllStores();
}
