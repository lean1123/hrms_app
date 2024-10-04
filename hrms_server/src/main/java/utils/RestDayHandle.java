package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RestDayHandle {
	public static long getNumOfWeekendDays(LocalDate fromDate, LocalDate endDate, int month, int year) {
		long soNgayNghiChinhThuc = 0;
		long soNgayCuoiTuan;
		long soNgayNghi;

		if (fromDate.getMonthValue() == endDate.getMonthValue() && endDate.getMonthValue() == month
				&& fromDate.getYear() == endDate.getYear() && endDate.getYear() == year) {
			soNgayNghi = fromDate.until(endDate, ChronoUnit.DAYS);

			soNgayCuoiTuan = getWeekendDays(fromDate, endDate);

			soNgayNghiChinhThuc = soNgayNghi - soNgayCuoiTuan;

		} else if (fromDate.getMonthValue() < endDate.getMonthValue() && fromDate.getMonthValue() == month
				&& fromDate.getYear() == endDate.getYear() && endDate.getYear() == year) {

			LocalDate ngayCuoiThang = fromDate.withDayOfMonth(fromDate.lengthOfMonth());

			soNgayNghi = fromDate.until(ngayCuoiThang, ChronoUnit.DAYS);

			soNgayCuoiTuan = getWeekendDays(fromDate, ngayCuoiThang);

			soNgayNghiChinhThuc = soNgayNghi - soNgayCuoiTuan;
		} else if (fromDate.getMonthValue() < endDate.getMonthValue() && endDate.getMonthValue() == month
				&& fromDate.getYear() == endDate.getYear() && endDate.getYear() == year) {

			LocalDate ngayDauThang = LocalDate.of(year, month, 1);

			soNgayNghi = ngayDauThang.until(endDate, ChronoUnit.DAYS);

			soNgayCuoiTuan = getWeekendDays(ngayDauThang, endDate);

			soNgayNghiChinhThuc = soNgayNghi - soNgayCuoiTuan;

		}

		return soNgayNghiChinhThuc;
	}

	public static long getWeekendDays(LocalDate fromDate, LocalDate endDate) {

		long result = 0;

		while (fromDate.isBefore(endDate)) {
			DayOfWeek thu = fromDate.getDayOfWeek();

			if (thu == DayOfWeek.SATURDAY || thu == DayOfWeek.SUNDAY) {
				result += 1;
			}
			fromDate = fromDate.plus(1, ChronoUnit.DAYS);
		}

		return result;

	}
}
