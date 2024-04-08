package jdbc;

import java.util.List;

public class ProductServiceImpl implements Service {
	private DAO dao; //interface
	public ProductServiceImpl() {
		dao=new ProductDAOImpl();
	}
	@Override
	public int register(ProductVO p) {
		//실제 구현 영역
		System.out.println("register sericeImpl success!!");
		//각 DAO에게 저장 요청
		//dao 요청시 sql 구문과 비슷하게 메서드를 명을 작성하는것이 일반적
		return dao.insert(p);
	}
	@Override
	public List<ProductVO> getlist() {
		System.out.println("list sericeImpl success!!");
		// TODO Auto-generated method stub
		return dao.selectlist();
	}
	@Override
	public ProductVO getDetail(int pno) {
		// TODO Auto-generated method stub
		System.out.println("detail sericeImpl success!!");
		return dao.selectOne(pno);
	}
}
