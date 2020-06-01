package learnJava.designMode.������ģʽ;

/**
 * �����������������ʱ��Ҫ����һ�����ӵĶ���������Ӷ���ͨ���ɶ���Ӳ�����һ���Ĳ�����϶��ɡ����磬���������
 * CPU�����塢�ڴ桢Ӳ�̡��Կ������䡢��ʾ�������̡����Ȳ�����װ���ɵģ��ɹ�Ա�������Լ�ȥ��װ����������ǽ������������Ҫ����߼�������۹�˾����������۹�˾���ż�����Աȥ��װ�������Ȼ���ٽ���Ҫ�������Ĳɹ�Ա��
 * 
 * ���������������Ӻܶ࣬����Ϸ�еĲ�ͬ��ɫ�����Ա𡢸��ԡ����������͡����͡���װ�����͵����Զ��������죻���������еķ����̡������������ܡ���̥�Ȳ���Ҳ���ֶ�����ÿ������ʼ��ķ����ˡ��ռ��ˡ����⡢���ݡ�����������Ҳ������ͬ��
 * 
 * ����������Щ��Ʒ�����ɶ���������ɵģ����������������ѡ�񣬵��䴴�����趼��ͬС�졣�����Ʒ�Ĵ����޷���ǰ����ܵĹ���ģʽ������ֻ�н�����ģʽ���Ժܺõ����������Ʒ�Ĵ�����
 * ģʽ�Ķ������ص�
 * 
 */

/**
 * 
 * �����ߣ�Builder��ģʽ�Ķ��壺ָ��һ�����Ӷ���Ĺ��������ı�ʾ���룬ʹͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ�����������ģʽ����Ϊ������ģʽ�����ǽ�һ�����ӵĶ���ֽ�Ϊ����򵥵Ķ���Ȼ��һ��һ���������ɡ�
 * �������벻������룬����Ʒ����ɲ����ǲ���ģ���ÿһ�����ǿ������ѡ��ġ�
 * 
 * ��ģʽ����Ҫ�ŵ����£� ��������Ľ������໥������������ϵͳ����չ�� �ͻ��˲���֪����Ʒ�ڲ���ɵ�ϸ�ڣ����ڿ���ϸ�ڷ��ա�
 * 
 * ��ȱ�����£� ��Ʒ����ɲ��ֱ�����ͬ������������ʹ�÷�Χ�� �����Ʒ���ڲ��仯���ӣ���ģʽ�����Ӻܶ�Ľ������ࡣ
 * 
 * �����ߣ�Builder��ģʽ�͹���ģʽ�Ĺ�ע�㲻ͬ��������ģʽע���㲿������װ���̣�����������ģʽ��ע���㲿���Ĵ������̣������߿��Խ��ʹ�á�
 */

/**
 * �����ߣ�Builder��ģʽ�ɲ�Ʒ���������ߡ����彨���ߡ�ָ���ߵ� 4 ��Ҫ�ع��ɣ���������������������ṹ��ʵ�ַ�����
 * 
 * 
 * 1. ģʽ�Ľṹ,�����ߣ�Builder��ģʽ����Ҫ��ɫ����:
 * 
 * ��Ʒ��ɫ��Product�������ǰ��������ɲ����ĸ��Ӷ����ɾ��彨����������������粿����
 * �������ߣ�Builder��������һ������������Ʒ�����Ӳ����ĳ��󷽷��Ľӿڣ�ͨ��������һ�����ظ��Ӳ�Ʒ�ķ��� getResult()��
 * ���彨����(Concrete Builder����ʵ�� Builder �ӿڣ���ɸ��Ӳ�Ʒ�ĸ��������ľ��崴��������
 * ָ���ߣ�Director���������ý����߶����еĲ���������װ�䷽����ɸ��Ӷ���Ĵ�������ָ�����в��漰�����Ʒ����Ϣ��
 */
public class index {

	// ��Ʒ��ɫ�����������ɲ����ĸ��Ӷ���
	class Product {
		private String partA;
		private String partB;
		private String partC;

		public void setPartA(String partA) {
			this.partA = partA;
		}

		public void setPartB(String partB) {
			this.partB = partB;
		}

		public void setPartC(String partC) {
			this.partC = partC;
		}

		public void show() {
			// ��ʾ��Ʒ������
			System.out.println(partA + "   -   " + partB + "   -   " + partC);
		}
	}

	// �������ߣ�����������Ʒ�����Ӳ����ĳ��󷽷���
	abstract class Builder {
		// ������Ʒ����
		protected Product product = new Product();

		public abstract void buildPartA();

		public abstract void buildPartB();

		public abstract void buildPartC();

		// ���ز�Ʒ����
		public Product getResult() {
			return product;
		}
	}

	// ���彨���ߣ�ʵ���˳������߽ӿڡ�
	class ConcreteBuilder extends Builder {
		public void buildPartA() {
			product.setPartA("���� PartA");
		}

		public void buildPartB() {
			product.setPartB("���� PartB");
		}

		public void buildPartC() {
			product.setPartC("���� PartC");
		}
	}

	// ָ���ߣ����ý������еķ�����ɸ��Ӷ���Ĵ�����
	class Director {
		private Builder builder;

		public Director(Builder builder) {
			this.builder = builder;
		}

		// ��Ʒ��������װ����
		public Product construct() {
			builder.buildPartA();
			builder.buildPartB();
			builder.buildPartC();
			return builder.getResult();
		}
	}

	public static void main(String[] args) {
		new index().run();
	}

    // �ͻ���
	public void run() {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		Product product = director.construct();
		product.show();
	}
}
