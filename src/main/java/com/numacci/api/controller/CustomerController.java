package com.numacci.api.controller;

import com.numacci.api.dto.Customer;
import com.numacci.api.service.CustomerService;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers") //クラスレベルで定義しているので、このクラスで定義したエンドポイントは全て/customersスタートになる
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer post(@Validated @RequestBody Customer customer, Errors errors) {
        // If the fields of requested customer object are invalid,
        // throw Runtime Exception with validation errors.
        //@Validation: HTTPリクエストのBodyで連携されたCustomerオブジェクトが、
        // Customerクラスで定義した各フィールドの制約に違反していないかをチェックする
        if (errors.hasErrors()) { //今回だと、フィールドのいずれかがnullチェックに違反しているとエラーがerrorsに格納される
            throw new RuntimeException((Throwable) errors);
        }
        // NOTE: You can also validate whether insertion succeeded or not here.
        return customerService.register(customer);
    }

    @GetMapping
    public List<Customer> get() {
        return customerService.retrieve();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable String id) {
        return customerService.retrieve(id);
    }

    @PatchMapping
    public Customer patch(@Validated @RequestBody Customer customer, Errors errors) {

        if (errors.hasErrors()) {
            throw new RuntimeException((Throwable) errors);
        }
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return customerService.delete(id);
    }
}
