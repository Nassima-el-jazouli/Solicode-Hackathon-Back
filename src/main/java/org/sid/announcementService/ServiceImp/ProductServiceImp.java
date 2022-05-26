package org.sid.announcementService.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.sid.announcementService.Repository.ProductRepository;
import org.sid.announcementService.ServiceDao.ProductServiceDao;
import org.sid.announcementService.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductServiceDao {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public Product AddProduct(Product product) {

        return  productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return  productRepository.findAll();
    }

    public Optional<Product> findById(String id) {

        return  productRepository.findById(id);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }


    @Override
    public List<Product> getNotValidateAnnounces() {
        return productRepository.findNotValidateAnnounces();
    }

    @Override
    public List<Product> getTrueValidateAnnounces() {
        return productRepository.findTrueValidateAnnounces();
    }

    @Override
    public Optional<Product> findByTitle(String title) {
        return productRepository.findByHouseTitle(title);
    }

    @Override
    public List<Product> getTrueValidateAnnouncesToPublish() {
        return productRepository.findTrueValidateAnnouncesToPublish();
    }

    @Override
    public List<Product> getTrueValidateAnnouncesPublished() {
        return productRepository.findTrueValidateAnnouncesPublished();
    }

    @Override
    public List<Product> getAnnouncesNotPublishedYet() {
        return  productRepository.findAnnouncesNotPublishedYet();
    }


}
