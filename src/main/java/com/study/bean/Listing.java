package com.study.bean;

/**
 * ѡ����⣬
 * ѡ������
 * ͶƱ������
 * �õ�¼�˻��Ƿ���ͶƱ�� 
 * @author Administrator
 *
 */
public class Listing {
	private int id;
	private String title;
	private int optionNum;
	private int voteNum;
	private boolean vote;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOptionNum() {
		return optionNum;
	}
	public void setOptionNum(int optionNum) {
		this.optionNum = optionNum;
	}
	public int getVoteNum() {
		return voteNum;
	}
	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
	}
	
}
