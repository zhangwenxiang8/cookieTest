package work.utilTest;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
        private static final String URL="jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8";
        private static final String USER="root";
        private static final String PWD="123456";

        static{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static Connection getconnection(){
            Connection conn=null;

            try {
                conn=DriverManager.getConnection(URL,USER,PWD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

        public static void close(ResultSet rs, PreparedStatement sta, Connection conn){
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sta!=null){
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    //定义方法 查
        public static <E> List<E> R(String sql, RowMap<E> rw, Object...obj){
            List<E> lists= new ArrayList<>();
            Connection conn=null;
            PreparedStatement sta=null;
            conn=getconnection();
            try {
                sta=conn.prepareStatement(sql);
                if (obj!=null){
                    for ( int i=0;i<obj.length;i++) {
                        sta.setObject(i+1,obj[i]);
                    }
                }

                ResultSet rs =sta.executeQuery();
                while(rs.next()){
                    E e=  rw.RowMapping(rs);
                    lists.add(e);
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
            return lists;
        }


    //定义方法 增删改
    public static int CUD(String sql,Object...obj){
        int a=0;
        Connection conn=null;
        PreparedStatement sta=null;
        conn=getconnection();           //创建链接
        try {

            sta=conn.prepareStatement(sql);   //创建查询窗口,写入sql语句
            if (obj!=null){
                for ( int i=0;i<obj.length;i++) {
                    sta.setObject(i+1,obj[i]);
                }

            }a=sta.executeUpdate();  //执行
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,sta,conn);
        }
        return a;
    }


    public static <T> T queryOne(String sql, RowMap<T> rw, Object...obj){
        T t =null;
        Connection conn=null;
        PreparedStatement sta=null;
        conn=getconnection();
        try {
            sta=conn.prepareStatement(sql);
            if (obj!=null){
                for ( int i=0;i<obj.length;i++) {
                    sta.setObject(i+1,obj[i]);
                }
            }

            ResultSet rs =sta.executeQuery();
            while(rs.next()){
                t=  rw.RowMapping(rs);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return t;
    }

}


