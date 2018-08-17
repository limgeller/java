package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import dto.MemberDTO;
import dto.TeamDTO;

public class MemberQuery extends MappingSqlQuery<MemberDTO>{
	private static String sql = "select member_id, member.name as memberName, "
			+ "team.team_id, team.name as teamName from member, team where "
			+ "member.team_id = team.team_id and member_id = ?";
	

	public MemberQuery(DataSource dataSource) {
		super(dataSource, sql);
		super.declareParameter(new SqlParameter("member_id", Types.INTEGER));
		compile();
	}

	@Override
	protected MemberDTO mapRow(ResultSet arg0, int arg1) throws SQLException {
		MemberDTO member = new MemberDTO();
		member.setId(arg0.getInt("member_id"));
		member.setName(arg0.getString("memberName"));
		TeamDTO team = new TeamDTO();
		team.setId(arg0.getInt("team_id"));
		team.setName(arg0.getString("teamName"));
		member.setTeam(team);
		return member;
	} 

}