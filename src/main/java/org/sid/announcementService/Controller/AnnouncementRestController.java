package org.sid.announcementService.Controller;

import org.sid.announcementService.Repository.ProductRepository;
import org.sid.announcementService.ServiceImp.ProductServiceImp;
import org.sid.announcementService.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Announce")
public class AnnouncementRestController {

@Autowired
public ProductServiceImp productServiceImp;

    @Autowired
    public ProductRepository productRepository;



    @GetMapping(path="/hello")
    public String hello() throws Exception {
        return "salam";
    }


    @PostMapping(path = "/AddAnnounce")
    public  void AddAnnounce(@RequestBody Product product){

        productServiceImp.AddProduct(product);

    }

    @GetMapping("/Announce")
    public List<Product> getAllAnnounces() {
        return (List<Product>) productServiceImp.getAllProducts();
    }

    @GetMapping("/AnnouncesTrueValidate")
    public List<Product> getTrueValidateAnnounces() {
        return (List<Product>) productServiceImp.getTrueValidateAnnounces();
    }

    @GetMapping("/AnnouncesTrueValidateToPublish")
    public List<Product> getTrueValidateAnnouncesToPublish() {
        return (List<Product>) productServiceImp.getTrueValidateAnnouncesToPublish();
    }

    @GetMapping("/AnnouncesTrueValidatePublished")
    public List<Product> getTrueValidateAnnouncesPublished() {
        return (List<Product>) productServiceImp.getTrueValidateAnnouncesPublished();
    }

    @GetMapping("/AnnouncesNotPublishedYet")
    public List<Product> getAnnouncesNotPublishedYet() {
        return (List<Product>) productServiceImp.getAnnouncesNotPublishedYet();
    }

    @GetMapping("/AnnouncesNotValidate")
    public List<Product> getNotValidateAnnounces() {
        return (List<Product>) productServiceImp.getNotValidateAnnounces();
    }


    @GetMapping("/Announce/{id}")
    public ResponseEntity< Product > getProductById(@PathVariable(value = "id") String AnnounceId)
            throws ResourceNotFoundException {
        Product product = productServiceImp.findById(AnnounceId)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + AnnounceId));
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/Announce/{id}")
    public ResponseEntity < Product > updateAnnounce(@PathVariable(value = "id") String AnnounceId,
                                                   @Valid @RequestBody Product ProductDetails)
                                                    throws ResourceNotFoundException {
        Product product = productServiceImp.findById(AnnounceId)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + AnnounceId));

        product.setCategory(ProductDetails.getCategory());
        product.setQuantity(ProductDetails.getQuantity());
        product.setImage(ProductDetails.getImage());
        product.setAddress(ProductDetails.getAddress());
        product.setNumTel(ProductDetails.getCategory());
        final Product updatedAnnounce = productServiceImp.AddProduct(product);
        return ResponseEntity.ok(updatedAnnounce);

    }

    @DeleteMapping("/Announce/{id}")
    public Map< String, Boolean > deleteCategory(@PathVariable(value = "id") String categoryId)
            throws ResourceNotFoundException {
        Product category = productServiceImp.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        productServiceImp.delete(category);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

   @PutMapping("/validate/{title}")
    public ResponseEntity < Product > validateAnnounce(@PathVariable(value = "title") String ProductTitle)
            throws ResourceNotFoundException {

       Product product = productServiceImp.findByTitle(ProductTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + ProductTitle));

       product.setValidation(true);
       product.setValidate(true);

        final Product validatedAnnounce = productServiceImp.AddProduct(product);
        return ResponseEntity.ok(validatedAnnounce);

    }

    @PutMapping("/rejectAnnounce/{title}")
    public ResponseEntity < Product > rejectAnnounce(@PathVariable(value = "title") String ProductTitle)
            throws ResourceNotFoundException {
        

    	Product product = productServiceImp.findByTitle(ProductTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + ProductTitle));

    	product.setValidation(false);
    	product.setValidate(true);
    	product.setRejected(true);

        final Product validatedAnnounce = productServiceImp.AddProduct(product);
        return ResponseEntity.ok(validatedAnnounce);

    }

    @PutMapping("/AddToPublication/{title}")
    public ResponseEntity < Product > AddToPublication(@PathVariable(value = "title") String ProductTitle)
            throws ResourceNotFoundException {
        
    	Product product = productServiceImp.findByTitle(ProductTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + ProductTitle));

        product.setToPublish(true);

        final Product validatedAnnounce = productServiceImp.AddProduct(product);
        return ResponseEntity.ok(validatedAnnounce);

    }

    @PutMapping("/RemoveFromPublication/{title}")
    public ResponseEntity < Product > RemoveFromPublication(@PathVariable(value = "title") String ProductTitle)
            throws ResourceNotFoundException {
      
    	Product product = productServiceImp.findByTitle(ProductTitle)
                .orElseThrow(() -> new ResourceNotFoundException("Announce not found for this id :: " + ProductTitle));

        product.setToPublish(false);

        final Product validatedAnnounce = productServiceImp.AddProduct(product);
        return ResponseEntity.ok(validatedAnnounce);

    }


}