package com.example.myapplication.SQlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Class.product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    private static final String TABLE_SANPHAM = "SANPHAM";
    private static final String TABLE_HOADON = "HOADON";
    private static final String TABLE_TAIKHOAN = "TAIKHOAN";
    private static final String TABLE_HINHTHUCTHANHTOAN = "HINHTHUCTHANHTOAN";
    private static final String TABLE_QUYEN = "QUYEN";
    private static final String TABLE_CHITIETHOADON = "CHITIETHOADON";
    private static final String TABLE_CHITIETTAIKHOAN = "CHITIETTAIKHOAN";

    // Create table statements
    private static final String CREATE_TABLE_SANPHAM = "CREATE TABLE " + TABLE_SANPHAM + " (" +
            "MASANPHAM TEXT PRIMARY KEY, " +
            "TENSANPHAM TEXT, " +
            "HINHANH TEXT, " +
            "MOTA TEXT, " +
            "GIA REAL, " +
            "TRANGTHAI INTEGER, " +
            "SOLUONG INTEGER)";

    private static final String CREATE_TABLE_HOADON = "CREATE TABLE " + TABLE_HOADON + " (" +
            "MAHOADON TEXT PRIMARY KEY, " +
            "NGAYLAP TEXT, " +
            "TONGTIEN REAL, " +
            "TRANGTHAI INTEGER, " +
            "DIACHI TEXT, " +
            "SDT TEXT, " +
            "MATAIKHOAN TEXT, " +
            "MAHINHTHUC TEXT, " +
            "FOREIGN KEY(MATAIKHOAN) REFERENCES TAIKHOAN(MATAIKHOAN), " +
            "FOREIGN KEY(MAHINHTHUC) REFERENCES HINHTHUCTHANHTOAN(MAHINHTHUC))";

    private static final String CREATE_TABLE_TAIKHOAN = "CREATE TABLE " + TABLE_TAIKHOAN + " (" +
            "MATAIKHOAN TEXT PRIMARY KEY, " +
            "TENNGUOIDUNG TEXT, " +
            "EMAIL TEXT, " +
            "MATKHAU TEXT)";

    private static final String CREATE_TABLE_HINHTHUCTHANHTOAN = "CREATE TABLE " + TABLE_HINHTHUCTHANHTOAN + " (" +
            "MAHINHTHUC TEXT PRIMARY KEY, " +
            "TENHINHTHUC TEXT)";

    private static final String CREATE_TABLE_QUYEN = "CREATE TABLE " + TABLE_QUYEN + " (" +
            "MAQUYEN TEXT PRIMARY KEY, " +
            "TENQUYEN TEXT)";

    private static final String CREATE_TABLE_CHITIETHOADON = "CREATE TABLE " + TABLE_CHITIETHOADON + " (" +
            "MASANPHAM TEXT, " +
            "MAHOADON TEXT, " +
            "SOLUONG INTEGER, " +
            "TONGTIENSP REAL, " +
            "PRIMARY KEY (MASANPHAM, MAHOADON), " +
            "FOREIGN KEY(MASANPHAM) REFERENCES SANPHAM(MASANPHAM), " +
            "FOREIGN KEY(MAHOADON) REFERENCES HOADON(MAHOADON))";

    private static final String CREATE_TABLE_CHITIETTAIKHOAN = "CREATE TABLE " + TABLE_CHITIETTAIKHOAN + " (" +
            "MATAIKHOAN TEXT, " +
            "MAQUYEN TEXT, " +
            "PRIMARY KEY (MATAIKHOAN, MAQUYEN), " +
            "FOREIGN KEY(MATAIKHOAN) REFERENCES TAIKHOAN(MATAIKHOAN), " +
            "FOREIGN KEY(MAQUYEN) REFERENCES QUYEN(MAQUYEN))";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SANPHAM);
        db.execSQL(CREATE_TABLE_HOADON);
        db.execSQL(CREATE_TABLE_TAIKHOAN);
        db.execSQL(CREATE_TABLE_HINHTHUCTHANHTOAN);
        db.execSQL(CREATE_TABLE_QUYEN);
        db.execSQL(CREATE_TABLE_CHITIETHOADON);
        db.execSQL(CREATE_TABLE_CHITIETTAIKHOAN);

//        insertSampleData(db); // Gọi phương thức chèn dữ liệu mẫu sau khi tạo các bảng
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SANPHAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOADON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAIKHOAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HINHTHUCTHANHTOAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUYEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHITIETHOADON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHITIETTAIKHOAN);
        onCreate(db);
    }

    // Phương thức chèn dữ liệu mẫu
//    private void insertSampleData(SQLiteDatabase db) {
//        db.execSQL("INSERT INTO SANPHAM (MASANPHAM, TENSANPHAM, HINHANH, MOTA, GIA, TRANGTHAI, SOLUONG) VALUES ('P001', 'Cà phê đen', 'ca_phe_den.png', 'Cà phê đen nguyên chất', 50000, 1, 100)");
//        db.execSQL("INSERT INTO HOADON (MAHOADON, NGAYLAP, TONGTIEN, TRANGTHAI, DIACHI, SDT, MATAIKHOAN, MAHINHTHUC) VALUES ('H001', '2024-07-21', 100000, 1, '123 Đường ABC', '0123456789', 'TK001', 'HT001')");
//        db.execSQL("INSERT INTO TAIKHOAN (MATAIKHOAN, TENNGUOIDUNG, EMAIL, MATKHAU) VALUES ('TK001', 'Nguyen Van A', 'nguyenvana@example.com', 'password123')");
//        db.execSQL("INSERT INTO HINHTHUCTHANHTOAN (MAHINHTHUC, TENHINHTHUC) VALUES ('HT001', 'Thanh toán khi nhận hàng')");
//        db.execSQL("INSERT INTO HINHTHUCTHANHTOAN (MAHINHTHUC, TENHINHTHUC) VALUES ('HT002', 'Thanh toán online')");
//        db.execSQL("INSERT INTO QUYEN (MAQUYEN, TENQUYEN) VALUES ('Q001', 'Admin')");
//        db.execSQL("INSERT INTO QUYEN (MAQUYEN, TENQUYEN) VALUES ('Q002', 'User')");
//        db.execSQL("INSERT INTO CHITIETHOADON (MASANPHAM, MAHOADON, SOLUONG, TONGTIENSP) VALUES ('P001', 'H001', 2, 100000)");
//        db.execSQL("INSERT INTO CHITIETTAIKHOAN (MATAIKHOAN, MAQUYEN) VALUES ('TK001', 'Q001')");
//    }



    // Phương thức truy xuất tất cả sản phẩm
    public List<product> getAllProducts() {
        List<product> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SANPHAM", null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("TENSANPHAM"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("MOTA"));
                int imageResource = R.drawable.product; // Bạn có thể thay thế bằng hình ảnh phù hợp

                productList.add(new product(name, description, imageResource));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return productList;
    }

    // Phương thức đếm số lượng bản ghi trong bảng
    public int getCount(String tableName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT COUNT(*) FROM " + tableName;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count;
    }
}
