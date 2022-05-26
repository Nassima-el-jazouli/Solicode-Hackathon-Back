package org.sid.announcementService.ServiceDao;

import java.util.List;
import java.util.Optional;

import org.sid.announcementService.entities.Product;

public interface ProductServiceDao {
	public Product AddProduct(Product product);
    public List<Product> getAllProducts();
    public Optional<Product> findById(String id);


    void delete(Product product);


    public List<Product> getNotValidateAnnounces();

    public List<Product> getTrueValidateAnnounces();

    Optional<Product> findByTitle(String title);

    public List<Product> getTrueValidateAnnouncesToPublish();

    public List<Product> getTrueValidateAnnouncesPublished();

    public List<Product> getAnnouncesNotPublishedYet();
}
