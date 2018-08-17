package view;

import org.apache.commons.lang.StringUtils;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class UpdateMemberView extends AbsView {
	private MemberDAO memberDAO;
	private TeamDAO teamDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void showMenu(){
		String str = ">>>���� ���� ����\n";
		str += "���� ID�� �Է��Ͽ� �ּ���(Enter)\n";
		str += "�ƹ��͵� �Է����� �ʰ� Enter�� ������ �޴��� �����մϴ�.";
		msg(str);		
	}
	@Override
	public void show() {
		showMenu();
		String id = getKeyInputString("���� ID ");
		if (StringUtils.isEmpty(id)){
			return;
		}
		
		MemberDTO member = getMember(id);
		if (member != null) {
			member.setName(getName());
			TeamDTO team = getTeam();
			if (team == null) return;
			member.setTeam(team); 
			memberDAO.updateMember(member);
		}else {
			show();
		}
	}
	public String getName(){
		String name = getKeyInputString("���� �̸� ");
		return name;
	}
	public TeamDTO getTeam(){
		String id = getKeyInputString("�� ID ");
		TeamDTO team = teamDAO.getTeam(Integer.valueOf(id));
		return team;
	}
	
	public MemberDTO getMember(String id){
		if (Utils.isNumeric(id, "���� ID ")){
			MemberDTO member = memberDAO.getMember(Integer.valueOf(id));
			return member;
		}
		return null;
	}

}
