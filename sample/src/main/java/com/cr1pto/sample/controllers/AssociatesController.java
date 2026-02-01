package com.cr1pto.sample.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cr1pto.sample.interfaces.CommonService;
import com.cr1pto.sample.requests.AssociateRequest;
import com.cr1pto.sample.responses.AssociateResponse;

@RestController
public class AssociatesController {

    private CommonService commonService;

    public AssociatesController(CommonService commonService) {
        super();
        this.commonService = commonService;
    }

    @GetMapping("associates")
    @ResponseBody
    public ResponseEntity<List<AssociateResponse>> getAssociates() {

        var response = this.commonService.getAllAssociates();

        return ResponseEntity.ok(response);
    }

    @GetMapping("associates/{lastName}")
    @ResponseBody
    public ResponseEntity<List<AssociateResponse>> getAssociate(@PathVariable String lastName) {

        var response = this.commonService.getAllAssociates();

        return ResponseEntity.ok(response);
    }

    @PostMapping("associates")
    @ResponseBody
    public ResponseEntity<AssociateResponse> createNewAssociate(@RequestBody AssociateRequest request) {

        var response = this.commonService.addNewAssociate(request);

        return ResponseEntity.created(URI.create("")).body(response);
    }
}