package dao;
 
import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.MemberDTO;
public interface MemberDAO {
	List<MemberDTO> getMembers(Integer id) throws DataAccessException;//특정 팀의 모든 선수 보기: id 는 팀 id값
	MemberDTO       getMember(Integer id) throws DataAccessException;		//선수의 정보 보기 : id는 선수 id
	void 			insertMember(MemberDTO dto) throws DataAccessException;//선수등록
	void  			deleteMember(MemberDTO dto) throws DataAccessException;//선수 삭제
	void 			updateMember(MemberDTO dto) throws DataAccessException;//선수 팀 변경, 이름변경
	
}  
