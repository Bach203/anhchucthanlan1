package com.example.bee.model.request.create_request;

import com.example.bee.common.CommonEnum;
import com.example.bee.entity.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreatedChiTietSanPhamRequest {
    private Long id;

    @NotNull(message = "Vui lòng nhập số lượng")
    private Integer soLuong;

    @NotNull(message = "Vui lòng nhập giá tiền")
    private BigDecimal giaTien;

    private LocalDateTime ngayTao;

    private LocalDateTime ngaySua;

    private String nguoiTao;

    private String nguoiSua;

    private CommonEnum.TrangThaiChiTietSanPham trangThai;

    @NotNull(message = "Vui lòng chọn Loại đế")
    private LoaiDe loaiDe;

    @NotNull(message = "Vui lòng chọn Địa hình sân")
    private DiaHinhSan diaHinhSan;

    @NotNull(message = "Vui lòng chọn Sản phẩm")
    private SanPham sanPham;

    @NotNull(message = "Vui lòng chọn Màu sắc")
    private MauSac mauSac;

    @NotNull(message = "Vui lòng chọn Kích cỡ")
    private KichCo kichCo;

    @NotNull(message = "Vui lòng chọn Anh")
    private String anhUP;

}
