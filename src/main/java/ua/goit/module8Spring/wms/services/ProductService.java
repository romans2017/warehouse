package ua.goit.module8Spring.wms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.module8Spring.wms.dto.ProductDto;
import ua.goit.module8Spring.wms.models.Product;
import ua.goit.module8Spring.wms.repositories.ProductRepository;

@Service
public class ProductService extends AbstractModelService<Product, ProductDto> {

    @Autowired
    protected ProductRepository repository;

    @Override
    public boolean isExist(String name) {
        return repository.existsByNameIgnoreCase(name);
    }
}
