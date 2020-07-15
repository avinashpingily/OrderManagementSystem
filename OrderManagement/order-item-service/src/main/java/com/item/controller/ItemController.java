package com.item.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.item.model.Item;
import com.item.service.ItemService;

@RestController
public class ItemController {

	
	@Autowired
	ItemService itemService;

	@PostMapping("/item/save")
	public @ResponseBody Item saveOrUpdateItem(@Valid @RequestBody Item item) {
		Item savedItem = itemService.saveOrUpdate(item);
		return savedItem;
	}

	@GetMapping("/item/{productCode}")
	public @ResponseBody Item getItem(@PathVariable Long productCode) {
		return itemService.getItem(productCode);
	}
	
	@PostMapping("/item/update")
	public @ResponseBody Item updateItem(@RequestBody Item iteme) {
		return itemService.updateItem(iteme);
	}
	
}
