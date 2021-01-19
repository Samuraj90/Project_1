package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final String PRODUCT_DESCRIPTION = "a cool product";
    private static final Double PRODUCT_COUNT_255= 255D;
    static final Double PRODUCT_ALARM_20 = 20.5D;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        Product product = new Product();
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setCount(PRODUCT_COUNT_255);
        product.setPrice(BIG_DECIMAL_100);
        product.setActiveAlarm(PRODUCT_ALARM_20);

        //when
        productRepository.save(product);

        //then
        Assert.assertNotNull(product.getId());
        Product newProduct = productRepository.findOne(product.getId());
        Assert.assertEquals((Long) 1L, newProduct.getId());
        Assert.assertEquals(PRODUCT_DESCRIPTION, newProduct.getDescription());
        Assert.assertEquals(BIG_DECIMAL_100.compareTo(newProduct.getPrice()), 0);
        Assert.assertEquals(PRODUCT_COUNT_255, newProduct.getCount());
        Assert.assertEquals(PRODUCT_ALARM_20, newProduct.getActiveAlarm());
    }
}