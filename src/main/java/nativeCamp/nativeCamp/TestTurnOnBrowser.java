package nativeCamp.nativeCamp;

public class TestTurnOnBrowser {
    static java.awt.Desktop dp = java.awt.Desktop.getDesktop();
    static String baseUrl= "https://nativecamp.net/zh-tw/waiting/detail/";

    public static void turnOnTeacherPage(Integer teacherID){

        try {

            String url = baseUrl+teacherID;

            java.net.URI uri = java.net.URI.create(url);

            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                dp.browse(uri);
                // 獲取系統預設瀏覽器開啟連結
            }
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {

            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        java.awt.Toolkit.getDefaultToolkit().beep();

    }

}
