/**
 * @author tanbb
 * @create 2020-08-14 16:57
 */
public class TemplateMethod implements Template{

    private Template target = null;

    public TemplateMethod() {}
    public TemplateMethod(Template target) {
        this.target = target;
    }

    public final void print(String message) {
        System.out.println("##########");
        wapPrint(message);
        System.out.println("##########");
    }


    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(message->{
            System.out.println("#####"+message+"#####");
        });

        TemplateMethod t2 = new TemplateMethod(message->{
            System.out.println("***"+message+"***");
        });

        TemplateMethod t3 = new TemplateMethod() {
            @Override
            public void wapPrint(String message) {
                System.out.println("----"+message+"----");
            }
        };

        t1.print("hhhhh");

        t2.print("hhhhh");

        t3.print("11111");
    }

    @Override
    public void wapPrint(String message) {
        if(target != null) {
            target.wapPrint(message);
        }
    }
}
