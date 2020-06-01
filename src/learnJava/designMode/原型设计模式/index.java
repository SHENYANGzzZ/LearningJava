package learnJava.designMode.ԭ�����ģʽ;

/**
 * ԭ�ͣ�Prototype��ģʽ�Ķ������£���һ���Ѿ�������ʵ����Ϊԭ�ͣ�ͨ�����Ƹ�ԭ�Ͷ���������һ����ԭ����ͬ�����Ƶ��¶���
 * �����ԭ��ʵ��ָ����Ҫ�����Ķ�������ࡣ�����ַ�ʽ��������ǳ���Ч����������֪�����󴴽���ϸ�ڡ�
 * ���磬Windows ����ϵͳ�İ�װͨ���Ϻ�ʱ��������ƾͿ��˺ܶࡣ�������и��Ƶ����ӷǳ��࣬���ﲻһһ�о��ˡ�
 */

/**
 * 1. ģʽ�Ľṹ
 * 
 * ԭ��ģʽ����������Ҫ��ɫ�� ����ԭ���ࣺ�涨�˾���ԭ�Ͷ������ʵ�ֵĽӿڡ� 
 * ����ԭ���ࣺʵ�ֳ���ԭ����� clone() ���������ǿɱ����ƵĶ���
 * �����ࣺʹ�þ���ԭ�����е� clone() �����������µĶ���
 */

/**
 * 2. ģʽ��ʵ��
 * 
 * ԭ��ģʽ�Ŀ�¡��Ϊǳ��¡�����¡��Java �е� Object ���ṩ��ǳ��¡�� clone() ����������ԭ����ֻҪʵ�� Cloneable
 * �ӿھͿ�ʵ�ֶ����ǳ��¡������� Cloneable �ӿھ��ǳ���ԭ���ࡣ
 */
public class index {

	public static void main(String[] args) throws CloneNotSupportedException {
		citation obj1 = new citation("����", "ͬѧ����2016ѧ���һѧ���б������㣬����Ϊ����ѧ����", "�ع�ѧԺ");
		obj1.display();
		citation obj2 = (citation) obj1.clone();
		obj2.setName("����");
		obj2.setCollege("��������");
		obj2.display();

	}

	// ��״��
	static class citation implements Cloneable {
		String name;
		String info;
		String college;

		citation() {
			super();
		}

		citation(String name, String info, String college) {
			this.name = name;
			this.info = info;
			this.college = college;
			System.out.println("��״�����ɹ���");
		}

		void setName(String name) {
			this.name = name;
		}

		String getName() {
			return (this.name);
		}

		public String getCollege() {
			return college;
		}

		public void setCollege(String college) {
			this.college = college;
		}

		void display() {
			System.out.println(name + info + college);
		}

		public Object clone() throws CloneNotSupportedException {
			System.out.println("��״�����ɹ���");
			return (citation) super.clone();
		}
	}
}
