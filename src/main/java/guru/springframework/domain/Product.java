package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;
    private double count;
    private BigDecimal price;
    private double activeAlarm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCount() {return count; }

    public void setCount(double count) { this.count = count; }

    public double getActiveAlarm() { return activeAlarm; }

    public void setActiveAlarm(double activeAlarm) {this.activeAlarm = activeAlarm; }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
