package work.service;

import work.dao.IProductDAO;
import work.dao.ProductDAOimpl;
import work.pojo.Product;

import java.util.List;

public class ProductServiceimpl implements ProductService {
    private IProductDAO dao=new ProductDAOimpl();

    @Override
    public List<Product> getLists() {  //查找
        return dao.getLists();      //去dao层实现类里调用查找内部类的方法
    }

    @Override                       //添加 add()
    public int add(Product product) {
        return dao.add(product);
    }

    @Override
    public int delete(int id) {         //删除
        return dao.delete(id);
    }

    @Override
    public Product getOne(int id) {
        return dao.getOne(id);   //放id进来
    }

    @Override
    public int update(Product product) {
        return dao.update(product);
    }

    @Override
    public List<Product> Resulet(String text) {
        return dao.Resulset(text);
    }


}

