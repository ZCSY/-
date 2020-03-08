package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class BookMgr {

	BookSet book = new BookSet();	//����ͼ�����
	private int lendCount = 0;		//�ѽ���鼮����
	private int existCount = 0;		//δ����鼮����
    private long charge;			//ÿһ�ε��ݴ����
    
	public BookSet getBook() {
		return book;
	}
	public int getLendCount() {
		return lendCount;
	}
	public int getExistCount() {
		return existCount;
	}
	public long getCharge() {
		return charge;
	}
	public void setCharge(long charge) {
		this.charge = charge;
	}
	
	/**
	 * ��ʼ���ĸ�ͼ��
	 */
	public void initial() {
		book.name[0] = "���ݽṹ";
		book.state[0] = 0;
		book.date[0] = "1997-7-1";
		book.count[0] = 12;
		
		book.name[1] = "���ݿ�";
		book.state[1] = 1;
		book.count[1] = 14;
		
		book.name[2] = "Java�ֲ�";
		book.state[2] = 1;
		book.count[2] = 8;
		
		book.name[3] = "�㷨����";
		book.state[3] = 1;
		book.count[3] = 4;
	}
	
	/**
	 * ��ʼ�˵�
	 */
	public void startMenu() {
		System.out.println("��ӭʹ��ͼ�����ϵͳ");
		System.out.println("-------------------------------------");
		System.out.println("0. ��     ��");     
		System.out.println("1.������а�");	 
		System.out.println("2.����ͼ��");
		System.out.println("3.�鿴ͼ��");
		System.out.println("4.ɾ��ͼ��");
		System.out.println("5.���ͼ��");
		System.out.println("6.�黹ͼ��");
		System.out.print("--------------------------------------\n");
		
		System.out.println("��ѡ��");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice) {
			case 0:			//�˳�
				break;
			case 1:			
				list();
				returnMain();
				break;
			case 2:
				add();
				break;
			case 3:
				search();
		     	returnMain();
				break;
			case 4:
				delete();
				break;
			case 5:
				lend();
				break;
			case 6:
				returnbook();
				break;
			default:
				System.out.println("������������������...");	
				returnMain();
		}
		input.close();		
	}
	
	/**
	 * �������˵�
	 */
	public void returnMain() {
		Scanner input = new Scanner(System.in);
		System.out.println("���� 0 ���أ�");
		if(input.nextInt() == 0) {
			startMenu();
		}
		else {
			System.out.println("�������, �쳣��ֹ��");
		}
		input.close();
	}
	
	/**
	 * ������а�
	 * @return
	 */
	public String[] list() {
		//���������飬������������ͼ����Ϣ
		String[] newname = new String[50];
		int[] newcount = new int[50];
		for(int k=0;k<book.name.length;k++) {
			newname[k] = book.name[k];
			newcount[k] = book.count[k];
		}
		
		//����ð�������㷨��������
		for(int i=0;i<newname.length-1;i++) {
			for(int j=i+1;j<newname.length;j++) {
				if(newname[j] == null) {
					break;
				}
				if(newcount[i] > newcount[j]) {
					int temp1 = newcount[i];
					newcount[i] = newcount[j];
					newcount[j] = temp1;
					
					String temp2 = newname[i];
					newname[i] = newname[j];
					newname[j] = temp2;
				}
			}
		}
		System.out.println("---> ���а�\n");
    	System.out.println("**************************");
    	System.out.println("����\t����");
    	//��ʾ���а���Ϣ
    	for(int i=newname.length-1;i>=0;i--) {
    		if(newname[i] != null) {
    			System.out.println(newcount[i]+"\t<<"+ newname[i]+ ">>" );
    		}
    	}
    	System.out.println("**************************");
     	return newname;
	}

	/**
	 * ����ͼ��
	 */
	public void add() {
		//Ϊ������ԣ���ַ���Ϊ�������뷽���ͺ���׷���鼮����
		System.out.println("---> ����ͼ��\n");    	
		System.out.print("������ͼ�����ƣ� ");
		String name = getInputData();
		addBook(name);
		System.out.println("**************************");
	   	returnMain();
	}
	/**
	 * �����������ݣ���������ͼ���ɾ��ͼ�������
	 * @return
	 */
	private String getInputData() {
		Scanner input = new Scanner(System.in);
		String name = input.next();
		return name;
	}
	/**
	 * ׷��ͼ��
	 * @param naem
	 * @return
	 */
	public BookSet addBook(String name) {
		for(int i = 0; i < book.name.length; i++){   		 
	   		 if(book.name[i] == null){    	/*TODO 1.�жϴ�������Ϣ��������λ��*/
	    		//TODO 2.�����������
	   			book.name[i] = name;
	   			book.state[i] = 1;
	   			book.count[i] = 0;
				System.out.println("������"+name+"���ɹ���");
				break;
			 }
		 }
		return book;
	}

	/**
	 * �鿴ͼ��
	 */
	public void search() {
		lendCount = 0;
		existCount = 0;
		System.out.println("---> �鿴ͼ��\n");
    	System.out.println("���\t״ ̬\t����\t\t�������");
    	//TODO ����ͼ����Ϣ����˳�����,��Ŵ�1��ʼ�����ͼ��δ���������������"----"��ʾ��״̬�ֶ���"���"��"δ���"��ʶ
    	for(int i = 0; i < book.name.length; i++){   
			if(book.name[i] == null){	
				break;
			}
			else if(book.state[i] == 1){		
				System.out.println(i+1+"\t"+"δ���"+"\t"+book.name[i]+"\t\t"+"----");
				existCount++;
			}
			else if(book.state[i] == 0){		
				System.out.println(i+1+"\t"+"���"+"\t"+book.name[i]+"\t\t"+book.date[i]);
				lendCount++;
			}
		}
		//TODO ��ӡ�ѽ���鼮��������lendCount
		System.out.println("�ѽ���鼮������"+lendCount);
    	//TODO ��ӡ��δ����鼮��������existCount
    	System.out.println("δ����鼮������"+existCount); 
	}

	/**
	 * ɾ��ͼ��
	 */
	public void delete() {
		System.out.println("---> ɾ��ͼ��\n");
    	System.out.print("������ͼ�����ƣ� ");
        String name = getInputData();
        //Ϊ����������������һ������
        deleteBook(name);
        returnMain();
	}
	/**
	 * ɾ��ͼ��ĺ��ķ���
	 * @param name
	 */
	public void deleteBook(String name) {
		boolean flag = false;		//��ʶɾ���ɹ����
		//�������飬����ƥ����Ϣ
		for(int i=0;i<book.name.length;i++) {
			if(book.name[i].equals(name) && book.state[i]==1){		/*TODO �ж��鼮�Ƿ�����ɾ������*/
      			/*TODO ���ɾ������*/
      			int j=i;
      			for(;j<book.name.length-1;j++) {
      				book.name[j] = book.name[j+1];
      				book.state[j] = book.state[j+1];
      				book.date[j] = book.date[j+1];
      				book.count[j] = book.count[j+1];
      			}
                //���һ����Ϊ�յ�Ԫ���ÿ�
                book.name[j]=null;
                book.date[j]=null;
				System.out.println("ɾ����"+name+"���ɹ���");
                flag=true;//��λ����ʾɾ���ɹ�
                break;
      		}else if(book.name[i].equals(name) && book.state[i] == 0){		/*TODO �жϲ�ѯ�����鼮�ѱ����*/
				System.out.println("��"+name+"��Ϊ���״̬������ɾ����"); 
                flag=true;//��λ
                break;
            }
		}
		if(!flag){
			System.out.println("û���ҵ�ƥ����Ϣ��");
        }
		System.out.println("**************************");
	}
	
	/**
	 * ���ͼ��
	 */
	public void lend() {
		System.out.println("---> ���ͼ��\n");
	   	Scanner input = new Scanner(System.in);
	   	System.out.print("������ͼ�����ƣ� ");
	   	String want = input.next();  //Ҫ�����ͼ������ 
	   	System.out.print("�����������ڣ���-��-�գ���");
	   	String lendDate = input.next();  //�������
	   	//Ϊ������ԣ��������
	   	lendBook(want, lendDate);
	   	System.out.println("**************************");
	   	returnMain();
	}
	
	/**
	 * ���ͼ��ĺ��ķ���
	 * @param want
	 * @param lendDate
	 */
	public void lendBook(String want,String lendDate) {
		for(int i = 0; i < book.name.length; i++){   		 
			 if(book.name[i] == null){    //��ƥ��
				 System.out.println("û���ҵ�ƥ����Ϣ��");
				 break;
			 }else if(book.name[i].equals(want) && book.state[i]==1){ 	 /*TODO �ж�ƥ�䵽�ɽ��鼮*/
				 /*TODO ��ȫ�������*/
				 book.state[i] = 0;
				 book.date[i] = lendDate;
				 book.count[i]++;
				 System.out.println("��"+want+"�����Խ����");
				 break;
			 }else if(book.name[i].equals(want) && book.state[i]==0){  /*TODO �жϲ�ѯ�����鼮�ѱ����*/
				 System.out.println("��"+want+"���ѱ������");
				 break;
			 }   		 
		 }
	}

	/**
              * �黹ͼ��
     */
    public void returnbook() {
        System.out.println("---> �黹ͼ��\n");
        Scanner input = new Scanner(System.in);
        System.out.print("������ͼ�����ƣ� ");
        String want = input.next();
        System.out.print("������黹���ڣ���-��-�գ���");
        String redate = input.next();
        //Ϊ������ԣ��������
        returnbook(want, redate);
        System.out.println("**************************");
        returnMain();
    }
    /**
             * �黹ͼ�鲢�������
     */
    public void returnbook(String want, String redate) {
        //��ʼ�����
        this.setCharge(0);
        for (int i = 0; i < book.name.length; i++) {
            if (book.name[i] == null) {    //��ƥ��
                System.out.println("û���ҵ�ƥ����Ϣ��");
                break;
			 }else if(book.name[i].equals(want) && book.state[i] == 0){  //�ҵ�ƥ��	 
                /*��ȫ�黹���� 1.����Ϊδ���״̬ 2.�������*/
				book.state[i] = 1;
                System.out.println("\n�黹��" + want + "���ɹ�!");
                System.out.println("�������Ϊ��" + book.date[i]);
                System.out.println("�黹����Ϊ��" + redate);
                System.out.println("Ӧ�����Ԫ����" + charge(book.date[i],redate));
                break;
			 }else if(book.name[i].equals(want) && book.state[i] == 1){ 		//�ҵ�ƥ�䵫û�н��  
                System.out.println("��ͼ��û�б�������޷����й黹������");
                break;
            }
        }
    }
    /**
              * �������ڲ�
     *
     * @param dstr1 ��һ������
     * @param dstr2 �ڶ�������
     */
    public long charge(String dstr1, String dstr2) {
        long charge = 0;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sd.parse(dstr1);
            Date d2 = sd.parse(dstr2);
            charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
            this.setCharge(charge);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return charge;
    }
}
