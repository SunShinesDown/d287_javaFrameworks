package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //5 parts sample
       if (partRepository.count() == 0) {
           //part 1
           OutsourcedPart o = new OutsourcedPart();
           o.setCompanyName("SwitchPro inc.");
           o.setName("touch switch");
           o.setInv(50);
           o.setPrice(20.0);
           o.setMaxInv(70);
           o.setMinInv(1);
           o.setId(100L);
           outsourcedPartRepository.save(o);
           //part 2
           OutsourcedPart o1 = new OutsourcedPart();
           o1.setCompanyName("SwitchPro inc.");
           o1.setName("paddle switch");
           o1.setInv(60);
           o1.setPrice(20.0);
           o1.setMaxInv(80);  
           o1.setMinInv(0);   
           o1.setId(101L);
           outsourcedPartRepository.save(o1);
           //part 3
           OutsourcedPart o2 = new OutsourcedPart();
           o2.setCompanyName("Standz inc.");
           o2.setName("dark wooden stand");
           o2.setInv(45);
           o2.setPrice(20.0);
           o2.setMaxInv(60);
           o2.setMinInv(3);
           o2.setId(102L);
           partRepository.save(o2);
           //part 4
           OutsourcedPart o3 = new OutsourcedPart();
           o3.setCompanyName("Standz inc.");
           o3.setName("metal stand");
           o3.setInv(30);
           o3.setPrice(20.0);
           o3.setMaxInv(100);
           o3.setMinInv(10);
           o3.setId(103L);
           outsourcedPartRepository.save(o3);
           //part 5
           OutsourcedPart o4 = new OutsourcedPart();
           o4.setCompanyName("Shady's Shades");
           o4.setName("paper globe shade");
           o4.setInv(40);
           o4.setPrice(20.0);
           o4.setMaxInv(70);
           o4.setMinInv(2);
           o4.setId(104L);
           outsourcedPartRepository.save(o4);
       }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
        //5 products sample
        if (productRepository.count() == 0) {
            Product lamp1 = new Product("touch floor lamp", 130.0, 20);
            Product lamp2 = new Product("wooden floor lamp", 135.0, 30);
            Product lamp3 = new Product("metal floor lamp", 100.0, 25);
            Product lamp4 = new Product("shadeless floor lamp", 90.0, 50);
            Product lamp5 = new Product("tripod wooden floor lamp", 125.0, 40);
            productRepository.save(lamp1);
            productRepository.save(lamp2);
            productRepository.save(lamp3);
            productRepository.save(lamp4);
            productRepository.save(lamp5);
        }
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
