package com.kitri.project.member;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.kitri.project.mail.MailHandler;
import com.kitri.project.mail.MemberEmailAuth;
import com.kitri.project.mail.TempKey;

@Component("memberService")
public class MemberServiceImpl implements MemberService{
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private MemberDao dao;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void join(Member m) {	// ȸ�� ��û�ϱ�
		dao = sqlSession.getMapper(MemberDao.class);
		dao.insert(m);
	}
	
	@Override
	public Member getMyInfo(String id) {	// �� ��������
		dao = sqlSession.getMapper(MemberDao.class);
		return dao.select(id);
	}
	
	@Override
	public Member getEmail(String email) {
		dao = sqlSession.getMapper(MemberDao.class);
		return dao.selectEmail(email);
	}

	@Override
	public void edit(Member m) {	// ������ ����, �����ڰ� ȸ������ ���� ����
		dao = sqlSession.getMapper(MemberDao.class);
		dao.update(m);
	}
	
	@Override
	public void adminConfirm(String id) {
		dao = sqlSession.getMapper(MemberDao.class);
		dao.adminConfirm(id);
	}

	@Override
	public void out(String id) {	// ȸ�� Ż���ϱ�
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Member> getReservation() {	// ������: ������ ��� ����
		dao = sqlSession.getMapper(MemberDao.class);
		return dao.selectReservation();
	}
	
	@Override
	public Member getReservationComplete(String id) {	// ������: ���Խ��� ���� �ο���
		dao = sqlSession.getMapper(MemberDao.class);
		return dao.selectReservationComplete(id);
	}

	@Override
	public ArrayList<Member> getAll() {	// ������: ȸ�� ��ü ��Ϻ���
		dao = sqlSession.getMapper(MemberDao.class);
		return dao.selectAll();
	}

	@Override
	public boolean login(Member m) {	// �α��� �ϱ�
		dao = sqlSession.getMapper(MemberDao.class);
		Member m2 = dao.select(m.getId());
		if(m2!=null && m2.getPwd().equals(m.getPwd())) {	//&& m2.getAdmin_confirm().equals('o')
			return true;
		}
		return false;
	}
}
