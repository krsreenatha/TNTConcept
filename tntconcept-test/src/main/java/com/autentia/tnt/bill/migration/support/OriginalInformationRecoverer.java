/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.autentia.tnt.bill.migration.support;

import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.bill.migration.BillToBillPaymentMigration;

public class OriginalInformationRecoverer {

	private static final Log log = LogFactory.getLog(OriginalInformationRecoverer.class);
	
	/**
	 * Recupera la suma total de todos los conceptos de todas las facturas del tipo que se envie por parametro
	 * @param billType tipo de factura
	 */
	public static double getTotalFacturasOriginal(String billType) throws Exception {
		
		Connection con = null;
		Statement stmt = null;
		LineNumberReader file = null;
		double result = -1;
		
		try {
			log.info("RECOVERING TOTAL FACTURAS " + billType  + " ORIGINALES");

			// connect to database
			Class.forName(BillToBillPaymentMigration.DATABASE_DRIVER);
			con = DriverManager.getConnection(BillToBillPaymentMigration.DATABASE_CONNECTION, BillToBillPaymentMigration.DATABASE_USER, BillToBillPaymentMigration.DATABASE_PASS);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT sum((bb.units*bb.amount)*(1+(bb.iva/100))) as total from Bill b left join BillBreakDown bb on b.id=bb.billId, Organization o, Project p where b.projectId = p.id and p.organizationId = o.id and b.billType='" + billType + "'");  
			while(rs.next())  
			{
				result = rs.getDouble(1);
				log.info("\t" + result);
			}
			
		} catch (Exception e) {
			log.error("FAILED: WILL BE ROLLED BACK: ", e);
			con.rollback();
			
		} finally {
			if (file != null) {
				file.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.rollback();
			}
		}
		
		return result;
	} 
	
	/**
	 * Recupera la suma total de todos los conceptos de cada una de las facturas cuyo tipo se envia por parametro
	 * @param billType tipo de factura
	 */
	public static double[] getImporteFacturaOriginal(String billType) throws Exception {
		Connection con = null;
		Statement stmt = null;
		LineNumberReader file = null;
		double[] result = new double[0];
		
		try {
			log.info("RECOVERING IMPORTE FACTURAS " + billType + " ORIGINALES");

			// connect to database
			Class.forName(BillToBillPaymentMigration.DATABASE_DRIVER);
			con = DriverManager.getConnection(BillToBillPaymentMigration.DATABASE_CONNECTION, BillToBillPaymentMigration.DATABASE_USER, BillToBillPaymentMigration.DATABASE_PASS);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT sum((bb.units*bb.amount)*(1+(bb.iva/100))) as total from Bill b left join BillBreakDown bb on b.id=bb.billId, Organization o, Project p where b.projectId = p.id and p.organizationId = o.id and b.billType='" + billType + "' group by b.id order by total");

			rs.last();
			result = new double[rs.getRow()];
			rs.beforeFirst();
			int counter = 0;
			
			while(rs.next())  
			{
				result[counter] = rs.getDouble(1);
				log.info("\t" + result[counter]);
				counter++;
			}
			
		} catch (Exception e) {
			log.error("FAILED: WILL BE ROLLED BACK: ", e);
			con.rollback();
			
		} finally {
			if (file != null) {
				file.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.rollback();
			}
		}			
		return result;
	}
	
	/**
	 * Recupera la fecha de pago o cobro de cada una de las facturas cuyo tipo se envia por parametro
	 * @param billType tipo de factura
	 */
	public static Date[] getFechaFacturaOriginal(String billType) throws Exception {
		Connection con = null;
		Statement stmt = null;
		LineNumberReader file = null;
		Date[] result = new Date[0];
		
		try {
			log.info("RECOVERING FECHAS " + billType + " ORIGINALES");

			// connect to database
			Class.forName(BillToBillPaymentMigration.DATABASE_DRIVER);
			con = DriverManager.getConnection(BillToBillPaymentMigration.DATABASE_CONNECTION, BillToBillPaymentMigration.DATABASE_USER, BillToBillPaymentMigration.DATABASE_PASS);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT date_add(creationDate, INTERVAL expiration DAY) as date FROM Bill B where billType = '" + billType + "' order by date");

			rs.last();
			result = new Date[rs.getRow()];
			rs.beforeFirst();
			int counter = 0;
			
			while(rs.next())  
			{
				result[counter] = rs.getDate(1);
				log.info("\t" + result[counter]);
				counter++;
			}
			
		} catch (Exception e) {
			log.error("FAILED: WILL BE ROLLED BACK: ", e);
			con.rollback();
			
		} finally {
			if (file != null) {
				file.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.rollback();
			}
		}			
		return result;
	}
}
