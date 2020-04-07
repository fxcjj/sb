package com.vic.sb36.repository;

import com.vic.sb36.doc.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * item repository
 */
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
}