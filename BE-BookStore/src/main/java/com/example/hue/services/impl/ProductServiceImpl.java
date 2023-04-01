package com.example.hue.services.impl;

import com.example.hue.common.converter.ProductConverter;
import com.example.hue.common.exception.ResourceNotFoundException;
import com.example.hue.models.dto.ProductDTO;
import com.example.hue.models.entity.Product;
import com.example.hue.models.entity.ProductCategory;
import com.example.hue.repositories.ProductRepository;
import com.example.hue.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findByActiveTrue();

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        for (Product product : products) {
            productDTOs.add(productConverter.toDTO(product));
        }

        return productDTOs;
    }

    @Override
    public ProductDTO getById(Long id) {

        return productConverter.toDTO(productRepository.findByIdAndActiveTrue(id));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productConverter.toEntity(productDTO);

        product = productRepository.save(product);

        productDTO.setId(product.getId());

        return productDTO;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Long id) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));

        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setUnitPrice(productDTO.getUnitPrice());
        existingProduct.setUnitInStock(productDTO.getUnitInStock());
        existingProduct.setActive(productDTO.getActive());
        existingProduct.setImageUrl(productDTO.getImageUrl());
        existingProduct.setCategory(
                new ProductCategory(productDTO.getCategory().getId(), productDTO.getCategory().getCategoryName(), productDTO.getCategory().getDescription()));

        Product product = productRepository.save(existingProduct);

        productDTO.setId(product.getId());

        return productDTO;

    }

    @Override
    public void delete(Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
        existingProduct.setActive(false);
        productRepository.save(existingProduct);
    }

    @Override
    public Page<ProductDTO> getAllPaginate(Integer page, Integer size) {

        Pageable paging = PageRequest.of(page, size);

        Page<Product> productsPage = productRepository.findByActiveTrue(paging);

        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);

        return productsDtoPage;
    }

    @Override
    public Page<ProductDTO> getByName(String name, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);

        Page<Product> productsPage = productRepository.findByNameContainingAndActiveTrue(name, paging);

        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);

        return productsDtoPage;
    }

    @Override
    public Page<ProductDTO> getByCategory(Long id, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);

        Page<Product> productsPage = productRepository.findByCategoryIdAndActiveTrue(id, paging);

        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);

        return productsDtoPage;
    }

    @Override
    public Page<ProductDTO> findByNameAndCategory(Long id, String name, Integer page, Integer size) {

        Pageable paging = PageRequest.of(page, size);

        Page<Product> productsPage = productRepository.findByCategoryIdAndNameContainingAndActiveTrue(id, name, paging);

        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);

        return productsDtoPage;
    }

    @Override
    public Page<ProductDTO> getNewProduct(Integer page, Integer size) {

        Pageable paging = PageRequest.of(page, size, Sort.by("id").descending());

        Page<Product> productsPage = productRepository.findByActiveTrue(paging);

        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);

        return productsDtoPage;

    }

    @Override
    public Page<ProductDTO> getByPriceDesc(Integer page, Integer size) {

        Pageable paging = PageRequest.of(page, size, Sort.by("unitPrice").descending());

        Page<Product> productsPage = productRepository.findByActiveTrue(paging);

        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);

        return productsDtoPage;
    }

    @Override
    public Page<ProductDTO> getByPriceAsc(Integer page, Integer size) {

        Pageable paging = PageRequest.of(page, size, Sort.by("unitPrice").ascending());

        Page<Product> productsPage = productRepository.findByActiveTrue(paging);

        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);

        return productsDtoPage;
    }

    @Override
    public List<ProductDTO> getByCategoryid(Long id) {

        List<Product> products = productRepository.findByCategoryIdAndActiveTrue(id);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

        for (Product product : products) {
            productDTOs.add(productConverter.toDTO(product));
        }

        return productDTOs;

    }

}
