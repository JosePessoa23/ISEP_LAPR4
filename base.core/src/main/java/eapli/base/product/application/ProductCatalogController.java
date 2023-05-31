package eapli.base.product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Product;
import eapli.base.product.persistance.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogController {

    /**
     * The product repository
     */
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    /**
     * Return the Catalog without filters
     * @param orderMeth the sorting method
     * @return the catalog
     */
    public List<Product> getCatalogNoFilter(int orderMeth){
        List<Product> catalog = new ArrayList<>();
        switch (orderMeth){
            case 1:
                catalog = (List<Product>) productRepository.getCatalogNoFilter("SELECT d FROM Product d WHERE d.availability = true ORDER BY d.code.code");
                break;
            case 2:
                catalog = (List<Product>) productRepository.getCatalogNoFilter("SELECT d FROM Product d WHERE d.availability = true ORDER BY d.priceWithTaxes.price");
                break;
            case 3:
                catalog = (List<Product>) productRepository.getCatalogNoFilter("SELECT d FROM Product d WHERE d.availability = true ORDER BY d.brand.brand");
                break;
            case 4:
                catalog = (List<Product>) productRepository.getCatalogNoFilter("SELECT d FROM Product d WHERE d.availability = true ORDER BY d.category.CategoryCode.categoryCode");
                break;
            default:
                break;
        }
        return catalog;
    }

    /**
     * Return the catalog with filters
     * @param filters the filters
     * @param sort the sorting method
     * @return the catalog
     */
    public List<Product> getCatalogFilter(String[] filters, int sort) {
        List<Product> catalog = new ArrayList<>();
        boolean first = true;
        String query = "SELECT d FROM Product d ";
        if(filters[0] != null){
            query+= String.format("WHERE d.category.CategoryCode.categoryCode = '%s' ", filters[0]);
            first = false;
        }
        if(filters[1] != null){
            if(first){
                query+= "WHERE d.extendedDescription.extendedDescription LIKE '%" +filters[1] + "%' ";
                first = false;
            }else{
                query+= String.format("AND d.extendedDescription.extendedDescription LIKE '%s%s%s' ","%", filters[1],"%");
            }
        }
        if(filters[2] != null){
            if(first){
                query+= String.format("WHERE d.brand.brand = '%s' ", filters[2]);
            }else{
                query+= String.format("AND d.brand.brand = '%s' ", filters[2]);
            }
        }
        switch (sort) {
            case 1:
                query += "AND d.availability = true ORDER BY d.code.code";
                break;
            case 2:
                query += "AND d.availability = true ORDER BY d.priceWithTaxes.price";
                break;
            case 3:
                query += "AND d.availability = true ORDER BY d.brand.brand";
                break;
            case 4:
                query += "AND d.availability = true ORDER BY d.category.CategoryCode.categoryCode";
                break;
        }
        return (List<Product>) productRepository.getCatalogNoFilter(query);
    }
}
