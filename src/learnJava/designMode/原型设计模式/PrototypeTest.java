package learnJava.designMode.ԭ�����ģʽ;

//����ԭ����
class Realizetype implements Cloneable {
	Realizetype() {
		System.out.println("����ԭ�ʹ����ɹ���");
	}

	public Object clone() throws CloneNotSupportedException {
		System.out.println("����ԭ�͸��Ƴɹ���");
		return (Realizetype) super.clone();
	}
}

//ԭ��ģʽ�Ĳ�����
public class PrototypeTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Realizetype obj1 = new Realizetype();
		Realizetype obj2 = (Realizetype) obj1.clone();
		System.out.println("obj1==obj2?" + (obj1 == obj2));
	}
}