package jdbc;

import java.util.List;

public interface Service {

	

	

	int register(ProductVO p);

	List<ProductVO> getlist();

	ProductVO getDetail(int pno);

}
