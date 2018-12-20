package work.dao;


import work.pojo.Product;
import work.utilTest.JdbcUtil;
import work.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOimpl implements IProductDAO {
    @Override
    public List<Product> getLists() {
        return JdbcUtil.R("select * from product", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                //形参里有rs,所以得拿出他里面的对象出来,一个个提取
                Product p=new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setUrl(rs.getString("url"));
                    p.setPrice(rs.getDouble("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, null); //动态参数千万不能少,少写不会报错
    }

    @Override
    public int add(Product product) {
        return JdbcUtil.CUD("insert into product(product_name,price,product_des,url)values(?,?,?,?)",product.getProductName(),product.getPrice(),product.getProductDes(),product.getUrl());
    }               //sql语句好好背背

    @Override
    public int delete(int id) {         //删除方法
        return JdbcUtil.CUD("delete from product where product_id=?",id);
    }

    @Override
    public Product getOne(int id) {
        return JdbcUtil.queryOne("select * from product where product_id=?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p=new Product();
                try {
                    p.setProductName(rs.getString("product_name"));  //获取数据库里的值
                    p.setPrice(rs.getDouble("price"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setUrl(rs.getString("url"));
                    p.setProductId(rs.getInt("id"));       //以id值为参照执行单个查找方法
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, id);
    }

    @Override
    public int update(Product product) {
        return JdbcUtil.CUD("update product set product_name=?,price=?,product_des=?,url=? where product_id=?",product.getProductName(),product.getPrice(),product.getProductDes(),product.getUrl(),product.getProductId());
    }

    @Override
    public List<Product> Resulset(final String text) {
        return JdbcUtil.R("select * from product where product_name like concat('%',?,'%')", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product p=new Product();
                try {
                    p.setProductName(rs.getString("product_name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setUrl(rs.getString("url"));
                    p.setProductId(rs.getInt("id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        },text);
    }


}
