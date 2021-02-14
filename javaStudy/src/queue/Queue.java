package queue;

import java.util.LinkedList;

class Queue {

	public static void main(String[] args) {
		// 积己规过
		java.util.Queue<Message> mQueue = new LinkedList<Message>();
		
		mQueue.offer(new Message("sendMail", "全辨悼"));
		mQueue.offer(new Message("sendSMS", "脚侩鼻"));
		mQueue.offer(new Message("sendKakaotalk", "全滴膊"));
		
		while (!mQueue.isEmpty()) {
			Message message = mQueue.poll();
			System.out.println(message.to);
			
		}
	}

}
