package learnJava.designMode.工厂设计模式;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 工厂方法（FactoryMethod）模式的定义：定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。
 * 这满足创建型模式中所要求的“创建与使用相分离”的特点。
 */

/**
 * 1. 模式的结构
 * 
 * 工厂方法模式的主要角色如下。 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法
 * newProduct() 来创建产品。 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 */
public class AbstractFactoryTest {
	public static void main(String[] args) {
		try {
			Product a;
			AbstractFactory af;
			af = (AbstractFactory) ReadXML1.getObject(); // java 反射机制
			a = af.newProduct(); // 工厂类生产产品
			a.show(); // 产品类中的方法
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

//抽象产品：提供了产品的接口
interface Product {
	public void show();
}

//具体产品1：实现抽象产品中的抽象方法
class TV implements Product {
	public void show() {
		System.out.println("正在播放：【请回答1988】");
	}
}

//具体产品2：实现抽象产品中的抽象方法
class MP3 implements Product {
	public void show() {
		System.out.println("正在播放：周杰伦 -《轨迹》");
	}
}

//抽象工厂：提供了厂品的生成方法
interface AbstractFactory {
	public Product newProduct();
}

//具体工厂1：实现了厂品的生成方法
class TVFactory implements AbstractFactory {
	public Product newProduct() {
		System.out.println("熊猫牌电视机制造厂-->生产电视机中...");
		return new TV();
	}
}

//具体工厂2：实现了厂品的生成方法
class MusicFactory implements AbstractFactory {
	public Product newProduct() {
		System.out.println("ipod 中国代理厂分厂-->生产中...");
		return new MP3();
	}
}

class ReadXML1 {
	// 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
	public static Object getObject() {
		try {
			// 创建文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src/learnJava/designMode/工厂设计模式/config1.xml"));
			// 获取包含类名的文本节点
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String cName = "learnJava.designMode.工厂设计模式." + classNode.getNodeValue();
			// System.out.println("新类名："+cName);
			// 通过类名生成实例对象并将其返回
			Class<?> c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}