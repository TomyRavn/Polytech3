package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.util.Pager;

//저장소라는 의미
//@Mapper annotation으로만 하면 뒷단의 세부사항을 놓칠 수 있다.
@Repository
public class BookDaoImpl implements BookDao {

	//ibatis는 mybatis의 초기
	@Autowired
	SqlSession sql;

	
	@Override
	public List<Book> list(Pager pager) {
		return sql.selectList("book.list", pager);
	}


//	namespace 'book'의 id가 add인 쿼리를 이용하겠다
	@Override
	public void add(Book item) {
		sql.insert("book.add", item);
	}


	@Override
	public void delete(int bookid) {
		sql.delete("book.delete", bookid);
	}


	@Override
	public Book item(int bookid) {
		return sql.selectOne("book.item", bookid);
	}


	@Override
	public void update(Book item) {
		sql.update("book.update", item);
	}


	@Override
	public int total(Pager pager) {
		return sql.selectOne("book.total", pager);
	}


}