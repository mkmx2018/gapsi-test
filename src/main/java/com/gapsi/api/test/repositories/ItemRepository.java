
package com.gapsi.api.test.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gapsi.api.test.entities.Item;


public interface ItemRepository extends CrudRepository<Item, String> {
}
