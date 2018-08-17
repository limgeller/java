package dao;
 
import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.MemberDTO;
public interface MemberDAO {
	List<MemberDTO> getMembers(Integer id) throws DataAccessException;//Ư�� ���� ��� ���� ����: id �� �� id��
	MemberDTO       getMember(Integer id) throws DataAccessException;		//������ ���� ���� : id�� ���� id
	void 			insertMember(MemberDTO dto) throws DataAccessException;//�������
	void  			deleteMember(MemberDTO dto) throws DataAccessException;//���� ����
	void 			updateMember(MemberDTO dto) throws DataAccessException;//���� �� ����, �̸�����
	
}  
