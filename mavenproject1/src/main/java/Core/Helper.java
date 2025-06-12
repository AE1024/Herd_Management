package Core;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*
 * @author elmaz
 */
public class Helper {
    //bu class telefon dogrulama vb. kontroller için metotları içerecek,
    //bu sayede buradan ulasılarak daha kolay işlem yapılacak.

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }

    public static  boolean isFieldsEmpty(JTextField[] fields){
        for (JTextField field : fields) {
            if(isFieldEmpty(field )){
                return  true;
            }
        }
        return  false;
    }

    //telefon kontrol
    public static boolean isPhoneValidate(JTextField field){
        if(isFieldEmpty(field)) return false;
        String regex = "^(\\+90|0)?5\\d{9}$";
        if(field.getText().trim().matches(regex)){
            return true;
        }
        return  false;
    }
    //Uyarı mesajları
    public static void showMsg(String result){
        String title;
        String message;
        switch (result){
            case "empty":
                title = "HATA!";
                message = "Lütfen alanları doldurun.";
                break;
            case "validate":
                title = "İşlem Başarılı";
                message = "Giriş yapıldı.";
                break;
            case "error":
                title = "HATA!";
                message = "Hata oluştu.";
                break;
            default:
                title = "HATA!";
                message = result;
                break;

        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    //anasayfa için
    public static void setLoginIcon(JFrame frame){
        URL iconURL = Helper.class.getResource("/Icons/goat(2).png");
        if (iconURL != null) {
            ImageIcon originalIcon = new ImageIcon(iconURL);
            frame.setIconImage(originalIcon.getImage());
        }else
            JOptionPane.showMessageDialog(null, "Başlangıc ikonu bulunamadı !","HATA",JOptionPane.INFORMATION_MESSAGE);
    } 
}
