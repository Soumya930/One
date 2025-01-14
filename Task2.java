 abstract class Notify{
    abstract void message(String message );
    abstract void recipient(String recipient );
    
}

class EmailNotify extends Notify{
 void message(String message){
    System.out.println(" The Message by email . "+ message);
 }
 void recipient(String recipient){
    System.out.println(" The recipient by email . "+ recipient);
 }
}

class SmsNotify extends Notify{
    void message(String message){
        System.out.println(" The Message by SMS . " + message);
     }
     void recipient(String recipient){
        System.out.println(" The recipient by SMS . "+ recipient);
     }
}

class PushNotify extends Notify{
    void message(String message){
        System.out.println(" The Message by PUSH Notification . "+ message);
     }
     void recipient(String recipient){
        System.out.println(" The recipient by PUSH Notification  . "+ recipient);
     }
}



// Dynamic Selection
class NotiFactory {
    static Notify getNotifier(String type){
        switch ( type.toLowerCase()){
            case "email":
            return  new EmailNotify();
        case "sms":
            return new SmsNotify();
        case "push":
            return new PushNotify();
        default:
            throw new IllegalArgumentException("Invalid notification type");
        }
    }
}



class Task2{
    public static void main(String[] args) {
      Notify nf = NotiFactory.getNotifier("sms");
      nf.message(" I do it!!! ");
      nf.recipient("soumya jain ");  
    }
}
