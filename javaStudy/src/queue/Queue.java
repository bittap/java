package queue;

import java.util.LinkedList;

class Queue {

	public static void main(String[] args) {
		// �������
		java.util.Queue<Message> mQueue = new LinkedList<Message>();
		
		mQueue.offer(new Message("sendMail", "ȫ�浿"));
		mQueue.offer(new Message("sendSMS", "�ſ��"));
		mQueue.offer(new Message("sendKakaotalk", "ȫ�β�"));
		
		while (!mQueue.isEmpty()) {
			Message message = mQueue.poll();
			System.out.println(message.to);
			
		}
	}

}
