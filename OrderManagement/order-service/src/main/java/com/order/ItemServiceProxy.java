package com.order;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.model.Item;

@FeignClient(name="item-service", url="localhost:8201")
public interface ItemServiceProxy {
	
	@PostMapping("item/save")
	public @ResponseBody Item saveOrUpdateItem(@Valid @RequestBody Item item);
	
	@GetMapping("item/{productCode}")
	public @ResponseBody Item getItem(@PathVariable Long productCode);
	
	@PostMapping("item/update")
	public @ResponseBody Item updateItem(@RequestBody Item iteme);



}
