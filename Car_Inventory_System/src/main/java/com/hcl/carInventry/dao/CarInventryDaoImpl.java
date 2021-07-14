package com.hcl.carInventry.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.carInventry.model.CarInventry;

@Component
public class CarInventryDaoImpl implements CarInventryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static final String getDataSQL = "select * from CarInventry";

	public static final String insertSQl = "insert into CarInventry (make,model,year,salesPrice)values(?,?,?,?)";

	public static final String updateSQL = "update CarInventry set make=?,model=?,year=?,salesPrice=? where inventryNo=?";

	public static final String deleteDataByIdSQL = "delete from CarInventry where inventryNo=?";

	public CarInventry carInventry(ResultSet rs, int rownum) throws SQLException {
		return CarInventry.builder().inventryNo(rs.getInt(1)).make(rs.getString(2)).model(rs.getString(3))
				.year(rs.getDouble(4)).salesPrice(rs.getDouble(5)).build();
	}

	@Override
	public List<CarInventry> getAllData() {
		return jdbcTemplate.query(getDataSQL, this::carInventry);
	}

	@Override
	public void saveData(CarInventry carInventry) {
		jdbcTemplate.update(insertSQl, carInventry.getMake(), carInventry.getModel(), carInventry.getYear(),
				carInventry.getSalesPrice());
	}

	@Override
	public void updateData(int inventryNo, CarInventry carInventry) {
		jdbcTemplate.update(updateSQL, carInventry.getMake(), carInventry.getModel(), carInventry.getYear(),
				carInventry.getSalesPrice(), carInventry.getInventryNo());
	}

	@Override
	public void deleteDataById(int inventryNo) {
		jdbcTemplate.update(deleteDataByIdSQL, inventryNo);
	}

}
