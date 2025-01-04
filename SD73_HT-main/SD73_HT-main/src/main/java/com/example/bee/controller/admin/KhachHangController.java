package com.example.bee.controller.admin;

import com.example.bee.model.request.create_request.CreatedTaiKhoanRequest;
import com.example.bee.model.request.update_request.UpdatedTaiKhoanRequest;
import com.example.bee.model.response.TaiKhoanResponse;
import com.example.bee.service.TaiKhoanService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/api/khach-hang")
public class KhachHangController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping()
    public ResponseEntity<?> getAll(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchText", defaultValue = "", required = false) String searchText,
            @RequestParam(value = "trangThai", defaultValue = "", required = false) String trangThai,
            @RequestParam(value = "gioiTinh", required = false) String gioiTinhString,
            @RequestParam(value = "sortField", defaultValue = "", required = false) String sorter,
            @RequestParam(value = "sortOrder", defaultValue = "", required = false) String sortOrder
    ) {
        return ResponseEntity.ok(taiKhoanService.getAllKhachHang(page, pageSize, sorter,sortOrder, gioiTinhString, searchText, trangThai));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllKhachHang(){
        return ResponseEntity.ok(taiKhoanService.getAllKhachHang1());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addKhachHang(@RequestBody CreatedTaiKhoanRequest createTaiKhoanRequest) {
        return new ResponseEntity<>(taiKhoanService.addKhachHang(createTaiKhoanRequest), HttpStatus.CREATED);
    }


    @GetMapping("/edit/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id")Long id){
        return ResponseEntity.ok(taiKhoanService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdatedTaiKhoanRequest request) {
        TaiKhoanResponse taiKhoan = taiKhoanService.updateKhachHang(id, request);
        return ResponseEntity.ok(taiKhoan);
    }

    @GetMapping("/excel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        byte[] excelFile = taiKhoanService.exportExcelTaiKhoan1();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=khach_hang.xlsx");
        response.getOutputStream().write(excelFile);
    }
}
