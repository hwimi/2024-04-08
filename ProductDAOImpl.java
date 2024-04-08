package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements DAO {

	//DB연결
	private Connection conn;
	
	//sql 구분을 실행시키는 가능하는 객체
	private PreparedStatement pst;
	//쿼리구문 저장스트링
	private String query="";
	
	public ProductDAOImpl() {
		//DBconnection class 생성(싱글톤)
		DatabaseConnection dbc=DatabaseConnection.getInstance();
		conn=dbc.getConnection();
	}
	//sql 구문처리

	@Override
	public int insert(ProductVO p) {
		System.out.println("insert DAOImmpl success!!");
		System.out.println(p);
		query="insert into product(pname,price,madeby) values(?,?,?)";
		try {
			pst=conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			//insert,update,delete=>executeUpdate() return int(처리개수로 리턴)
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductVO> selectlist() {
			System.out.println("list DAOImpl success");
			query="select*from product order by pno desc";
			List<ProductVO> list=new ArrayList<>();
			try {
				pst=conn.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					list.add(new ProductVO(rs.getInt("pno"), 
							rs.getString("pname"), rs.getInt("price")));
							
				}
				return list;
			} 
				
				catch (SQLException e) {
				System.out.println("list error");
				e.printStackTrace();
			}
			
		
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		System.out.println("selectOne DAOImpl success");
		query="select*from product where pno=?";
		try {
			pst=conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return new ProductVO(
						
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby")
						);
			}
		} catch (Exception e) {
			System.out.println("detail error!!");
			e.printStackTrace();
		}
		return null;
	}
	
}
