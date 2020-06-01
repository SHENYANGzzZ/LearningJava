package learnJava.designMode.原型设计模式;

/**
 * 原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 * 例如，Windows 操作系统的安装通常较耗时，如果复制就快了很多。在生活中复制的例子非常多，这里不一一列举了。
 */

/**
 * 1. 模式的结构
 * 
 * 原型模式包含以下主要角色。 抽象原型类：规定了具体原型对象必须实现的接口。 
 * 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 */

/**
 * 2. 模式的实现
 * 
 * 原型模式的克隆分为浅克隆和深克隆，Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable
 * 接口就可实现对象的浅克隆，这里的 Cloneable 接口就是抽象原型类。
 */
public class index {

	public static void main(String[] args) throws CloneNotSupportedException {
		citation obj1 = new citation("张三", "同学：在2016学年第一学期中表现优秀，被评为三好学生。", "韶关学院");
		obj1.display();
		citation obj2 = (citation) obj1.clone();
		obj2.setName("李四");
		obj2.setCollege("归墟梦演");
		obj2.display();

	}

	// 奖状类
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
			System.out.println("奖状创建成功！");
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
			System.out.println("奖状拷贝成功！");
			return (citation) super.clone();
		}
	}
}
