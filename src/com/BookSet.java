package com;

public class BookSet {
	String[] name = new String[50];		//����1�洢ͼ������
	int[] state = new int[50];			//����2�洢ͼ����״̬��0->�ѽ�� / 1->�ɽ�
	String[] date = new String[50];		//����3�洢ͼ��������
	int[] count = new int[50];			//����4�洢ͼ��������
	
	/*
	 * getters/setters����
	 */
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int[] getState() {
		return state;
	}
	public void setState(int[] state) {
		this.state = state;
	}
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public int[] getCount() {
		return count;
	}
	public void setCount(int[] count) {
		this.count = count;
	}
}

