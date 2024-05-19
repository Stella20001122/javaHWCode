package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Pet;

//PetDao接口，实现pet实体类的CRUD操作
//JpaRepository<T, ID>是jpa提供的接口，接口当中定义了实体的基本操作
//T 指定具体操作的实现类--Pet实体类
//ID 指定主键字段的类型（id注解对应的属性） --Integer

public interface PetDao extends JpaRepository<Pet, Integer>{

	//当提供的方法无法满足业务需要，可以在这里自定义查询
}
