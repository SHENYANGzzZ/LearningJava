package learnJava.designMode.�������ģʽ;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * ����������FactoryMethod��ģʽ�Ķ��壺����һ��������Ʒ����Ĺ����ӿڣ�����Ʒ�����ʵ�ʴ��������Ƴٵ������ӹ����൱�С�
 * �����㴴����ģʽ����Ҫ��ġ�������ʹ������롱���ص㡣
 */

/**
 * 1. ģʽ�Ľṹ
 * 
 * ��������ģʽ����Ҫ��ɫ���¡� ���󹤳���Abstract Factory�����ṩ�˴�����Ʒ�Ľӿڣ�������ͨ�������ʾ��幤���Ĺ�������
 * newProduct() ��������Ʒ�� ���幤����ConcreteFactory������Ҫ��ʵ�ֳ��󹤳��еĳ��󷽷�����ɾ����Ʒ�Ĵ�����
 * �����Ʒ��Product���������˲�Ʒ�Ĺ淶�������˲�Ʒ����Ҫ���Ժ͹��ܡ�
 * �����Ʒ��ConcreteProduct����ʵ���˳����Ʒ��ɫ������Ľӿڣ��ɾ��幤������������ͬ���幤��֮��һһ��Ӧ��
 */
public class AbstractFactoryTest {
	public static void main(String[] args) {
		try {
			Product a;
			AbstractFactory af;
			af = (AbstractFactory) ReadXML1.getObject(); // java �������
			a = af.newProduct(); // ������������Ʒ
			a.show(); // ��Ʒ���еķ���
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

//�����Ʒ���ṩ�˲�Ʒ�Ľӿ�
interface Product {
	public void show();
}

//�����Ʒ1��ʵ�ֳ����Ʒ�еĳ��󷽷�
class TV implements Product {
	public void show() {
		System.out.println("���ڲ��ţ�����ش�1988��");
	}
}

//�����Ʒ2��ʵ�ֳ����Ʒ�еĳ��󷽷�
class MP3 implements Product {
	public void show() {
		System.out.println("���ڲ��ţ��ܽ��� -���켣��");
	}
}

//���󹤳����ṩ�˳�Ʒ�����ɷ���
interface AbstractFactory {
	public Product newProduct();
}

//���幤��1��ʵ���˳�Ʒ�����ɷ���
class TVFactory implements AbstractFactory {
	public Product newProduct() {
		System.out.println("��è�Ƶ��ӻ����쳧-->�������ӻ���...");
		return new TV();
	}
}

//���幤��2��ʵ���˳�Ʒ�����ɷ���
class MusicFactory implements AbstractFactory {
	public Product newProduct() {
		System.out.println("ipod �й������ֳ�-->������...");
		return new MP3();
	}
}

class ReadXML1 {
	// �÷������ڴ�XML�����ļ�����ȡ������������������һ��ʵ������
	public static Object getObject() {
		try {
			// �����ĵ�����
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src/learnJava/designMode/�������ģʽ/config1.xml"));
			// ��ȡ�����������ı��ڵ�
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String cName = "learnJava.designMode.�������ģʽ." + classNode.getNodeValue();
			// System.out.println("��������"+cName);
			// ͨ����������ʵ�����󲢽��䷵��
			Class<?> c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}