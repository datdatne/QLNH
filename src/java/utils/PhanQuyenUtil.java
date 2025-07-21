package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PhanQuyenUtil {

    public static boolean isDangNhap(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("username") != null;
    }

    public static boolean coQuyen(HttpServletRequest request, String[] vaiTroChoPhep) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("vaitro") == null) {
            return false;
        }

        String vaiTro = (String) session.getAttribute("vaitro");

        for (String v : vaiTroChoPhep) {
            if (vaiTro.equalsIgnoreCase(v)) {
                return true;
            }
        }

        return false;
    }

    public static boolean laAdmin(HttpServletRequest request) {
        return coQuyen(request, new String[]{"Admin"});
    }

    public static boolean laBep(HttpServletRequest request) {
        return coQuyen(request, new String[]{"Bep"});
    }

    public static boolean laThuNgan(HttpServletRequest request) {
        return coQuyen(request, new String[]{"ThuNgan"});
    }

    public static boolean laPhucVu(HttpServletRequest request) {
        return coQuyen(request, new String[]{"PhucVu"});
    }
}
