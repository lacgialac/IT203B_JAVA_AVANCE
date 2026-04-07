import java.sql.Connection;
import java.sql.PreparedStatement;

public void capPhatThuoc(int medicineId, int patientId) {
    Connection conn = null;

    try {
        conn = DatabaseManager.getConnection();

        // ❗ Tắt Auto-Commit
        conn.setAutoCommit(false);

        // 1. Trừ thuốc trong kho
        String sqlUpdateInventory =
                "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
        PreparedStatement ps1 = conn.prepareStatement(sqlUpdateInventory);
        ps1.setInt(1, medicineId);
        ps1.executeUpdate();

        // 2. Lưu lịch sử cấp phát
        String sqlInsertHistory =
                "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
        PreparedStatement ps2 = conn.prepareStatement(sqlInsertHistory);
        ps2.setInt(1, patientId);
        ps2.setInt(2, medicineId);
        ps2.executeUpdate();

        // ✅ Nếu cả 2 thành công → commit
        conn.commit();

        System.out.println("Cấp phát thuốc thành công!");

    } catch (Exception e) {
        try {
            // ❌ Có lỗi → rollback toàn bộ
            if (conn != null) {
                conn.rollback();
            }
        } catch (Exception rollbackEx) {
            rollbackEx.printStackTrace();
        }

        System.out.println("Lỗi xảy ra, đã rollback: " + e.getMessage());

    } finally {
        try {
            if (conn != null) {
                // 🔄 Bật lại auto-commit (best practice)
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}