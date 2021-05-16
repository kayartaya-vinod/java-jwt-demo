package co.vinod.demo.entity;

import lombok.Data;

@Data
public class Product {
	private Integer id;
	private String name;
	private String brand;
	private String category;
	private String description;
	private String quantityPerUnit;
	private String picture;
	private Double unitPrice;
	private Double discount;
}
