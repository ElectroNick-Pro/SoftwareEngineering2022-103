package MainApp.pages.foodGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
 
import javax.swing.JFrame;
import javax.swing.JPanel;

class RoundRect extends JFrame{

    private static final long serialVersionUID = 1L;
	private JPanel panel;
	private Dimension size=new Dimension(305, 400);
	
	final int R = 66;
	final int G = 194;
	final int B = 110;
	//RoundedRectangle frame = this;

    public RoundRect(){
        
// 设置画笔颜色，填充或描边
final Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 100),
getWidth(), getHeight(), new Color(R, G, B, 200), true);

panel = new JPanel(){ 
private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setPaint(p);
    // 设置画笔颜色为白色
    g2d.setColor(new Color(255,255,255));
    g2d.fillRect(0, 0, getWidth(), getHeight());
    
    // 设置画笔颜色为蓝色
    g2d.setColor(new Color(41,141,208));
    Shape shape = null;
    shape = new RoundRectangle2D.Double(0, 0, 195, 125, 6.5D, 6.5D);
    g2d.draw(shape);		
    
}
};
//this.setSize(size);
// 去除窗体的默认修饰，这是自定义的首要前提
//this.setUndecorated(true);
// 将panel设置为内容窗体
//this.setContentPane(panel);
//this.setVisible(true);
//重新设定可见区域
//setVisibleRegion(frame.getWidth(),frame.getHeight());	
//center();

//窗体透明
//		AWTUtilities.setWindowOpacity(frame, 0.5f);
    }
}