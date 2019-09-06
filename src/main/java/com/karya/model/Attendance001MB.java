package com.karya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	@Entity
	@Table(name="empAttendance001mb")
	public class Attendance001MB implements Serializable{

		private static final long serialVersionUID = -723583058586873479L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "Id")
		private int Id;
		
		@Column(name="clTaken")
		private String clTaken;
		
		@Column(name="clBalance")
		private String clBalance;
		
		@Column(name="compoffTaken")
		private String compoffTaken;
		
		@Column(name="compoffBalance")
		private String compoffBalance;
		
		@Column(name="lwtoutpTaken")
		private String lwtoutpTaken;
		
		@Column(name="lwtoutpBalance")
		private String lwtoutpBalance;
		
		@Column(name="mtlvTaken")
		private String mtlvTaken;
		
		@Column(name="mtlvBalance")
		private String mtlvBalance;
		
		@Column(name="ptyTaken")
		private String ptyTaken;
		
		@Column(name="ptyBalance")
		private String ptyBalance;
		
		@Column(name="pvglvTaken")
		private String pvglvTaken;
		
		@Column(name="pvglvBalance")
		private String pvglvBalance;
		
		@Column(name="sklvTaken")
		private String sklvTaken;
		
		@Column(name="sklvBalance")
		private String sklvBalance;
		
		@Column(name="vcTaken")
		private String vcTaken;
		
		@Column(name="vcBalance")
		private String vcBalance;
		
		
		/*@ManyToOne
		@JoinColumn(name="sNo")
		private Employee001MB employee001mb;*/
		
		@Column(name="empNumber")
		private String empNumber;
		
		@Column(name="empName")
		private String empName;
		
		@Column(name="deptName")
		private String deptName;
		
			public String getDeptName() {
			return deptName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getClTaken() {
			return clTaken;
		}

		public void setClTaken(String clTaken) {
			this.clTaken = clTaken;
		}

		public String getClBalance() {
			return clBalance;
		}

		public void setClBalance(String clBalance) {
			this.clBalance = clBalance;
		}

		public String getCompoffTaken() {
			return compoffTaken;
		}

		public void setCompoffTaken(String compoffTaken) {
			this.compoffTaken = compoffTaken;
		}

		public String getCompoffBalance() {
			return compoffBalance;
		}

		public void setCompoffBalance(String compoffBalance) {
			this.compoffBalance = compoffBalance;
		}

		public String getLwtoutpTaken() {
			return lwtoutpTaken;
		}

		public void setLwtoutpTaken(String lwtoutpTaken) {
			this.lwtoutpTaken = lwtoutpTaken;
		}

		public String getLwtoutpBalance() {
			return lwtoutpBalance;
		}

		public void setLwtoutpBalance(String lwtoutpBalance) {
			this.lwtoutpBalance = lwtoutpBalance;
		}

		public String getMtlvTaken() {
			return mtlvTaken;
		}

		public void setMtlvTaken(String mtlvTaken) {
			this.mtlvTaken = mtlvTaken;
		}

		public String getMtlvBalance() {
			return mtlvBalance;
		}

		public void setMtlvBalance(String mtlvBalance) {
			this.mtlvBalance = mtlvBalance;
		}

		public String getPtyTaken() {
			return ptyTaken;
		}

		public void setPtyTaken(String ptyTaken) {
			this.ptyTaken = ptyTaken;
		}

		public String getPtyBalance() {
			return ptyBalance;
		}

		public void setPtyBalance(String ptyBalance) {
			this.ptyBalance = ptyBalance;
		}

		public String getPvglvTaken() {
			return pvglvTaken;
		}

		public void setPvglvTaken(String pvglvTaken) {
			this.pvglvTaken = pvglvTaken;
		}

		public String getPvglvBalance() {
			return pvglvBalance;
		}

		public void setPvglvBalance(String pvglvBalance) {
			this.pvglvBalance = pvglvBalance;
		}

		public String getSklvTaken() {
			return sklvTaken;
		}

		public void setSklvTaken(String sklvTaken) {
			this.sklvTaken = sklvTaken;
		}

		public String getSklvBalance() {
			return sklvBalance;
		}

		public void setSklvBalance(String sklvBalance) {
			this.sklvBalance = sklvBalance;
		}

		public String getVcTaken() {
			return vcTaken;
		}

		public void setVcTaken(String vcTaken) {
			this.vcTaken = vcTaken;
		}

		public String getVcBalance() {
			return vcBalance;
		}

		public void setVcBalance(String vcBalance) {
			this.vcBalance = vcBalance;
		}

		/*public Employee001MB getEmployee001mb() {
			return employee001mb;
		}

		public void setEmployee001mb(Employee001MB employee001mb) {
			this.employee001mb = employee001mb;
		}
*/
		public String getEmpNumber() {
			return empNumber;
		}

		public void setEmpNumber(String empNumber) {
			this.empNumber = empNumber;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		

}
