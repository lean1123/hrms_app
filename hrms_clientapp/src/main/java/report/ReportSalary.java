package report;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gui.main.Application;

public class ReportSalary {
	public static void main(String[] args) throws IOException {

		xuatExcel(2,2023);
    }

	public static void xuatExcel(int month,int year) throws IOException {
		
//		System.out.println(queryResults[1][10]);
//		System.out.println(queryResults.length);
//
        // In ra kết quả của mảng 2 chiều
//        for (String[] row : queryResults) {
//            if (row != null) {
//                for (String cell : row) {
//                    System.out.print(cell + "\t");
//                }
//                System.out.println(); // In ra dòng mới sau khi in hết các giá trị trong một hàng
//            }
//        }
		//String filePath= "D:\\pathdata3-write.xlsx";
		String filePath= "D:\\"+"BANG LUONG THANG "+month+" NAM "+year+".xlsx";
		File myFile= new File(filePath);
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet1=workbook.createSheet("Sheet123");
		
//		String [][] tableData= {
//				{"No.","Name","Position","BasicSalary","WorkDays","Allowance","TotalSalry","BHTN","BHXH","BHYT","TotalBH","RealSalary"},
//				
//		};
		String[][] queryResults = Application.payrollsDao.getQueryResults(month, year);
		if (queryResults==null) {
			Application.showMessageWarning("Not find salary by month and year!");
			return;
		}
		String[][] tableData = {
				{"","","","","","BANG LUONG THANG "+month+"NAM "+year,"","","","","","","",""},
                {"STT", "HoTen", "ViTri","PhongBan", "LuongCoBan", "SoNgayCong", "PhuCap", "TongLuong","TRUHAO", "", "", "TongBH", "ThucNhan","KyNhan"},
                {"", "", "", "", "","", "", "", "BHTN", "BHYT", "BHXH", "", "",""},
              //  {"","NguoiLap","","","","","","","","HCM,ngay    thang    nam  ","","","","",""},
              //  {"","","","","","","","","","Cong Ty ABC","","","","",""}
                
        };
		String [][] footer= {
				{"","NguoiLap","","","","","","","","HCM,ngay    thang "+month+"   nam "+year,"","","","",""},
	            {"","","","","","","","","","Cong Ty ABC","","","","",""}
		};
		System.out.println("Do dai cua tableData"+ tableData.length);
//      for (String[] row : tableData) {
//      if (row != null) {
//          for (String cell : row) {
//              System.out.print(cell + "\t");
//          }
//          System.out.println(); // In ra dòng mới sau khi in hết các giá trị trong một hàng
//      }
//  }
//      for (String[] row : queryResults) {
//        if (row != null) {
//            for (String cell : row) {
//                System.out.print(cell + "\t");
//            }
//            System.out.println(); // In ra dòng mới sau khi in hết các giá trị trong một hàng
//        }
//    }
		Row row=null;
		Cell cell= null;
		int rowPosition=0;
		int colPosition=0;
	//	int startRow = tableData.length;

		

		// Thêm dữ liệu từ tableData vào sheet
		for (int i = 0; i < tableData.length; i++) {
		    row = sheet1.createRow(i + rowPosition);
		    for (int j = 0; j < tableData[i].length; j++) {
		        cell = row.createCell(j + colPosition);
		        cell.setCellValue(tableData[i][j]);
		    }
		}

		// Đặt vị trí hàng bắt đầu cho dữ liệu từ queryResults
		rowPosition += tableData.length;

		// Thêm dữ liệu từ queryResults vào sheet
//		for (int i = 0; i < queryResults.length; i++) {
//		    row = sheet1.createRow(i + rowPosition);
//		    for (int j = 0; j < queryResults[i].length; j++) {
//		        cell = row.createCell(j + colPosition);
//		        cell.setCellValue(queryResults[i][j]);
//		    }
//		}


		for (int i = 1; i < queryResults.length; i++) {
		    row = sheet1.createRow(i-1 + rowPosition);
		    for (int j = 0; j < queryResults[1].length; j++) {
		        cell = row.createCell(j + colPosition);
		        cell.setCellValue(queryResults[i][j]); // Thay đổi chỉ số hàng từ i thành i + 1
		    }
		}

		System.out.println("hello");
		rowPosition += queryResults.length;

		for (int i = 0; i < footer.length; i++) {
		    row = sheet1.createRow(i + rowPosition);
		    for (int j = 0; j < footer[i].length; j++) {
		        cell = row.createCell(j + colPosition);
		        cell.setCellValue(footer[i][j]);
		    }
		}
		sheet1.addMergedRegion(CellRangeAddress.valueOf("F1:I1"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("A2:A3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("B2:B3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("C2:C3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("D2:D3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("E2:E3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("F2:F3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("G2:G3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("H2:H3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("I2:K2"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("L2:L3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("M2:M3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("N2:N3"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("J7:L7"));
		sheet1.addMergedRegion(CellRangeAddress.valueOf("J8:L8"));


//		sheet1.addMergedRegion(CellRangeAddress.valueOf("A1:A2"));

//		sheet1.addMergedRegion(CellRangeAddress.valueOf("A1:A2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("B1:B2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("C1:C2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("D1:D2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("E1:E2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("F1:F2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("G1:G2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("N1:N2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("L1:L2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("M1:M2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("H1:H2"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("I1:K1"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("J6:L6"));
//		sheet1.addMergedRegion(CellRangeAddress.valueOf("J7:L7"));

		FileOutputStream fout = new FileOutputStream(myFile);
		workbook.write(fout);
		fout.close();	
		System.out.println("Created");
	}
	/*
	public static String[][] getQueryResults(int month, int year) {
	    EntityManager em = Persistence.createEntityManagerFactory("JPA_ORM_HRMS_MSSQL").createEntityManager();
	    String[][] resultArray = null;

	    try {
	        em.getTransaction().begin();
	        Query query = em.createNativeQuery("SELECT e.full_name, e.role, d.name as PhongBan, a.basic_salary, p.work_days, a.allowance, p.salary_total, p.BHTN, p.BHYT, p.BHXH, (p.BHTN + p.BHYT + p.BHXH) AS TongBH, p.real_salary " +
	                                            "FROM employees e " +
	                                            "INNER JOIN aggrementInfos a ON e.ID = a.employee_id " +
	                                            "INNER JOIN payrolls p ON e.id = p.employee_id " +
	                                            "INNER JOIN departments d ON e.department_id = d.department_id " +
	                                            "WHERE p.month = :month AND p.year = :year " +
	                                            "ORDER BY d.name");
	        query.setParameter("month", month);
	        query.setParameter("year", year);
	        List<Object[]> results = query.getResultList();
	        em.getTransaction().commit();
	        
	    
	    

	        resultArray = new String[results.size() + 1][];
	        int rowNum = 1; // Số thứ tự hàng
	        for (Object[] result : results) {
	            String[] rowArray = new String[result.length + 1];
	            rowArray[0] = String.valueOf(rowNum); // Gán số thứ tự hàng
	            for (int i = 0; i < result.length; i++) {
	                rowArray[i + 1] = String.valueOf(result[i]); // Gán giá trị từ kết quả truy vấn vào mảng
	            }
	            resultArray[rowNum] = rowArray; // Gán hàng vào mảng kết quả
	            rowNum++; // Tăng số thứ tự hàng
	        }
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    
	    return resultArray;
	}*/

}
