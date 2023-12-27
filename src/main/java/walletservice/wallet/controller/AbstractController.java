package walletservice.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import walletservice.wallet.convertor.AbstractConvertor;
import walletservice.wallet.service.AbstractService;
@RequestMapping("/")
public abstract class AbstractController<D,E,S extends AbstractService<E,?>> {

    @Autowired
    protected AbstractConvertor<D,E> adapter;

    @Autowired
    protected S service;

}
