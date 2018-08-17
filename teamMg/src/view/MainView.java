package view;


import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainView extends AbsViewTemplate {
	
	private SelectTeamView selectTeamView;
	private InsertMemberView insertMemberView;
	private SelectMemberView selectMemberView;
	public void setSelectMemberView(SelectMemberView selectMemberView) {
		this.selectMemberView = selectMemberView;
	}

	public void setInsertMemberView(InsertMemberView insertMemberView) {
		this.insertMemberView = insertMemberView;
	}

	public void setSelectTeamView(SelectTeamView selectTeamView) {
		this.selectTeamView = selectTeamView;
	}

	@Override
	protected void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("********************");
		System.out.println();
		System.out.println("1. ����");
		System.out.println("2. �� ����Ʈ");
		System.out.println("3. ���� �߰�");
		System.out.println("4. ���� ����");
		System.out.println();
		System.out.println("********************");
		System.out.println("��ȣ �Է�(Enter)");
	}

	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	protected void execute(int number) {
		switch(number) {
		case 1 :
			msg("���α׷��� �����մϴ�.");
			System.exit(0);
		case 2 : 
			selectTeamView.show();
			break;
		case 3 :
			insertMemberView.show();
			break;
		case 4 :
			selectMemberView.show();
			break;
		} 

	}
	
	public static void main(String[] args) {
		GenericApplicationContext ac = new GenericXmlApplicationContext("appContext.xml");
		MainView mv = (MainView)ac.getBean("mainView");
		
		while(true) {
			mv.show();
		}
	}
} 




