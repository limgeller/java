package view;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class InsertMemberView extends AbsView{
	private TeamDAO teamDAO;
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	public void show() {
		final String memberName ="팀원 이름";
		String name =getKeyInputString(memberName);
		
		if(Utils.isEmpty(name, memberName)) {
			show();//return;을 쓰면 앞전 메뉴로 돌아감
		}else if(Utils.isSmallLength(name, memberName, 128)){
			MemberDTO member = new MemberDTO();
			member.setName(name);
			showTeamField(member);
		}
	}
	
	protected void showTeamField(MemberDTO member) {
		final String teamId="팀 ID";
		String id =getKeyInputString(teamId);
		if(Utils.isEmpty(id, teamId)) {
			showTeamField(member);
		}else if(Utils.isNumeric(id, teamId)){
			TeamDTO team = teamDAO.getTeam(Integer.parseInt(id));
			if(team == null) {
				msg(":::["+id+"]의 팀은 존재하지 않습니다. 다시 확인해 주세요");
				showTeamField(member);
			}else {
				member.setTeam(team);
				memberDAO.insertMember(member);
				msg(":::팀["+team.getName()+"]에 선수 ["+member.getName()+"]를 등록했습니다.");
			}
		}
	}

}
