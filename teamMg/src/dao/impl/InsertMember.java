package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertMember extends SqlUpdate{
	public InsertMember(DataSource dataSource) {
		super(dataSource, "Insert into member values(seq_member_id.nextval,?,?)");
		super.declareParameter(new SqlParameter("name",Types.VARCHAR));
		super.declareParameter(new SqlParameter("team_id",Types.INTEGER));
		compile();
	}
}
