package net.www.orchid.repository.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import net.www.orchid.entity.Product;

public interface ProductSearchRepository extends ElasticsearchRepository<Product, Long>{

}
