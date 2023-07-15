package in.ind.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class ProductEntity {
	
	@Id
	@GeneratedValue
	private Integer pid;
	
	@NotBlank(message= "Name is manadatory")
	@Size(min = 3, max = 15, message = "Name should be 3-15 character")
	private String name;
	
	@NotNull(message="Price is manadatory")
	@Positive(message= "Price should be positive number")
	private Double price ;
	
	@NotNull(message="Quantity is manadatory")
	@Positive(message= "Quantity should be positive number")
	private Integer quantity;

}
