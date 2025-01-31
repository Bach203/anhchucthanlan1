package com.example.bee.service;

import com.example.bee.model.response.ThongKeSanPhamHotResponse;
import com.example.bee.model.response.ThongKeSoLuongTonResponse;
import com.example.bee.model.response.ThongKeTheoDMYResponse;
import com.example.bee.model.response.ThongKeTheoDoanhThuResponse;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface ThongKeService {
    ThongKeTheoDMYResponse thongKeTheoNgay(LocalDate ngayThanhToan);

    ThongKeTheoDMYResponse thongKeTheoTuan(LocalDate startOfWeek, LocalDate endOfWeek);

    ThongKeTheoDMYResponse thongKeTheoThang(LocalDate startOfMonth, LocalDate endOfMonth);

    ThongKeTheoDMYResponse thongKeTheoNam(LocalDate startOfYear, LocalDate endOfYear);

    ThongKeTheoDMYResponse thongKeTheoKhoangNgay(LocalDate start, LocalDate end);

    Page<ThongKeSoLuongTonResponse> thongKeSoLuongTon(Integer page, Integer pageSize);

    Page<ThongKeTheoDoanhThuResponse> thongKeTheoDoanhThu(Integer page, Integer pageSize);

    List<ThongKeSanPhamHotResponse> thongKeSanPhamHot(int topN, YearMonth yearMonth);

    byte[] exportExcelThongKe() throws IOException;

}
