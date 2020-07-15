package com.item.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.exception.ItemNotFound;
import com.item.model.Item;
import com.item.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Item saveOrUpdate(Item item) {
		Item savedItem = itemRepository.save(item);
		return savedItem;
	}

	public Item getItem(Long productCode) {
		Optional<Item> item = itemRepository.findById(productCode);
		if (!item.isPresent()) {
			logger.error("Items Not Found for the productCode {}  ", productCode);
			throw new ItemNotFound("Items Not Found for the productCode : " + productCode);
		}
		return item.get();
	}
	
	public Item updateItem(Item item) {
		Optional<Item> itemByCode = itemRepository.findById(item.getProductCode());
		if(!itemByCode.isPresent() || itemByCode.get().getQuantity()< item.getQuantity()) {
			logger.error("Items are lessthan the avaiable items {}  ", item.getProductCode());
			throw new ItemNotFound("Items are lessthan the avaiable items : " + item.getProductCode());
		}
		
		item.setQuantity(itemByCode.get().getQuantity()- item.getQuantity());
		return itemRepository.save(item);
	}

}
