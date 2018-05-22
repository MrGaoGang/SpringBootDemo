package com.mrgao.test;

import com.mrgao.enty.Article;
import com.mrgao.enty.Blog;
import com.mrgao.enty.User;
import com.mrgao.enty.UserBean;
import com.mrgao.mapper.ArticleMapper;
import com.mrgao.mapper.BlogMapper;
import com.mrgao.mapper.UserMapper;
import com.mrgao.mapper.UserTMapper;
import com.mrgao.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public static void main(String[] args) {
        //insertUser();
        //deleteUser(1);
        //selectUserById(7);
        //selectAllUser();
//        getUserId();
//        getUserByName();
        getUserArticles(1);
       // getBlogArticles(1);
    }


    private static void getUserId() {
        SqlSession session = DBTools.getSession();
        UserTMapper mapper = session.getMapper(UserTMapper.class);
        User user = mapper.selectUserByID(1);

        logger.error("用户user对象:{},操作状态:{}", new Object[]{user});

        session.commit();

        session.close();
    }


    private static void getUserByName() {
        SqlSession session = DBTools.getSession();
        UserTMapper mapper = session.getMapper(UserTMapper.class);
        List<User> list = mapper.selectUsersByName("test1");

        for (User user : list) {
            System.out.println("id是" + user.getId() + "，用户名：" + user.getUserName()
                    + "，地址：" + user.getUserAddress());
        }

        session.commit();

        session.close();
    }


    public static void getUserArticles(int userid) {
        SqlSession session = DBTools.getSession();
        try {
            ArticleMapper articleOperation = session
                    .getMapper(ArticleMapper.class);
            List<Article> articles = articleOperation.getUserArticles(userid);
            for (Article article : articles) {
                System.out.println("文字标题：" + article.getTitle() + "，文字内容"
                        + article.getContent() + "，用户名："
                        + article.getUser().getUserName() + "，用户地址："
                        + article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }

    public static void getBlogArticles(int blogid) {
        SqlSession session = DBTools.getSession();
        try {
            BlogMapper blogOperation = session
                    .getMapper(BlogMapper.class);
            Blog blog = blogOperation.getBlogByID(blogid);
            System.out.println(blog.getTitle() + ":<<博客的标题");
            List<Article> articles = blog.getArticles();
            for (Article article : articles) {
                System.out.println("文字标题：" + article.getTitle() + "，文字内容"
                        + article.getContent() + "，用户名："
                        + article.getUser().getUserName() + "，用户地址："
                        + article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }

    /**
     * 新增用户
     */
    private static boolean insertUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean("test01", "123456", 7000.0);
        try {
            int index = mapper.insertUser(user);
            boolean bool = index > 0 ? true : false;
            logger.error("新增用户user对象:{},操作状态:{}", new Object[]{user, bool});
            session.commit();
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        } finally {
            session.close();
        }
    }


    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    private static boolean deleteUser(int id) {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            int index = mapper.deleteUser(id);
            boolean bool = index > 0 ? true : false;
            logger.debug("根据用户id:{},操作状态{}", new Object[]{id, bool});
            session.commit();
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        } finally {
            session.close();
        }
    }


    /**
     * 根据id查询用户
     *
     * @param id
     */
    private static void selectUserById(int id) {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            UserBean user = mapper.selectUserById(id);
            logger.debug("根据用户Id:{},查询用户信息:{}", new Object[]{id, user});
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    /**
     * 查询所有的用户
     */
    private static void selectAllUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<UserBean> user = mapper.selectAllUser();
            logger.debug("获取所用的用户:{}", user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}