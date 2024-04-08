package jdbc;

import java.util.List;

public interface DAO {

	int insert(ProductVO p);

	List<ProductVO> selectlist();

	ProductVO selectOne(int pno);

}
