package com.jr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jr.demprestful.Book;
//继承JpaRepository默认提供的一些基本的数据库操作方法
public interface BookRepository extends JpaRepository<Book,Integer> {

}