import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
    Connection conn = null;

    try {
        conn = DatabaseManager.getConnection();

        // ❗ Tắt auto commit
        conn.setAutoCommit(false);

        // 1. Trừ tiền ví
        String sqlDeductWallet =
                "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
        PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet);
        ps1.setDouble(1, amount);
        ps1.setInt(2, patientId);
        ps1.executeUpdate();

        // 2. Update hóa đơn
        String sqlUpdateInvoice =
                "UPDATE Invoicess SET status = 'PAID' WHERE invoice_id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice);
        ps2.setInt(1, invoiceId);
        ps2.executeUpdate();

        // ✅ Thành công → commit
        conn.commit();
        System.out.println("Thanh toán hoàn tất!");

    } catch (SQLException e) {
        try {
            // ❗ BẮT BUỘC rollback khi lỗi
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println("Thanh toán thất bại, đã rollback: " + e.getMessage());

    } finally {
        try {
            if (conn != null) {
                // 🔄 Reset lại trạng thái (best practice)
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}