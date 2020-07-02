package kr.ac.kopo.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	
	//static : 딱 한번만 선언 , new를 하지 않고 사용 가능
	private static SqlSessionFactory sqlSessionFactory;

	static{
		try {
			// 지정한 위치의 마이바티스 설정파일을 읽어서 SqlSessionFactory(Mybatis본체;jdbc기능을 편하게 해주는 역할)를 생성
			String resource = "batis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}