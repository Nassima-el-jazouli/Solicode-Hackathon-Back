package org.sid.announcementService.Repository;

import java.util.List;
import java.util.Optional;

import org.sid.announcementService.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository  extends MongoRepository<Product, String> {
	
	List<Product> findAllById(String id);

    @Query("{ 'IsValidate' : false }")
    List<Product> findNotValidateAnnounces();

    @Query("{ 'validation' : true }")
    List<Product> findTrueValidateAnnounces();

    @Query("{ 'title' : ?0 }")
    Optional<Product> findByHouseTitle(String houseTitle);

    @Query("{ 'validation' : true,'toPublish':false }")
    List<Product> findTrueValidateAnnouncesToPublish();

    @Query("{ 'validation' : true,'toPublish':true }")
    List<Product> findTrueValidateAnnouncesPublished();

    @Query("{ 'toPublish':false }")
    List<Product> findAnnouncesNotPublishedYet();
}
