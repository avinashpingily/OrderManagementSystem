package com.item.repository;

import org.springframework.data.repository.CrudRepository;

import com.item.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
