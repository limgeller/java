package view;

import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;

public class SelectMemberView extends AbsViewTemplate{
	private MemberDAO memberDAO;
	private DeleteMemberView deleteMemberView;
	private UpdateMemberView updateMemberView;
	public void setUpdateMemberView(UpdateMemberView updateMemberView) {
		this.updateMemberView = updateMemberView;
	}

	public void setDeleteMemberView(DeleteMemberView deleteMemberView) {
		this.deleteMemberView = deleteMemberView;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void showHeader() {
		System.out.println("************************");
		System.out.println(">>>>>���� ����");
		System.out.println("************************");
	}
	
	protected Integer getTeamId() {
		String teamId = getKeyInputString("�� ID");
		if(Utils.isNumeric(teamId, "�� ID")) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}
	public void showMemberList(List<MemberDTO> memberList) {
		if(!memberList.isEmpty()) {
			msg("���� : "+ memberList.get(0).getTeam().getName());
		}
		System.out.println("ID\t\t�̸�");
		System.out.println("******************");
		for(MemberDTO member : memberList) {
			System.out.println(member.getId()+"\t\t"+member.getName());
		}
	}
	@Override
	public void show() {
		showHeader();
		Integer teamId = getTeamId();
		List<MemberDTO> memberList = memberDAO.getMembers(teamId);
		showMemberList(memberList);
		msg("EnterŰ�� ��������");
		getEnter();
		super.show();
	}
	
	@Override
	protected void showMenu() {
		showHeader();
		
		System.out.println("1. ���� ����");
		System.out.println("2. ���� ����");
		System.out.println("3. �޴� ����");
		System.out.println("********************");
		System.out.println("��ȣ �Է�(����Ű)");

	}

	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	protected void execute(int number) {
		switch(number) {
		case 1 :
			updateMemberView.show();
			break;
		case 2 : 
			deleteMemberView.show();
			break;
		case 3 :
			return;

		} 

	}

}
