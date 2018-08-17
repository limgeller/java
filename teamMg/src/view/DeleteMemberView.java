package view;

import org.apache.commons.lang.StringUtils;

import dao.MemberDAO;
import dto.MemberDTO;

public class DeleteMemberView extends AbsView {
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
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
		if (Utils.isNumeric(id, "���� ID ")){
			MemberDTO member = memberDAO.getMember(Integer.valueOf(id));
			memberDAO.deleteMember(member);
		}else {
			show();
		}
	}
 
}


