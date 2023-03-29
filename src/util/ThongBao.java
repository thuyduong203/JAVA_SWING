/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Duongntt
 */
public class ThongBao {

    public String thongBaoKqThem(Boolean them) {
        if (them) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    public String thongBaoKqUpdate(Boolean update) {
        if (update) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật không thành công";
        }
    }

    public String thongBaoKqDelete(Boolean delete) {
        if (delete) {
            return "Xoá thành công";
        } else {
            return "Xoá không thành công";
        }
    }
}
