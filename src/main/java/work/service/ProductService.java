package work.service;

import work.pojo.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getLists();
    public int add(Product product);
    public int delete(int id);
    public Product getOne(int id);
    public int update(Product product);
}
