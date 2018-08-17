package view;

import java.util.List;

import dao.TeamDAO;
import dto.TeamDTO;

public class SelectTeamView extends AbsView {
	private TeamDAO teamDAO;
	
	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("********************");
		System.out.println(">>>�� ����");
		System.out.println("********************");
		System.out.println("��ID\t\t����");
		System.out.println("----------------------------");
		List<TeamDTO> teamList = teamDAO.getTeamList();
		for(TeamDTO dto : teamList) {
			System.out.println(dto.getId() + "\t\t" + dto.getName());
		}
		msg("EnterŰ�� ��������!!");
		getEnter();
	}

}
 