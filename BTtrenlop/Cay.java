public class Cay<T> {
    public static final int NIL = -1; // liên kết rỗng

    // lớp nút nội bộ: nhãn và 2 liên kết
    private static class Nut<T> {
        T nhan;
        int conTruong = NIL;
        int emKe = NIL;

        Nut(T nhan) {
            this.nhan = nhan;
        }
    }

    private Nut<T>[] ds;   // Mảng lưu danh sách các nút
    private int n = 0;     // Số lượng nút hiện có trong cây
    private int goc = NIL; // Chỉ số mảng của nút gốc

    @SuppressWarnings("unchecked")
    public Cay(int maxN) {
        if (maxN <= 0) {
            throw new IllegalArgumentException("Dung lượng cây maxN phải lớn hơn 0!");
        }
        ds = (Nut<T>[]) new Nut[maxN];
    }


    // CÁC HÀM QUẢN LÝ VÀ KHỞI TẠO NÚT
    // Hàm phụ trợ tạo nút mới trong mảng, có kiểm tra tràn dung lượng
    private int taoNut(T x) {
        if (n >= ds.length) {
            throw new IllegalStateException("Cây đã đầy bộ nhớ (tối đa " + ds.length + " nút)!");
        }
        ds[n] = new Nut<>(x);
        return n++;
    }

    public int goc() {
        return goc;
    }

    public int soNut() {
        return n;
    }

    public T nhan(int v) {
        return (v < 0 || v >= n) ? null : ds[v].nhan;
    }

    // Khởi tạo nút gốc cho cây

    public int themGoc(T x) {
        return goc = taoNut(x);
    }

    // Thêm nút mới nhãn x làm con ở cuối danh sách con của nút cha p
    public int themCon(int p, T x) {
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Chỉ số nút cha không hợp lệ: " + p);
        }

        int v = taoNut(x);

        // Nếu cha chưa có con nào -> v là con trưởng
        if (ds[p].conTruong == NIL) {
            ds[p].conTruong = v;
        } else {
            // Duyệt đến người em cuối cùng trong danh sách con của p
            int c = ds[p].conTruong;
            while (ds[c].emKe != NIL) {
                c = ds[c].emKe;
            }
            ds[c].emKe = v;
        }
        return v;
    }


    // CÁC PHÉP TOÁN THEO YÊU CẦU ĐỀ BÀI
    // 1. Tìm con trưởng của nút v - O(1)
    public int timConTruong(int v) {
        return (v < 0 || v >= n) ? NIL : ds[v].conTruong;
    }

    // 2. Tìm em liền kề của nút v - O(1)
    public int timEmKe(int v) {
        return (v < 0 || v >= n) ? NIL : ds[v].emKe;
    }

    /**
     * 3. Tìm bố của nút v - O(n)
     * Duyệt qua các nút p và quét danh sách con của p để tìm v
     * @return Chỉ số nút cha hoặc NIL (-1) nếu v là gốc hoặc không tìm thấy
     */
    public int timBo(int v) {
        if (v == goc || v < 0 || v >= n) {
            return NIL;
        }

        for (int p = 0; p < n; p++) {
            for (int c = ds[p].conTruong; c != NIL; c = ds[c].emKe) {
                if (c == v) {
                    return p;
                }
            }
        }
        return NIL;
    }

   // Duyệt
    /**
     * Duyệt tiền tự (Pre-order Traversal)
     */
    public void tienTu(int v) {
        if (v == NIL || v < 0 || v >= n) return;
        System.out.print(ds[v].nhan + " ");
        for (int c = ds[v].conTruong; c != NIL; c = ds[c].emKe) {
            tienTu(c);
        }
    }

    public void inCay(int v, int capDo) {
        if (v == NIL || v < 0 || v >= n) return;

        for (int i = 0; i < capDo; i++) {
            System.out.print("    ");
        }
        System.out.println("- [" + v + "] " + ds[v].nhan);

        for (int c = ds[v].conTruong; c != NIL; c = ds[c].emKe) {
            inCay(c, capDo + 1);
        }
    }

    /**
     * Chuyển chỉ số nút thành chuỗi hiển thị nhãn của nút (hoặc "NIL")
     */
    public String in(int v) {
        return (v == NIL || v < 0 || v >= n) ? "NIL" : String.valueOf(ds[v].nhan);
    }


    // CHƯƠNG TRÌNH CHẠY THỬ
    public static void main(String[] args) {
        // Khởi tạo cây với kiểu dữ liệu Integer
        Cay<Integer> t = new Cay<>(1000);
        int a = t.themGoc(1);
        int b = t.themCon(a, 2);
        int c = t.themCon(a, 3);
        int d = t.themCon(a, 4);
        int e = t.themCon(b, 5);
        int f = t.themCon(b, 6);
        int g = t.themCon(d, 7);

        System.out.println("=== CẤU TRÚC PHÂN CẤP CỦA CÂY ===");
        t.inCay(t.goc(), 0);
        System.out.print("\nDuyệt tiền tự: ");
        t.tienTu(t.goc());
        System.out.println();
        System.out.println("\n=== KẾT QUẢ CÁC PHÉP TOÁN ===");
        System.out.println("Con trưởng của nút 1: " + t.in(t.timConTruong(a))); // Kỳ vọng: 2
        System.out.println("Em liền kề của nút 2: " + t.in(t.timEmKe(b)));      // Kỳ vọng: 3
        System.out.println("Em liền kề của nút 4: " + t.in(t.timEmKe(d)));      // Kỳ vọng: NIL
        System.out.println("Bố của nút 6:         " + t.in(t.timBo(f)));        // Kỳ vọng: 2
        System.out.println("Bố của nút 1 (Gốc):   " + t.in(t.timBo(a)));        // Kỳ vọng: NIL

        // Thử nghiệm thêm với kiểu string
        System.out.println("\n=== THỬ NGHIỆM VỚI CÂY DẠNG CHUỖI (String) ===");
        Cay<String> thuMuc = new Cay<>(50);
        int root = thuMuc.themGoc("C:");
        int win = thuMuc.themCon(root, "Windows");
        int users = thuMuc.themCon(root, "Users");
        thuMuc.themCon(win, "System32");
        thuMuc.themCon(users, "Admin");

        thuMuc.inCay(thuMuc.goc(), 0);
    }
}