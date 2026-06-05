package com.example.demo.Domain.Common.Daos;

import com.example.demo.Domain.Common.Dtos.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MemberDAO {

    @Autowired
    private DataSource dataSource3;   // DataSourceConfig 의 HikariDataSource 빈

    // TODO: 회원 1건 등록
    //  - dataSource3.getConnection() 으로 Connection 획득
    //  - "insert into tbl_member values(null,?,?,?,?)" PreparedStatement 생성
    //  - name / email / phone / createAt(Timestamp.valueOf(LocalDateTime.now())) 바인딩
    //  - executeUpdate() 결과(int) 반환
    public int insert(MemberDTO dto) throws SQLException {
        Connection conn = dataSource3.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tbl_member VALUES (null,?,?,?,?)");
        pstmt.setString(1,dto.getName());
        pstmt.setString(2,dto.getEmail());
        pstmt.setString(3,dto.getPhone());
        pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
        int result = pstmt.executeUpdate();
        return result;
    }

    // TODO: 회원 전체 조회
    //  - "select * from tbl_member order by id desc" 실행
    //  - ResultSet 을 돌며 MemberDTO.builder() 로 매핑하여 List 로 반환
    public List<MemberDTO> selectAll() throws SQLException {
        Connection conn = dataSource3.getConnection();
    }

}
