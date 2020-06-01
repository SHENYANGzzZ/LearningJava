package learnJava.designMode.�������ģʽ;

/**
 * ����ģʽ�����ģʽ����򵥵�ģʽ֮һ��ͨ������ͨ��Ĺ��캯���ǹ��еģ��ⲿ�����ͨ����new
 * ���캯��()�������ɶ��ʵ�������ǣ��������Ĺ��캯����Ϊ˽�еģ��ⲿ����޷����øù��캯����Ҳ���޷����ɶ��ʵ����
 * ��ʱ����������붨��һ����̬˽��ʵ�����������ṩһ����̬�Ĺ��к������ڴ������ȡ�þ�̬˽��ʵ����
 */

public class index {

	/*
	 * �� 1 �֣�����ʽ����
	 * 
	 * ��ģʽ���ص��������ʱû�����ɵ�����ֻ�е���һ�ε��� getlnstance ����ʱ��ȥ��������������������£�
	 */
	static class LazySingleton {
		private static volatile LazySingleton instance = null; // ��֤ instance �������߳���ͬ��

		private LazySingleton() {
		} // private ���������ⲿ��ʵ����

		public static synchronized LazySingleton getInstance() {
			// getInstance ����ǰ��ͬ��
			if (instance == null) {
				instance = new LazySingleton();
			}
			return instance;
		}

		// ע�⣺�����д���Ƕ��̳߳�����Ҫɾ�����������еĹؼ��� volatile ��
		// synchronized�����򽫴����̷߳ǰ�ȫ�����⡣�����ɾ���������ؼ��־��ܱ�֤�̰߳�ȫ������ÿ�η���ʱ��Ҫͬ������Ӱ�����ܣ������ĸ������Դ����������ʽ������ȱ�㡣
	}

	/*
	 * �� 2 �֣�����ʽ����
	 * 
	 * ��ģʽ���ص�����һ�����ؾʹ���һ����������֤�ڵ��� getInstance ����֮ǰ�����Ѿ������ˡ�
	 */
	static class HungrySingleton {
		private static final HungrySingleton instance = new HungrySingleton();

		private HungrySingleton() {
		}

		public static HungrySingleton getInstance() {
			return instance;
		}
		// ����ʽ�������ഴ����ͬʱ���Ѿ�������һ����̬�Ķ���ϵͳʹ�ã��Ժ��ٸı䣬�������̰߳�ȫ�ģ�����ֱ�����ڶ��̶߳�����������⡣
	}

}
