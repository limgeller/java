package dao;


import java.util.List;

import org.springframework.dao.DataAccessException;

import dto.TeamDTO;

public interface TeamDAO {
	List<TeamDTO> getTeamList() throws DataAccessException;//��ü �� ����Ʈ ����
	TeamDTO 	  getTeam(Integer id) throws DataAccessException;//id�� �ش��ϴ� �Ѱ��� �� ����
}
 