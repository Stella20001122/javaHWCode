package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.example.demo.dao.PetDao;
import com.example.demo.domain.Pet;

@SpringBootTest
class DemoApplicationTests {
	//用来单元测试
	@Test
	void contextLoads() {
		System.out.println("table创建成功");
	}
	//对jpa的接口方法进行测试
	/*添加宠物信息*/
	@Autowired
	PetDao petDao;
	//springboot在启动的时候，底层使用动态代理的方式获得接口的实现类
	
//	@Test
//	void addpets() {
//		System.out.println("添加pet");
//		Pet pet=new Pet();
//		//id自增，不需要手动设置
//		pet.setPname("猫咪");
//		pet.setColor("白色");
//		
//		petDao.save(pet);//添加操作
//		/*save:
//		 *如果没指定id，则自增添加
//		 *如果指定了id，先去查询有没有这个id的记录
//		 *有则更新，没有则添加
//		 **/
//	}
	
	//查询--根据id查询
//	@Test
//	void findpets() {
//		//findById是jpa接口中该定义的，查询的内容封装到了Optional对象中
//		//再根据get()方法得到了pet对象
//		Optional<Pet>optional =petDao.findById(1);
//		Pet pet =optional.get();
//		System.out.println(pet.getId()+""+pet.getPname()+""+pet.getColor());
//	}
	
	//查询--所有
	@Test
	void findAllpets() {
		//List<T> findAll();返回一个list
		List<Pet> pets=petDao.findAll();
		for(Pet pet:pets) {
			System.out.println(pet.getId()+""+pet.getPname()+""+pet.getColor());
		}
		
		//findAll里可以用sort进行排序查询
//		List<Pet> pcolor = petDao.findAll(Sort.by("color"));
//		for(Pet pet:pcolor) {
//			System.out.println(pet.getPname());
//		}
	}	
	
	//删除
	@Test
	void delePet() {
		/*delete(T)：传递一个对象，删除这个对象
		 *deleteById:按传入的id删除对象
		 */
//		Pet pet=new Pet();
//		pet.setId(1);
//		petDao.delete(pet);
		
		petDao.deleteById(2);
	}
	
}
