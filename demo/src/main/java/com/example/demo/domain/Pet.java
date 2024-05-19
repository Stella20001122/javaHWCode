package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Pet实体类，对应底层数据库表，一开始mysql数据库中没有t_pet表
//可以使用jpa的正向工程，生成底层对应的关系表

//@Entity注解：表明当前是实体类，和底层名为t_pet的关系表进行映射

@Entity(name="t_pet")
public class Pet {
	@Id //表明是个主键字段（唯一值）
	//指定当前主键的生成策略：自增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column //标识pname是个普通列，其他属性不设置就是默认值
	private String pname;
	
	@Column 
	private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
